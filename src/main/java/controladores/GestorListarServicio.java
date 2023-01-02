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
import java.util.ArrayList;
import java.util.Iterator;
import modelos.Almacenamiento;
import modelos.Servicio;
import vistas.GestionServicioGUI;
import vistas.ListarServicio;

public class GestorListarServicio {
    
    private ListarServicio ventanaListarServicio;
    private Almacenamiento almacenamiento;
    private ArrayList <Servicio> servicios;
    
    public GestorListarServicio(ListarServicio ventanaListarServicio, Almacenamiento almacenamiento) {
        this.ventanaListarServicio = ventanaListarServicio;
        this.almacenamiento = almacenamiento;
        servicios = almacenamiento.getServicios();
        insertarServicios();
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
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios", almacenamiento);
        ventanaListarServicio.dispose();
    }
    public void insertarServicios() {
        Iterator i = servicios.iterator();

        while(i.hasNext()) {
            Servicio servicio = (Servicio) i.next();
            Object[] fila = new Object[1];
            fila[0] = servicio.getNombre();
            ventanaListarServicio.anadirFilaTabla(fila);
        }
    }
}
