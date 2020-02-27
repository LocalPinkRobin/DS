
package s1e1_darioymaria;


public class FactoriaMontana implements FactoriaCarreraYBicicleta{
    
    @Override
    public CarreraMontana crearCarrera(int n) {
        CarreraMontana resultado = new CarreraMontana(n);
        return (resultado);
    }

    @Override
    public Bicicleta crearBicicleta(int id) {
        BicicletaMontana resultado = new BicicletaMontana (id);
        return (resultado);
    }

}
