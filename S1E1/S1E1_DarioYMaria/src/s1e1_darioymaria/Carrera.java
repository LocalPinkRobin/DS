
package s1e1_darioymaria;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Carrera extends Thread {
   
    ArrayList <Bicicleta> bicicletas;
    float retirados;
    
    
    Carrera (int n){
        bicicletas = new ArrayList<>();
    }
    
    protected void retira(float f){
        int porcentaje = (int)(bicicletas.size() * f);
        Random rand = new Random(); 
        int auxiliar;
        for(int i = 0; i < porcentaje; i++){
            auxiliar = rand.nextInt(bicicletas.size());
            bicicletas.get(auxiliar).stop();
            bicicletas.remove(auxiliar);
        }
    }
    
    public void comenzar() {
        this.start();
    }
    
    @Override
    public void run() {
        int rand = ThreadLocalRandom.current().nextInt(20,50000);
        for (Bicicleta b : bicicletas) {
            b.start();
        }
        
        /*--------------------------------------------------------------------*/
        System.out.println("Carrera iniciada");
        /*--------------------------------------------------------------------*/
        
        try {
            Thread.sleep(rand); // Hace esperar al hilo actual rand milisegundos
        } catch (InterruptedException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.retira(this.retirados);
        
        /*--------------------------------------------------------------------*/
        int segundos = rand/1000;
        String mensaje = "Bicicletas forzosamente retiradas a los " + segundos + " segundos";
        System.out.println(mensaje);
        /*--------------------------------------------------------------------*/
    }
}