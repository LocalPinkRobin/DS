package P2;

import static java.lang.Math.abs;

public abstract class Consumo {
    protected int rpmActuales = 0;
    protected int rpmAnteriores = 0;
    protected int incrementoRpm = 0;
    protected int rpmTotales = 0;
    protected Boolean aviso = false;
    
    protected Double nivel = 0d;


    public abstract Boolean aviso ();
    
    protected abstract void actualizarNivel();
    
    public Double getNivel() {
        return nivel;
    }

    public void repostar(){
        aviso = false;
        rpmActuales = 0;
        rpmAnteriores = 0;
        rpmTotales = 0;
    }
    
    public void setRpm(int rpmActuales, Boolean actualizar) {
        this.rpmActuales = rpmActuales;
        
        int incremento = rpmActuales - rpmAnteriores;
        incrementoRpm = (incremento >= 0) ? incremento : 0;
        rpmTotales += incrementoRpm + rpmAnteriores;
        rpmAnteriores = this.rpmActuales;
        
        if (actualizar)
            actualizarNivel();
    }
    public int getRpmTotales(){
        return rpmTotales;
    }

}
