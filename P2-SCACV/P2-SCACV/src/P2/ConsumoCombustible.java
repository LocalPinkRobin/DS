package P2;

import static java.lang.Math.pow;

public class ConsumoCombustible extends Consumo{
    
    private static final Double MAX = 100d;

    private Double combustible = Math.random() * (50 - 20 + 1) + 20;
    
    public ConsumoCombustible() {
        super();
        actualizarNivel();
    }

    @Override
    public Boolean aviso() {
        if (nivel < 20){
            aviso = true;
        }
        return aviso;
    }
    
    @Override
    public void setRpm(int rpmActuales, Boolean actualizar) {
        super.setRpm(rpmActuales,false);
        actualizarCombustible();
    }

    @Override
    public void repostar (){
        super.repostar();
        combustible = MAX;
        actualizarNivel();
    }

    private void actualizarCombustible (){
        if (incrementoRpm < 1)
            incrementoRpm = 1;
        
        Double incremento = (incrementoRpm*0.155)*rpmActuales*(rpmActuales*0.255)*8*pow(10,-9);
        combustible = ((combustible - incremento) >= 0) ? combustible - incremento : 0 ;
        actualizarNivel();
    }
    
    @Override
    protected void actualizarNivel() {
        nivel = (combustible/MAX)*100;
    }
    
    public Double getCombustible () {
        return combustible;
    }
}
