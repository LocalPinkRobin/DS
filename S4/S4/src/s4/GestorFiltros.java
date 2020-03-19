/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package s4;

public class GestorFiltros {
    private CadenaFiltros cadena;
    
    public GestorFiltros() {
        cadena = new CadenaFiltros();
    }
    
    public void crearFiltrosSalpicadero() {
        CalcularVelocidad filtro1 = new CalcularVelocidad();
        cadena.addFiltro(filtro1);
        
        RepercutirRozamiento filtro2 = new RepercutirRozamiento();
        cadena.addFiltro(filtro2);
    }
    
    public double gestionarSalpicadero(double revoluciones, EstadoMotor estadoMotor, Salpicadero salpicadero) {
        double revs = cadena.ejecutar(revoluciones, estadoMotor);
        
        if (revs < 0) {
            revs = 0;
        } else if (revs > 5000) {
            revs = 5000;
        }
        
        salpicadero.ejecutar(revs, estadoMotor);
        return revs;
    }
}
