/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package d3e1mariydario;

public class D3E1MariYDario {

    public static void main(String[] args) {
        GraficaTemperatura grafica = new GraficaTemperatura();
        BotonCambio boton = new BotonCambio();
        PantallaTemperatura pantalla = new PantallaTemperatura();
        
        grafica.setVisible(true);
        boton.setVisible(true);
        pantalla.setVisible(true);
        
        Temperatura temp = new Temperatura(100);
        temp.addObserver(grafica);
        temp.addObserver(boton);
        
        boton.setObservable(temp);
        pantalla.setObservable(temp);
        
        temp.start();
        pantalla.start();
    }
    
}
