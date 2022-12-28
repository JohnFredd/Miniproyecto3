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
import modelos.Almacenamiento;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;
import modelos.Medico;
import modelos.Servicio;
import vistas.CitasDeAfiliado;
import vistas.GestionDeCitas;
import vistas.PlantillaCita;

public class GestorPlantillaCita {
    
    private final PlantillaCita vistaPlantillaCita;
    private final Almacenamiento almacenamiento;
    private final String opcion;
    private final String motivoCita;
    private final long cedula;
    private final HashMap<Long, Medico> medicos;
    
    public GestorPlantillaCita(PlantillaCita vistaPlantillaCita, String opcion, String motivoCita, long cedula, Almacenamiento almacenamiento) {
        this.almacenamiento = almacenamiento;
        this.opcion = opcion;
        this.motivoCita = motivoCita;
        this.cedula = cedula;
        medicos = almacenamiento.getMedicos();
        this.vistaPlantillaCita = vistaPlantillaCita;
        modificarPlantilla();
        vistaPlantillaCita.getTxtReferencia().setText("0001");
        //Añadiendo Listeners
        this.vistaPlantillaCita.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaPlantillaCita.addBtnAgendarListener(new ManejadoraDeMouse());
        this.vistaPlantillaCita.addBtnVerificarListener(new ManejadoraDeMouse());
        this.vistaPlantillaCita.addBtnAsignarListener(new ManejadoraDeMouse());
    }
    
    public void modificarPlantilla(){
        switch (opcion) {
        
            case "Agendar" -> {
                plantillaAgendarCita();
            }
            case "Modificar" -> {
                plantillaModificarCita();
            }
            case "Eliminar" -> {
                plantillaEliminarCita();
            }
        }
    }
    
    public void plantillaAgendarCita(){
        
        //Ingresando nombre, cédula y motivo de cita en interfaz
        vistaPlantillaCita.getTxtNombre().setText(almacenamiento.getAfiliados().get(cedula).getNombre());
        vistaPlantillaCita.getTxtCedula().setText(String.valueOf(cedula));
        vistaPlantillaCita.getTxtServicio().setText(motivoCita);
    }
    
    public void plantillaModificarCita(){
        
        //Modificando título y botones
        vistaPlantillaCita.getLblTitulo().setText("Modificar Cita");
        vistaPlantillaCita.getBtnAgendar().setText("Modificar Cita");
        
        //Ingresando nombre, cédula y motivo de cita en interfaz
        vistaPlantillaCita.getTxtNombre().setText(almacenamiento.getAfiliados().get(cedula).getNombre());
        vistaPlantillaCita.getTxtCedula().setText(String.valueOf(cedula));
        vistaPlantillaCita.getTxtServicio().setText(motivoCita);
    }
    
    public void plantillaEliminarCita(){
        
        //Modificando título y botones
        vistaPlantillaCita.getLblTitulo().setText("Eliminar Cita");
        vistaPlantillaCita.getBtnAgendar().setText("Eliminar Cita");
        
        //Ingresando nombre, cédula y motivo de cita en interfaz
        vistaPlantillaCita.getTxtNombre().setText(almacenamiento.getAfiliados().get(cedula).getNombre());
        vistaPlantillaCita.getTxtCedula().setText(String.valueOf(cedula));
        vistaPlantillaCita.getTxtServicio().setText(motivoCita);
        
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPlantillaCita.getBtnAgendar()&& "Agendar".equals(opcion) && vistaPlantillaCita.getBtnAgendar().isEnabled()){
                if (e.getButton() == 1){
                    agendarCita();
                }
            }
            
            if (e.getSource() == vistaPlantillaCita.getBtnAgendar()&& "Modificar".equals(opcion)){
                if (e.getButton() == 1){
                    modificarCita();
                }
            }
            if (e.getSource() == vistaPlantillaCita.getBtnAgendar()&& "Eliminar".equals(opcion)){
                if (e.getButton() == 1){
                    eliminarCita();
                }
            }

            if (e.getSource() == vistaPlantillaCita.getBtnRegresar() && !"Consultar".equals(opcion)){
                if (e.getButton() == 1){
                    irGestionCitasGUI();  
                }
            }
            
            if (e.getSource() == vistaPlantillaCita.getBtnRegresar() && "Consultar".equals(opcion)){
                if (e.getButton() == 1){
                    irCitasAfiliadoGUI();  
                }
            }
            
