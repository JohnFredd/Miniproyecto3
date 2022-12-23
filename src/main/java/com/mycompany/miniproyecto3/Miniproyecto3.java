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

package com.mycompany.miniproyecto3;

import java.util.Arrays;
import javax.swing.JOptionPane;
import vistas.PpalGUI;

import modelos.*;
public class Miniproyecto3 {

    public static void main(String[] args) {
        try
        {
            Almacenamiento almacenamiento = new Almacenamiento();
            PpalGUI ventanaPpal = new PpalGUI("Servicio de salud - Universidad del Valle", almacenamiento);
        }catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            JOptionPane.showMessageDialog(null, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
