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
import java.util.Iterator;
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
    
    public void exportarDatosAfiliados() {
        JFileChooser chooser = new JFileChooser();
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.txt", ".txt");
        
        chooser.setFileFilter(filtro);
        
        int seleccion = chooser.showSaveDialog(new JPanel());
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            try
            {
                FileWriter fw = new FileWriter(chooser.getSelectedFile());
                PrintWriter pw = new PrintWriter(fw);

                Iterator i = afiliados.entrySet().iterator();
                
                while(i.hasNext()) {
                    HashMap.Entry <Integer, Afiliado> mapa = (HashMap.Entry) i.next();
                    Afiliado afiliado = mapa.getValue();
                    pw.print(afiliado.getNombre() + ";");
                    pw.print(afiliado.getSexo() + ";");
                    pw.print(afiliado.getDireccion() + ";");
                    pw.print(afiliado.getEmail() + ";");
                    pw.print(String.valueOf(afiliado.getCedula()) + ";");
                    pw.print(String.valueOf(afiliado.getEdad()) + ";");
                    pw.println(String.valueOf(afiliado.getTelefono()));
                }

                pw.close();
                System.out.println("Datos guardados exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al guardar datos: " + e.getMessage());
            }
        }
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

    public void anadirAfiliado(Afiliado afiliado) {
        afiliados.put(afiliado.getCedula(), afiliado);
    }
    
    public void modificarAfiliado(int cedulaAnterior, Afiliado afiliado) {
        afiliados.remove(cedulaAnterior);
        afiliados.put(afiliado.getCedula(), afiliado);
    }
    
    public void eliminarAfiliado(int cedula) {
        Afiliado afiliado = afiliados.get(cedula);
        afiliados.remove(cedula);
        
        for (int i=0; i<citas.size(); i++) {
            Cita cita = citas.get(i);
            if (cita.getAfiliado() == afiliado) {
                citas.remove(i);
            }
        }
    }
    
    public void anadirMedico(Medico medico) {
        medicos.put(medico.getCedula(), medico);
    }
    
    public void modificarMedico(int cedulaAnterior, Medico medico) {
        medicos.remove(cedulaAnterior);
        medicos.put(medico.getCedula(), medico);
    }
    
    public void eliminarMedico(int cedula) {
        Medico medico = medicos.get(cedula);
        medicos.remove(cedula);
        
        for (int i=0; i<citas.size(); i++) {
            Cita cita = citas.get(i);
            if (cita.getMedico() == medico) {
                citas.remove(i);
            }
        }
    }
    
    public void anadirConsultorio(Consultorio consultorio) {
        consultorios.add(consultorio);
    }
    
    public void modificarConsultorio(int indentificador, Consultorio consultorio) {
        consultorios.set(indentificador,consultorio);
    }
    
    public void eliminarConsultorio(int indentificador) {
        Consultorio consultorio = consultorios.get(indentificador);
        consultorios.remove(indentificador);
        
        for (int i=0; i<citas.size(); i++) {
            Cita cita = citas.get(i);
            if (cita.getConsultorio() == consultorio) {
                citas.remove(i);
            }
        }
    }
    
    public void anadirServicio(Servicio servicio) {
        servicios.add(servicio);
    }
    
    public void modificarServicio(int indentificador, Servicio servicio) {
        servicios.set(indentificador,servicio);
    }
    
    public void eliminarServicio(int indentificador) {
        Servicio servicio = servicios.get(indentificador);
        servicios.remove(indentificador);
        
        for (int i=0; i<citas.size(); i++) {
            Cita cita = citas.get(i);
            if (cita.getServicioRequerido() == servicio) {
                citas.remove(i);
            }
        }
        for (int i=0; i<consultorios.size(); i++) {
            Consultorio consultorio = consultorios.get(i);
            if (consultorio.getServicioAsociado() == servicio) {
                consultorios.remove(i);
            }
        }
        for (int i=0; i<medicos.size(); i++) {
            Medico medico = medicos.get(i);
            while (medico.getServicios().remove(servicio)){
                
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
