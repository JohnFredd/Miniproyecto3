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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelos.Almacenamiento;
import modelos.Medico;
import modelos.Servicio;
import vistas.GestionServicioGUI;
import vistas.ListarMedico;
import vistas.PlantillaMedico;

public class GestorPlantillaMedico {
    
    PlantillaMedico vistaPlantillaMedico;
    Almacenamiento almacenamiento;
    private String opcion;
    private long cedula;
    public GestorPlantillaMedico(PlantillaMedico vistaPlantillaMedico, String opcion, Almacenamiento almacenamiento, long cedula) {
        this.vistaPlantillaMedico = vistaPlantillaMedico;
        this.opcion = opcion;
        this.almacenamiento = almacenamiento;
        this.cedula = cedula;
        traerServicios();
        modificarPlantilla();
        verificarNumero(vistaPlantillaMedico.getTxtCedula());
        verificarNumero(vistaPlantillaMedico.getTxtEdad());
        verificarNumero(vistaPlantillaMedico.getTxtTelefono());
        this.vistaPlantillaMedico.addBtnRegresarListener(new ManejadoraDeMouse());
        this.vistaPlantillaMedico.addBtnAgregarListener(new ManejadoraDeMouse());
    }
    
    public void modificarPlantilla(){
        
        switch(opcion){
            case "Actualizar" -> {
                plantillaActualizarMedico();
            }
            case "Eliminar" -> {
                plantillaEliminarMedico();
            }
            case "Consultar" -> {
                plantillaConsultarMedico();
                
            }
        }
    }
    public void plantillaActualizarMedico(){
        
        //Modificando título y botones
        vistaPlantillaMedico.getLblTitulo().setText("Actualizar médico");
        vistaPlantillaMedico.getBtnAgregar().setText("Actualizar médico");
        
        //Ingresando los datos del médico
        Medico miMedico = almacenamiento.getMedicos().get(cedula);
        vistaPlantillaMedico.getTxtCedula().setText(Long.toString(miMedico.getCedula()));
        vistaPlantillaMedico.getTxtEdad().setText(Integer.toString(miMedico.getEdad()));
        vistaPlantillaMedico.getTxtTelefono().setText(Long.toString(miMedico.getTelefono()));
        vistaPlantillaMedico.getTxtNombre().setText(miMedico.getNombre());
        vistaPlantillaMedico.getTxtDireccion().setText(miMedico.getDireccion());
        vistaPlantillaMedico.getTxtCorreo().setText(miMedico.getEmail());
        vistaPlantillaMedico.getComboSexo().setSelectedItem(miMedico.getSexo());
        
        //Hacer que se seleccionen los servicios del medico
        ArrayList <Integer> seleccionados = new ArrayList();
        for(int i = 0; i<miMedico.getServicios().size(); i++){
            String servicio = "";
            servicio += miMedico.getServicios().get(i);
            for(int o = 0; o<vistaPlantillaMedico.getListaEspecialidad().getModel().getSize(); o++){
                if(servicio.equals(vistaPlantillaMedico.getListaEspecialidad().getModel().getElementAt(o))){
                    seleccionados.add(o);
                }
            }
        }
        int[] indices = new int[seleccionados.size()];
        for (int i = 0; i<seleccionados.size(); i++) {
            indices[i] = seleccionados.get(i);
        }
        vistaPlantillaMedico.getListaEspecialidad().setSelectedIndices(indices);
    }
    
    public void plantillaEliminarMedico(){
        //Modificando título y botones
        vistaPlantillaMedico.getLblTitulo().setText("Eliminar médico");
        vistaPlantillaMedico.getBtnAgregar().setText("Eliminar médico");
        
        //Ingresando los datos del médico
        Medico miMedico = almacenamiento.getMedicos().get(cedula);
        vistaPlantillaMedico.getTxtCedula().setText(Long.toString(miMedico.getCedula()));
        vistaPlantillaMedico.getTxtEdad().setText(Integer.toString(miMedico.getEdad()));
        vistaPlantillaMedico.getTxtTelefono().setText(Long.toString(miMedico.getTelefono()));
        vistaPlantillaMedico.getTxtNombre().setText(miMedico.getNombre());
        vistaPlantillaMedico.getTxtDireccion().setText(miMedico.getDireccion());
        vistaPlantillaMedico.getTxtCorreo().setText(miMedico.getEmail());
        vistaPlantillaMedico.getComboSexo().setSelectedItem(miMedico.getSexo());
        
        //Desabilitando campos de texto
        vistaPlantillaMedico.getTxtCedula().setEditable(false);
        vistaPlantillaMedico.getTxtNombre().setEditable(false);
        vistaPlantillaMedico.getTxtEdad().setEditable(false);
        vistaPlantillaMedico.getTxtDireccion().setEditable(false);
        vistaPlantillaMedico.getTxtCorreo().setEditable(false);
        vistaPlantillaMedico.getTxtTelefono().setEditable(false);
        vistaPlantillaMedico.getComboSexo().setEnabled(false);
        vistaPlantillaMedico.getListaEspecialidad().setEnabled(false);
        
        
                
        //Cambiando lista especialidades
        ArrayList <String> lista = new ArrayList();
        ArrayList <Servicio> servicios = miMedico.getServicios();
        for (int i = 0; i < servicios.size(); i++) {
            String servicio = "";
            servicio += servicios.get(i);
            lista.add(servicio);
        }
        vistaPlantillaMedico.cambiarEspecialidades(lista);
    }
    
