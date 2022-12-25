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
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelos.Afiliado;
import modelos.Almacenamiento;
import modelos.Consultorio;
import modelos.Servicio;
import vistas.GestionServicioGUI;
import vistas.ListarAfiliado;
import vistas.ListarConsultorio;
import vistas.ListarMedico;
import vistas.ListarServicio;
import vistas.PlantillaAfiliado;
import vistas.PlantillaConsultorio;
import vistas.PlantillaMedico;
import vistas.PlantillaServicio;
import vistas.PpalGUI;

public class GestorGestionServicio {
    
    private final GestionServicioGUI vistaGestionServicio;
    private final Almacenamiento almacenamiento;
    private final String[] opciones = {
                                    "Agregar",
                                    "Actualizar",
                                    "Listar",
                                    "Eliminar"
                                   };
    
    public GestorGestionServicio(GestionServicioGUI vistaGestionServicio, Almacenamiento almacenamiento) {
        
        //Vista
        this.vistaGestionServicio = vistaGestionServicio;
        
        //Añadiendo Listeners
        this.vistaGestionServicio.addBtnAfiliadosListener(new ManejadoraDeMouse());
        this.vistaGestionServicio.addBtnMedicosListener(new ManejadoraDeMouse());
        this.vistaGestionServicio.addBtnConsultoriosListener(new ManejadoraDeMouse());
        this.vistaGestionServicio.addBtnServiciosListener(new ManejadoraDeMouse());
        this.vistaGestionServicio.addBtnRegresarListener(new ManejadoraDeMouse());
        this.almacenamiento = almacenamiento;
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
          if (e.getSource() == vistaGestionServicio.getBtnAfiliados()){
                if (e.getButton() == 1){
                    opcionesAfiliado();
                }
          }
          
          if (e.getSource() == vistaGestionServicio.getBtnMedicos()){
                if (e.getButton() == 1){
                    opcionesMedico();
                }
          }
          
          if (e.getSource() == vistaGestionServicio.getBtnConsultorios()){
                if (e.getButton() == 1){
                    opcionesConsultorio();
                }
          }
          
          if (e.getSource() == vistaGestionServicio.getBtnServicios()){
                if (e.getButton() == 1){
                    opcionesServicio();
                }
          }
          
          if (e.getSource() == vistaGestionServicio.getBtnRegresar()){
                if (e.getButton() == 1){
                    irPpal();
                }
          }
          
        }

    }
    
    public void irPpal() {
        PpalGUI ventanaPpal = new PpalGUI("Servicio de salud - Universidad del Valle", almacenamiento);
        vistaGestionServicio.dispose();
    }
    
    //Opciones a realizar con un afiliado
    public void opcionesAfiliado(){
        try {
            String resp = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">¿Qué desea hacer?</p></html>", "Opciones afiliados", JOptionPane.DEFAULT_OPTION, UIManager.getIcon("OptionPane.questionIcon"), opciones, opciones[0]);

            switch(resp){
                case "Agregar" -> {
                    irAgregarAfiliado();
                }
                case "Actualizar" -> {
                    String cedulaABuscar;
                    try {
                        cedulaABuscar = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Ingrese la cédula del afiliado a actualizar</p></html>", "Actualizar afiliado", JOptionPane.DEFAULT_OPTION);
                        if (cedulaABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Por favor ingrese una cédula</p></html>", "Error", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                        } else {
                            long cedula = Long.parseLong(cedulaABuscar);
                            if(almacenamiento.getAfiliados().containsKey(cedula)){
                                irActualizarAfiliado(cedula);
                            } else {
                                JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se encontró ningún afiliado registrado con esa cédula</p></html>", "Afiliado no encontrado", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                            }
                        }
                    } catch(NullPointerException np){

                    }
                }
                case "Listar" -> {
                    irListarAfiliado();
                }
                case "Eliminar" -> {
                    String cedulaABuscar = (String) JOptionPane.showInputDialog(vistaGestionServicio,"<html><p style = \" font:12px; \">Ingrese la cédula del afiliado a eliminar</p></html>", "Eliminar afiliado", JOptionPane.DEFAULT_OPTION);
                    try {
                        if (cedulaABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Por favor ingrese una cédula</p></html>", "Error", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                        } else {
                            long cedula = Long.parseLong(cedulaABuscar);
                            if(almacenamiento.getAfiliados().containsKey(cedula)){
                                //Afiliado miAfiliado = almacenamiento.getAfiliados().get(cedula);
                                irEliminarAfiliado(cedula);
                            } else {
                                JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se encontró ningún afiliado registrado con esa cédula</p></html>", "Afiliado no encontrado", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                            }
                        }
                    } catch(NullPointerException np){

                    }
                }
            }
        } catch(NullPointerException np){

        }
    }
    
    public void irAgregarAfiliado(){
        PlantillaAfiliado ventanaAgregarAfiliado = new PlantillaAfiliado("Agregar afiliado", "Agregar", almacenamiento, 0);
        vistaGestionServicio.dispose();
    }
    
    public void irActualizarAfiliado(long cedula) {
        PlantillaAfiliado ventanaAgregarAfiliado = new PlantillaAfiliado("Actualizar afiliado", "Actualizar", almacenamiento, cedula);
        vistaGestionServicio.dispose();
    }
    
    public void irListarAfiliado(){
        ListarAfiliado ventanaListaAfiliado = new ListarAfiliado("Lista de afiliados",almacenamiento);
        vistaGestionServicio.dispose();
    }
    
    public void irEliminarAfiliado(long cedula) {
        PlantillaAfiliado ventanaEliminarAfiliado = new PlantillaAfiliado("Eliminar afiliado", "Eliminar", almacenamiento, cedula);
        vistaGestionServicio.dispose();
    }
    
    //Opciones a realizar con un médico
    public void opcionesMedico(){
        try {
            String resp = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">¿Qué desea hacer?</p></html>", "Opciones médicos", JOptionPane.DEFAULT_OPTION, UIManager.getIcon("OptionPane.questionIcon"), opciones, opciones[0]);

            switch(resp){
                case "Agregar" -> {
                    if(!almacenamiento.getServicios().isEmpty()){
                        irAgregarMedico();
                    } else {
                            JOptionPane.showMessageDialog(null, "Antes de agregar un médico, agregue un servicio.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);                    
                    }
                }
                case "Actualizar" -> {
                    String cedulaABuscar;
                    try {
                        cedulaABuscar = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Ingrese la cédula del médico a actualizar</p></html>", "Actualizar médico", JOptionPane.DEFAULT_OPTION);
                        if (cedulaABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Por favor ingrese una cédula</p></html>", "Error", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                        } else {
                            long cedula = Long.parseLong(cedulaABuscar);
                            if(almacenamiento.getMedicos().containsKey(cedula)){
                                irActualizarMedico(cedula);
                            } else {
                                JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se encontró ningún médico registrado con esa cédula</p></html>", "Afiliado no encontrado", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                            }
                            
                        }
                    } catch(NullPointerException np){
                        JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se ingresó ninguna cédula</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                    }
                }
                case "Listar" -> {
                    irListarMedico();
                }
                case "Eliminar" -> {
                    String cedulaABuscar = (String) JOptionPane.showInputDialog(vistaGestionServicio, "Ingrese la cédula del médico a eliminar", "Eliminar médico", JOptionPane.DEFAULT_OPTION);
                    try {
                        if (cedulaABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Por favor ingrese una cédula</p></html>", "Error", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                        } else {
                            long cedula = Long.parseLong(cedulaABuscar);
                            if(almacenamiento.getMedicos().containsKey(cedula)){
                                irEliminarMedico(cedula);
                            } else {
                                JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se encontró ningún médico registrado con esa cédula</p></html>", "Afiliado no encontrado", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                            }
                        }
                    } catch(NullPointerException np){
                        JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se ingresó ninguna cédula</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                    }
                }
            }
        } catch(NullPointerException np){
            
        }
    }
    public void irAgregarMedico(){
        PlantillaMedico ventanaAgregarMedico = new PlantillaMedico("Agregar médico", "Agregar", almacenamiento, 0);
        vistaGestionServicio.dispose();
    }
    public void irActualizarMedico(long cedula) {
        PlantillaMedico ventanaAgregarMedico = new PlantillaMedico("Actualizar médico", "Actualizar", almacenamiento, cedula);
        vistaGestionServicio.dispose();
    }
    public void irListarMedico(){
        ListarMedico ventanaListaMedico = new ListarMedico("Lista de médicos", almacenamiento);
        vistaGestionServicio.dispose();
    }
    public void irEliminarMedico(long cedula) {
        PlantillaMedico ventanaAgregarMedico = new PlantillaMedico("Eliminar médico", "Eliminar", almacenamiento, cedula);
        vistaGestionServicio.dispose();
    }
    
    //Opciones a realizar con un consultorio
    public void opcionesConsultorio(){
        try {
            String resp = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">¿Qué desea hacer?</p></html>", "Opciones consultorios", JOptionPane.DEFAULT_OPTION, UIManager.getIcon("OptionPane.questionIcon"), opciones, opciones[0]);
            
            if(resp != null & !"Agregar".equals(resp) & !"Listar".equals(resp)){
                
                switch(resp){
                    
                    case "Actualizar" -> {
                        String idABuscar;
                        try {
                            idABuscar = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Ingrese el identificador del consultorio a actualizar</p></html>", "Actualizar afiliado", JOptionPane.DEFAULT_OPTION);
                            if (idABuscar.isBlank()){
                                JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Por favor ingrese un identificador</p></html>", "Error", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                            } else {
                                if(almacenamiento.getConsultorios().containsKey(idABuscar)){
                                    irActualizarConsultorio(idABuscar);
                                } else {
                                    JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se encontró ningún consultorio registrado con ese identificador</p></html>", "Afiliado no encontrado", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                                }
                            }
                        } catch(NullPointerException np){

                        }
                    }
                    
                    case "Eliminar" -> {
                        String idABuscar;
                        try {
                            idABuscar = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Ingrese el identificador del consultorio a eliminar</p></html>", "Actualizar afiliado", JOptionPane.DEFAULT_OPTION);
                            if (idABuscar.isBlank()){
                                JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Por favor ingrese un identificador</p></html>", "Error", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                            } else {
                                if(almacenamiento.getConsultorios().containsKey(idABuscar)){
                                    irEliminarConsultorio(idABuscar);
                                } else {
                                    JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se encontró ningún consultorio registrado con ese identificador</p></html>", "Afiliado no encontrado", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                                }
                            }
                        } catch(NullPointerException np){

                        }
                    }
                }
            } else if ("Listar".equals(resp)){
                irListarConsultorio();
            } else if ("Agregar".equals(resp)){
                if(!almacenamiento.getServicios().isEmpty()){
                    irAgregarConsultorio();
                } else {
                    JOptionPane.showMessageDialog(null, "Antes de agregar un consultorio, agregue un servicio.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
                
                }
            } 

        } catch(NullPointerException np){
            
        }
    }
    
    public void irAgregarConsultorio(){
        PlantillaConsultorio ventanaAgregarConsultorio = new PlantillaConsultorio("Agregar consultorio", "Agregar", almacenamiento, "");
        vistaGestionServicio.dispose();
    }
    public void irActualizarConsultorio(String id) {
        PlantillaConsultorio ventanaActualizarConsultorio = new PlantillaConsultorio("Actualizar consultorio", "Actualizar", almacenamiento, id);
        vistaGestionServicio.dispose();
    }
    public void irListarConsultorio(){
        ListarConsultorio ventanaListaConsultorio = new ListarConsultorio("Listas de consultorios", almacenamiento);
        vistaGestionServicio.dispose();
    }
    public void irEliminarConsultorio(String id) {
        PlantillaConsultorio ventanaActualizarConsultorio = new PlantillaConsultorio("Eliminar consultorio", "Eliminar", almacenamiento, id);
        vistaGestionServicio.dispose();
    }
    
    //Opciones a realizar con un servicio
    public void opcionesServicio(){
        try {
            String resp = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">¿Qué desea hacer?</p></html>", "Opciones servicios médicos", JOptionPane.DEFAULT_OPTION, UIManager.getIcon("OptionPane.questionIcon"), opciones, opciones[0]);
            
            //Convirtiendo los servicios actuales a String[]
            ArrayList<Servicio> servicios = almacenamiento.getServicios();
            String[] misServicios = new String[servicios.size()];
            
            for (int i= 0; i<servicios.size(); i++){
                String servicio = "";
                servicio += servicios.get(i).getNombre();
                misServicios[i] = servicio;
            }
            
            if(resp != null & !"Agregar".equals(resp) & !"Listar".equals(resp)){
                if(misServicios.length != 0){
                    String resp2 = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Escoja el servicio</p></html>", "Lista de servicios", JOptionPane.DEFAULT_OPTION, UIManager.getIcon("OptionPane.questionIcon"), misServicios, misServicios[0]);
                    switch(resp){

                        case "Actualizar" -> {
                            try {
                                if (resp2 != null){
                                    for (String miServicio : misServicios) {
                                        if (miServicio.equals(resp2)) {
                                            irActualizarServicio(resp2);
                                        }
                                    }
                                }
                            } catch(NullPointerException np){
                                JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se escogió ningún servicio</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                            }
                        }

                        case "Eliminar" -> {
                            try {
                                if (resp2 != null){
                                    for (String miServicio : misServicios) {
                                        if (miServicio.equals(resp2)) {
                                            irEliminarServicio(resp2);
                                        }
                                    }
                                }
                            } catch(NullPointerException np){
                                JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se escogió ningún servicio</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                            }
                        }
                    }
                    
                } else{
                    JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Agregue un servicio primero</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));

                }
            } else if ("Listar".equals(resp)){
                irListarServicio();
            } else if ("Agregar".equals(resp)){
                irAgregarServicio();
            } 

        } catch(NullPointerException np){
            
        }
    }
    public void irAgregarServicio(){
        PlantillaServicio ventanaAgregarServicio = new PlantillaServicio("Agregar servicio", "Agregar", almacenamiento, null);
        vistaGestionServicio.dispose();
    }
    public void irActualizarServicio(String servicio) {
        PlantillaServicio ventanaActualizarServicio = new PlantillaServicio("Actualizar servicio", "Actualizar", almacenamiento, servicio);
        vistaGestionServicio.dispose();
    }
    public void irListarServicio(){
        ListarServicio ventanaListaServicio = new ListarServicio("Lista de servicios", almacenamiento);
        vistaGestionServicio.dispose();
    }
    public void irEliminarServicio(String servicio) {
        PlantillaServicio ventanaEliminarServicio = new PlantillaServicio("Eliminar servicio", "Eliminar", almacenamiento, servicio);
        vistaGestionServicio.dispose();
    }
}
