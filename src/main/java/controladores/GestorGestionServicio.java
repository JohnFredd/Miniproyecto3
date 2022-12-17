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
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import vistas.GestionDeCitas;
import vistas.GestionServicioGUI;
import vistas.ListarAfiliado;
import vistas.OpcionesDeRespaldo;
import vistas.PlantillaAfiliado;

public class GestorGestionServicio {
    
    private final GestionServicioGUI vistaGestionServicio;
    private final GestorPlantillaAfiliado gestorPlantillaAfiliado;
    private final String[] opciones = {
                                    "Agregar",
                                    "Actualizar",
                                    "Listar",
                                    "Eliminar"
                                   };
    
    public GestorGestionServicio(GestionServicioGUI vistaGestionServicio, GestorPlantillaAfiliado gestorPlantillaAfiliado) {
        this.vistaGestionServicio = vistaGestionServicio;
        this.gestorPlantillaAfiliado = gestorPlantillaAfiliado;
        this.vistaGestionServicio.addBtnAfiliadosListener(new ManejadoraDeMouse());
    }
    
    class ManejadoraDeMouse extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e){
          if (e.getSource() == vistaGestionServicio.getBtnAfiliados()){
                if (e.getButton() == 1){
                    String resp = (String) JOptionPane.showInputDialog(vistaGestionServicio, "¿Qué desea hacer?", "Opciones afiliados", JOptionPane.DEFAULT_OPTION, UIManager.getIcon("OptionPane.questionIcon"), opciones, opciones[0]);
                    
                    switch(resp){
                        case "Agregar" -> {
                            irAgregarAfiliado();
                        }
                        case "Actualizar" -> {
                            String cedulaABuscar;
                            try {
                                cedulaABuscar = (String) JOptionPane.showInputDialog(vistaGestionServicio, "<html><p style = \" font:15px; \">Ingrese la cédula del afiliado a actualizar</p></html>", "Actualizar afiliado", JOptionPane.DEFAULT_OPTION);
                                if(cedulaABuscar.equals("12345")){
                                    irActualizarAfiliado();

                                } else if (cedulaABuscar.isBlank()){
                                    JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:15px; \">Por favor ingrese una cédula</p></html>", "Afiliado no encontrado", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                                }
                            } catch(NullPointerException np){
                                JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:14px; \">No se ingresó ninguna cédula</p></html>", "Afiliado no encontrado", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                            }
                        }
                        case "Listar" -> {
                            irListarAfiliado();
                        }
                        case "Eliminar" -> {
                            String cedulaABuscar = (String) JOptionPane.showInputDialog(vistaGestionServicio, "Ingrese la cédula del afiliado a actualizar", "Actualizar afiliado", JOptionPane.DEFAULT_OPTION);
                            try {
                                if(cedulaABuscar.equals("12345")){
                                    irEliminarAfiliado();

                                } else if(cedulaABuscar.isBlank()){
                                    JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:15px; \">No se encontró un afiliado registrado con esa cédula</p></html>", "Afiliado no encontrado", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.errorIcon"));
                                }
                            } catch(NullPointerException np){
                                JOptionPane.showMessageDialog(vistaGestionServicio, "<html><p style = \" font:14px; \">No se ingresó ninguna cédula</p></html>", "Afiliado no encontrado", JOptionPane.OK_OPTION, UIManager.getIcon("OptionPane.informationIcon"));
                            }
                        }
                    }
                }
          }
          
          if (e.getSource() == vistaGestionServicio.getBtnConsultorios()){
                if (e.getButton() == 1){
                    
                }
          }
          
          if (e.getSource() == vistaGestionServicio.getBtnMedicos()){
                if (e.getButton() == 1){
                    
                }
          }
          
          if (e.getSource() == vistaGestionServicio.getBtnRegresar()){
                if (e.getButton() == 1){
                    
                }
          }
          
          if (e.getSource() == vistaGestionServicio.getBtnServicios()){
                if (e.getButton() == 1){
                    
                }
          }
        }

    }
    
    private void irActualizarAfiliado() {
        gestorPlantillaAfiliado.plantillaActualizarAfiliado();
        vistaGestionServicio.dispose();
    }
    
    private void irAgregarAfiliado(){
        PlantillaAfiliado ventanaAgregarAfiliado = new PlantillaAfiliado();
        ventanaAgregarAfiliado.setVisible(true);
        vistaGestionServicio.dispose();
    }
    
    private void irListarAfiliado(){
        ListarAfiliado ventanaListaAfiliado = new ListarAfiliado();
        //Crear gestor también
        ventanaListaAfiliado.setVisible(true);
        vistaGestionServicio.dispose();
    }
    
    private void irEliminarAfiliado() {
        gestorPlantillaAfiliado.plantillaEliminarAfiliado();
        vistaGestionServicio.dispose();
    }
    /*
    public void irGestionDeCitas(){
        GestionDeCitas ventanaGestionCitas = new GestionDeCitas();
        ventanaGestionCitas.setVisible(true);
        vistaPpal.dispose();
    }
    
    public void irRespaldo(){
        OpcionesDeRespaldo ventanaRespaldo = new OpcionesDeRespaldo();
        ventanaRespaldo.setVisible(true);
        vistaPpal.dispose();
    }*/
}
