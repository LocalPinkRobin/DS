package s1e1_darioymaria;

public interface FactoriaCarreraYBicicleta {
    public abstract Carrera crearCarrera(int n);
    public abstract Bicicleta crearBicicleta(int id);
    
    public default void comenzarCarrera(Carrera carrera) {
        carrera.comenzar();
    }
}
