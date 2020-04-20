package P2;

public abstract class Consumo {
    Motor motor;
    int rpm;
    Boolean aviso = false;


    public abstract Boolean aviso ();

    public void compostaje(){
        aviso = false;
    }

}
