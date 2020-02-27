package s1e1_darioymaria;

import java.util.logging.Level;
import java.util.logging.Logger;

public interface FactoriaCarreraYBicicleta {
    public abstract Carrera crearCarrera(int n);
    public abstract Bicicleta crearBicicleta(int id);
    
    public default void comenzarCarrera(Carrera carrera) {
        try {
            carrera.comenzar();
        } catch (InterruptedException ex) {
            Logger.getLogger(FactoriaCarretera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
