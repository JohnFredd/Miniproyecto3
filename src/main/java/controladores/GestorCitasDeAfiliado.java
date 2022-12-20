
package controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelos.Almacenamiento;
import vistas.CitasDeAfiliado;
import vistas.GestionDeCitas;

public class GestorCitasDeAfiliado {
    
    private CitasDeAfiliado ventanaCitasAfiliado;
    private final Almacenamiento almacenamiento;

    public GestorCitasDeAfiliado(CitasDeAfiliado ventanaCitasAfiliado, Almacenamiento almacenamiento) {
        this.ventanaCitasAfiliado = ventanaCitasAfiliado;
        this.almacenamiento = almacenamiento;
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
