
package controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelos.Almacenamiento;
import vistas.GestionServicioGUI;
import vistas.ListarAfiliado;

public class GestorListarAfiliado {
    
    private ListarAfiliado ventanaListarAfiliado;
    Almacenamiento almacenamiento;

    public GestorListarAfiliado(ListarAfiliado ventanaListarAfiliado, Almacenamiento almacenamiento) {
        this.ventanaListarAfiliado = ventanaListarAfiliado;
        this.almacenamiento = almacenamiento;
        insertarAfiliados();
        this.ventanaListarAfiliado.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == ventanaListarAfiliado.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestionServicioGUI();  
                }
            }
        }
    }
    private void irGestionServicioGUI() {
        
        //Creación de vistas
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios", almacenamiento);
        ventanaListarAfiliado.dispose();
    }
    public void insertarAfiliados() {
         
    }
   
}
