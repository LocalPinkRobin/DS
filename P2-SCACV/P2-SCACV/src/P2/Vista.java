/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P2;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vista extends javax.swing.JFrame {

    private double revoluciones = 0;
    private EstadosMotor estadoMotor = EstadosMotor.APAGADO;
    private EstadoCrucero estadoCrucero = EstadoCrucero.APAGADO;
    
    private double kmh = 0;
    private double kmTotales = 0;
    private double kmRecientes = 0;
    private Controlador controlador;

    public Vista() {
        initComponents();
    }
    
    private void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
    
    private void permutarColor(javax.swing.JToggleButton boton) {
        if (boton.getForeground() == Color.black)
                boton.setForeground(Color.red);
            else
                boton.setForeground(Color.black);
    }
        
    //NUEVOS////////////////////////////////////////////////////////////////////
    
    
    public void setRevoluciones(int revoluciones) {
        jProgressBarRPM.setValue(revoluciones);
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
        jLabelVelocidad.setText(kmh.toString());
    }
    
    public void setKmRecientes(Double km){
        jLabelKilometrosRecientes.setText(km.toString());
    }
    
    public void setKmTotales (Double totales){
        jLabelKilometrosTotales.setText(totales.toString());

    }
    
    public void velGuardada (Double ultima){
        ultimaVelocidad.setText(ultima.toString());
    }
    
    public void avisoCombutible (Boolean aviso){
        gasolina.setForeground(Color.red);
    }
    public void avisoAceite (Boolean aviso){
        aceite.setForeground(Color.red);

    }
    public void avisoFrenos (Boolean aviso){
        frenos.setForeground(Color.red);    
    }
    public void avisoGeneral (Boolean aviso){
        revision.setForeground(Color.red);
        
    }
    
    ////////////////////////////////////////////////////////////////////////////
    public void ejecutar(double revoluciones, EstadosMotor estadoMotor) {
        if (estadoMotor == EstadosMotor.APAGADO)
            kmRecientes = 0;
        
        
        this.kmh = velocidadLineal(revoluciones);

        jLabelVelocidad.setText(Double.toString(kmh));
    }
    
    private double velocidadLineal(double velocidadAngular) {
        double radioMotor = 0.015;
        
        double resultado = (2*Math.PI)*radioMotor*velocidadAngular*(60d/100d);
        return resultado;
    }
    
    public void start() {
        Hebra hebra = new Hebra();
        hebra.start();
    }
    
    public class Hebra extends Thread {
        @Override
        public void run() {
            double kmRecorridos = 0;
            while (true) {
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Salpicadero.class.getName()).log(Level.SEVERE, null, ex);
                }
                kmRecorridos = kmh/3600;
                
                kmTotales += kmRecorridos;
                jLabelKilometrosTotales.setText(Double.toString(kmTotales));
                
                kmRecientes += kmRecorridos;
                jLabelKilometrosRecientes.setText(Double.toString(kmRecientes));
            }
        }
    }
    
    public double getRevoluciones() {
        return revoluciones;
    }
    
    public EstadosMotor getEstadoMotor() {
        return estadoMotor;
    }

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
        acelerarSCACV = new javax.swing.JToggleButton();
        mantenerSCACV = new javax.swing.JToggleButton();
        reiniciarSCACV = new javax.swing.JToggleButton();
        apagadoSCACV = new javax.swing.JToggleButton();
        etiquetaCrucero = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ultimaVelocidad = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        gasolina = new javax.swing.JLabel();
        frenos = new javax.swing.JLabel();
        aceite = new javax.swing.JLabel();
        revision = new javax.swing.JLabel();

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

        jProgressBarRPM.setMaximum(5000);

        jLabelRPM.setFont(new java.awt.Font("DejaVu Sans", 1, 24)); // NOI18N
        jLabelRPM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRPM.setText("RPM");

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
                        .addGap(178, 178, 178)
                        .addComponent(jLabelRPM, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabelRPM, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        apagadoSCACV.setText("APAGADO");
        apagadoSCACV.setToolTipText("");
        apagadoSCACV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagadoSCACVActionPerformed(evt);
            }
        });

        etiquetaCrucero.setText("estadoCrucero");

        jLabel13.setText("Ultima velocidad guardada:");

        jLabel14.setText("Estado:");

        ultimaVelocidad.setText("km");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mantenerSCACV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reiniciarSCACV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(apagadoSCACV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(acelerarSCACV, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel7))
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
                                .addComponent(ultimaVelocidad)))))
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
                .addGap(18, 18, 18)
                .addComponent(apagadoSCACV)
                .addGap(34, 34, 34)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(frenos)
                            .addComponent(revision)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gasolina)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(aceite)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(gasolina)
                        .addGap(18, 18, 18)
                        .addComponent(aceite)
                        .addGap(18, 18, 18)
                        .addComponent(frenos)
                        .addGap(18, 18, 18)
                        .addComponent(revision)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void encenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encenderActionPerformed
        if (encender.isSelected()) {
            if (controlador.setEstadoMotor(EstadosMotor.ENCENDIDO)) {
                encender.setText("APAGAR");
                encender.setForeground(Color.red);
                estado.setText("ENCENDIDO");
            } else {
                encender.setSelected(false);
            }
        } else {
            if (controlador.setEstadoMotor(EstadosMotor.APAGADO)) {
            estado.setText("APAGADO");
            encender.setText("ENCENDER");
            encender.setForeground(Color.green);
            acelerar.setSelected(false);
            frenar.setSelected(false);
            } else {
                encender.setSelected(true);
            }
        }

        repaint();
        revalidate();
    }//GEN-LAST:event_encenderActionPerformed

    private void acelerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acelerarActionPerformed
        if (encender.isSelected() && !frenar.isSelected()) {
            if (acelerar.isSelected()) {
                if (encender.isSelected() && controlador.setEstadoMotor(EstadosMotor.ACELERANDO)) {
                    acelerar.setText("Soltar acelerador");
                    acelerar.setForeground(Color.red);
                    estado.setText("ACELERANDO");   
                } else {
                    acelerar.setSelected(false);
                }

            } else {
                if (controlador.setEstadoMotor(EstadosMotor.ENCENDIDO)) {
                    acelerar.setText("ACELERAR");
                    acelerar.setForeground(Color.black);
                    estado.setText("ENCENDIDO");
                } else {
                    acelerar.setSelected(true);
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
                    frenar.setText("Soltar freno");
                    frenar.setForeground(Color.red);
                    estado.setText("FRENANDO");
                } else {
                    frenar.setSelected(false);
                }

            } else {
                if (controlador.setEstadoMotor(EstadosMotor.ENCENDIDO)) {
                    frenar.setText("FRENAR");
                    frenar.setForeground(Color.black);
                    estado.setText("ENCENDIDO");
                } else {
                    frenar.setSelected(false);
                }
            }

            repaint();
            revalidate();
        }
    }//GEN-LAST:event_frenarActionPerformed

    private void reiniciarSCACVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarSCACVActionPerformed
        controlador.setEstadoCrucero(EstadoCrucero.REINICIAR);
        this.permutarColor(reiniciarSCACV);
        // Cambiar etiquieta de estado
    }//GEN-LAST:event_reiniciarSCACVActionPerformed

    private void acelerarSCACVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acelerarSCACVActionPerformed
        controlador.setEstadoCrucero(EstadoCrucero.ACELERAR);
        this.permutarColor(acelerarSCACV);
        // Cambiar etiquieta de estado
    }//GEN-LAST:event_acelerarSCACVActionPerformed

    private void mantenerSCACVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mantenerSCACVActionPerformed
        controlador.setEstadoCrucero(EstadoCrucero.REINICIAR);
        this.permutarColor(mantenerSCACV);
        // Cambiar etiquieta de estado
    }//GEN-LAST:event_mantenerSCACVActionPerformed

    private void apagadoSCACVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagadoSCACVActionPerformed
        controlador.setEstadoCrucero(EstadoCrucero.APAGADO);
        this.permutarColor(apagadoSCACV);
        // Cambiar etiquieta de estado
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
    private javax.swing.JToggleButton acelerarSCACV;
    private javax.swing.JToggleButton apagadoSCACV;
    private javax.swing.JToggleButton encender;
    private javax.swing.JLabel estado;
    private javax.swing.JLabel etiquetaCrucero;
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
    private javax.swing.JToggleButton mantenerSCACV;
    private javax.swing.JToggleButton reiniciarSCACV;
    private javax.swing.JLabel revision;
    private javax.swing.JLabel ultimaVelocidad;
    // End of variables declaration//GEN-END:variables
}
