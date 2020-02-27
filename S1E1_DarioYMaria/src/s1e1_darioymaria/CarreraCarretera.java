
package s1e1_darioymaria;

public class CarreraCarretera extends Carrera{
    CarreraCarretera(int n){
        super(n);
        retirados = 0.1f;
        
        for (int i = 0; i < n; i++) {
            bicicletas.add(new BicicletaCarretera(i));
        }
    }
    
    public void retira(){
        super.retira(0.1f);
    }
} 