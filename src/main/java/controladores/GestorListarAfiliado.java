
package controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;
import modelos.Afiliado;
import modelos.Almacenamiento;
import vistas.GestionServicioGUI;
import vistas.ListarAfiliado;
import vistas.PlantillaAfiliado;

public class GestorListarAfiliado {
    
    private ListarAfiliado ventanaListarAfiliado;
    private Almacenamiento almacenamiento;
    private HashMap<Long, Afiliado> afiliados;

    public GestorListarAfiliado(ListarAfiliado ventanaListarAfiliado, Almacenamiento almacenamiento) {
        this.ventanaListarAfiliado = ventanaListarAfiliado;
        this.almacenamiento = almacenamiento;
        afiliados = almacenamiento.getAfiliados();
        insertarAfiliados();
        this.ventanaListarAfiliado.addBtnRegresarListener(new ManejadoraDeMouse());
        this.ventanaListarAfiliado.addBtnConsultarListener(new ManejadoraDeMouse());
    }
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == ventanaListarAfiliado.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestionServicioGUI();  
                }
            }
            if (e.getSource() == ventanaListarAfiliado.getBtnConsultar()){
                if (e.getButton() == 1){
                    irConsultar();  
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
        Iterator i = afiliados.entrySet().iterator();

        while(i.hasNext()) {
            HashMap.Entry <Integer, Afiliado> mapa = (HashMap.Entry) i.next();
            Afiliado afiliado = mapa.getValue();
            Object[] fila = new Object[4];
            fila[0] = afiliado.getNombre();
            fila[1] = afiliado.getCedula();
            fila[2] = afiliado.getTelefono();
            fila[3] = afiliado.getEmail();
            ventanaListarAfiliado.anadirFilaTabla(fila);
        }
    }
    
    public void irConsultar() {
        int fila = ventanaListarAfiliado.filaSeleccionada();
        if (fila != -1) {
            long cedula = ventanaListarAfiliado.afiliadoSeleccionado(fila);
            PlantillaAfiliado ventanaAgregarAfiliado = new PlantillaAfiliado("Consultar afiliado", "Consultar", almacenamiento, cedula);
            ventanaListarAfiliado.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Ninguna entrada seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   
}
