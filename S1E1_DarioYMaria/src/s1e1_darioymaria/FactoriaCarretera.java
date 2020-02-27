
package s1e1_darioymaria;

public class FactoriaCarretera implements FactoriaCarreraYBicicleta{
        
    @Override
    public CarreraCarretera crearCarrera(int n) {
        CarreraCarretera resultado = new CarreraCarretera(n);
        return (resultado);
    }

    @Override
    public Bicicleta crearBicicleta(int id) {
        BicicletaCarretera resultado = new BicicletaCarretera (id);
        return (resultado);
    }
}
