/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package s4;

public class RepercutirRozamiento implements Filtro {
    
    private double rozamiento = 50;
    
    @Override
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor) {
        double aux = revoluciones - this.rozamiento;
        
        if (aux < 0) 
            aux = 0;
        
        return aux;
    }
}
