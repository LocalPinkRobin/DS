/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package P2;

public class Motor {
    private final int MAXREVDEFECTO = 5000;
    
    private EstadosMotor estadoActual = EstadosMotor.APAGADO;
    private int revoluciones;
    private int maxRevoluciones = MAXREVDEFECTO;
    private Double tamEje;
    private int factorRozamiento;
    
    public Motor(Double tamEje, int factorRozamiento) {
        this.tamEje = tamEje;
        this.factorRozamiento = factorRozamiento;
    }

    public EstadosMotor getEstadoActual() {
        return estadoActual;
    }

    public int getRevoluciones() {
        return revoluciones;
    }

    public Double getTamEje() {
        return tamEje;
    }

    public int getFactorRozamiento() {
        return factorRozamiento;
    }

    public int getMaxRevoluciones() {
        return maxRevoluciones;
    }

    public Boolean setEstadoActual(EstadosMotor estado) {
        Boolean exito = false;
        
        if (estado != this.estadoActual) {
            if (estado == EstadosMotor.APAGADO) {
                if (this.estadoActual == EstadosMotor.ENCENDIDO && this.revoluciones == 0) {
                    this.estadoActual = estado;
                    exito = true;
                }
            } else if (estado == EstadosMotor.ENCENDIDO) {
                    this.estadoActual = EstadosMotor.ENCENDIDO;
                    exito = true;
            } else if (estado == EstadosMotor.ACELERANDO) {
                if (this.estadoActual == EstadosMotor.ENCENDIDO) {
                    this.estadoActual = estado;
                    exito = true;
                }
            } else {
                if (this.estadoActual == EstadosMotor.ENCENDIDO) {
                    this.estadoActual = estado;
                    exito = true;
                }
            }
        }
        
        return exito;
    }

    public void setRevoluciones(int revoluciones) {
        if (revoluciones >= 0)
            this.revoluciones = revoluciones;
        else
            this.revoluciones = 0;
    }

    public void setMaxRevoluciones(int maxRevoluciones) {
        if (maxRevoluciones > 0)
            this.maxRevoluciones = maxRevoluciones;
        else
            this.maxRevoluciones = 1;
    }
}
