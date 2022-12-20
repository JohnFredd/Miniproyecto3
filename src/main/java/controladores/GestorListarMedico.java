
package controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelos.Almacenamiento;
import vistas.GestionServicioGUI;
import vistas.ListarMedico;

public class GestorListarMedico {
    
    private ListarMedico ventanaListarMedico;
    Almacenamiento almacenamiento;

    public GestorListarMedico(ListarMedico ventanaListarMedico, Almacenamiento almacenamiento) {
        this.ventanaListarMedico = ventanaListarMedico;
        this.almacenamiento = almacenamiento;
        this.ventanaListarMedico.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == ventanaListarMedico.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestionServicioGUI();  
                }
            }
        }
    }
    private void irGestionServicioGUI() {
        
        //Creación de vistas
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios", almacenamiento);
        ventanaListarMedico.dispose();
    }
    
    
}
