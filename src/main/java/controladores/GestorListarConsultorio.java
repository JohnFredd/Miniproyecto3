
package controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelos.Almacenamiento;
import vistas.GestionServicioGUI;
import vistas.ListarConsultorio;

public class GestorListarConsultorio {
    
    private ListarConsultorio ventanaListarConsultorio;

    public GestorListarConsultorio(ListarConsultorio ventanaListarConsultorio, Almacenamiento almacenamiento) {
        this.ventanaListarConsultorio = ventanaListarConsultorio;
        this.ventanaListarConsultorio.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == ventanaListarConsultorio.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestionServicioGUI();  
                }
            }
        }
    }
    private void irGestionServicioGUI() {
        
        //Creación de vistas
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios");
        ventanaListarConsultorio.dispose();
    }
    
}
