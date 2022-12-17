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
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class PpalGUI extends javax.swing.JFrame {

    ImagenFondo fondo = new ImagenFondo();
    public PpalGUI() {
        this.setContentPane(fondo);
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        btnGestionServicio = new javax.swing.JButton();
        btnGestionCita = new javax.swing.JButton();
        btnRespaldo = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 60)); // NOI18N
        lblTitulo.setText("Servicio de Salud");

        lblTitulo2.setFont(new java.awt.Font("Agency FB", 1, 60)); // NOI18N
        lblTitulo2.setText("Universidad del Valle");

        btnGestionServicio.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnGestionServicio.setText("Gestión del servicio");
        btnGestionServicio.setFocusPainted(false);
        btnGestionServicio.setOpaque(true);
        btnGestionServicio.setRequestFocusEnabled(false);

        btnGestionCita.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnGestionCita.setText("Gestión de citas");
        btnGestionCita.setFocusPainted(false);
        btnGestionCita.setRequestFocusEnabled(false);

        btnRespaldo.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnRespaldo.setText("Opciones de respaldo");
        btnRespaldo.setFocusPainted(false);
        btnRespaldo.setRequestFocusEnabled(false);

        separador.setForeground(new java.awt.Color(0, 0, 0));
        separador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnGestionServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnGestionCita, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo2)
                .addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(btnRespaldo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(21, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGestionServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGestionCita, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(btnRespaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(463, 463, 463)
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)))
        );

        btnGestionServicio.setBackground(Color.WHITE);
        btnGestionCita.setBackground(Color.WHITE);
        btnRespaldo.setBackground(Color.WHITE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @return 
     */

    public JButton getBtnGestionCita() {
        return btnGestionCita;
    }

    public JButton getBtnGestionServicio() {
        return btnGestionServicio;
    }

    /**
     */
    public JButton getBtnRespaldo() {
        return btnRespaldo;
    }
    
    public void addBtnGestionServicioListener(MouseListener listenerBotones){
        btnGestionServicio.addMouseListener(listenerBotones);
    }
    
    public void addBtnGestionCitaListener(MouseListener listenerBotones){
        btnGestionCita.addMouseListener(listenerBotones);
    }
    
    public void addBtnRespaldoListener(MouseListener listenerBotones){
        btnRespaldo.addMouseListener(listenerBotones);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGestionCita;
    private javax.swing.JButton btnGestionServicio;
    private javax.swing.JButton btnRespaldo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JSeparator separador;
    // End of variables declaration//GEN-END:variables


}
