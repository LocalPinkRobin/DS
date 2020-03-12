/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package s4;

public abstract class Filtro {
    
    public enum EstadoMotor {
        ENCENDIDO, APAGADO, ACELERANDO, FRENANDO;
    }
    
    private double incrementoVelocidad;
    
    public abstract double ejecutar(double revoluciones, EstadoMotor estadoMotor);
    
    public double getIncrementoVelocidad() {
        return this.incrementoVelocidad;
    }
    
    public void setIncrementoVelocidad(double incrementoVelocidad) {
        this.incrementoVelocidad = incrementoVelocidad;
    }
}
