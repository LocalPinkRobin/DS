
package s1e1_darioymaria;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Bicicleta extends Thread{
    
    private int idBicicleta;
    
    Bicicleta(int id){
        idBicicleta = id;

    }
            
    @Override
    public void run(){
        try {
            this.sleep(60000);
            
        /*--------------------------------------------------------------------*/
        String mensaje = "Bicicleta " + Integer.toString(this.idBicicleta) + " arranca";
        System.out.println(mensaje);
        /*--------------------------------------------------------------------*/
        
        } catch (InterruptedException ex) {
            Logger.getLogger(Bicicleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}