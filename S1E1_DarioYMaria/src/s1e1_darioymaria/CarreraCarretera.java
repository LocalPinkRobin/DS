
package s1e1_darioymaria;
import java.util.ArrayList;
import java.util.Random;

public class CarreraCarretera extends Carrera{
    CarreraCarretera(int n){
        super(n);
        for (int i = 0; i < n; i++) {
            bicicletas.add(new BicicletaCarretera(i));
            bicicletas.get(i).start();

        }        
    }
    
    public void retira(){
        super.retira(0.1f);
    }
} 