
package s1e1_darioymaria;
import java.util.ArrayList;
import java.util.Random;

public abstract class Carrera {
   
    ArrayList <Bicicleta> bicicletas;
    
    
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
}