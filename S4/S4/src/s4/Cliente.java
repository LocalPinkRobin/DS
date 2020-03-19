/*
 * encoding:utf-8
 * 
 * Autores: María Sánchez Marcos y Darío Megías Guerrero
 */
package s4;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        FrameBotones panel = new FrameBotones();
        GestorFiltros gestorFiltros = new GestorFiltros();
        FrameSalpicadero frameSalpicadero = new FrameSalpicadero();
        Salpicadero salpicadero = new Salpicadero();
        
        // get the screen size as a java dimension
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // get 2/3 of the height, and 2/3 of the width
        int height = screenSize.height * 2 / 3;
        int width = screenSize.width * 2 / 3;

        // set the jframe height and width
        frameSalpicadero.setPreferredSize(new Dimension(width, height));
        
        frameSalpicadero.setLocation(250, 150);
        frameSalpicadero.add(salpicadero);
        frameSalpicadero.setVisible(true);
        
        panel.setVisible(true);
        
        salpicadero.start();
        
        gestorFiltros.crearFiltrosSalpicadero();
        
        while (true) {
            panel.setRevoluciones(gestorFiltros.gestionarSalpicadero(panel.getRevoluciones(), panel.getEstadoMotor(), salpicadero));
            Thread.sleep(100);
        }
    }
    
}
