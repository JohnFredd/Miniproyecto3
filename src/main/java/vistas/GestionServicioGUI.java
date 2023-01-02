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

import controladores.GestorGestionServicio;
import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import modelos.Almacenamiento;

public class GestionServicioGUI extends javax.swing.JFrame {

    ImagenFondo fondo = new ImagenFondo();
    
    public GestionServicioGUI(String titulo, Almacenamiento almacenamiento) {
        this.setContentPane(fondo);
        initComponents();
        GestorGestionServicio gestorServicio = new GestorGestionServicio(this, almacenamiento);
        setVisible(true);
        setTitle(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnAfiliados = new javax.swing.JButton();
        btnMedicos = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnServicios = new javax.swing.JButton();
        btnConsultorios = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 60)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Gestión del servicio");

        btnAfiliados.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnAfiliados.setText("Afiliados");
        btnAfiliados.setFocusPainted(false);
        btnAfiliados.setRequestFocusEnabled(false);

        btnMedicos.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnMedicos.setText("Médicos");
        btnMedicos.setFocusPainted(false);
        btnMedicos.setRequestFocusEnabled(false);

        btnRegresar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRequestFocusEnabled(false);

        btnServicios.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnServicios.setText("Servicios médicos");
        btnServicios.setFocusPainted(false);
        btnServicios.setRequestFocusEnabled(false);

        btnConsultorios.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnConsultorios.setText("Consultorios");
        btnConsultorios.setFocusPainted(false);
        btnConsultorios.setRequestFocusEnabled(false);

        separador.setForeground(new java.awt.Color(0, 0, 0));
        separador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAfiliados, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultorios, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMedicos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnServicios, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(btnRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAfiliados, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultorios, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(462, 462, 462)
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );

        btnAfiliados.setBackground(Color.WHITE);
        btnMedicos.setBackground(Color.WHITE);
        btnRegresar.setBackground(Color.WHITE);
        btnServicios.setBackground(Color.WHITE);
        btnConsultorios.setBackground(Color.WHITE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @return 
     */

    public JButton getBtnAfiliados() {
        return btnAfiliados;
    }

    public JButton getBtnConsultorios() {
        return btnConsultorios;
    }

    public JButton getBtnMedicos() {
        return btnMedicos;
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    public JButton getBtnServicios() {
        return btnServicios;
    }
    public void addBtnAfiliadosListener(MouseListener listenerBotones){
        btnAfiliados.addMouseListener(listenerBotones);
    }
    
    public void addBtnMedicosListener(MouseListener listenerBotones){
        btnMedicos.addMouseListener(listenerBotones);
    }
    
    public void addBtnConsultoriosListener(MouseListener listenerBotones){
        btnConsultorios.addMouseListener(listenerBotones);
    }
    
    public void addBtnServiciosListener(MouseListener listenerBotones){
        btnServicios.addMouseListener(listenerBotones);
    }
    
    public void addBtnRegresarListener(MouseListener listenerBotones){
        btnRegresar.addMouseListener(listenerBotones);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfiliados;
    private javax.swing.JButton btnConsultorios;
    private javax.swing.JButton btnMedicos;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnServicios;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables

}
