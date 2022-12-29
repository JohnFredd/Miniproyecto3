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

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import modelos.Almacenamiento;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelos.Afiliado;
import modelos.Cita;
import modelos.Consultorio;
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
    private final HashMap<String, Consultorio> consultorios;
    private ArrayList<Object[]> opcionesComboBox;
    private int referenciaCita;
    
    public GestorPlantillaCita(PlantillaCita vistaPlantillaCita, String opcion, String motivoCita, long cedula, Almacenamiento almacenamiento) {
        this.almacenamiento = almacenamiento;
        this.opcion = opcion;
        this.motivoCita = motivoCita;
        this.cedula = cedula;
        medicos = almacenamiento.getMedicos();
        consultorios = almacenamiento.getConsultorios();
        this.vistaPlantillaCita = vistaPlantillaCita;
        modificarPlantilla();
        asignarReferenciaCita();
        //Añadiendo Listeners
        this.vistaPlantillaCita.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaPlantillaCita.addBtnAgendarListener(new ManejadoraDeMouse());
        this.vistaPlantillaCita.addBtnVerificarListener(new ManejadoraDeMouse());
        this.vistaPlantillaCita.addBtnAsignarListener(new ManejadoraDeMouse());
        this.vistaPlantillaCita.addMedicosComboListener(new ManejadoraDeLista());
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
                if(!verificarFechasAntiguas()){
                    JOptionPane.showMessageDialog(null, "<html><p style = \" font:12px; \">Seleccione sólo fechas a partir de la actual</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                    return;
                }
                
                if (e.getButton() == 1){
                    medicosDisponibles();
                }
            }
            
            if (e.getSource() == vistaPlantillaCita.getBtnAsignar() && vistaPlantillaCita.getBtnAsignar().isEnabled()){
                if (e.getButton() == 1){
                    asignarConsultorio(); 
                }
            }
        }
    }
    
    class ManejadoraDeLista implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            vistaPlantillaCita.getTxtConsultorio().setText("");
            vistaPlantillaCita.getBtnAgendar().setEnabled(false);
        }
        
    }
    
    public void agendarCita() {
       
        //Obteniendo los datos
        int numeroReferencia = Integer.parseInt(vistaPlantillaCita.getTxtReferencia().getText());
        Date date = vistaPlantillaCita.getDateChooser().getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        LocalTime hora = obtenerHoraEscogida();
        ArrayList <Servicio> servicios = almacenamiento.getServicios();
        Iterator i = servicios.iterator();
        Servicio servicio = null;
        while (i.hasNext()) {
           servicio = (Servicio) i.next();
           if (servicio.getNombre().equals(motivoCita)) {
               break;
           }
        }
        Afiliado afiliado = almacenamiento.getAfiliados().get(cedula);
        Consultorio consultorio = almacenamiento.getConsultorios().get(vistaPlantillaCita.getTxtConsultorio().getText());
        Medico medico = obtenerMedicoEscogido();
        Cita cita = new Cita(numeroReferencia, fecha, hora, servicio, afiliado, consultorio, medico);
        try {
            almacenamiento.anadirCita(cita);
            JOptionPane.showMessageDialog(null, "<html><p style = \" font:12px; \">Cita agendada con éxito</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
            irGestionCitasGUI();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "<html><p style = \" font:12px; \">Error al agendar cita: " + e.getMessage() + "</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
        }
    }
    
    public void modificarCita() {
       
       //Obteniendo los datos
       
    }
    
    public void eliminarCita() {
       
       //Obteniendo los datos
       
    }
    
    // Actualiza el comboBox con los médicos que prestan el servicio requerido y sus horas disponibles
    public void medicosDisponibles(){
        vistaPlantillaCita.limpiarMedicosCombo();
        opcionesComboBox = new ArrayList();
        Iterator i = medicos.entrySet().iterator();
        ArrayList<Medico> misMedicos = new ArrayList();
        
        while(i.hasNext()) {
            HashMap.Entry <Long, Medico> mapa = (HashMap.Entry) i.next();
            Medico medico = mapa.getValue();
            ArrayList<Servicio> servicioDelMedico = medico.getServicios();
            
            //Convirtiendo los servicios del médico a String[]
            for (int o = 0; o < servicioDelMedico.size(); o++){
                String servicio = "";
                servicio += servicioDelMedico.get(o);
                if (servicio.equals(motivoCita)) {
                    misMedicos.add(medico);
                }
            }
        }
        
        Iterator o = misMedicos.iterator();
        Date date = vistaPlantillaCita.getDateChooser().getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        while (o.hasNext()) {
            Medico medico = (Medico) o.next();
            ArrayList<LocalTime> horas = verificarHorarios(medico, fecha);
            for (LocalTime hora : horas) {
                vistaPlantillaCita.anadirMedicosCombo(medico.getNombre() + ", " + hora);
                Object[] medicoYHora = new Object[2];
                medicoYHora[0] = medico;
                medicoYHora[1] = hora;
                opcionesComboBox.add(medicoYHora);
            }
        }
        if (vistaPlantillaCita.getComboMedico().getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(null, "<html><p style = \" font:12px; \">No hay disponibilidad para esa fecha.</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
            vistaPlantillaCita.getComboMedico().setEnabled(false);
            vistaPlantillaCita.getBtnAsignar().setEnabled(false);
        } else {
            vistaPlantillaCita.getComboMedico().setEnabled(true);
            vistaPlantillaCita.getBtnAsignar().setEnabled(true);
        }
    }
    
    public Medico obtenerMedicoEscogido(){
        int opcionElegida = vistaPlantillaCita.getComboMedico().getSelectedIndex();
        return (Medico)opcionesComboBox.get(opcionElegida)[0];
    }
    
    //Asigna el consultorio de acuerdo a la hora escogida
    public void asignarConsultorio(){
        if(validarCamposVacios()){
            JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //Asignando consultorios
        Iterator i = consultorios.entrySet().iterator();
        ArrayList<Consultorio> misConsultorios = new ArrayList();
        
        while(i.hasNext()) {
            HashMap.Entry <Long, Consultorio> mapa = (HashMap.Entry) i.next();
            Consultorio consultorio = mapa.getValue();
            Servicio servicioDelConsultorio = consultorio.getServicioAsociado();
            
            //Convirtiendo los servicios del consultorio a String[]
            //String servicio = "";
            String servicio = servicioDelConsultorio.getNombre();
            if (servicio.equals(motivoCita)) {
                misConsultorios.add(consultorio);
            }
        }
        
        Iterator o = misConsultorios.iterator();
        Date date = vistaPlantillaCita.getDateChooser().getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        Consultorio consultorioDisponible = null;
        LocalTime hora = obtenerHoraEscogida();
        while (o.hasNext()) {
            Consultorio consultorio = (Consultorio) o.next();
            if (!verificarHorarios(consultorio, fecha, hora)) {
                vistaPlantillaCita.getTxtConsultorio().setText(consultorio.getIdentificador());
                vistaPlantillaCita.getBtnAgendar().setEnabled(true);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "<html><p style = \" font:12px; \">No hay disponibilidad para ese momento.</p></html>", "Aviso", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
    }
    
    public LocalTime obtenerHoraEscogida(){
        String opcionElegida = vistaPlantillaCita.getComboMedico().getModel().getSelectedItem().toString();
        int posicionDeComa = opcionElegida.indexOf(',');
        String horaElegida = opcionElegida.substring(posicionDeComa+2, opcionElegida.length());
        LocalTime lt = LocalTime.parse(horaElegida);
        return lt;
    }
    
    public ArrayList<LocalTime> verificarHorarios(Medico medico, Date date) {
        HashMap <Integer, Cita> citas = almacenamiento.getCitas();
        Iterator i = citas.entrySet().iterator();
        ArrayList<LocalTime> horariosOcupados = new ArrayList();
        ArrayList<LocalTime> horariosPosibles = new ArrayList();
        ArrayList<LocalTime> horariosdisponibles = new ArrayList();
        for (int h = 7; h < 17; h++) {
            if (h != 12 && h != 13) {
                horariosPosibles.add(LocalTime.of(h, 0));
                horariosPosibles.add(LocalTime.of(h, 30));
            }
        }
        while (i.hasNext()) {
            HashMap.Entry <Integer, Cita> mapa = (HashMap.Entry) i.next();
            Cita cita = mapa.getValue();
            if (cita.getMedico().equals(medico) && cita.getFecha().toString().equals(date.toString())) {
                horariosOcupados.add(cita.getHora());
            }
        }
        for (LocalTime hora : horariosPosibles) {
            if (!horariosOcupados.contains(hora)) {
                horariosdisponibles.add(hora);
            }
        }
        return horariosdisponibles;
    }

    public boolean verificarHorarios(Consultorio consultorio, Date date, LocalTime hora) {
        HashMap <Integer, Cita> citas = almacenamiento.getCitas();
        Iterator i = citas.entrySet().iterator();
        
        while (i.hasNext()) {
            HashMap.Entry <Integer, Cita> mapa = (HashMap.Entry) i.next();
            Cita cita = mapa.getValue();
            if (cita.getConsultorio().equals(consultorio) && cita.getFecha().toString().equals(date.toString()) && cita.getHora().toString().equals(hora.toString())) {
                return true;
            }
        }
        return false;
    }
    
    public boolean verificarFechasAntiguas() {
        boolean fechaValida = false;
        
        //Convirtiendo la fecha escogida (Date) a LocalDate
        Date date = vistaPlantillaCita.getDateChooser().getDate();
        long d = date.getTime();
        String miFecha = new java.sql.Date(d).toString();
        LocalDate fechaEscogida = LocalDate.parse(miFecha);

        //Obteniendo la fecha actual
        LocalDate fecha = LocalDate.now();
        if(fechaEscogida.isBefore(fecha)){
            vistaPlantillaCita.limpiarMedicosCombo();
            opcionesComboBox = new ArrayList();
            vistaPlantillaCita.getTxtConsultorio().setText("");
            vistaPlantillaCita.getComboMedico().setEnabled(false);
            vistaPlantillaCita.getBtnAsignar().setEnabled(false);
            vistaPlantillaCita.getBtnAgendar().setEnabled(false);
            fechaValida = false;
            return fechaValida;
        }
        fechaValida = true;
        return fechaValida;
    }
    
    public void asignarReferenciaCita() {
        int numeroDeReferencia = 1;
        while (almacenamiento.getCitas().containsKey(numeroDeReferencia)) {
            numeroDeReferencia += 1;
        }
        referenciaCita = numeroDeReferencia;
        vistaPlantillaCita.getTxtReferencia().setText(String.valueOf(referenciaCita));
    }
    
    public boolean validarCamposVacios(){
        boolean error = false;
        
        if(vistaPlantillaCita.getComboMedico().getModel().getSelectedItem() == null)
            error = true;
        return error;
    }
    
    public void irGestionCitasGUI() {
        
        GestionDeCitas vistaGestionCitas= new GestionDeCitas("Gestión de Citas", almacenamiento);
        vistaPlantillaCita.dispose();
    }
    
    public void irCitasAfiliadoGUI() {
        
        CitasDeAfiliado vistaCitasAfiliado= new CitasDeAfiliado("Gestión de Citas", "Consultar", cedula, almacenamiento);
        vistaPlantillaCita.dispose();
    }
}

