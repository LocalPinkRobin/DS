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
    
    public void gestionar() {
        CalcularVelocidad filtro1 = new CalcularVelocidad();
        cadena.addFiltro(filtro1);
        
        RepercutirRozamiento filtro2 = new RepercutirRozamiento();
        cadena.addFiltro(filtro2);
    }
}
