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

public class AgregarCitaGUI extends javax.swing.JFrame {

    ImagenFondo fondo = new ImagenFondo();
    
    public AgregarCitaGUI() {
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
        panelDatosAfiliado = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        panelMotivoCita = new javax.swing.JPanel();
        txtServicio = new javax.swing.JTextField();
        lblServicio = new javax.swing.JLabel();
        panelFechaCita = new javax.swing.JPanel();
        txtDia = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        lblDia = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblAnio = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        lblHora = new javax.swing.JLabel();
        comboHora = new javax.swing.JComboBox<>();
        panelDetallesCIta = new javax.swing.JPanel();
        lblMedico = new javax.swing.JLabel();
        lblConsultorio = new javax.swing.JLabel();
        comboMedico = new javax.swing.JComboBox<>();
        comboConsultorio = new javax.swing.JComboBox<>();
        lblReferencia = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        btnAgendar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPpal.setOpaque(false);

        lblTitulo.setFont(new java.awt.Font("Agency FB", 1, 52)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Agendar cita");

        panelDatosAfiliado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Datos del afiliado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelDatosAfiliado.setOpaque(false);

        txtNombre.setEditable(false);
        txtNombre.setFocusable(false);

        txtCedula.setEditable(false);
        txtCedula.setFocusable(false);

        lblNombre.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblNombre.setText("Nombre");

        lblCedula.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblCedula.setText("Cédula");

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
                .addGroup(panelDatosAfiliadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(txtCedula))
                .addGap(38, 38, 38))
        );
        panelDatosAfiliadoLayout.setVerticalGroup(
            panelDatosAfiliadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosAfiliadoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelDatosAfiliadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosAfiliadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        panelMotivoCita.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Motivo de cita", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelMotivoCita.setOpaque(false);

        txtServicio.setEditable(false);
        txtServicio.setFocusable(false);

        lblServicio.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblServicio.setText("Servicio");

        javax.swing.GroupLayout panelMotivoCitaLayout = new javax.swing.GroupLayout(panelMotivoCita);
        panelMotivoCita.setLayout(panelMotivoCitaLayout);
        panelMotivoCitaLayout.setHorizontalGroup(
            panelMotivoCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMotivoCitaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtServicio, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );
        panelMotivoCitaLayout.setVerticalGroup(
            panelMotivoCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMotivoCitaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelMotivoCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblServicio))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        panelFechaCita.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Fecha y hora de la cita", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelFechaCita.setOpaque(false);

        txtDia.setEditable(false);
        txtDia.setFocusable(false);

        txtMes.setEditable(false);
        txtMes.setFocusable(false);

        lblDia.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblDia.setText("Día");

        lblMes.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblMes.setText("Mes");

        lblAnio.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblAnio.setText("Año");

        txtAnio.setEditable(false);
        txtAnio.setFocusable(false);

        lblHora.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblHora.setText("Hora");

        comboHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelFechaCitaLayout = new javax.swing.GroupLayout(panelFechaCita);
        panelFechaCita.setLayout(panelFechaCitaLayout);
        panelFechaCitaLayout.setHorizontalGroup(
            panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaCitaLayout.createSequentialGroup()
                .addGroup(panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFechaCitaLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDia, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblMes, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFechaCitaLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAnio)
                    .addComponent(txtDia, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMes, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboHora, 0, 251, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );
        panelFechaCitaLayout.setVerticalGroup(
            panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFechaCitaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(panelFechaCitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHora)
                    .addComponent(comboHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        panelDetallesCIta.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Detalles de la cita", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        panelDetallesCIta.setOpaque(false);

        lblMedico.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblMedico.setText("Médico");

        lblConsultorio.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblConsultorio.setText("Consultorio");

        comboMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboConsultorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblReferencia.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        lblReferencia.setText("Número de referencia");

        txtReferencia.setEditable(false);
        txtReferencia.setFocusable(false);

        javax.swing.GroupLayout panelDetallesCItaLayout = new javax.swing.GroupLayout(panelDetallesCIta);
        panelDetallesCIta.setLayout(panelDetallesCItaLayout);
        panelDetallesCItaLayout.setHorizontalGroup(
            panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesCItaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetallesCItaLayout.createSequentialGroup()
                        .addComponent(lblReferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDetallesCItaLayout.createSequentialGroup()
                        .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblConsultorio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(38, 38, 38))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(panelDetallesCItaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReferencia, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        btnAgendar.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        btnAgendar.setText("Agendar cita");
        btnAgendar.setFocusPainted(false);
        btnAgendar.setRequestFocusEnabled(false);

        btnRegresar.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRequestFocusEnabled(false);

        separador.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout panelPpalLayout = new javax.swing.GroupLayout(panelPpal);
        panelPpal.setLayout(panelPpalLayout);
        panelPpalLayout.setHorizontalGroup(
            panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelPpalLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPpalLayout.createSequentialGroup()
                        .addComponent(panelDatosAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(panelMotivoCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPpalLayout.createSequentialGroup()
                        .addComponent(panelFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(panelDetallesCIta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPpalLayout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addGap(566, 566, 566)
                        .addComponent(btnAgendar))))
        );
        panelPpalLayout.setVerticalGroup(
            panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPpalLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMotivoCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDetallesCIta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(panelPpalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegresar)
                    .addComponent(btnAgendar))
                .addGap(18, 18, 18)
                .addComponent(separador, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAgendar.setBackground(Color.WHITE);
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
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboConsultorio;
    private javax.swing.JComboBox<String> comboHora;
    private javax.swing.JComboBox<String> comboMedico;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblConsultorio;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblHora;
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
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtServicio;
    // End of variables declaration//GEN-END:variables
}
