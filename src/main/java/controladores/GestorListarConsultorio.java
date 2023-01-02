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
import java.util.HashMap;
import java.util.Iterator;
import modelos.Almacenamiento;
import modelos.Consultorio;
import vistas.GestionServicioGUI;
import vistas.ListarConsultorio;

public class GestorListarConsultorio {
    
    private ListarConsultorio ventanaListarConsultorio;
    private Almacenamiento almacenamiento;
    private HashMap <String, Consultorio> consultorios;

    public GestorListarConsultorio(ListarConsultorio ventanaListarConsultorio, Almacenamiento almacenamiento) {
        this.ventanaListarConsultorio = ventanaListarConsultorio;
        this.almacenamiento = almacenamiento;
        consultorios = almacenamiento.getConsultorios();
        insertarConsultorios();
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
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios", almacenamiento);
        ventanaListarConsultorio.dispose();
    }
    
    public void insertarConsultorios() {
        Iterator i = consultorios.entrySet().iterator();

        while(i.hasNext()) {
            HashMap.Entry <String, Consultorio> mapa = (HashMap.Entry) i.next();
            Consultorio consultorio = mapa.getValue();
            Object[] fila = new Object[2];
            fila[0] = consultorio.getIdentificador();
            fila[1] = consultorio.getServicioAsociado().getNombre();
            ventanaListarConsultorio.anadirFilaTabla(fila);
        }
    }
    
}
