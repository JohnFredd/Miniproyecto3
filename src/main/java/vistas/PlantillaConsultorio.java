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

import java.awt.Color;
import javax.swing.JFrame;

public class PlantillaConsultorio extends javax.swing.JFrame {

    ImagenFondo fondo = new ImagenFondo();
    
    public PlantillaConsultorio() {
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
        comboMedico = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        btnAgendar = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        lblReferencia2 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPpal.setOpaque(false);

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 60)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Agregar Consultorio");

        lblReferencia1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        lblReferencia1.setText("Identificador");

        comboMedico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRegresar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRequestFocusEnabled(false);

        btnAgendar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnAgendar.setText("Agregar Consultorio");
        btnAgendar.setFocusPainted(false);
        btnAgendar.setRequestFocusEnabled(false);
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        separador.setForeground(new java.awt.Color(0, 0, 0));
        separador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblReferencia2.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        lblReferencia2.setText("Servicio Medico Asociado ");

        txtCedula.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCedula.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout panelPpalLayout = new javax.swing.GroupLayout(panelPpal);
        panelPpal.setLayout(panelPpalLayout);
        panelPpalLayout.setHorizontalGroup(
            panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPpalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(panelPpalLayout.createSequentialGroup()
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPpalLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPpalLayout.createSequentialGroup()
                                .addComponent(btnRegresar)
                                .addGap(113, 113, 113)
                                .addComponent(btnAgendar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(separador)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPpalLayout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPpalLayout.createSequentialGroup()
                                .addComponent(lblReferencia2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPpalLayout.createSequentialGroup()
                                .addComponent(lblReferencia1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(164, 164, 164)))))
                .addContainerGap())
        );
        panelPpalLayout.setVerticalGroup(
            panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPpalLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReferencia1))
                .addGap(18, 18, 18)
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPpalLayout.createSequentialGroup()
                        .addComponent(lblReferencia2)
                        .addGap(111, 111, 111)
                        .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgendar)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(panelPpalLayout.createSequentialGroup()
                        .addComponent(comboMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        btnRegresar.setBackground(Color.WHITE);
        btnAgendar.setBackground(Color.WHITE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPpal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelPpal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgendarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboMedico;
    private javax.swing.JLabel lblReferencia1;
    private javax.swing.JLabel lblReferencia2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelPpal;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextField txtCedula;
    // End of variables declaration//GEN-END:variables
}
