/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package P2;

public class ControlCrucero{

    private Double velocidadGuardada;
    private EstadoCrucero estadoActual;

    public void setVelocidadGuardada(Double v){
        velocidadGuardada = v;
    }

    public Double getVelocidadGuardada(){
        return velocidadGuardada;
    }

    public EstadoCrucero getEstadoActcual(){
        return (estadoActual);
    }

    public void setEstadoActual(EstadoCrucero e){
        if (estadoActual != e){
            estadoActual = e;
        }
    }

}
