
package s1e1_darioymaria;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Carrera {
   
    ArrayList <Bicicleta> bicicletas;
    float retirados;
    
    
    Carrera ( int n){
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
    
    public void comenzar() throws InterruptedException {
        int rand = ThreadLocalRandom.current().nextInt(20,50000);
        for (Bicicleta b : bicicletas) {
            b.start();
        }
        
        /*--------------------------------------------------------------------*/
        System.out.println("Carrera iniciada");
        /*--------------------------------------------------------------------*/
        
        Thread.sleep(rand); // Hace esperar al hilo actual rand milisegundos
        this.retira(retirados);
        
        /*--------------------------------------------------------------------*/
        System.out.println("Corredores retirados");
        /*--------------------------------------------------------------------*/
    }
}