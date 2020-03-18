/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package s4;

public class CalcularVelocidad implements Filtro {
    
    public double incrementoVelocidad = -100;
    
    @Override
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor) {
        double resultado = revoluciones;
        
        if (estadoMotor == EstadoMotor.ACELERANDO) {
            resultado -= this.incrementoVelocidad;
        } else if (estadoMotor == EstadoMotor.FRENANDO) {
            resultado += incrementoVelocidad;
        }
        
        return resultado;
    }
    
}
