/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Vista extends javax.swing.JFrame {
    
    private static DecimalFormat df1 = new DecimalFormat("0.0");
    private static DecimalFormat df2 = new DecimalFormat("0.00");
    
    private Controlador controlador;

    public Vista() {
        initComponents();
    }
    
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    private void permutarColorBoton(javax.swing.JButton boton, Color apagado, Color encendido) {
        if (boton.getForeground() == apagado)
                boton.setForeground(encendido);
        else
            boton.setForeground(apagado);
    }
    
    private void desactivarBotones(ArrayList<javax.swing.JButton> botones) {
        for (javax.swing.JButton boton : botones) {
            boton.setForeground(Color.black);
        }
    }
    
    void pulsarAcelerarSCACV(Boolean cambiarEstado) {
        
        desactivarBotones(new ArrayList<>(Arrays.asList(mantenerSCACV,reiniciarSCACV,apagadoSCACV)));
        this.permutarColorBoton(acelerarSCACV, Color.black, Color.red);
        this.etiquetaCrucero.setText("ACELERANDO");
        if (cambiarEstado) {
            controlador.setEstadoCrucero(EstadoCrucero.ACELERAR);
        }
        this.desactivarAcelerador();
    }
    
    void pulsarMantenerSCACV(Boolean cambiarEstado) {
        desactivarBotones(new ArrayList<>(Arrays.asList(acelerarSCACV,reiniciarSCACV,apagadoSCACV)));
        this.permutarColorBoton(mantenerSCACV, Color.black, Color.red);
        this.etiquetaCrucero.setText("MANTENIENDO");
        if (cambiarEstado) {
            controlador.setEstadoCrucero(EstadoCrucero.MANTENER);
        }
        this.desactivarAcelerador();
    }
    
    void pulsarReiniciarSCACV(Boolean cambiarEstado) {
        desactivarBotones(new ArrayList<>(Arrays.asList(mantenerSCACV,acelerarSCACV,apagadoSCACV)));
        this.permutarColorBoton(reiniciarSCACV, Color.black, Color.red);
        this.etiquetaCrucero.setText("REINICIANDO");
        if (cambiarEstado) {
            controlador.setEstadoCrucero(EstadoCrucero.REINICIAR);
        }
        this.desactivarAcelerador();
    }
    
    void pulsarApagadoSCACV(Boolean cambiarEstado) {
        desactivarBotones(new ArrayList<>(Arrays.asList(mantenerSCACV,reiniciarSCACV,acelerarSCACV)));
        this.permutarColorBoton(apagadoSCACV, Color.black, Color.red);
        this.etiquetaCrucero.setText("APAGADO");
        if (cambiarEstado) {
            controlador.setEstadoCrucero(EstadoCrucero.APAGADO);
        }
    }
    
    private void activarEncender() {
        encender.setSelected(true);
        encender.setText("APAGAR");
        encender.setForeground(Color.red);
    }
    
    private void desactivarEncender() {
        encender.setSelected(false);
        encender.setText("ENCENDER");
        encender.setForeground(Color.black);
    }
    
    private void activarAcelerador() {
        acelerar.setSelected(true);
        acelerar.setText("Soltar acelerador");
        acelerar.setForeground(Color.red);
    }
    
    private void desactivarAcelerador() {
        acelerar.setSelected(false);
        acelerar.setText("ACELERAR");
        acelerar.setForeground(Color.black);
    }
    
    private void activarFreno() {
        frenar.setSelected(true);
        frenar.setText("Soltar freno");
        frenar.setForeground(Color.red);
    }
    
    private void desactivarFreno() {
        frenar.setSelected(false);
        frenar.setText("FRENAR");
        frenar.setForeground(Color.black);
    }
        
    //NUEVOS////////////////////////////////////////////////////////////////////
    
    
    public void setRevoluciones(int revoluciones) {
        radial2.setValue((double)revoluciones);
    }
    
    public void setEstadoMotor(EstadosMotor e){

        if(e == EstadosMotor.APAGADO){
            estado.setText("APAGADO");
            estado.setForeground(Color.red);
        } else if(e == EstadosMotor.ENCENDIDO){
            estado.setText("ENCENCIDO");
            estado.setForeground(Color.green);
        } else if( e == EstadosMotor.ACELERANDO){            
            estado.setText("ACELERANDO");
            estado.setForeground(Color.green);
        } else if (e == EstadosMotor.FRENANDO){            
            estado.setText("FRENANDO");
            estado.setForeground(Color.yellow);
        }
    }
    
    public void setEstadoCrucero(EstadoCrucero e){
        
        if (e == EstadoCrucero.ACELERAR){
            etiquetaCrucero.setText("ACELERANDO");
        } else if (e == EstadoCrucero.APAGADO){
            etiquetaCrucero.setText("APAGADO");
        } else if (e == EstadoCrucero.MANTENER){
            etiquetaCrucero.setText("VELOCIDAD MANTENIDA");
        } else if (e == EstadoCrucero.REINICIAR){
            etiquetaCrucero.setText("REINICIANDO VELOCIDAD CRUCERO");

        }
        
    }
    
    public void setKmh (Double kmh){
        radial1.setValue(kmh);
      
    }
    
    public void setKmRecientes(Double km){
        cuentakmrecientes.setLcdValue(km);
    }
    
    public void setKmTotales (Double totales){
        cuentakmtotal.setLcdValue(totales);

    }
    
    public void velGuardada (Double ultima){
        if (ultima == 0d)
            ultimaVelocidad.setText("No Hay");
        else
            ultimaVelocidad.setText(df1.format(ultima));
    }
    
    public void avisoCombustible (Boolean aviso){
        if (aviso)
            gasolina.setForeground(Color.red);
        else
            gasolina.setForeground(Color.black);
    }
    
    public void avisoAceite (Boolean aviso){
        if (aviso)
            aceite.setForeground(Color.red);
        else
            aceite.setForeground(Color.black);

    }
    
    public void avisoFrenos (Boolean aviso){
        if (aviso)
            frenos.setForeground(Color.red);
        else
            frenos.setForeground(Color.black);
    }
    
    public void avisoGeneral (Boolean aviso){
        if (aviso)
            revision.setForeground(Color.red);
        else
            revision.setForeground(Color.black);
    }
    
    public void setNivelCombustible(Double nivel) {
        nivelGasolina.setText(df1.format(nivel) + "%");
        gasol.setValue(nivel);
    }
    
    public void setNivelAceite(Double nivel) {
        nivelAceite.setText(df1.format(nivel) + "%");
    }
    
    public void setNivelFrenos(Double nivel) {
        nivelFreno.setText(df1.format(nivel) + "%");
    }
    
    public void setEstadoGeneral(Double nivel) {
        estadoGeneral.setText(df1.format(nivel) + "%");
    }
    
    public void permutarMantenimiento(Boolean cambiar) {
        repostar.setVisible(cambiar);
        cambiarAceite.setVisible(cambiar);
        cambiarFrenos.setVisible(cambiar);
        revisionGeneral.setVisible(cambiar);
    }
    
    public void setUltimasRpmAceite(int rpm){
        ultimarpmaceite.setText(Integer.toString(rpm));
    }
    
    public void setUltimasRpmFrenos (int rpm){
        ultimarpmfrenos.setText(Integer.toString(rpm));

    }
    public void setUltimasRpmRevision (int rpm){
        ultimarpmrevision.setText(Integer.toString(rpm));

    }
    
    ////////////////////////////////////////////////////////////////////////////

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        encender = new javax.swing.JToggleButton();
        acelerar = new javax.swing.JToggleButton();
        frenar = new javax.swing.JToggleButton();
        estado = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        radial2 = new eu.hansolo.steelseries.gauges.Radial();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cuentakmrecientes = new eu.hansolo.steelseries.gauges.DisplaySingle();
        cuentakmtotal = new eu.hansolo.steelseries.gauges.DisplaySingle();
        gasol = new eu.hansolo.steelseries.gauges.Radial1Square();
        gasolina = new javax.swing.JLabel();
        nivelGasolina = new javax.swing.JLabel();
        repostar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        radial1 = new eu.hansolo.steelseries.gauges.Radial();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        etiquetaCrucero = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ultimaVelocidad = new javax.swing.JLabel();
        acelerarSCACV = new javax.swing.JButton();
        mantenerSCACV = new javax.swing.JButton();
        reiniciarSCACV = new javax.swing.JButton();
        apagadoSCACV = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        frenos = new javax.swing.JLabel();
        aceite = new javax.swing.JLabel();
        revision = new javax.swing.JLabel();
        cambiarAceite = new javax.swing.JButton();
        cambiarFrenos = new javax.swing.JButton();
        revisionGeneral = new javax.swing.JButton();
        nivelAceite = new javax.swing.JLabel();
        nivelFreno = new javax.swing.JLabel();
        estadoGeneral = new javax.swing.JLabel();
        ultimarpmaceite = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ultimarpmfrenos = new javax.swing.JLabel();
        ultimarpmrevision = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(205, 255, 217));

        encender.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        encender.setForeground(new java.awt.Color(0, 255, 0));
        encender.setText("ENCENDER");
        encender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encenderActionPerformed(evt);
            }
        });

        acelerar.setText("ACELERAR");
        acelerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acelerarActionPerformed(evt);
            }
        });

        frenar.setText("FRENAR");
        frenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frenarActionPerformed(evt);
            }
        });

        estado.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        estado.setForeground(new java.awt.Color(255, 0, 51));
        estado.setText("APAGADO");

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        radial2.setMaxValue(5000.0);
        radial2.setTitle("Revoluciones");
        radial2.setUnitString("rpm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radial2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radial2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Distancia recorrida");

        jLabel4.setText("Reciente:");
        jLabel4.setToolTipText("");

        jLabel5.setText("Total:");

        cuentakmrecientes.setLcdDecimals(2);
        cuentakmrecientes.setLcdUnitString("Km");

        javax.swing.GroupLayout cuentakmrecientesLayout = new javax.swing.GroupLayout(cuentakmrecientes);
        cuentakmrecientes.setLayout(cuentakmrecientesLayout);
        cuentakmrecientesLayout.setHorizontalGroup(
            cuentakmrecientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 129, Short.MAX_VALUE)
        );
        cuentakmrecientesLayout.setVerticalGroup(
            cuentakmrecientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        cuentakmtotal.setLcdDecimals(2);
        cuentakmtotal.setLcdUnitString("Km");

        javax.swing.GroupLayout cuentakmtotalLayout = new javax.swing.GroupLayout(cuentakmtotal);
        cuentakmtotal.setLayout(cuentakmtotalLayout);
        cuentakmtotalLayout.setHorizontalGroup(
            cuentakmtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );
        cuentakmtotalLayout.setVerticalGroup(
            cuentakmtotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        gasol.setTitle("Gasolina");

        javax.swing.GroupLayout gasolLayout = new javax.swing.GroupLayout(gasol);
        gasol.setLayout(gasolLayout);
        gasolLayout.setHorizontalGroup(
            gasolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );
        gasolLayout.setVerticalGroup(
            gasolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 231, Short.MAX_VALUE)
        );

        gasolina.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        gasolina.setText("Gasolina");

        nivelGasolina.setText("0%");

        repostar.setText("Repostar");
        repostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gasolina)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(nivelGasolina)))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(repostar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(gasol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(47, 47, 47)
                                .addComponent(cuentakmrecientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(48, 48, 48)
                                .addComponent(cuentakmtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(gasolina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nivelGasolina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(repostar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gasol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(cuentakmrecientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel4)
                                .addGap(29, 29, 29)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cuentakmtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel5)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        radial1.setMaxValue(300.0);
        radial1.setThreshold(120.0);
        radial1.setTitle("Velocimetro");
        radial1.setUnitString("Km/h");

        javax.swing.GroupLayout radial1Layout = new javax.swing.GroupLayout(radial1);
        radial1.setLayout(radial1Layout);
        radial1Layout.setHorizontalGroup(
            radial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 265, Short.MAX_VALUE)
        );
        radial1Layout.setVerticalGroup(
            radial1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radial1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(radial1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("SCACV");

        etiquetaCrucero.setText("APAGADO");

        jLabel13.setText("Velocidad guardada:");

        jLabel14.setText("Estado:");

        ultimaVelocidad.setText("No Hay");

        acelerarSCACV.setText("ACELERAR");
        acelerarSCACV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acelerarSCACVActionPerformed(evt);
            }
        });

        mantenerSCACV.setText("MANTENER");
        mantenerSCACV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mantenerSCACVActionPerformed(evt);
            }
        });

        reiniciarSCACV.setText("REINICIAR");
        reiniciarSCACV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarSCACVActionPerformed(evt);
            }
        });

        apagadoSCACV.setForeground(new java.awt.Color(255, 0, 0));
        apagadoSCACV.setText("APAGADO");
        apagadoSCACV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagadoSCACVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(acelerarSCACV, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mantenerSCACV)
                                .addGap(18, 18, 18)
                                .addComponent(reiniciarSCACV, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(apagadoSCACV, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(30, 30, 30)
                                        .addComponent(etiquetaCrucero))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ultimaVelocidad)))))
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(317, 317, 317))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acelerarSCACV)
                    .addComponent(mantenerSCACV)
                    .addComponent(reiniciarSCACV)
                    .addComponent(apagadoSCACV))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCrucero)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(ultimaVelocidad))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel8.setText("Motor:");

        frenos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        frenos.setText("Pastillas de Freno");

        aceite.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        aceite.setText("Aceite");

        revision.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        revision.setText("Revisión general");

        cambiarAceite.setText("Cambiar aceite");
        cambiarAceite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarAceiteActionPerformed(evt);
            }
        });

        cambiarFrenos.setText("Cambiar Frenos");
        cambiarFrenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarFrenosActionPerformed(evt);
            }
        });

        revisionGeneral.setText("Hacer revision general");
        revisionGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revisionGeneralActionPerformed(evt);
            }
        });

        nivelAceite.setText("0%");

        nivelFreno.setText("0%");

        estadoGeneral.setText("0%");

        ultimarpmaceite.setText("0");

        jLabel10.setText("r.p.m acumulado");

        jLabel11.setText("r.p.m acumulado");

        jLabel12.setText("r.p.m acumulado");

        ultimarpmfrenos.setText("0");

        ultimarpmrevision.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel8)
                                .addGap(106, 106, 106)
                                .addComponent(estado))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(encender, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(acelerar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(frenar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(frenos)
                            .addComponent(revision)
                            .addComponent(aceite))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nivelFreno, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(estadoGeneral, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nivelAceite, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ultimarpmfrenos)
                            .addComponent(ultimarpmrevision)
                            .addComponent(ultimarpmaceite))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(revisionGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cambiarFrenos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cambiarAceite, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nivelAceite)
                                    .addComponent(aceite)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(estado)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(encender, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(acelerar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(frenar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cambiarAceite, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(ultimarpmaceite))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cambiarFrenos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(ultimarpmfrenos)
                            .addComponent(frenos)
                            .addComponent(nivelFreno))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(revisionGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(ultimarpmrevision)
                                .addComponent(revision)
                                .addComponent(estadoGeneral)))
                        .addGap(32, 32, 32)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void encenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encenderActionPerformed
        if (encender.isSelected()) {
            if (controlador.setEstadoMotor(EstadosMotor.ENCENDIDO)) {
                activarEncender();
                desactivarAcelerador();
                desactivarFreno();
            } else {
                desactivarEncender();
            }
        } else {
            if (controlador.setEstadoMotor(EstadosMotor.APAGADO)) {
            desactivarEncender();
            desactivarAcelerador();
            desactivarFreno();
            } else {
                activarEncender();
            }
        }

        repaint();
        revalidate();
    }//GEN-LAST:event_encenderActionPerformed

    private void acelerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acelerarActionPerformed
        if (encender.isSelected() && !frenar.isSelected()) {
            if (acelerar.isSelected()) {
                if (encender.isSelected() && controlador.setEstadoMotor(EstadosMotor.ACELERANDO)) {
                    activarAcelerador();
                } else {
                    desactivarAcelerador();
                }

            } else {
                if (controlador.setEstadoMotor(EstadosMotor.ENCENDIDO)) {
                    desactivarAcelerador();
                } else {
                    activarAcelerador();
                }
            }

            repaint();
            revalidate();
        }
    }//GEN-LAST:event_acelerarActionPerformed

    private void frenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frenarActionPerformed
        if (encender.isSelected() && !acelerar.isSelected()) {
            if (frenar.isSelected()) {
                if (encender.isSelected() && controlador.setEstadoMotor(EstadosMotor.FRENANDO)) {
                    activarFreno();
                } else {
                    desactivarFreno();
                }

            } else {
                if (controlador.setEstadoMotor(EstadosMotor.ENCENDIDO)) {
                    desactivarFreno();
                } else {
                    activarFreno();
                }
            }

            repaint();
            revalidate();
        }
    }//GEN-LAST:event_frenarActionPerformed

    private void repostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repostarActionPerformed
        controlador.repostar();
    }//GEN-LAST:event_repostarActionPerformed

    private void cambiarAceiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarAceiteActionPerformed
        setUltimasRpmAceite(controlador.modelo.getConsumoAceite().getRpmTotales());
        controlador.cambiarAceite();
    }//GEN-LAST:event_cambiarAceiteActionPerformed

    private void cambiarFrenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarFrenosActionPerformed
        setUltimasRpmFrenos(controlador.modelo.getConsumoFrenos().getRpmTotales());
        controlador.cambiarFrenos();

    }//GEN-LAST:event_cambiarFrenosActionPerformed

    private void revisionGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revisionGeneralActionPerformed
        setUltimasRpmRevision(controlador.modelo.getConsumoGeneral().getRpmTotales());    
        controlador.hacerRevisionGeneral();
    }//GEN-LAST:event_revisionGeneralActionPerformed

    private void acelerarSCACVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acelerarSCACVActionPerformed
        this.pulsarAcelerarSCACV(true);
    }//GEN-LAST:event_acelerarSCACVActionPerformed

    private void mantenerSCACVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mantenerSCACVActionPerformed
        this.pulsarMantenerSCACV(true);
    }//GEN-LAST:event_mantenerSCACVActionPerformed

    private void reiniciarSCACVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarSCACVActionPerformed
        this.pulsarReiniciarSCACV(true);
    }//GEN-LAST:event_reiniciarSCACVActionPerformed

    private void apagadoSCACVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagadoSCACVActionPerformed
        this.pulsarApagadoSCACV(true);
    }//GEN-LAST:event_apagadoSCACVActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aceite;
    private javax.swing.JToggleButton acelerar;
    private javax.swing.JButton acelerarSCACV;
    private javax.swing.JButton apagadoSCACV;
    private javax.swing.JButton cambiarAceite;
    private javax.swing.JButton cambiarFrenos;
    private eu.hansolo.steelseries.gauges.DisplaySingle cuentakmrecientes;
    private eu.hansolo.steelseries.gauges.DisplaySingle cuentakmtotal;
    private javax.swing.JToggleButton encender;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel estadoGeneral;
    private javax.swing.JLabel etiquetaCrucero;
    private javax.swing.JToggleButton frenar;
    private javax.swing.JLabel frenos;
    private eu.hansolo.steelseries.gauges.Radial1Square gasol;
    private javax.swing.JLabel gasolina;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton mantenerSCACV;
    private javax.swing.JLabel nivelAceite;
    private javax.swing.JLabel nivelFreno;
    private javax.swing.JLabel nivelGasolina;
    private eu.hansolo.steelseries.gauges.Radial radial1;
    private eu.hansolo.steelseries.gauges.Radial radial2;
    private javax.swing.JButton reiniciarSCACV;
    private javax.swing.JButton repostar;
    private javax.swing.JLabel revision;
    private javax.swing.JButton revisionGeneral;
    private javax.swing.JLabel ultimaVelocidad;
    private javax.swing.JLabel ultimarpmaceite;
    private javax.swing.JLabel ultimarpmfrenos;
    private javax.swing.JLabel ultimarpmrevision;
    // End of variables declaration//GEN-END:variables
}
