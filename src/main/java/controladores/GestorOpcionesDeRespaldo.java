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
import vistas.OpcionesDeRespaldo;
import vistas.PpalGUI;

public class GestorOpcionesDeRespaldo {
    
    OpcionesDeRespaldo vistaRespaldo;

    public GestorOpcionesDeRespaldo(OpcionesDeRespaldo vistaRespaldo) {
        this.vistaRespaldo = vistaRespaldo;
        this.vistaRespaldo.addBtnBackupListener(new ManejadoraDeMouse());
        this.vistaRespaldo.addBtnRestaurarListener(new ManejadoraDeMouse());
        this.vistaRespaldo.addBtnRegresarListener(new ManejadoraDeMouse());
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
          
          if (e.getSource() == vistaRespaldo.getBtnRegresar()){
                if (e.getButton() == 1){
                    irPpal();
                }
          }
        }

    }
    
    private void realizarBackup() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void restaurarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void irPpal() {
        PpalGUI ventanaPpal = new PpalGUI("Servicio de salud - Universidad del Valle");
        vistaRespaldo.dispose();
    }
    
    
}
