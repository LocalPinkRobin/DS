package P2;

import static java.lang.Math.pow;

public class ConsumoCombustible extends Consumo{

    private Double combustible = Math.random() * (50 - 20 + 1) + 20;
    static final Double MAX = 100d;

    @Override
    public Boolean aviso() {
        if (combustible < 20){
            aviso = true;
        }
        return aviso;
    }

    @Override
    public void compostaje (){
        combustible = MAX;
        aviso = false;
    }

    void actualizarCombustible (){
        combustible = rpm*rpm*5*pow(10,-10);
    }
    Double getCombustible () {
        return (combustible);
    }
}
