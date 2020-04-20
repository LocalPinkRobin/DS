/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package P2;

public class Modelo {
    private Motor motor;
    private ControlCrucero controlCrucero;
    private ConsumoCombustible consumoConbustible;
    private ConsumoAceite consumoAceite;
    private ConsumoFrenos consumoFrenos;
    private ConsumoGeneral consumoGeneral;

    public Motor getMotor() {
        return motor;
    }

    public ControlCrucero getControlCrucero() {
        return controlCrucero;
    }

    public ConsumoCombustible getConsumoConbustible() {
        return consumoConbustible;
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
