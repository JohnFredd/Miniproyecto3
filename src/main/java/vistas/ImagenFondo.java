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
import javax.swing.JPanel;

public class ImagenFondo extends JPanel{
    
    private Image imagen;
        
        public void paint (Graphics g){
            imagen = new ImageIcon(getClass().getResource("/Imagenes/fondoCeleste2.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
}
