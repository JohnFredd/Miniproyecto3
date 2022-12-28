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

import com.toedter.calendar.JDateChooser;
import controladores.GestorPlantillaCita;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelos.Almacenamiento;


public class PlantillaCita extends javax.swing.JFrame {

    ImagenFondo fondo = new ImagenFondo();
    private DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
    
    public PlantillaCita(String titulo,String opcion, String motivoCita, long cedula, Almacenamiento almacenamiento) {
        this.setContentPane(fondo);
        initComponents();
        GestorPlantillaCita gestorCita = new GestorPlantillaCita(this, opcion, motivoCita, cedula, almacenamiento);
        setVisible(true);
        setTitle(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void anadirMedicosCombo(ArrayList<String> fila){
        modeloCombo.addAll(fila);
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
    public JLabel getlblMes() {
        return lblServicio;
    }
    public JButton getBtnRegresar() {
        return btnRegresar;
    }
    public void setBtnRegresar(JButton btnRegresar) {
        this.btnRegresar = btnRegresar;
    }
    public JButton getBtnAgendar() {
        return btnAgendar;
    }
    public void setBtnAgendar(JButton btnAgendar) {
        this.btnAgendar = btnAgendar;
    }
    public JButton getBtnVerificar() {
        return btnVerificar;
    }
    public void setBtnVerificar(JButton btnVerificar) {
        this.btnVerificar = btnVerificar;
    }
    public JComboBox<String> getComboMedico() {
        return comboMedico;
    }
    public void setComboMedico(JComboBox<String> comboMedico) {
        this.comboMedico = comboMedico;
    }
    public JTextField getTxtCedula() {
        return txtCedula;
    }
    public void setTxtCedula(JTextField txtCedula) {
        this.txtCedula = txtCedula;
    }
    public JTextField getTxtConsultorio() {
        return txtConsultorio;
    }
    public void setTxtConsultorio(JTextField txtConsultorio) {
        this.txtConsultorio = txtConsultorio;
    }
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtReferencia() {
        return txtReferencia;
    }

    public void setTxtReferencia(JTextField txtReferencia) {
        this.txtReferencia = txtReferencia;
    }

    public JTextField getTxtServicio() {
        return txtServicio;
    }

    public void setTxtServicio(JTextField txtServicio) {
        this.txtServicio = txtServicio;
    }

    public JDateChooser getDateChooser() {
        return dateChooser;
    }

    public void setDateChooser(JDateChooser dateChooser) {
        this.dateChooser = dateChooser;
    }

    public JButton getBtnAsignar() {
        return btnAsignar;
    }

    public void setBtnAsignar(JButton btnAsignar) {
        this.btnAsignar = btnAsignar;
    }
    
    public void addBtnRegresarListener(MouseListener listenerBotones){
        btnRegresar.addMouseListener(listenerBotones);
    }
    
    public void addBtnVerificarListener(MouseListener listenerBotones){
        btnVerificar.addMouseListener(listenerBotones);
    }
    public void addBtnAgendarListener(MouseListener listenerBotones){
        btnAgendar.addMouseListener(listenerBotones);
    }
    
    public void addBtnAsignarListener(MouseListener listenerBotones){
        btnAsignar.addMouseListener(listenerBotones);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPpal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        panelDatosAfiliado = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        panelMotivoCita = new javax.swing.JPanel();
        lblServicio = new javax.swing.JLabel();
        txtServicio = new javax.swing.JTextField();
        panelFechaCita = new javax.swing.JPanel();
        btnVerificar = new javax.swing.JButton();
        dateChooser = new com.toedter.calendar.JDateChooser();
        lblEscoja = new javax.swing.JLabel();
        panelDetallesCIta = new javax.swing.JPanel();
        lblMedico = new javax.swing.JLabel();
        lblConsultorio = new javax.swing.JLabel();
        comboMedico = new javax.swing.JComboBox<>();
        lblReferencia = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        txtConsultorio = new javax.swing.JTextField();
        btnAsignar = new javax.swing.JButton();
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

        txtCedula.setEditable(false);
        txtCedula.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtCedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(txtCedula))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelDatosAfiliadoLayout.setVerticalGroup(
            panelDatosAfiliadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosAfiliadoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelDatosAfiliadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosAfiliadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panelMotivoCita.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Motivo de Cita", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelMotivoCita.setOpaque(false);

        lblServicio.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblServicio.setText("Servicio");

        txtServicio.setEditable(false);
        txtServicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtServicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout panelMotivoCitaLayout = new javax.swing.GroupLayout(panelMotivoCita);
        panelMotivoCita.setLayout(panelMotivoCitaLayout);
        panelMotivoCitaLayout.setHorizontalGroup(
            panelMotivoCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMotivoCitaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelMotivoCitaLayout.setVerticalGroup(
            panelMotivoCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMotivoCitaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelMotivoCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServicio)
                    .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        panelFechaCita.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Fecha de la Cita", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelFechaCita.setOpaque(false);

        btnVerificar.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btnVerificar.setText("Comprobar Disponibilidad");
        btnVerificar.setFocusPainted(false);
        btnVerificar.setRequestFocusEnabled(false);

        dateChooser.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        lblEscoja.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblEscoja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEscoja.setText("Escoja la fecha");

        javax.swing.GroupLayout panelFechaCitaLayout = new javax.swing.GroupLayout(panelFechaCita);
        panelFechaCita.setLayout(panelFechaCitaLayout);
        panelFechaCitaLayout.setHorizontalGroup(
            panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechaCitaLayout.createSequentialGroup()
                .addGap(0, 80, Short.MAX_VALUE)
                .addGroup(panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEscoja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );
        panelFechaCitaLayout.setVerticalGroup(
            panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaCitaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEscoja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
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

        comboMedico.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        comboMedico.setModel(modeloCombo);
        comboMedico.setEnabled(false);

        lblReferencia.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblReferencia.setText("Número de referencia");

        txtReferencia.setEditable(false);
        txtReferencia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtReferencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtConsultorio.setEditable(false);
        txtConsultorio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtConsultorio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnAsignar.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        btnAsignar.setText("Asignar consultorio");
        btnAsignar.setEnabled(false);
        btnAsignar.setFocusPainted(false);
        btnAsignar.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelDetallesCItaLayout = new javax.swing.GroupLayout(panelDetallesCIta);
        panelDetallesCIta.setLayout(panelDetallesCItaLayout);
        panelDetallesCItaLayout.setHorizontalGroup(
            panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesCItaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetallesCItaLayout.createSequentialGroup()
                        .addComponent(lblReferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtReferencia))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDetallesCItaLayout.createSequentialGroup()
                        .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblConsultorio))
                        .addGap(91, 91, 91)
                        .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDetallesCItaLayout.createSequentialGroup()
                                .addGap(0, 11, Short.MAX_VALUE)
                                .addComponent(btnAsignar)
                                .addGap(9, 9, 9))
                            .addComponent(txtConsultorio, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(21, 21, 21))
        );
        panelDetallesCItaLayout.setVerticalGroup(
            panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesCItaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMedico)
                    .addComponent(comboMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAsignar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblConsultorio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtConsultorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReferencia)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        btnAsignar.setBackground(Color.WHITE);

        btnRegresar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRequestFocusEnabled(false);

        separador.setForeground(new java.awt.Color(0, 0, 0));
        separador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAgendar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnAgendar.setText("Agendar cita");
        btnAgendar.setEnabled(false);
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
                .addContainerGap(30, Short.MAX_VALUE))
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
                .addContainerGap(48, Short.MAX_VALUE))
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

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JComboBox<String> comboMedico;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblConsultorio;
    private javax.swing.JLabel lblEscoja;
    private javax.swing.JLabel lblMedico;
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
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtConsultorio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtServicio;
    // End of variables declaration//GEN-END:variables
}
