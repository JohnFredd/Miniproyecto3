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
import vistas.GestionDeCitas;
import vistas.GestionServicioGUI;
import vistas.OpcionesDeRespaldo;
import vistas.PlantillaAfiliado;
import vistas.PlantillaConsultorio;
import vistas.PlantillaMedico;
import vistas.PlantillaServicio;
import vistas.PpalGUI;

public class GestorPpalGUI {
    
    private final PpalGUI vistaPpal;
  
    public GestorPpalGUI(PpalGUI vistaPpal) {
        this.vistaPpal = vistaPpal;
        this.vistaPpal.addBtnGestionServicioListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnGestionCitaListener(new ManejadoraDeMouse());
        this.vistaPpal.addBtnRespaldoListener(new ManejadoraDeMouse());
        
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
        
        //Creación de ventanas
        GestionServicioGUI ventanaGestionServicio = new GestionServicioGUI();
        PlantillaAfiliado vistaPlantillaAfiliado = new PlantillaAfiliado();
        PlantillaMedico vistaPlantillaMedico = new PlantillaMedico();
        PlantillaConsultorio vistaPlantillaConsultorio = new PlantillaConsultorio();
        PlantillaServicio vistaPlantillaServicio = new PlantillaServicio();
        
        //Creación de gestores
        GestorPlantillaAfiliado gestorAfiliado = new GestorPlantillaAfiliado(vistaPlantillaAfiliado);
        GestorPlantillaMedico gestorMedico = new GestorPlantillaMedico(vistaPlantillaMedico);
        GestorPlantillaConsultorio gestorConsultorio = new GestorPlantillaConsultorio(vistaPlantillaConsultorio);
        GestorPlantillaServicio gestorServicio = new GestorPlantillaServicio(vistaPlantillaServicio);
        GestorGestionServicio gestorGestionServicio = new GestorGestionServicio(ventanaGestionServicio, gestorAfiliado, gestorMedico, gestorConsultorio, gestorServicio);
        
        //Configuración de ventanas
        ventanaGestionServicio.setVisible(true);
        vistaPlantillaAfiliado.dispose();
        vistaPlantillaMedico.dispose();
        vistaPlantillaConsultorio.dispose();
        vistaPlantillaServicio.dispose();
        vistaPpal.dispose();
    }
    
    public void irGestionDeCitas(){
        GestionDeCitas ventanaGestionCitas = new GestionDeCitas();
        ventanaGestionCitas.setVisible(true);
        vistaPpal.dispose();
    }
    
    public void irRespaldo(){
        OpcionesDeRespaldo ventanaRespaldo = new OpcionesDeRespaldo();
        ventanaRespaldo.setVisible(true);
        vistaPpal.dispose();
    }
    
}
