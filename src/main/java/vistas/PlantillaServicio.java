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

import controladores.GestorPlantillaServicio;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PlantillaServicio extends javax.swing.JFrame {

    ImagenFondo fondo = new ImagenFondo();
    
    public PlantillaServicio() {
        GestorPlantillaServicio gestorServicio = new GestorPlantillaServicio(this);
        this.setContentPane(fondo);
        initComponents();
        setVisible(true);
        //setSize(920,704);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPpal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblReferencia1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        txtServicio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPpal.setOpaque(false);

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 60)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Agregar servicio médico");

        lblReferencia1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        lblReferencia1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReferencia1.setText("Nombre servicio médico");

        btnRegresar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRequestFocusEnabled(false);

        btnAgregar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnAgregar.setText("Agregar servicio médico");
        btnAgregar.setFocusPainted(false);
        btnAgregar.setRequestFocusEnabled(false);

        separador.setForeground(new java.awt.Color(0, 0, 0));
        separador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtServicio.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtServicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout panelPpalLayout = new javax.swing.GroupLayout(panelPpal);
        panelPpal.setLayout(panelPpalLayout);
        panelPpalLayout.setHorizontalGroup(
            panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblReferencia1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPpalLayout.createSequentialGroup()
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPpalLayout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPpalLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelPpalLayout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addGap(45, 45, 45)
                                .addComponent(btnAgregar)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelPpalLayout.setVerticalGroup(
            panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPpalLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(lblReferencia1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        btnRegresar.setBackground(Color.WHITE);
        btnAgregar.setBackground(Color.WHITE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPpal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelPpal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
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

    public JTextField getTxtServicio() {
        return txtServicio;
    }

    public void setTxtServicio(JTextField txtServicio) {
        this.txtServicio = txtServicio;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel lblReferencia1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelPpal;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextField txtServicio;
    // End of variables declaration//GEN-END:variables
}
