
package s1e1_darioymaria;

public abstract class Bicicleta extends Thread{
    
    private int idBicicleta;
    
    Bicicleta(int id){
        idBicicleta = id;
        this.start();
    }
    
    
}