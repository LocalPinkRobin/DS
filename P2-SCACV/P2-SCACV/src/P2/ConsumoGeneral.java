package P2;

import static java.lang.Math.pow;

public class ConsumoGeneral extends Consumo{
    
    @Override
    public Boolean  aviso(){
        if( (rpm >= (pow(10,9)))){
            aviso = true;
        }
        return aviso;
    }
}
