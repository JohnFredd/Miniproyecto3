
package controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelos.Almacenamiento;
import vistas.GestionServicioGUI;
import vistas.ListarServicio;

public class GestorListarServicio {
    
    private ListarServicio ventanaListarServicio;

    public GestorListarServicio(ListarServicio ventanaListarServicio, Almacenamiento almacenamiento) {
        this.ventanaListarServicio = ventanaListarServicio;
        this.ventanaListarServicio.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == ventanaListarServicio.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestionServicioGUI();  
                }
            }
        }
    }
    private void irGestionServicioGUI() {
        
        //Creación de vistas
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios");
        ventanaListarServicio.dispose();
    }
}
