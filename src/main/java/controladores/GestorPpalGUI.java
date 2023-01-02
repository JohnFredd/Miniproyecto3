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
import modelos.Almacenamiento;
import vistas.GestionDeCitas;
import vistas.GestionServicioGUI;
import vistas.OpcionesDeRespaldo;
import vistas.PpalGUI;

public class GestorPpalGUI {
    
    private final PpalGUI vistaPpal;
    private final Almacenamiento almacenamiento;
  
    public GestorPpalGUI(PpalGUI vistaPpal, Almacenamiento almacenamiento) {
        this.vistaPpal = vistaPpal;
        this.vistaPpal.addBtnGestionServicioListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnGestionCitaListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnRespaldoListener(new ManejadoraDeMouse());
        this.almacenamiento = almacenamiento;
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
          if (e.getSource() == vistaPpal.getBtnGestionServicio()){
                if (e.getButton() == 1){
                    irGestionServicioGUI();
                }
          }
          
          if (e.getSource() == vistaPpal.getBtnGestionCita()){
                if (e.getButton() == 1){
                    irGestionDeCitas();
                }
          }
          
          if (e.getSource() == vistaPpal.getBtnRespaldo()){
                if (e.getButton() == 1){
                    irRespaldo();
                }
          }
        }
    }
    
    public void irGestionServicioGUI(){
        GestionServicioGUI ventanaGestionServicio = new GestionServicioGUI("Gestión de servicios", almacenamiento);
        ventanaGestionServicio.setVisible(true);
        vistaPpal.dispose();
    }
    
    public void irGestionDeCitas(){
        GestionDeCitas ventanaGestionCitas = new GestionDeCitas("Gestión de citas", almacenamiento);
        ventanaGestionCitas.setVisible(true);
        vistaPpal.dispose();
    }
    
    public void irRespaldo(){
        OpcionesDeRespaldo ventanaRespaldo = new OpcionesDeRespaldo("Opciones de respaldo", almacenamiento);
        ventanaRespaldo.setVisible(true);
        vistaPpal.dispose();
    }
    
}
