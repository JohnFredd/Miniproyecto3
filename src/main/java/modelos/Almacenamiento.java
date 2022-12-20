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

public class Almacenamiento {
    
    private HashMap <Long, Afiliado> afiliados;
    private HashMap <Long, Medico> medicos;
    private ArrayList <Servicio> servicios;
    private ArrayList <Consultorio> consultorios;
    private ArrayList <Cita> citas;
    
    public Almacenamiento () throws IOException, ClassNotFoundException {
        try
        {
            restaurarDatos();
        } catch (FileNotFoundException e) {
            
        } catch (IOException | ClassNotFoundException e) {
            throw e;
        }
    }
    
    public boolean hacerBackUp() throws IOException{
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
            return true;
        } catch (IOException e) {
            throw e;
        }
    }
    
    public boolean restaurarDatos() throws IOException, ClassNotFoundException {
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
            return true;
        } catch(IOException | ClassNotFoundException e) {
            throw e;
        }
    }
    
    public boolean exportarDatosAfiliados(File ruta) throws IOException {
        try
        {
            FileWriter fw = new FileWriter(ruta);
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
            return true;
        } catch (IOException e) {
            throw e;
        }
    }
    
    public boolean backUpCitas(File ruta) throws IOException{
        try
        {
            OutputStream os = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(os);

            oos.writeObject(citas);

            oos.close();
            return true;
        } catch (IOException e) {
            throw e;
        }
    }
    
    public boolean restauracionCitas(File ruta) throws IOException, ClassNotFoundException {
        try
        {
            InputStream is = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(is);

            citas = (ArrayList) ois.readObject();

            ois.close();
            return true;
        } catch(IOException | ClassNotFoundException e) {
            throw e;
        }
    }

    public boolean anadirAfiliado(Afiliado afiliado) {
        System.out.println(afiliado.toString());
        System.out.println("Cédula: "+afiliado.getCedula());
        afiliados.put(afiliado.getCedula(), afiliado);
        return true;
    }
    
    public void modificarAfiliado(long cedulaAnterior, Afiliado afiliado) {
        afiliados.remove(cedulaAnterior);
        afiliados.put(afiliado.getCedula(), afiliado);
    }
    
    public void eliminarAfiliado(long cedula) {
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
    
    public void modificarMedico(long cedulaAnterior, Medico medico) {
        medicos.remove(cedulaAnterior);
        medicos.put(medico.getCedula(), medico);
    }
    
    public void eliminarMedico(long cedula) {
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
    
    public HashMap<Long, Afiliado> getAfiliados() {
        return afiliados;
    }

    public void setAfiliados(HashMap<Long, Afiliado> afiliados) {
        this.afiliados = afiliados;
    }

    public HashMap<Long, Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(HashMap<Long, Medico> medicos) {
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
