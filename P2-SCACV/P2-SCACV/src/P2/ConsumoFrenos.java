package P2;

import static java.lang.Math.pow;

public class ConsumoFrenos extends Consumo{

    @Override
    public Boolean  aviso(){
        if( (rpm >= (pow(10,8)))){
            aviso = true;
        }
        return aviso;
    }
}
