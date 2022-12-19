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

package modelos;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Almacenamiento {
    
    private HashMap <Integer, Afiliado> afiliados;
    private HashMap <Integer, Medico> medicos;
    private ArrayList <Servicio> servicios;
    private ArrayList <Consultorio> consultorios;
    private ArrayList <Cita> citas;
    
    public Almacenamiento () {
        restaurarDatos();
    }
    
    public void hacerBackUp() {
        try
        {
            OutputStream os = new FileOutputStream("Datos.bin");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            
            oos.writeObject(afiliados);
            oos.writeObject(medicos);
            oos.writeObject(servicios);
            oos.writeObject(consultorios);
            oos.writeObject(citas);
            
            oos.close();
            System.out.println("Datos guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
    
    public void restaurarDatos() {
        try
        {
            InputStream is = new FileInputStream("Datos.bin");
            ObjectInputStream ois = new ObjectInputStream(is);
            
            afiliados = (HashMap) ois.readObject();
            medicos = (HashMap) ois.readObject();
            servicios = (ArrayList) ois.readObject();
            consultorios = (ArrayList) ois.readObject();
            citas = (ArrayList) ois.readObject();
            
            ois.close();
            System.out.println("Datos recuperados exitosamente.");
        } catch(IOException | ClassNotFoundException e) {
            System.out.println("Error al recuperar datos: " + e.getMessage());
        }
    }
    
    public boolean exportarDatosAfiliados() {
        return true;
    }
    
    public void backUpCitas() {
        JFileChooser chooser = new JFileChooser();
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.bin", ".bin");
        
        chooser.setFileFilter(filtro);
        
        int seleccion = chooser.showSaveDialog(new JPanel());
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try
            {
                OutputStream os = new FileOutputStream(chooser.getSelectedFile());
                ObjectOutputStream oos = new ObjectOutputStream(os);

                oos.writeObject(citas);

                oos.close();
                System.out.println("Datos guardados exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al guardar datos: " + e.getMessage());
            }
        }
    }
    
    public void restauracionCitas() {
        JFileChooser chooser = new JFileChooser();
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.bin", ".bin");
        
        chooser.setFileFilter(filtro);
        
        int seleccion = chooser.showOpenDialog(new JPanel());
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try
            {
                InputStream is = new FileInputStream(chooser.getSelectedFile());
                ObjectInputStream ois = new ObjectInputStream(is);

                citas = (ArrayList) ois.readObject();

                ois.close();
                System.out.println("Datos recuperados exitosamente.");
            } catch(IOException | ClassNotFoundException e) {
                System.out.println("Error al recuperar datos: " + e.getMessage());
            }
        }
    }

    public HashMap<Integer, Afiliado> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(HashMap<Integer, Afiliado> afiliados) {
        this.afiliados = afiliados;
    }

    public HashMap<Integer, Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(HashMap<Integer, Medico> medicos) {
        this.medicos = medicos;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    public ArrayList<Consultorio> getConsultorios() {
        return consultorios;
    }

    public void setConsultorios(ArrayList<Consultorio> consultorios) {
        this.consultorios = consultorios;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }
    
}
