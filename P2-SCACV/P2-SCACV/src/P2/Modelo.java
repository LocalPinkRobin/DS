/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package P2;

public class Modelo {
    private Motor motor;
    private ControlCrucero controlCrucero;
    private ConsumoCombustible consumoCombustible;
    private ConsumoAceite consumoAceite;
    private ConsumoFrenos consumoFrenos;
    private ConsumoGeneral consumoGeneral;
    
    public Modelo() {
        motor =              new Motor(0.015, 30);
        controlCrucero =     new ControlCrucero();
        consumoCombustible = new ConsumoCombustible();
        consumoAceite =      new ConsumoAceite();
        consumoFrenos =      new ConsumoFrenos();
        consumoGeneral =     new ConsumoGeneral();
    }

    public Motor getMotor() {
        return motor;
    }

    public ControlCrucero getControlCrucero() {
        return controlCrucero;
    }

    public ConsumoCombustible getConsumoCombustible() {
        return consumoCombustible;
    }

    public ConsumoAceite getConsumoAceite() {
        return consumoAceite;
    }

    public ConsumoFrenos getConsumoFrenos() {
        return consumoFrenos;
    }

    public ConsumoGeneral getConsumoGeneral() {
        return consumoGeneral;
    }
    
    
}
