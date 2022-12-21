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

import controladores.GestorGestionDeCitas;
import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import modelos.Almacenamiento;

/**
 *
 * @author santy
 */
public class GestionDeCitas extends javax.swing.JFrame {

    ImagenFondo fondo = new ImagenFondo();
    
    public GestionDeCitas(String titulo, Almacenamiento almacenamiento) {
        
        this.setContentPane(fondo);
        initComponents();
        GestorGestionDeCitas gestorGestionCitas = new GestorGestionDeCitas(this, almacenamiento);
        setVisible(true);
        setTitle(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnAgendar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 60)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gestión de citas");

        btnAgendar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnAgendar.setText("Agendar cita");
        btnAgendar.setFocusPainted(false);
        btnAgendar.setRequestFocusEnabled(false);

        btnModificar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnModificar.setText("Modificar cita");
        btnModificar.setFocusPainted(false);
        btnModificar.setRequestFocusEnabled(false);

        btnRegresar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRequestFocusEnabled(false);

        btnEliminar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnEliminar.setText("Eliminar cita");
        btnEliminar.setFocusPainted(false);
        btnEliminar.setRequestFocusEnabled(false);

        btnConsultar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnConsultar.setText("Consultar cita");
        btnConsultar.setFocusPainted(false);
        btnConsultar.setRequestFocusEnabled(false);

        separador.setForeground(new java.awt.Color(0, 0, 0));
        separador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(btnRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        btnAgendar.setBackground(Color.WHITE);
        btnModificar.setBackground(Color.WHITE);
        btnRegresar.setBackground(Color.WHITE);
        btnEliminar.setBackground(Color.WHITE);
        btnConsultar.setBackground(Color.WHITE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @return 
     */
    
    public JLabel getLblTitulo() {
        return lblTitulo;
    }
    
    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }    
    
    public JButton getBtnAgendar() {
        return btnAgendar;
    }

    public void setBtnAgendar(JButton btnAgendar) {
        this.btnAgendar = btnAgendar;
    }

    public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public void setBtnConsultar(JButton btnConsultar) {
        this.btnConsultar = btnConsultar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    /**
     * @param btnRegresar
     */
    public void setBtnRegresar(JButton btnRegresar) {
        this.btnRegresar = btnRegresar;
    }
    public void addBtnAgendarListener(MouseListener listenerBotones){
            btnAgendar.addMouseListener(listenerBotones);
        }
    
    public void addBtnConsultarListener(MouseListener listenerBotones){
        btnConsultar.addMouseListener(listenerBotones);
    }
    
    public void addBtnEliminarListener(MouseListener listenerBotones){
        btnEliminar.addMouseListener(listenerBotones);
    }
    
    public void addBtnModificarListener(MouseListener listenerBotones){
        btnModificar.addMouseListener(listenerBotones);
    }
    
    public void addBtnRegresarListener(MouseListener listenerBotones){
        btnRegresar.addMouseListener(listenerBotones);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables

}
