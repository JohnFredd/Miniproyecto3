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

import controladores.GestorListarConsultorio;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelos.Almacenamiento;

public class ListarConsultorio extends javax.swing.JFrame {

    ImagenFondo fondo = new ImagenFondo();
    private final DefaultTableModel modeloTabla = new DefaultTableModel();
    private JTableHeader th;
    
    public ListarConsultorio(String titulo, Almacenamiento almacenamiento) {
        this.setContentPane(fondo);
        llenarColumnas();
        initComponents();
        diseñoTabla();
        GestorListarConsultorio gestorListarConsultorio = new GestorListarConsultorio(this, almacenamiento);
        setVisible(true);
        setTitle(titulo);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void llenarColumnas(){
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Identificador");
        
    }
    public void diseñoTabla(){
        
        //Fuente de cabecera
        th = tablaContenido.getTableHeader();
        Font fuente = new Font("Agency FB", Font.BOLD, 22);
        th.setFont(fuente);
        
        //Color cabecera
        tablaContenido.setOpaque(false);
        Color colorCabecera = new Color(29, 194, 231);  //11, 117, 244 Dark blue 241, 150, 20 Orange 29, 194, 231 Light Blue
        th.setBackground(colorCabecera);
        
        //Color fondo
        Color colorFondo = new Color(255, 255, 255);
        scroll.getViewport().setBackground(colorFondo);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPpal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        tablaContenido = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPpal.setOpaque(false);

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 60)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Lista consultorios");

        tablaContenido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        tablaContenido.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        tablaContenido.setModel(modeloTabla);
        tablaContenido.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(tablaContenido);

        btnRegresar.setFont(new java.awt.Font("Agency FB", 1, 36)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRequestFocusEnabled(false);

        separador.setForeground(new java.awt.Color(0, 0, 0));
        separador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelPpalLayout = new javax.swing.GroupLayout(panelPpal);
        panelPpal.setLayout(panelPpalLayout);
        panelPpalLayout.setHorizontalGroup(
            panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPpalLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPpalLayout.createSequentialGroup()
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPpalLayout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addGap(372, 372, 372))))
            .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelPpalLayout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE)))
        );
        panelPpalLayout.setVerticalGroup(
            panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPpalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnRegresar)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPpalLayout.createSequentialGroup()
                    .addContainerGap(654, Short.MAX_VALUE)
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(19, 19, 19)))
        );

        btnRegresar.setOpaque(true);
        btnRegresar.setBackground(Color.WHITE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPpal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPpal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @return 
     */

    public JButton getBtnRegresar() {
        return btnRegresar;
    }

    /**
     * @param btnRegresar
     */
    public void setBtnRegresar(JButton btnRegresar) {
        this.btnRegresar = btnRegresar;
    }
    public void addBtnRegresarListener(MouseListener listenerBotones){
        btnRegresar.addMouseListener(listenerBotones);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelPpal;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JSeparator separador;
    private javax.swing.JTable tablaContenido;
    // End of variables declaration//GEN-END:variables
}
