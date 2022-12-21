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
    
    private void irPpal() {
        PpalGUI ventanaPpal = new PpalGUI("Servicio de salud - Universidad del Valle", almacenamiento);
        vistaGestionServicio.dispose();
    }
    
    //Opciones a realizar con un afiliado
    private void opcionesAfiliado(){
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
                                Afiliado miAfiliado = almacenamiento.getAfiliados().get(cedula);
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
    
    private void irAgregarAfiliado(){
        PlantillaAfiliado ventanaAgregarAfiliado = new PlantillaAfiliado("Agregar afiliado", "Agregar", almacenamiento, 0);
        System.out.println("Se creó");
        vistaGestionServicio.dispose();
    }
    
    private void irActualizarAfiliado(long cedula) {
        PlantillaAfiliado ventanaAgregarAfiliado = new PlantillaAfiliado("Actualizar afiliado", "Actualizar", almacenamiento, cedula);
        vistaGestionServicio.dispose();
    }
    
    private void irListarAfiliado(){
        ListarAfiliado ventanaListaAfiliado = new ListarAfiliado("Lista de afiliados",almacenamiento);
        vistaGestionServicio.dispose();
    }
    
    private void irEliminarAfiliado(long cedula) {
        PlantillaAfiliado ventanaEliminarAfiliado = new PlantillaAfiliado("Eliminar afiliado", "Eliminar", almacenamiento, cedula);
        vistaGestionServicio.dispose();
    }
    
    //Opciones a realizar con un médico
    private void opcionesMedico(){
        try {
            String resp = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">¿Qué desea hacer?</p></html>", "Opciones médicos", JOptionPane.DEFAULT_OPTION, UIManager.getIcon("OptionPane.questionIcon"), opciones, opciones[0]);

            switch(resp){
                case "Agregar" -> {
                    irAgregarMedico();
                }
                case "Actualizar" -> {
                    String cedulaABuscar;
                    try {
                        cedulaABuscar = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Ingrese la cédula del médico a actualizar</p></html>", "Actualizar médico", JOptionPane.DEFAULT_OPTION);
                        if(cedulaABuscar.equals("12345")){
                            irActualizarMedico();

                        } else if (cedulaABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Por favor ingrese una cédula</p></html>", "Cédula inválida", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                        } else if(!cedulaABuscar.equals("12345")){
                            JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se encontró ningún médico registrado con esa cédula</p></html>", "Médico no encontrado", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
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
                        if(cedulaABuscar.equals("12345")){
                            irEliminarMedico();

                        } else if(cedulaABuscar.isBlank()){
                            JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Por favor ingrese una cédula</p></html>", "Médico no encontrado", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                        } else if(!cedulaABuscar.equals("12345")){
                            JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se encontró ningún médico registrado con esa cédula</p></html>", "Médico no encontrado", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                        }
                    } catch(NullPointerException np){
                        JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se ingresó ninguna cédula</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                    }
                }
            }
        } catch(NullPointerException np){
            
        }
    }
    private void irAgregarMedico(){
        PlantillaMedico ventanaAgregarMedico = new PlantillaMedico("Agregar médico", "Agregar", almacenamiento);
        vistaGestionServicio.dispose();
    }
    private void irActualizarMedico() {
        PlantillaMedico ventanaAgregarMedico = new PlantillaMedico("Actualizar médico", "Actualizar", almacenamiento);
        vistaGestionServicio.dispose();
    }
    private void irListarMedico(){
        ListarMedico ventanaListaMedico = new ListarMedico("Lista de médicos", almacenamiento);
        vistaGestionServicio.dispose();
    }
    private void irEliminarMedico() {
        PlantillaMedico ventanaAgregarMedico = new PlantillaMedico("Eliminar médico", "Eliminar", almacenamiento);
        vistaGestionServicio.dispose();
    }
    
    //Opciones a realizar con un consultorio
    private void opcionesConsultorio(){
        try {
            String resp = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">¿Qué desea hacer?</p></html>", "Opciones consultorios", JOptionPane.DEFAULT_OPTION, UIManager.getIcon("OptionPane.questionIcon"), opciones, opciones[0]);
            
            //Simulación de conversión de datos de un ArrayList a Array String, para ponerlo en el comboBox ;)
            ArrayList<String> consultorios = new ArrayList();
            consultorios.add("Consultorio 1");
            consultorios.add("Consultorio 2");
            consultorios.add("Laboratorio 3");

            Object[] arrayDeObjetos = consultorios.toArray();
            String[] misConsultorios = new String[consultorios.size()];
            for (int i= 0; i<arrayDeObjetos.length; i++){
                misConsultorios[i] = (String) arrayDeObjetos[i];
            }
            if(resp != null & !"Agregar".equals(resp) & !"Listar".equals(resp)){
                String resp2 = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Escoja el consultorio/laboratorio</p></html>", "Opciones consultorios", JOptionPane.DEFAULT_OPTION, UIManager.getIcon("OptionPane.questionIcon"), misConsultorios, misConsultorios[0]);
                
                switch(resp){
                    
                    case "Actualizar" -> {
                        try {
                            if (resp2 != null){
                                for (String miConsultorio : misConsultorios) {
                                    if (miConsultorio.equals(resp2)) {
                                        irActualizarConsultorio();
                                    }
                                }
                            }
                        } catch(NullPointerException np){
                            JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se escogió ningún consultorio</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                        }
                    }
                    
                    case "Eliminar" -> {
                        try {
                            if (resp2 != null){
                                for (String miConsultorio : misConsultorios) {
                                    if (miConsultorio.equals(resp2)) {
                                        irEliminarConsultorio();
                                    }
                                }
                            }
                        } catch(NullPointerException np){
                            JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se escogió ningún consultorio</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                        }
                    }
                }
            } else if ("Listar".equals(resp)){
                irListarConsultorio();
            } else if ("Agregar".equals(resp)){
                irAgregarConsultorio();
            } 

        } catch(NullPointerException np){
            
        }
    }
    
    private void irAgregarConsultorio(){
        PlantillaConsultorio ventanaAgregarConsultorio = new PlantillaConsultorio("Agregar consultorio", "Agregar", almacenamiento);
        vistaGestionServicio.dispose();
    }
    private void irActualizarConsultorio() {
        PlantillaConsultorio ventanaActualizarConsultorio = new PlantillaConsultorio("Actualizar consultorio", "Actualizar", almacenamiento);
        vistaGestionServicio.dispose();
    }
    private void irListarConsultorio(){
        ListarConsultorio ventanaListaConsultorio = new ListarConsultorio("Listas de consultorios", almacenamiento);
        vistaGestionServicio.dispose();
    }
    private void irEliminarConsultorio() {
        PlantillaConsultorio ventanaActualizarConsultorio = new PlantillaConsultorio("Eliminar consultorio", "Eliminar", almacenamiento);
        vistaGestionServicio.dispose();
    }
    
    //Opciones a realizar con un servicio
    private void opcionesServicio(){
        try {
            String resp = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">¿Qué desea hacer?</p></html>", "Opciones servicios médicos", JOptionPane.DEFAULT_OPTION, UIManager.getIcon("OptionPane.questionIcon"), opciones, opciones[0]);
            
            //Simulación de conversión de datos de un ArrayList a Array String, para ponerlo en el comboBox ;)
            ArrayList<String> servicios = new ArrayList();
            servicios.add("Odontología");
            servicios.add("Psiquiatría");
            servicios.add("Calvo");

            Object[] arrayDeObjetos = servicios.toArray();
            String[] misServicios = new String[servicios.size()];
            for (int i= 0; i<arrayDeObjetos.length; i++){
                misServicios[i] = (String) arrayDeObjetos[i];
            }
            if(resp != null & !"Agregar".equals(resp) & !"Listar".equals(resp)){
                String resp2 = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">Escoja el servicio</p></html>", "Lista de servicios", JOptionPane.DEFAULT_OPTION, UIManager.getIcon("OptionPane.questionIcon"), misServicios, misServicios[0]);
                
                switch(resp){
                    
                    case "Actualizar" -> {
                        try {
                            if (resp2 != null){
                                for (String miServicio : misServicios) {
                                    if (miServicio.equals(resp2)) {
                                        irActualizarServicio();
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
                                        irEliminarServicio();
                                    }
                                }
                            }
                        } catch(NullPointerException np){
                            JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:12px; \">No se escogió ningún servicio</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                        }
                    }
                }
            } else if ("Listar".equals(resp)){
                irListarServicio();
            } else if ("Agregar".equals(resp)){
                irAgregarServicio();
            } 

        } catch(NullPointerException np){
            
        }
    }
    private void irAgregarServicio(){
        PlantillaServicio ventanaAgregarServicio = new PlantillaServicio("Agregar servicio", "Agregar", almacenamiento);
        ventanaAgregarServicio.setVisible(true);
        vistaGestionServicio.dispose();
    }
    private void irActualizarServicio() {
        PlantillaServicio ventanaActualizarServicio = new PlantillaServicio("Actualizar servicio", "Actualizar", almacenamiento);
        vistaGestionServicio.dispose();
    }
    private void irListarServicio(){
        ListarServicio ventanaListaServicio = new ListarServicio("Lista de servicios", almacenamiento);
        vistaGestionServicio.dispose();
    }
    private void irEliminarServicio() {
        PlantillaServicio ventanaEliminarServicio = new PlantillaServicio("Eliminar servicio", "Eliminar", almacenamiento);
        vistaGestionServicio.dispose();
    }
}
