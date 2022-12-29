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

package controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelos.Almacenamiento;
import vistas.OpcionesDeRespaldo;
import vistas.PpalGUI;

public class GestorOpcionesDeRespaldo {
    
    private OpcionesDeRespaldo vistaRespaldo;
    private Almacenamiento almacenamiento;

    public GestorOpcionesDeRespaldo(OpcionesDeRespaldo vistaRespaldo, Almacenamiento almacenamiento) {
        this.vistaRespaldo = vistaRespaldo;
        this.almacenamiento = almacenamiento;
        this.vistaRespaldo.addBtnBackupListener(new ManejadoraDeMouse());
        this.vistaRespaldo.addBtnRestaurarListener(new ManejadoraDeMouse());
        this.vistaRespaldo.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaRespaldo.addBtnExportarListener(new ManejadoraDeMouse());
    }

    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            if (e.getSource() == vistaRespaldo.getBtnBackup()){
                if (e.getButton() == 1){
                    realizarBackup();
                }
            }
          
            if (e.getSource() == vistaRespaldo.getBtnRestaurar()){
                if (e.getButton() == 1){
                    restaurarDatos();
                }
            }
            
            if (e.getSource() == vistaRespaldo.getBtnExportar()){
                if (e.getButton() == 1){
                    exportarAfiliados();
                }
            }
          
            if (e.getSource() == vistaRespaldo.getBtnRegresar()){
                if (e.getButton() == 1){
                    irPpal();
                }
            }
        }

    }
    
    public void realizarBackup() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".bin", "bin");
        chooser.setFileFilter(filtro);
        int seleccion = chooser.showSaveDialog(null);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fileName = chooser.getSelectedFile();
            try {
                almacenamiento.hacerBackUp(fileName);
                JOptionPane.showMessageDialog(null, "BackUp realizado correctamente", "info", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void restaurarDatos() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".bin", "bin");
        chooser.setFileFilter(filtro);
        int seleccion = chooser.showOpenDialog(null);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fileName = chooser.getSelectedFile();
            try {
                almacenamiento.restaurarDatos(fileName);
                JOptionPane.showMessageDialog(null, "Restauración realizada correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void exportarAfiliados() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".txt", "txt");
        chooser.setFileFilter(filtro);
        int seleccion = chooser.showSaveDialog(null);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fileName = chooser.getSelectedFile();
            try {
                almacenamiento.exportarDatosAfiliados(fileName);
                JOptionPane.showMessageDialog(null, "Datos exportados correctamente", "Info", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void irPpal() {
        PpalGUI ventanaPpal = new PpalGUI("Servicio de salud - Universidad del Valle", almacenamiento);
        vistaRespaldo.dispose();
    }
    
    
}
