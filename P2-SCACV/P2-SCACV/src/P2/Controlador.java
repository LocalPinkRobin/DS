/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package P2;

public class Controlador {
    Modelo modelo;
    Vista vista;
    
    public Controlador() {
        modelo = new Modelo();
        vista = new Vista(this);
    }
    
    public void ejecutar() {
        
    }
    
    public Boolean setEstadoMotor(EstadosMotor estado) {
        Boolean exito = false;   
     
        if (modelo.getMotor().setEstadoActual(estado))
            exito = true;
        
        return exito;
    }
    
    public void setEstadoCrucero(EstadoCrucero estado) {
        modelo.getControlCrucero().setEstadoActual(estado);
    }
}
