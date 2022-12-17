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

import vistas.PlantillaAfiliado;

public class GestorPlantillaAfiliado {
    
    PlantillaAfiliado vistaPlantillaAfiliado;

    public GestorPlantillaAfiliado(PlantillaAfiliado vistaPlantillaAfiliado) {
        this.vistaPlantillaAfiliado = vistaPlantillaAfiliado;
    }
    
    public void plantillaActualizarAfiliado(){
        vistaPlantillaAfiliado = new PlantillaAfiliado();
        vistaPlantillaAfiliado.setVisible(true);
        vistaPlantillaAfiliado.getLblTitulo().setText("Actualizar afiliado");
        vistaPlantillaAfiliado.getBtnAgregar().setText("Actualizar afiliado");
    }
    
    public void plantillaEliminarAfiliado(){
        
        vistaPlantillaAfiliado = new PlantillaAfiliado();
        vistaPlantillaAfiliado.setVisible(true);
        vistaPlantillaAfiliado.getLblTitulo().setText("Eliminar afiliado");
        vistaPlantillaAfiliado.getBtnAgregar().setText("Eliminar afiliado");
        
        //Desabilitando campos de texto
        vistaPlantillaAfiliado.getTxtCedula().setEditable(false);
        vistaPlantillaAfiliado.getTxtNombre().setEditable(false);
        vistaPlantillaAfiliado.getTxtEdad().setEditable(false);
        vistaPlantillaAfiliado.getTxtDireccion().setEditable(false);
        vistaPlantillaAfiliado.getTxtCorreo().setEditable(false);
        vistaPlantillaAfiliado.getTxtTelefono().setEditable(false);
        vistaPlantillaAfiliado.getComboSexo().setEnabled(false);
    }
}
