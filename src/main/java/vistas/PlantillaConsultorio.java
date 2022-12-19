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

import controladores.GestorPlantillaConsultorio;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PlantillaConsultorio extends javax.swing.JFrame {

    ImagenFondo fondo = new ImagenFondo();
    
    public PlantillaConsultorio() {
        GestorPlantillaConsultorio gestorConsultorio = new GestorPlantillaConsultorio(this);
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
        btnAgregar = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        lblReferencia2 = new javax.swing.JLabel();
        txtIdentificador = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPpal.setOpaque(false);

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 60)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Agregar consultorio");

        lblReferencia1.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        lblReferencia1.setText("Identificador");

        comboMedico.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnRegresar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRequestFocusEnabled(false);

        btnAgregar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnAgregar.setText("Agregar consultorio");
        btnAgregar.setFocusPainted(false);
        btnAgregar.setRequestFocusEnabled(false);

        separador.setForeground(new java.awt.Color(0, 0, 0));
        separador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblReferencia2.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        lblReferencia2.setText("Servicio médico asociado ");

        txtIdentificador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtIdentificador.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout panelPpalLayout = new javax.swing.GroupLayout(panelPpal);
        panelPpal.setLayout(panelPpalLayout);
        panelPpalLayout.setHorizontalGroup(
            panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPpalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPpalLayout.createSequentialGroup()
                        .addComponent(lblReferencia2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPpalLayout.createSequentialGroup()
                        .addComponent(lblReferencia1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(170, 170, 170))
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPpalLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPpalLayout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addGap(101, 101, 101)
                        .addComponent(btnAgregar))
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panelPpalLayout.setVerticalGroup(
            panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPpalLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReferencia1))
                .addGap(18, 18, 18)
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPpalLayout.createSequentialGroup()
                        .addComponent(lblReferencia2)
                        .addGap(111, 111, 111)
                        .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))
                    .addGroup(panelPpalLayout.createSequentialGroup()
                        .addComponent(comboMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
            .addComponent(panelPpal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @return 
     */

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgendar(JButton btnAgendar) {
        this.btnAgregar = btnAgendar;
    }

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }

    public JComboBox<String> getComboMedico() {
        return comboMedico;
    }

    public void setComboMedico(JComboBox<String> comboMedico) {
        this.comboMedico = comboMedico;
    }

    public JTextField getTxtIdentificador() {
        return txtIdentificador;
    }

    public void setTxtIdentificador(JTextField txtIdentificador) {
        this.txtIdentificador = txtIdentificador;
    }
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboMedico;
    private javax.swing.JLabel lblReferencia1;
    private javax.swing.JLabel lblReferencia2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelPpal;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextField txtIdentificador;
    // End of variables declaration//GEN-END:variables
}
