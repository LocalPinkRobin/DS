package P2;

import static java.lang.Math.pow;

public class ConsumoAceite extends Consumo{

    @Override
    public Boolean  aviso(){
        if( (rpm >= 5*pow(10,6))){
            aviso = true;
        }
        return aviso;
    }

}
