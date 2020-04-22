package P2;

import static java.lang.Math.pow;

public class ConsumoFrenos extends Consumo{
    
    private static final Double MAX = pow(10,8);

    @Override
    public Boolean  aviso(){
        if( (rpmTotales >= (MAX))){
            aviso = true;
        }
        return aviso;
    }
    
    @Override
    protected void actualizarNivel() {
        nivel = 100 - ((rpmTotales/MAX)*100);
    }
}
