/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package s4;

import java.util.ArrayList;

public class CadenaFiltros {
    ArrayList<Filtro> filtros;
    
    public CadenaFiltros() {
        filtros = new ArrayList<>();
    }
    
    public void addFiltro(Filtro filtro) {
        filtros.add(filtro);
    }
    
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor) {
        for (Filtro f : filtros) {
            revoluciones = f.ejecutar(revoluciones, estadoMotor);
        }
        
        return revoluciones;
    }
}
