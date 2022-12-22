
package controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;
import modelos.Almacenamiento;
import modelos.Medico;
import modelos.Servicio;
import vistas.GestionServicioGUI;
import vistas.ListarMedico;
import vistas.PlantillaMedico;

public class GestorListarMedico {
    
    private ListarMedico ventanaListarMedico;
    private Almacenamiento almacenamiento;
    private HashMap<Long, Medico> medicos;

    public GestorListarMedico(ListarMedico ventanaListarMedico, Almacenamiento almacenamiento) {
        this.ventanaListarMedico = ventanaListarMedico;
        this.almacenamiento = almacenamiento;
        medicos = almacenamiento.getMedicos();
        insertarMedicos();
        this.ventanaListarMedico.addBtnRegresarListener(new ManejadoraDeMouse());
        this.ventanaListarMedico.addBtnConsultarListener(new ManejadoraDeMouse());
    }
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == ventanaListarMedico.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestionServicioGUI();  
                }
            }
            if (e.getSource() == ventanaListarMedico.getBtnConsultar()){
                if (e.getButton() == 1){
                    irConsultar();  
                }
            }
        }
    }
    private void irGestionServicioGUI() {
        
        //Creación de vistas
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios", almacenamiento);
        ventanaListarMedico.dispose();
    }
    public void insertarMedicos() {
        Iterator i = medicos.entrySet().iterator();

        while(i.hasNext()) {
            HashMap.Entry <Integer, Medico> mapa = (HashMap.Entry) i.next();
            Medico medico = mapa.getValue();
            Object[] fila = new Object[5];
            fila[0] = medico.getNombre();
            fila[1] = medico.getCedula();
            ArrayList <Servicio> servicios = medico.getServicios();
            String serviciosString = "";
            for (int o = 0; o < servicios.size(); o++) {
                if (o != (servicios.size()-1)) {
                    serviciosString += servicios.get(o) + ", ";
                } else {
                    serviciosString += servicios.get(o) + ".";
                }
            }
            fila[2] = serviciosString;
            fila[3] = medico.getTelefono();
            fila[4] = medico.getEmail();
            ventanaListarMedico.anadirFilaTabla(fila);
        }
    }
    
    public void irConsultar() {
        int fila = ventanaListarMedico.filaSeleccionada();
        if (fila != -1) {
            long cedula = ventanaListarMedico.afiliadoSeleccionado(fila);
            PlantillaMedico ventanaAgregarAfiliado = new PlantillaMedico("Consultar afiliado", "Consultar", almacenamiento, cedula);
            ventanaListarMedico.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Ninguna entrada seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
