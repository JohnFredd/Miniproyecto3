
package controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;
import modelos.Almacenamiento;
import modelos.Cita;
import vistas.CitasDeAfiliado;
import vistas.GestionDeCitas;
import vistas.PlantillaCita;

public class GestorCitasDeAfiliado {
    
    private CitasDeAfiliado ventanaCitasAfiliado;
    private final Almacenamiento almacenamiento;
    private final long cedula;
    private HashMap<Integer, Cita> citas;
    
    public GestorCitasDeAfiliado(CitasDeAfiliado ventanaCitasAfiliado, long cedula, Almacenamiento almacenamiento) {
        this.ventanaCitasAfiliado = ventanaCitasAfiliado;
        this.almacenamiento = almacenamiento;
        this.citas = almacenamiento.getCitas();
        this.cedula = cedula;
        consultarCitasDeAfiliado();
        this.ventanaCitasAfiliado.addBtnRegresarListener(new ManejadoraDeMouse());
        this.ventanaCitasAfiliado.addBtnConsultarListener(new ManejadoraDeMouse());
    }
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == ventanaCitasAfiliado.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestionDeCitas();  
                }
            }
            if (e.getSource() == ventanaCitasAfiliado.getBtnConsultar()){
                if (e.getButton() == 1){
                    irConsultar();  
                }
            }
        }
    }
    private void irGestionDeCitas() {
        
        GestionDeCitas vistaGestionCitas = new GestionDeCitas("Gestión de citas", almacenamiento);
        ventanaCitasAfiliado.dispose();
    }
    private void consultarCitasDeAfiliado() {
        
        Iterator i = citas.entrySet().iterator();
        while(i.hasNext()) {
            HashMap.Entry <Integer, Cita> mapa = (HashMap.Entry) i.next();
            Cita cita = mapa.getValue();
            if (cita.getAfiliado().getCedula()==cedula) {
                Object[] fila = new Object[4];
                fila[0] = cita.getNumeroReferencia();
                fila[1] = cita.getAfiliado().getNombre();
                fila[2] = cita.getMedico().getNombre();
                fila[3] = cita.getFecha();
                ventanaCitasAfiliado.anadirFilaTabla(fila);
            }
        }
    }
    public void irConsultar() {
        int fila = ventanaCitasAfiliado.filaSeleccionada();
        if (fila != -1) {
            int numRef = ventanaCitasAfiliado.citaSeleccionada(fila);
            PlantillaCita ventanaAgregarCita = new PlantillaCita("Consultar cita", "Consultar", "", cedula, numRef, almacenamiento);
            ventanaCitasAfiliado.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Ninguna entrada seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
