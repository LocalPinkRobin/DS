/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package s4;

public class CalcularVelocidad extends Filtro {
    
    public CalcularVelocidad() {
        setIncrementoVelocidad(-100);
    }
    
    @Override
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor) {
        double resultado = revoluciones;
        
        if (estadoMotor == EstadoMotor.ACELERANDO) {
            resultado -= getIncrementoVelocidad();
        } else if (estadoMotor == EstadoMotor.FRENANDO) {
            resultado += getIncrementoVelocidad();
        }
        
        return resultado;
    }
    
}
