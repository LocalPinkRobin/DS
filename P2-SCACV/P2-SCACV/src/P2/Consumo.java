package P2;

public abstract class Consumo {
    int rpm;
    Boolean aviso = false;


    public abstract Boolean aviso ();

    public void repostar(){
        aviso = false;
        rpm = 0;
    }
    
    public void setRpm(int rpm) {
        this.rpm = rpm;
    }

}
