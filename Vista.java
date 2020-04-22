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
        jProgressBarRPM.setValue(revoluciones);
        etiquetaRpm.setText(Integer.toString(revoluciones));
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
        jLabelVelocidad.setText(df1.format(kmh));
    }
    
    public void setKmRecientes(Double km){
        jLabelKilometrosRecientes.setText(df2.format(km));
    }
    
    public void setKmTotales (Double totales){
        jLabelKilometrosTotales.setText(df2.format(totales));

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
        jProgressBarRPM = new javax.swing.JProgressBar();
        jLabelRPM = new javax.swing.JLabel();
        etiquetaRpm = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelKilometrosRecientes = new javax.swing.JLabel();
        jLabelKilometrosTotales = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelVelocidad = new javax.swing.JLabel();
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
        gasolina = new javax.swing.JLabel();
        frenos = new javax.swing.JLabel();
        aceite = new javax.swing.JLabel();
        revision = new javax.swing.JLabel();
        repostar = new javax.swing.JButton();
        cambiarAceite = new javax.swing.JButton();
        cambiarFrenos = new javax.swing.JButton();
        revisionGeneral = new javax.swing.JButton();
        nivelGasolina = new javax.swing.JLabel();
        nivelAceite = new javax.swing.JLabel();
        nivelFreno = new javax.swing.JLabel();
        estadoGeneral = new javax.swing.JLabel();

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

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jProgressBarRPM.setMaximum(6000);

        jLabelRPM.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabelRPM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRPM.setText("RPM");

        etiquetaRpm.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jProgressBarRPM, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabelRPM, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(etiquetaRpm)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRPM, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(etiquetaRpm)
                .addGap(18, 18, 18)
                .addComponent(jProgressBarRPM, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Distancia recorrida");

        jLabel4.setText("Reciente:");
        jLabel4.setToolTipText("");

        jLabelKilometrosRecientes.setText("Numero");

        jLabelKilometrosTotales.setText("Numero");

        jLabel6.setText("Km");

        jLabel2.setText("Km");

        jLabel5.setText("Total:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelKilometrosRecientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelKilometrosTotales)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelKilometrosRecientes)
                    .addComponent(jLabel2))
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelKilometrosTotales)
                    .addComponent(jLabel6))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Km/h");

        jLabelVelocidad.setFont(new java.awt.Font("DejaVu Sans", 0, 36)); // NOI18N
        jLabelVelocidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelVelocidad.setText("Valor Velocidad");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(30, 30, 30)
                                .addComponent(etiquetaCrucero))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ultimaVelocidad))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(mantenerSCACV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(reiniciarSCACV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(apagadoSCACV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(acelerarSCACV, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(acelerarSCACV)
                .addGap(18, 18, 18)
                .addComponent(mantenerSCACV)
                .addGap(18, 18, 18)
                .addComponent(reiniciarSCACV)
                .addGap(25, 25, 25)
                .addComponent(apagadoSCACV)
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaCrucero)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(ultimaVelocidad))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel8.setText("Motor:");

        gasolina.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        gasolina.setText("Gasolina");

        frenos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        frenos.setText("Pastillas de Freno");

        aceite.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        aceite.setText("Aceite");

        revision.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        revision.setText("Revisión general");

        repostar.setText("Repostar");
        repostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repostarActionPerformed(evt);
            }
        });

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

        nivelGasolina.setText("0%");

        nivelAceite.setText("0%");

        nivelFreno.setText("0%");

        estadoGeneral.setText("0%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
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
                                .addComponent(frenar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(52, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cambiarFrenos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(repostar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(frenos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cambiarAceite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(revisionGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(revision))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nivelFreno, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(estadoGeneral, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(aceite)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nivelAceite))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(gasolina)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nivelGasolina)))
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(estado)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(encender, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(acelerar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(frenar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gasolina)
                            .addComponent(nivelGasolina))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(aceite)
                            .addComponent(nivelAceite))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(frenos)
                            .addComponent(nivelFreno))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(revision)
                            .addComponent(estadoGeneral))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(repostar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cambiarAceite, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cambiarFrenos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(revisionGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
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
        controlador.cambiarAceite();
    }//GEN-LAST:event_cambiarAceiteActionPerformed

    private void cambiarFrenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarFrenosActionPerformed
        controlador.cambiarFrenos();
    }//GEN-LAST:event_cambiarFrenosActionPerformed

    private void revisionGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revisionGeneralActionPerformed
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
    private javax.swing.JToggleButton encender;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel estadoGeneral;
    private javax.swing.JLabel etiquetaCrucero;
    private javax.swing.JLabel etiquetaRpm;
    private javax.swing.JToggleButton frenar;
    private javax.swing.JLabel frenos;
    private javax.swing.JLabel gasolina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelKilometrosRecientes;
    private javax.swing.JLabel jLabelKilometrosTotales;
    private javax.swing.JLabel jLabelRPM;
    private javax.swing.JLabel jLabelVelocidad;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBarRPM;
    private javax.swing.JButton mantenerSCACV;
    private javax.swing.JLabel nivelAceite;
    private javax.swing.JLabel nivelFreno;
    private javax.swing.JLabel nivelGasolina;
    private javax.swing.JButton reiniciarSCACV;
    private javax.swing.JButton repostar;
    private javax.swing.JLabel revision;
    private javax.swing.JButton revisionGeneral;
    private javax.swing.JLabel ultimaVelocidad;
    // End of variables declaration//GEN-END:variables
}