            if (e.getSource() == vistaPlantillaCita.getBtnVerificar() && vistaPlantillaCita.getBtnVerificar().isEnabled()){
                if (vistaPlantillaCita.getDateChooser().getDate() == null){
                    JOptionPane.showMessageDialog(null, "<html><p style = \" font:12px; \">Por favor seleccione una fecha</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));            
                    return;
                }
                if (e.getButton() == 1){
                    medicosDisponibles();
                    actualizarMedicosHora();  
                }
            }
            
            if (e.getSource() == vistaPlantillaCita.getBtnAsignar() && vistaPlantillaCita.getBtnAsignar().isEnabled()){
                if (e.getButton() == 1){
                    asignarConsultorio(); 
                }
            }
        }
    }
    
    public void agendarCita() {
       
       //Obteniendo los datos
       Date date = vistaPlantillaCita.getDateChooser().getDate();
       long d = date.getTime();
       java.sql.Date fecha = new java.sql.Date(d);
    }
    
    public void actualizarMedicosHora() {
       
       //Obteniendo los datos
       Date date = vistaPlantillaCita.getDateChooser().getDate();
       long d = date.getTime();
       java.sql.Date fecha = new java.sql.Date(d);
       JOptionPane.showMessageDialog(vistaPlantillaCita, "La fecha es: " +fecha);
       vistaPlantillaCita.getComboMedico().setEnabled(true);
       vistaPlantillaCita.getBtnAsignar().setEnabled(true);
       
    }
    
    
    // Actualiza el comboBox con los médicos que prestan el servicio requerido
    public void medicosDisponibles(){
        
        Iterator i = medicos.entrySet().iterator();
        ArrayList<String> misMedicos = new ArrayList();
        
        while(i.hasNext()) {
            HashMap.Entry <Long, Medico> mapa = (HashMap.Entry) i.next();
            ArrayList<Servicio> servicioDelMedico = mapa.getValue().getServicios();
            
            //Convirtiendo los servicios del médico a String[]
            //String[] servicioDelMedicoStr = new String[servicioDelMedico.size()];
            for (int o= 0; o<servicioDelMedico.size(); o++){
                String servicio = "";
                servicio += servicioDelMedico.get(o);
                if (servicio.equals(motivoCita)) {
                    ArrayList<String> horarios = verificarHorarios(mapa.getValue(),vistaPlantillaCita.getDateChooser().getDate());
                }
                //servicioDelMedicoStr[o] = servicio;
            }
            
            //Verificando qué médico posee la especialidad del servicio requerido
            /*for (String misServicios : servicioDelMedicoStr) {
                if (misServicios.equals(motivoCita)) {
                    Medico medico = mapa.getValue();
                    misMedicos.add(medico.getNombre());
                    vistaPlantillaCita.anadirMedicosCombo(misMedicos);
                    misMedicos.removeAll(misMedicos);
                    break; 
                }
            }*/
        }
    }
    
    public void asignarConsultorio(){
        if(!validarCamposVacios()){
            //Asignando consultorios
            vistaPlantillaCita.getTxtConsultorio().setText("C101");
            vistaPlantillaCita.getBtnAgendar().setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void modificarCita() {
       
       //Obteniendo los datos
       
    }
    
    public void eliminarCita() {
       
       //Obteniendo los datos
       
    }

    public void irGestionCitasGUI() {
        
        GestionDeCitas vistaGestionCitas= new GestionDeCitas("Gestión de Citas", almacenamiento);
        vistaPlantillaCita.dispose();
    }
    
    public void irCitasAfiliadoGUI() {
        
        CitasDeAfiliado vistaCitasAfiliado= new CitasDeAfiliado("Gestión de Citas", "Consultar", cedula, almacenamiento);
        vistaPlantillaCita.dispose();
    }
    
    public boolean validarCamposVacios(){
        boolean error = false;
        
        if(vistaPlantillaCita.getComboMedico().getModel().getSelectedItem() == null)
            error = true;
        return error;
    }
    
    public ArrayList<String> verificarHorarios(Medico medico, Date date) {
        HashMap <Integer, Cita> citas = almacenamiento.getCitas();
        Iterator i = citas.entrySet().iterator();
        ArrayList<String> horarios;
        while (i.hasNext()) {
            HashMap.Entry <Integer, Cita> mapa = (HashMap.Entry) i.next();
            Cita cita = mapa.getValue();
            if (cita.getMedico() == medico) {
                
            }
        }
    }
}

