/*
 * MINIPROYECTO #3
 *
 * INTEGRANTES: 
 * John Freddy Belalcázar
 * Hernán David Cisneros
 * Santiago González Gálvez
 *
 * Grupo 01 FPOE 
 *
 * PROFESOR: Luis Yohany Romo Portilla 
 */

package vistas;

import controladores.GestorPlantillaCita;
import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelos.Almacenamiento;


public class PlantillaCita extends javax.swing.JFrame {

    ImagenFondo fondo = new ImagenFondo();
    
    public PlantillaCita(String titulo,String opcion, Almacenamiento almacenamiento) {
        this.setContentPane(fondo);
        initComponents();
        GestorPlantillaCita gestorCita = new GestorPlantillaCita(this, opcion,almacenamiento);
        setVisible(true);
        setTitle(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

  public JLabel getLblTitulo() {
        return lblTitulo;
    }
    /**
     * @param lblTitulo
     */
    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }    
    public JLabel getLblNombre() {
        return lblNombre;
    }
    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }   
    public JLabel getLblCedula() {
        return lblCedula;
    }
    public void setLblCedula(JLabel lblCedula) {
        this.lblCedula = lblCedula;
    }    
    public JLabel getlblServicio() {
        return lblServicio;
    }
    public void setLblServicio(JLabel lblServicio) {
        this.lblServicio = lblServicio;
    }   
    public JLabel getlblDia() {
        return lblServicio;
    }
    public void setLblDia(JLabel lblDia) {
        this.lblDia = lblDia;
    }    
    public JLabel getlblMes() {
        return lblServicio;
    }
    public void setLblMes(JLabel lblMes) {
        this.lblMes = lblMes;
    }   
    public JLabel getlblAnio() {
        return lblAnio;
    }
    public void setLblAño(JLabel lblAnio) {
        this.lblAnio = lblAnio;
    }  
    public JButton getBtnRegresar() {
        return btnRegresar;
    }
    public void setBtnRegresar(JButton btnRegresar) {
        this.btnRegresar = btnRegresar;
    }
    public void addBtnRegresarListener(MouseListener listenerBotones){
        btnRegresar.addMouseListener(listenerBotones);
    }
    public JButton getBtnAgendar() {
        return btnAgendar;
    }
    public void setBtnAgendar(JButton btnAgendar) {
        this.btnAgendar = btnAgendar;
    }
    public void addBtnAgendarListener(MouseListener listenerBotones){
        btnAgendar.addMouseListener(listenerBotones);
    }
    public JButton getBtnVerificar() {
        return btnVerificar;
    }
    public void setBtnVerificar(JButton btnVerificar) {
        this.btnVerificar = btnVerificar;
    }
    public void addBtnVerificarListener(MouseListener listenerBotones){
        btnVerificar.addMouseListener(listenerBotones);
    }
    
    public JComboBox<String> getcomboMedico() {
        return comboMedico;
    }

    public void setComboMedico(JComboBox<String> comboMedico) {
        this.comboMedico = comboMedico;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPpal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelDatosAfiliado = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        panelMotivoCita = new javax.swing.JPanel();
        lblServicio = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        panelFechaCita = new javax.swing.JPanel();
        lblDia = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        btnVerificar = new javax.swing.JButton();
        panelDetallesCIta = new javax.swing.JPanel();
        lblMedico = new javax.swing.JLabel();
        lblConsultorio = new javax.swing.JLabel();
        comboMedico = new javax.swing.JComboBox<>();
        comboConsultorio = new javax.swing.JComboBox<>();
        lblReferencia = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        btnAgendar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPpal.setOpaque(false);

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 60)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Agendar cita");

        panelDatosAfiliado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Datos del Afiliado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelDatosAfiliado.setOpaque(false);

        lblNombre.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblNombre.setText("Nombre");

