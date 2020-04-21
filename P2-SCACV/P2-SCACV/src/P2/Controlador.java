/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package P2;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador {
    private final int INCREVDEFECTO = 100;
    
    Modelo modelo;
    Vista vista;
    
    private Double kmh = 0d;
    private Double kmTotales = 0d;
    private Double kmRecientes = 0d;
    private Double velGuardada = null;
    private int incrementoRevoluciones = INCREVDEFECTO;
    
    private CalculoRevoluciones acelerando;
    private CalculoRevoluciones encendido;
    private CalculoEstadisticas estadisticas;
    
    public Controlador() {
        modelo = new Modelo();
        vista =  new Vista();
        vista.setControlador(this);
        
        acelerando = new CalculoRevoluciones();
        acelerando.setIncrementoRevoluciones(this.incrementoRevoluciones);
        
        encendido = new CalculoRevoluciones();
        encendido.setIncrementoRevoluciones(0);
        
        estadisticas = new CalculoEstadisticas();
    }
    
    public void ejecutar() {
        vista.setVisible(true);
        estadisticas.start();
    }
    
    private void actualizarVista() {
        vista.setEstadoMotor(modelo.getMotor().getEstadoActual());
        vista.setEstadoCrucero(modelo.getControlCrucero().getEstadoActcual());
        vista.setRevoluciones(modelo.getMotor().getRevoluciones());
        vista.setKmRecientes(kmRecientes);
        vista.setKmTotales(kmTotales);
        vista.setKmh(kmh);
        
        vista.avisoCombustible(modelo.getConsumoCombustible().aviso());
        vista.avisoAceite(modelo.getConsumoAceite().aviso());
        vista.avisoFrenos(modelo.getConsumoFrenos().aviso());
        vista.avisoGeneral(modelo.getConsumoGeneral().aviso());
    }
    
    public void setIncrementoRevoluciones(int incremento) {
        if (incremento >= 0) {
            this.incrementoRevoluciones = incremento;
        } else {
            this.incrementoRevoluciones = 0;
        }
    }
    
    private void apagarMotor() {
        this.setEstadoCrucero(EstadoCrucero.APAGADO);
        velGuardada = 0d;
        kmRecientes = 0d;
        
    }
    
    private void acelerar() {
        if (acelerando.isAlive()) {
            acelerando.interrupt();
        }
        
        acelerando.start();
    }
    
    private void encendido() {
        if (encendido.isAlive()) {
            encendido.interrupt();
        }
        
        encendido.start();
    }
    
    public Boolean setEstadoMotor(EstadosMotor estado) {
        Boolean exito = false;   
     
        if (modelo.getMotor().setEstadoActual(estado)) {
            exito = true;
            
            if (estado == EstadosMotor.APAGADO) {
                apagarMotor();
            } else if (estado == EstadosMotor.ACELERANDO) {
                this.acelerar();
            } else if (estado == EstadosMotor.FRENANDO) {
                this.acelerar();
            } else {
                encendido();
            }
        }
        
        actualizarVista();
        
        return exito;
    }
    
    public void setEstadoCrucero(EstadoCrucero estado) {
        modelo.getControlCrucero().setEstadoActual(estado);
    }
    
    private double velocidadLineal(int velocidadAngular) {
        double radioMotor = modelo.getMotor().getTamEje();
        
        double resultado = (2*Math.PI)*radioMotor*velocidadAngular*(60d/100d);
        return resultado;
    }
    
    private void aumentarConsumos(int revoluciones) {
        modelo.getConsumoCombustible().setRpm(revoluciones);
        modelo.getConsumoAceite().setRpm(revoluciones);
        modelo.getConsumoFrenos().setRpm(revoluciones);
        modelo.getConsumoGeneral().setRpm(revoluciones);
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
        int incrementoRevoluciones = 100;
        
        public void setIncrementoRevoluciones(int incremento) {
            this.incrementoRevoluciones = incremento;
        }
        
        @Override
        public void run() {
            EstadosMotor estadoActual = modelo.getMotor().getEstadoActual();
            int rozamiento = modelo.getMotor().getFactorRozamiento();
            
            if (estadoActual == EstadosMotor.FRENANDO)
                this.incrementoRevoluciones = -incrementoRevoluciones;
            
            while(modelo.getMotor().getEstadoActual() == estadoActual) {
                int nuevasRevoluciones = modelo.getMotor().getRevoluciones() + (incrementoRevoluciones - rozamiento);
                modelo.getMotor().setRevoluciones(nuevasRevoluciones);
                aumentarConsumos(nuevasRevoluciones);
                    
                if (modelo.getMotor().getRevoluciones() < 0) {
                    modelo.getMotor().setRevoluciones(0);
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
    }
}
