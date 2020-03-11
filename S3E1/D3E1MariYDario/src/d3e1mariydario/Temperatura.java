/*
 * encoding:utf-8
 *
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package d3e1mariydario;

import java.util.Observable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Temperatura extends Observable {
    
    private Double  temperatura;
    private MiHebra hebra;
    private long    refreshTime;

    public Temperatura(long refreshTime) {
        this.refreshTime = refreshTime;
    }

    public void setState(Double temperatura) {
        this.temperatura = temperatura;
        setChanged();
        System.out.println(Double.toString(this.temperatura));
        notifyObservers();
    }

    public Double getState() {
        return this.temperatura;
    }

    public void start() {
        this.hebra = new MiHebra();
        hebra.start();
    }
    
    @Override
    public void notifyObservers() {
        super.notifyObservers();
        System.out.println("Notified all observers");
    }

    public class MiHebra extends Thread {
        @Override
        public void run() {
            Double nuevaTemperatura;
            
            while (true){
                nuevaTemperatura = getRandom();
                setState(nuevaTemperatura);
                
                try {
                    sleep(refreshTime);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Temperatura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        public double getRandom() {
            Random rand = new Random();
            return  56 * rand.nextDouble();
        }
    }
}
