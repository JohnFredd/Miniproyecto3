
package controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelos.Almacenamiento;
import vistas.CitasDeAfiliado;
import vistas.GestionDeCitas;

public class GestorCitasDeAfiliado {
    
    private CitasDeAfiliado ventanaCitasAfiliado;
    private final Almacenamiento almacenamiento;
    private final long cedula;
    private final String opcion;
    
    public GestorCitasDeAfiliado(CitasDeAfiliado ventanaCitasAfiliado, String opcion, long cedula, Almacenamiento almacenamiento) {
        this.ventanaCitasAfiliado = ventanaCitasAfiliado;
        this.almacenamiento = almacenamiento;
        this.cedula = cedula;
        this.opcion = opcion;
        this.ventanaCitasAfiliado.addBtnRegresarListener(new ManejadoraDeMouse());
    }
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == ventanaCitasAfiliado.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestionDeCitas();  
                }
            }
        }
    }
    private void irGestionDeCitas() {
        
        GestionDeCitas vistaGestionCitas = new GestionDeCitas("Gestión de citas", almacenamiento);
        ventanaCitasAfiliado.dispose();
    } 
}
