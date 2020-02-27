
package s1e1_darioymaria;

public class Cliente {

    public static void main(String[] args) {
        
        FactoriaCarreraYBicicleta f1;
        FactoriaCarreraYBicicleta f2;
        Carrera c1;
        Carrera c2;
        
        f1 = new FactoriaCarretera();
        f2 = new FactoriaMontana();
        
        c1 = f1.crearCarrera(100);
        c2 = f2.crearCarrera(100);
    }
    
}
