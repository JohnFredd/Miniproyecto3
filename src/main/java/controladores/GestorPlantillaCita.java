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
import java.util.List;
import modelos.Almacenamiento;
import modelos.Cita;
import controladores.GestorGestionDeCitas;
import vistas.GestionDeCitas;
import vistas.PlantillaCita;

public class GestorPlantillaCita {
    
    PlantillaCita vistaPlantillaCita;
    Almacenamiento almacenamiento;
    //Cita cita;
    private final String opcion;
    
    public GestorPlantillaCita(PlantillaCita vistaPlantillaCita, String opcion, Almacenamiento almacenamiento) {
        this.almacenamiento = almacenamiento;
        this.opcion = opcion;
        
        //vista
        this.vistaPlantillaCita = vistaPlantillaCita;
        modificarPlantilla();
        //Añadiendo Listeners
        this.vistaPlantillaCita.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaPlantillaCita.addBtnAgendarListener(new ManejadoraDeMouse());
        this.vistaPlantillaCita.addBtnVerificarListener(new ManejadoraDeMouse());
    }
    
    public void modificarPlantilla(){
        switch (opcion) {
        
            case "Modificar" -> {
                plantillaModificarCita();
            }
            
            case "Eliminar" -> {
                plantillaEliminarCita();
            }
    }
    }
    public void plantillaModificarCita(){
        //Modificando título y botones
        vistaPlantillaCita.getLblTitulo().setText("Modificar Cita");
        vistaPlantillaCita.getBtnAgendar().setText("Modificar Cita");
    }
    
    public void plantillaEliminarCita(){
        //Modificando título y botones
        vistaPlantillaCita.getLblTitulo().setText("Eliminar Cita");
        vistaPlantillaCita.getBtnAgendar().setText("Eliminar Cita");
        
        
/*//Desabilitando campos de texto
        vistaPlantillaCita.getLblCedula().setEnabled(false);
        vistaPlantillaCita.getLblNombre().setEnabled(false);
        vistaPlantillaCita.getlblDia().setEnabled(false);
        vistaPlantillaCita.getlblMes().setEnabled(false);
        vistaPlantillaCita.getlblAnio().setEnabled(false);
        vistaPlantillaCita.getlblServicio().setEnabled(false);
    */    
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPlantillaCita.getBtnAgendar()&& "Modificar".equals(opcion)){
                if (e.getButton() == 1){
                    plantillaModificarCita();
                }
            }
            if (e.getSource() == vistaPlantillaCita.getBtnAgendar()&& "Eliminar".equals(opcion)){
                if (e.getButton() == 1){
                    plantillaEliminarCita();
                }
            }
            /*if (e.getSource() == vistaGestionCitas.getBtnAgendar()&& "Agendar".equals(opcion)){
                if (e.getButton() == 1){
                    agendarCita();
                }
            }*/

            if (e.getSource() == vistaPlantillaCita.getBtnRegresar()){
                if (e.getButton() == 1){
                    irGestionCitasGUI();  
                }
            }
        }
    }
    
   /* private void agendarCita() {
        
       //Obteniendo los datos
        int cedula = Integer.parseInt(vistaPlantillaCita.getLblCedula().getText());
        String nombre = vistaPlantillaAfiliado.getTxtNombre().getText();
        int edad = Integer.parseInt(vistaPlantillaCita.getTxtEdad().getText());
        String direccion = vistaPlantillaAfiliado.getTxtDireccion().getText();
        String correo = vistaPlantillaAfiliado.getTxtCorreo().getText();
        int telefono = Integer.parseInt(vistaPlantillaAfiliado.getTxtTelefono().getText());
        String sexo = (String)vistaPlantillaAfiliado.getComboSexo().getSelectedItem();
        Afiliado afiliado = new Afiliado(nombre, sexo, direccion, correo, cedula, edad, telefono);
        System.out.println(afiliado.toString());
        almacenamiento.anadirAfiliado(afiliado);
    }
*/
    public void irGestionCitasGUI() {
        
        //Creación de vistas
        GestionDeCitas vistaGestionCitas= new GestionDeCitas("Gestión de Citas", almacenamiento);
        vistaPlantillaCita.dispose();
    }
}

