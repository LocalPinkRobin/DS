/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package d3e1mariydario;

public class D3E1MariYDario {

    public static void main(String[] args) {
        GraficaTemperatura grafica = new GraficaTemperatura();
        grafica.setVisible(true);
        BotonCambio boton = new BotonCambio();
        boton.setVisible(true);
        
        Temperatura temp = new Temperatura();
        temp.addObserver(grafica);
        
        temp.addObserver(boton);
        boton.setObservable(temp);
        
        temp.start();
    }
    
}
