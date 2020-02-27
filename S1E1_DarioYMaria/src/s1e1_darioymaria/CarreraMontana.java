
package s1e1_darioymaria;

public class CarreraMontana extends Carrera{
    CarreraMontana(int n){
        super(n);
        retirados = 0.2f;
        
        for (int i = 0; i < n; i++) {
            bicicletas.add(new BicicletaMontana(i));
        }
    }
    
    
    public void retira(){
        super.retira(0.2f);
    }
}