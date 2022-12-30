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

package vistas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ImagenFondo extends JPanel{
    
    private Image imagen;
        
    public void paint (Graphics g){
        try {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/fondoCeleste.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error: No se pudo encontrar el directorio de la imagen de fondo", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
