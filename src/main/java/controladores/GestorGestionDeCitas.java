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
import modelos.Almacenamiento;
import vistas.CitasDeAfiliado;
import vistas.GestionDeCitas;
import vistas.PpalGUI;

public class GestorGestionDeCitas {
    
    private final GestionDeCitas vistaGestionCitas;

    public GestorGestionDeCitas(GestionDeCitas vistaGestionCitas) {
        this.vistaGestionCitas = vistaGestionCitas;
        this.vistaGestionCitas.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaGestionCitas.addBtnConsultarListener(new ManejadoraDeMouse());
    }

    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
          if (e.getSource() == vistaGestionCitas.getBtnRegresar()){
              if (e.getButton() == 1){
                  irPpal();
              }
          }
          if (e.getSource() == vistaGestionCitas.getBtnConsultar()){
              if (e.getButton() == 1){
                  irCitasDeAfiliado();
              }
          }
          //Botones faltantes ;D
        }
    }
    public void irPpal() {
        PpalGUI ventanaPpal = new PpalGUI("Servicio de salud - Universidad del Valle");
        vistaGestionCitas.dispose();
    }
    public void irCitasDeAfiliado() {
        Almacenamiento almacenamiento = new Almacenamiento();
        CitasDeAfiliado ventanaCitasAfiliado = new CitasDeAfiliado("Citas del afiliado", almacenamiento);
        vistaGestionCitas.dispose();
    }
}