        lblCedula.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblCedula.setText("Cédula");

        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosAfiliadoLayout = new javax.swing.GroupLayout(panelDatosAfiliado);
        panelDatosAfiliado.setLayout(panelDatosAfiliadoLayout);
        panelDatosAfiliadoLayout.setHorizontalGroup(
            panelDatosAfiliadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosAfiliadoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelDatosAfiliadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosAfiliadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jTextField6))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelDatosAfiliadoLayout.setVerticalGroup(
            panelDatosAfiliadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosAfiliadoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelDatosAfiliadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosAfiliadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panelMotivoCita.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Motivo de Cita", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelMotivoCita.setOpaque(false);

        lblServicio.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblServicio.setText("Servicio");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMotivoCitaLayout = new javax.swing.GroupLayout(panelMotivoCita);
        panelMotivoCita.setLayout(panelMotivoCitaLayout);
        panelMotivoCitaLayout.setHorizontalGroup(
            panelMotivoCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMotivoCitaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMotivoCitaLayout.setVerticalGroup(
            panelMotivoCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMotivoCitaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelMotivoCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServicio)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        panelFechaCita.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Fecha y Hora de la Cita", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelFechaCita.setOpaque(false);

        lblDia.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblDia.setText("Día");

        lblMes.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblMes.setText("Mes");

        lblAnio.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblAnio.setText("Año");

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        btnVerificar.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btnVerificar.setText("Comprobar Disponibilidad");
        btnVerificar.setFocusPainted(false);
        btnVerificar.setRequestFocusEnabled(false);
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFechaCitaLayout = new javax.swing.GroupLayout(panelFechaCita);
        panelFechaCita.setLayout(panelFechaCitaLayout);
        panelFechaCitaLayout.setHorizontalGroup(
            panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaCitaLayout.createSequentialGroup()
                .addGroup(panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFechaCitaLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDia, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMes, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechaCitaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(jTextField5)
                    .addComponent(jTextField3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechaCitaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnVerificar)
                .addGap(69, 69, 69))
        );
        panelFechaCitaLayout.setVerticalGroup(
            panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaCitaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDia)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMes)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnio)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnVerificar)
                .addGap(25, 25, 25))
        );

        btnVerificar.setBackground(Color.WHITE);

        panelDetallesCIta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Detalles de la Cita", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelDetallesCIta.setOpaque(false);

        lblMedico.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblMedico.setText("Médico");

        lblConsultorio.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblConsultorio.setText("Consultorio");

        comboMedico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboConsultorio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboConsultorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblReferencia.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblReferencia.setText("Número de referencia");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDetallesCItaLayout = new javax.swing.GroupLayout(panelDetallesCIta);
        panelDetallesCIta.setLayout(panelDetallesCItaLayout);
        panelDetallesCItaLayout.setHorizontalGroup(
            panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesCItaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetallesCItaLayout.createSequentialGroup()
                        .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblConsultorio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDetallesCItaLayout.createSequentialGroup()
                        .addComponent(lblReferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2)))
                .addGap(21, 21, 21))
        );
        panelDetallesCItaLayout.setVerticalGroup(
            panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesCItaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMedico)
                    .addComponent(comboMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblConsultorio)
                    .addComponent(comboConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReferencia)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        btnRegresar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRequestFocusEnabled(false);

        separador.setForeground(new java.awt.Color(0, 0, 0));
        separador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAgendar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnAgendar.setText("Agendar cita");
        btnAgendar.setFocusPainted(false);
        btnAgendar.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelPpalLayout = new javax.swing.GroupLayout(panelPpal);
        panelPpal.setLayout(panelPpalLayout);
        panelPpalLayout.setHorizontalGroup(
            panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPpalLayout.createSequentialGroup()
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPpalLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPpalLayout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addGap(169, 169, 169)
                                .addComponent(btnAgendar))
                            .addGroup(panelPpalLayout.createSequentialGroup()
                                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(panelDatosAfiliado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelFechaCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(panelMotivoCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panelDetallesCIta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(panelPpalLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPpalLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)))
        );
        panelPpalLayout.setVerticalGroup(
            panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPpalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMotivoCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelFechaCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDetallesCIta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgendar)
                    .addComponent(btnRegresar))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPpalLayout.createSequentialGroup()
                    .addContainerGap(635, Short.MAX_VALUE)
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)))
        );

        btnRegresar.setBackground(Color.WHITE);
        btnAgendar.setBackground(Color.WHITE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPpal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPpal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerificarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JComboBox<String> comboConsultorio;
    private javax.swing.JComboBox<String> comboMedico;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblConsultorio;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblMedico;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblReferencia;
    private javax.swing.JLabel lblServicio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelDatosAfiliado;
    private javax.swing.JPanel panelDetallesCIta;
    private javax.swing.JPanel panelFechaCita;
    private javax.swing.JPanel panelMotivoCita;
    private javax.swing.JPanel panelPpal;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables
}
