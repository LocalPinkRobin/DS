/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package d3e1mariydario;

import java.util.Observable;

public class Temperatura extends Observable {
    private float temperatura;
    
    public Temperatura(float temperatura) {
         this.temperatura = temperatura;
    }
    
    public void setState(float temperatura) {
        this.temperatura = temperatura;
        setChanged();
    }
    
    public float getState() {
        return this.temperatura;
    }
}
