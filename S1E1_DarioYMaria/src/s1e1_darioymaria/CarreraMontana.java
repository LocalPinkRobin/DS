
package s1e1_darioymaria;
import java.util.ArrayList;
import java.util.Random; 

public class CarreraMontana extends Carrera{
    CarreraMontana(int n){
        super(n);
        for (int i = 0; i < n; i++) {
            bicicletas.add(new BicicletaMontana(i));
            bicicletas.get(i).start();
            
        }
    }
    
    
    public void retira(){
        super.retira(0.2f);
    }
}