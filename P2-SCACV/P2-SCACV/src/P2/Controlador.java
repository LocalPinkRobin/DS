/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package P2;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador {
    private final int INCREVDEFECTO = 50;
    
    Modelo modelo;
    ventana vista;
    
    private Double kmh = 0d;
    private Double kmTotales = 0d;
    private Double kmRecientes = 0d;
    private Double velGuardada = null;
    private Integer bloqueoRevoluciones = null;
    private Integer revGuardadas = null;
    private int incrementoRevoluciones = INCREVDEFECTO;
    
    private Boolean bloquearRevoluciones = false;
    private Boolean cruceroEstabaEncendido = false;
    private Boolean debeMostrarMantenimiento = false;
    private Boolean mantenimientoMostrado = false;
    
    private CalculoRevoluciones encendido;
    private CalculoEstadisticas estadisticas;
    private GestionCrucero      crucero;
    
    public Controlador() {
        modelo = new Modelo();
        vista =  new ventana();
        vista.setControlador(this);
        
        bloqueoRevoluciones = modelo.getMotor().getFactorRozamiento();
        
        encendido = new CalculoRevoluciones();
        encendido.setIncrementoRevoluciones(this.incrementoRevoluciones);
        
        estadisticas = new CalculoEstadisticas();
        
        crucero = new GestionCrucero();
    }
    
    public void ejecutar() {
        vista.setVisible(true);
        encendido.start();
        estadisticas.start();
        crucero.start();
    }
    
    private void actualizarVista() {
        vista.setEstadoMotor(modelo.getMotor().getEstadoActual());
        vista.setEstadoCrucero(modelo.getControlCrucero().getEstadoActcual());
        vista.setRevoluciones(modelo.getMotor().getRevoluciones());
        vista.setKmRecientes(kmRecientes);
        vista.setKmTotales(kmTotales);
        vista.setKmh(kmh);
        
        vista.setNivelCombustible(modelo.getConsumoCombustible().getNivel());
        vista.avisoCombustible(modelo.getConsumoCombustible().aviso());
        vista.setNivelAceite(modelo.getConsumoAceite().getNivel());
        vista.avisoAceite(modelo.getConsumoAceite().aviso());
        vista.setNivelFrenos(modelo.getConsumoFrenos().getNivel());
        vista.avisoFrenos(modelo.getConsumoFrenos().aviso());
        vista.setEstadoGeneral(modelo.getConsumoGeneral().getNivel());
        vista.avisoGeneral(modelo.getConsumoGeneral().aviso());
        
        if (debeMostrarMantenimiento && !mantenimientoMostrado) {
            vista.permutarMantenimiento(true);
            mantenimientoMostrado = true;
        } else if (!debeMostrarMantenimiento && mantenimientoMostrado) {
            vista.permutarMantenimiento(false);
            mantenimientoMostrado = false;
        }
        
        if (velGuardada == null)
            vista.velGuardada(0d);
        else
            vista.velGuardada(velGuardada);
    }
    
    public void setIncrementoRevoluciones(int incremento) {
        if (incremento >= 0) {
            this.incrementoRevoluciones = incremento;
        } else {
            this.incrementoRevoluciones = 0;
        }
        encendido.setIncrementoRevoluciones(this.incrementoRevoluciones);
    }
    
    private void apagarMotor() {
        velGuardada = null;
        revGuardadas = null;
        kmRecientes = 0d;
        actualizarVista();
    }
    
    public Boolean setEstadoMotor(EstadosMotor estado) {
        Boolean exito = false;   
     
        if (modelo.getMotor().setEstadoActual(estado)) {
            exito = true;
            
            if (estado == EstadosMotor.APAGADO) {
                apagarMotor();
            } else if (estado == EstadosMotor.FRENANDO) {
                cruceroEstabaEncendido = false;
                this.setEstadoCrucero(EstadoCrucero.APAGADO);
            }
        }
        
        actualizarVista();
        
        return exito;
    }
    
    public Boolean setEstadoCrucero(EstadoCrucero estado) {
        Boolean exito = false;
        
        if (modelo.getMotor().getEstadoActual() != EstadosMotor.APAGADO) {
            if (estado == EstadoCrucero.ACELERAR) {
                modelo.getControlCrucero().setEstadoActual(estado);
                vista.pulsarAcelerarSCACV(false);
                exito = true;

            } else if (estado == EstadoCrucero.MANTENER || estado == EstadoCrucero.REINICIAR) {
                modelo.getControlCrucero().setEstadoActual(estado);
                exito = true;
                if (estado == EstadoCrucero.MANTENER)
                    vista.pulsarMantenerSCACV(false);
                else
                    vista.pulsarReiniciarSCACV(false);
                
            } else {
                vista.pulsarApagadoSCACV(false);
                modelo.getControlCrucero().setEstadoActual(estado);
                exito = true;
            }
        }
        
        actualizarVista();
        
        return exito;
    }
    
    private double velocidadLineal(int velocidadAngular) {
        double radioMotor = modelo.getMotor().getTamEje();
        
        double resultado = (2*Math.PI)*radioMotor*velocidadAngular*(60d/100d);
        return resultado;
    }
    
    private void aumentarConsumos(int revoluciones) {
        modelo.getConsumoCombustible().setRpm(revoluciones,true);
        modelo.getConsumoAceite().setRpm(revoluciones,true);
        modelo.getConsumoFrenos().setRpm(revoluciones,true);
        modelo.getConsumoGeneral().setRpm(revoluciones,true);
    }
    
    public void repostar(){
        modelo.getConsumoCombustible().repostar();
    }
    
    public void cambiarAceite(){
        modelo.getConsumoAceite().repostar();
    }
    
    public void cambiarFrenos(){
        modelo.getConsumoFrenos().repostar();
    }
    
    public void hacerRevisionGeneral(){
        modelo.getConsumoGeneral().repostar();;
    }
    
    public class CalculoEstadisticas extends Thread {
        @Override
        public void run() {
            double kmRecorridos = 0;
            
            while (true) {
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                kmRecorridos = kmh/3600;
                
                kmTotales += kmRecorridos;
                kmRecientes += kmRecorridos;
                
                actualizarVista();
            }
        }
    }
    
    public class CalculoRevoluciones extends Thread {
        private volatile Boolean salir = false;
        private int incrementoRevoluciones = 100;
        
        public void setIncrementoRevoluciones(int incremento) {
            this.incrementoRevoluciones = incremento;
        }
        
        @Override
        public void run() {
            salir = false;
            
            int rozamiento = modelo.getMotor().getFactorRozamiento();
            int incrementoAcelerando = incrementoRevoluciones;
            int incrementoFrenando    = -incrementoRevoluciones;
            int incrementoEncendido  = 0;
            int incrementoActual     = incrementoEncendido;
            
            int maxRevs = 0;
            
            while(!salir) {
                if (modelo.getMotor().getEstadoActual() == EstadosMotor.ENCENDIDO)
                    if (!bloquearRevoluciones) {
                        incrementoActual = incrementoEncendido;
                        maxRevs = modelo.getMotor().getMaxRevoluciones();
                    } else {
                        incrementoActual = bloqueoRevoluciones;
                        maxRevs = revGuardadas;
                    }
                    
                else if (modelo.getMotor().getEstadoActual() == EstadosMotor.ACELERANDO)
                    incrementoActual = incrementoAcelerando;
                else if (modelo.getMotor().getEstadoActual() == EstadosMotor.FRENANDO) 
                    incrementoActual = incrementoFrenando;
                    
                int nuevasRevoluciones = modelo.getMotor().getRevoluciones() + (incrementoActual - rozamiento);
                
                if (nuevasRevoluciones < 0) {
                    nuevasRevoluciones = 0;
                } else if (nuevasRevoluciones > maxRevs) {
                    nuevasRevoluciones = maxRevs;
                }
                
                modelo.getMotor().setRevoluciones(nuevasRevoluciones);
                aumentarConsumos(nuevasRevoluciones);
                kmh = velocidadLineal(modelo.getMotor().getRevoluciones());
                debeMostrarMantenimiento = false;
                if ((kmh == 0d) && (modelo.getMotor().getEstadoActual() == EstadosMotor.APAGADO)) {
                    debeMostrarMantenimiento = true;
                }

                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                
                actualizarVista();
            }
        }
        public void exit() {
            salir = true;
        }
    }
    
    public class GestionCrucero extends Thread {
        private volatile Boolean salir = false;
        
        @Override
        public void run() {
            while(!salir) {
                if (modelo.getMotor().getEstadoActual() != EstadosMotor.APAGADO) {
                    if (modelo.getControlCrucero().getEstadoActcual() == EstadoCrucero.ACELERAR) {
                        bloquearRevoluciones = false;
                        setEstadoMotor(EstadosMotor.ACELERANDO);
                        cruceroEstabaEncendido = true;
                    } else if (modelo.getControlCrucero().getEstadoActcual() == EstadoCrucero.MANTENER) {
                        revGuardadas = modelo.getMotor().getRevoluciones();
                        velGuardada = kmh;
                        bloquearRevoluciones = true;
                        setEstadoMotor(EstadosMotor.ENCENDIDO);
                        cruceroEstabaEncendido = true;
                    } else if (modelo.getControlCrucero().getEstadoActcual() == EstadoCrucero.REINICIAR) {
                        if (velGuardada != null) {
                            bloquearRevoluciones = false;
                            while(modelo.getMotor().getRevoluciones() != revGuardadas) {
                                if (modelo.getMotor().getRevoluciones() < revGuardadas) {
                                    setEstadoMotor(EstadosMotor.ACELERANDO);
                                } else {
                                    setEstadoMotor(EstadosMotor.ENCENDIDO);
                                }
                            }
                                bloquearRevoluciones = true;
                                cruceroEstabaEncendido = true;
                        }
                    } else {
                        bloquearRevoluciones = false;
                        
                        if (cruceroEstabaEncendido) {
                            setEstadoMotor(EstadosMotor.ENCENDIDO);
                        }
                        
                        cruceroEstabaEncendido = false;
                    }
                }
                
                try {
                        sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                actualizarVista();
            }
        }
        
        public void salir() {
            salir = true;
        }
    }
}