    public void plantillaConsultarMedico(){
        
        //Modificando título y botones
        vistaPlantillaMedico.getLblTitulo().setText("Consultar medico");
        //vistaPlantillaMedico.getBtnRegresar().setText("Regresar");
        vistaPlantillaMedico.getBtnRegresar().setVisible(true);
        vistaPlantillaMedico.getBtnAgregar().setVisible(false);
        
        //Ingresando los datos del afiliado a eliminar
        Medico miMedico = almacenamiento.getMedicos().get(cedula);
        vistaPlantillaMedico.getTxtCedula().setText(Long.toString(miMedico.getCedula()));
        vistaPlantillaMedico.getTxtEdad().setText(Integer.toString(miMedico.getEdad()));
        vistaPlantillaMedico.getTxtTelefono().setText(Long.toString(miMedico.getTelefono()));
        vistaPlantillaMedico.getTxtNombre().setText(miMedico.getNombre());
        vistaPlantillaMedico.getTxtDireccion().setText(miMedico.getDireccion());
        vistaPlantillaMedico.getTxtCorreo().setText(miMedico.getEmail());
        vistaPlantillaMedico.getComboSexo().setSelectedItem(miMedico.getSexo());
        
        //Desabilitando campos de texto
        vistaPlantillaMedico.getTxtCedula().setEditable(false);
        vistaPlantillaMedico.getTxtEdad().setEditable(false);
        vistaPlantillaMedico.getTxtNombre().setEditable(false);
        vistaPlantillaMedico.getListaEspecialidad().setEnabled(false);
        vistaPlantillaMedico.getTxtDireccion().setEditable(false);
        vistaPlantillaMedico.getTxtCorreo().setEditable(false);
        vistaPlantillaMedico.getTxtTelefono().setEditable(false);
        vistaPlantillaMedico.getComboSexo().setEnabled(false);
        
        //Quitando boton regresar
        
        
        //Cambiando lista especialidades
        ArrayList <String> lista = new ArrayList();
        ArrayList <Servicio> servicios = miMedico.getServicios();
        for (int i = 0; i < servicios.size(); i++) {
            String servicio = "";
            servicio += servicios.get(i);
            lista.add(servicio);
        }
        vistaPlantillaMedico.cambiarEspecialidades(lista);
        
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            if (e.getSource() == vistaPlantillaMedico.getBtnAgregar() && "Agregar".equals(opcion)){
                if (e.getButton() == 1){
                    agregarMedico();
                }
            }
            
            if (e.getSource() == vistaPlantillaMedico.getBtnAgregar() && "Actualizar".equals(opcion)){
                if (e.getButton() == 1){
                    actualizarMedico();
                }
            }
            
            if (e.getSource() == vistaPlantillaMedico.getBtnAgregar() && "Eliminar".equals(opcion)){
                if (e.getButton() == 1){
                    eliminarMedico();
                }
            }
            
            if (e.getSource() == vistaPlantillaMedico.getBtnRegresar()&& !"Consultar".equals(opcion)){
                if (e.getButton() == 1){
                    irGestionServicioGUI();  
                }
            } else {
                if (e.getButton() == 1){
                    irListarMedico();
                }
            }
        }
    }
    
    public void agregarMedico() {
        
        if(!validarCamposVacios()){

            //Obteniendo los datos de la ventana
            long cedulaNueva = Long.parseLong(vistaPlantillaMedico.getTxtCedula().getText());
            String nombre = vistaPlantillaMedico.getTxtNombre().getText();
            int edad = Integer.parseInt(vistaPlantillaMedico.getTxtEdad().getText());
            String direccion = vistaPlantillaMedico.getTxtDireccion().getText();
            String correo = vistaPlantillaMedico.getTxtCorreo().getText();
            long telefono = Long.parseLong(vistaPlantillaMedico.getTxtTelefono().getText());
            String sexo = (String)vistaPlantillaMedico.getComboSexo().getSelectedItem();

            List<String> listaEspecialidades = vistaPlantillaMedico.getListaEspecialidad().getSelectedValuesList();
            ArrayList<Servicio> misEspecialidades = new ArrayList(listaEspecialidades);

            //Creando el médico
            Medico medico = new Medico(misEspecialidades,nombre, sexo, direccion, correo, cedulaNueva, edad, telefono);
            try {
                //Agregando el médico
                if (almacenamiento.anadirMedico(medico)){
                    JOptionPane.showMessageDialog(null, "Médico agregado con éxito", "Resultado de agregar", JOptionPane.INFORMATION_MESSAGE);
                    irGestionServicioGUI();
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un médico con ese número de cédula", "Resultado de agregar", JOptionPane.ERROR_MESSAGE);
                }
            } catch(IOException e){
                JOptionPane.showMessageDialog(null, "Error al agregar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void actualizarMedico() {
        if(!validarCamposVacios()){
            
            //Obteniendo los datos
            long cedulaNueva = Long.parseLong(vistaPlantillaMedico.getTxtCedula().getText());
            String nombre = vistaPlantillaMedico.getTxtNombre().getText();
            int edad = Integer.parseInt(vistaPlantillaMedico.getTxtEdad().getText());
            String direccion = vistaPlantillaMedico.getTxtDireccion().getText();
            String correo = vistaPlantillaMedico.getTxtCorreo().getText();
            long telefono = Long.parseLong(vistaPlantillaMedico.getTxtTelefono().getText());
            String sexo = (String)vistaPlantillaMedico.getComboSexo().getSelectedItem();
            
            List<String> listaEspecialidades = vistaPlantillaMedico.getListaEspecialidad().getSelectedValuesList();
            ArrayList<Servicio> misEspecialidades = new ArrayList(listaEspecialidades);
            
            //Verifica si al actualizar el médico se ingresa una cédula que ya existía
            if(!almacenamiento.getAfiliados().containsKey(cedulaNueva) || almacenamiento.getAfiliados().get(cedula).getCedula() == (cedulaNueva)){
                //Creando el médico
                Medico medico = new Medico(misEspecialidades,nombre, sexo, direccion, correo, cedulaNueva, edad, telefono);

                try {
                    //Actualizando los datos de médico
                    almacenamiento.modificarMedico(cedula, medico);
                    JOptionPane.showMessageDialog(null, "Médico actualizado con éxito", "Resultado de actualizar", JOptionPane.INFORMATION_MESSAGE);
                    irGestionServicioGUI();
                } catch(IOException e){
                    JOptionPane.showMessageDialog(null, "Error al actualizar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un médico con esa cédula", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos requeridos antes de continuar.", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminarMedico() {
        
        //Eliminando el afiliado
        try{
            almacenamiento.eliminarMedico(cedula);
            JOptionPane.showMessageDialog(null, "Médico eliminado con éxito", "Resultado de eliminar", JOptionPane.INFORMATION_MESSAGE);
            irGestionServicioGUI();
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void traerServicios() {
        //Lista de todos los servicios agregados previamente
        ArrayList<Servicio> misServicios = almacenamiento.getServicios(); 
        ArrayList<String> allServices = new ArrayList();
        for (int i = 0; i < misServicios.size(); i++) {
            String servicio = "";
            servicio += misServicios.get(i).getNombre();
            allServices.add(servicio);
        }
        vistaPlantillaMedico.agregarEspecialidades(allServices);
    }
    
    public void irGestionServicioGUI() {
        
        GestionServicioGUI vistaGestionServicio = new GestionServicioGUI("Gestión de servicios", almacenamiento);
        vistaPlantillaMedico.dispose();
    }
    
    private void irListarMedico() {
        
        //Creación de vistas
        ListarMedico ventanaListaMedico = new ListarMedico("Lista de afiliados",almacenamiento);
        vistaPlantillaMedico.dispose();
    }
    
    private void verificarNumero(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isDigit(c) | Character.isSpaceChar(c)){
                    e.consume();
                }
            }
        });
    }
    private boolean validarCamposVacios(){
        boolean error = false;
        if(vistaPlantillaMedico.getTxtCedula().getText().isBlank())
            error = true;
        if(vistaPlantillaMedico.getTxtNombre().getText().isBlank())
            error = true;
        if(vistaPlantillaMedico.getTxtEdad().getText().isBlank())
            error = true;
        if(vistaPlantillaMedico.getTxtDireccion().getText().isBlank())
            error = true;
        if(vistaPlantillaMedico.getTxtTelefono().getText().isBlank())
            error = true;
        if(vistaPlantillaMedico.getTxtCorreo().getText().isBlank())
            error = true;
        String sexo=(String)vistaPlantillaMedico.getComboSexo().getSelectedItem();
        if(!"Masculino".equals(sexo) && !"Femenino".equals(sexo))
            error = true;
        List<String> listaEspecialidades = vistaPlantillaMedico.getListaEspecialidad().getSelectedValuesList();
        if(listaEspecialidades.isEmpty())
            error = true;
        return error;
    }
}
