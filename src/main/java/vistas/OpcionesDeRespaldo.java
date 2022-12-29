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

import controladores.GestorOpcionesDeRespaldo;
import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import modelos.Almacenamiento;

public class OpcionesDeRespaldo extends javax.swing.JFrame {

    private ImagenFondo fondo = new ImagenFondo();
    
    public OpcionesDeRespaldo(String titulo, Almacenamiento almacenamiento) {
        this.setContentPane(fondo);
        initComponents();
        GestorOpcionesDeRespaldo gestorRespaldo = new GestorOpcionesDeRespaldo(this, almacenamiento);
        setVisible(true);
        setTitle(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        separador = new javax.swing.JSeparator();
        lblTitulo = new javax.swing.JLabel();
        btnBackup = new javax.swing.JButton();
        btnRestaurar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        separador1 = new javax.swing.JSeparator();
        btnExportar = new javax.swing.JButton();

        separador.setForeground(new java.awt.Color(0, 0, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        lblTitulo.setText("Opciones de respaldo");

        btnBackup.setFont(new java.awt.Font("Agency FB", 1, 28)); // NOI18N
        btnBackup.setText("Realizar Backup");
        btnBackup.setFocusPainted(false);
        btnBackup.setRequestFocusEnabled(false);

        btnRestaurar.setFont(new java.awt.Font("Agency FB", 1, 28)); // NOI18N
        btnRestaurar.setText("Restaurar Backup");
        btnRestaurar.setFocusPainted(false);
        btnRestaurar.setRequestFocusEnabled(false);

        btnRegresar.setFont(new java.awt.Font("Agency FB", 1, 28)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRequestFocusEnabled(false);

        separador1.setForeground(new java.awt.Color(0, 0, 0));
        separador1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnExportar.setFont(new java.awt.Font("Agency FB", 1, 28)); // NOI18N
        btnExportar.setText("Exportar datos de afiliados");
        btnExportar.setFocusPainted(false);
        btnExportar.setRequestFocusEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(btnRegresar)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))))
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(btnExportar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(lblTitulo)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        btnBackup.setBackground(Color.WHITE);
        btnRestaurar.setBackground(Color.WHITE);
        btnRegresar.setBackground(Color.WHITE);
        btnRestaurar.setBackground(Color.WHITE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @return 
     */

    public JButton getBtnBackup() {
        return btnBackup;
    }

    public void setBtnBackup(JButton btnBackup) {
        this.btnBackup = btnBackup;
    }
    
    public JButton getBtnExportar() {
        return btnExportar;
    }

    public void setBtnExportar(JButton btnBackup) {
        this.btnExportar = btnBackup;
    }

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    public void setBtnRegresar(JButton btnRegresar) {
        this.btnRegresar = btnRegresar;
    }

    public JButton getBtnRestaurar() {
        return btnRestaurar;
    }

    /**
     * @param btnRestaurar
     */
    public void setBtnRestaurar(JButton btnRestaurar) {
        this.btnRestaurar = btnRestaurar;
    }

    public void addBtnRegresarListener(MouseListener listenerBotones){
        btnRegresar.addMouseListener(listenerBotones);
    }
    
    public void addBtnBackupListener(MouseListener listenerBotones){
        btnBackup.addMouseListener(listenerBotones);
    }
    public void addBtnRestaurarListener(MouseListener listenerBotones){
        btnRestaurar.addMouseListener(listenerBotones);
    }
    public void addBtnExportarListener(MouseListener listenerBotones){
        btnExportar.addMouseListener(listenerBotones);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackup;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSeparator separador;
    private javax.swing.JSeparator separador1;
    // End of variables declaration//GEN-END:variables

}
