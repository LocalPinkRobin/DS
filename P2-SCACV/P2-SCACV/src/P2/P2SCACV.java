/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package P2;

public class P2SCACV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AuxFrame frame = new AuxFrame();
        VistaPanel vista = new VistaPanel();
        Controlador controlador = new Controlador(vista);
        
        frame.setPanel(vista);
        controlador.ejecutar();
        
        frame.setVisible(true);
    }
    
}
