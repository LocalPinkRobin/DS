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
    private Double temperatura;
    private MiHebra hebra;

    public Temperatura() {}

    public void setState(Double temperatura) {
        this.temperatura = temperatura;
        setChanged();
    }

    public Double getState() {
        return this.temperatura;
    }

    public void start() {
        this.hebra = new MiHebra();
        hebra.start();
    }

    public class MiHebra extends Thread {
        @Override
        public void run() {
            Double nuevaTemperatura;
            while (true){
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Temperatura.class.getName()).log(Level.SEVERE, null, ex);
                }
                nuevaTemperatura = getRandom();
                setState(nuevaTemperatura);
            }
        }
        public double getRandom() {
            Random rand = new Random();
            return  56 * rand.nextDouble();
        }
    }
}
