package P2;

import static java.lang.Math.pow;

public class ConsumoAceite extends Consumo{
    
    private static final Double MAX = 5*pow(10,7);

    @Override
    public Boolean  aviso(){
        if( (rpmTotales >= MAX)){
            aviso = true;
        }
        return aviso;
    }
    
    @Override
    protected void actualizarNivel() {
        nivel = 100 - ((rpmTotales/MAX)*100);
    }

}
