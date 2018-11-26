/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhomeh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class Archivo {
    public void ObtenerDatoAlarma(){
        try {
            FileReader archivo=new FileReader("alarmas.txt");
            BufferedReader br= new BufferedReader(archivo);
            String info;
            String[] palabras;
            while((info=br.readLine())!=null){
                palabras=info.split(";");
                Alarma nuevo=new Alarma(palabras[0], palabras[1], palabras[2]);
                Alarma.alarmas.add(nuevo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ObtenerDatosUsuario(){
        try {
            FileReader archivo=new FileReader("usuarios.txt");
            BufferedReader br=new BufferedReader(archivo);
            String info;
            String[] palabras;
            while((info=br.readLine())!=null){
                palabras=info.split(";");
                int id = Integer.parseInt(palabras[0]);
                Usuario nuevo = new Usuario(palabras[1], id, palabras[2]);
                Usuario.usuarios.add(nuevo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ObtenerDatosHab(){
        try {
            FileReader archivo = new FileReader("habitaciones.txt");
            BufferedReader br = new BufferedReader(archivo);
            String info;
            String[] palabras;
            while ((info = br.readLine()) != null) {
                palabras = info.split(";");
                int area = Integer.parseInt(palabras[2]);
                Habitacion nuevo = new Habitacion(palabras[0], palabras[1],area );
                Habitacion.habitaciones.add(nuevo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void GuardarSensores(int secuencia, String ubicacion, String tipo, String fecha, int rangoMin,int rangoMax,int frecuenAct){
        try {
            String linea = secuencia+";"+ubicacion+";"+tipo+";"+fecha+";"+rangoMin+";"+rangoMax+";"+frecuenAct;
            FileWriter archivo = new FileWriter("sensores.txt", true);
            PrintWriter escribir = new PrintWriter(archivo);
            escribir.println(linea);
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void GuardarAlarmas(String nombre,String Tipo,String activacion)
    {
        try {
            String linea = nombre+";"+Tipo+";"+activacion;
            FileWriter archivo = new FileWriter("alarmas.txt", true);
            PrintWriter escribir = new PrintWriter(archivo);
            escribir.println(linea);
            archivo.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
    public void ObtenerDatosSensores() {
        try {
            FileReader archivo = new FileReader("sensores.txt");
            BufferedReader br = new BufferedReader(archivo);
            String info;
            String[] palabras;
            while ((info = br.readLine()) != null) {
                palabras = info.split(";");
                int secuencia = Integer.parseInt(palabras[0]);
                int ranmax = Integer.parseInt(palabras[5]);
                int ranmin = Integer.parseInt(palabras[4]);
                int freact = Integer.parseInt(palabras[6]);
                Sensor nuevo = new Sensor(palabras[2], secuencia,palabras[1],palabras[3],ranmin,ranmax,freact );
                Sensor.sensores.add(nuevo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void IngresarDatosHabitacion(String nombre, String ubicacion, int area)
    {
        String linea = nombre+";"+ubicacion+";"+area;
        try{
            FileWriter archivo = new FileWriter("habitaciones.txt", true);
            PrintWriter escribir = new PrintWriter(archivo);
            escribir.println(linea);
            archivo.close();
        }catch(Exception e) {
            e.printStackTrace();
          }
    }
    public void IngresarDatosUsuario(int id, String nombre, String rol) {
        String linea = id + ";" + nombre + ";" + rol;        
        try {            
            FileWriter archivo = new FileWriter("usuarios.txt", true);
            PrintWriter escribir = new PrintWriter(archivo);
            escribir.println(linea);
            archivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    public boolean Eliminar(String ruta,String id)
    {
        try {
            FileReader archivo = new FileReader(ruta);
            BufferedReader br = new BufferedReader(archivo);            
            String info;
            String[] palabras;
            String[] lineas =new String[50];
            while ((info = br.readLine()) != null) {
                palabras = info.split(";");
                int i = 0;
                if (palabras[2] != id) {
                    lineas[i] = info;
                    i++;
                }                
            }
            archivo.close();            
            FileWriter nuevo_archivo = new FileWriter(ruta);
            PrintWriter escribir = new PrintWriter(nuevo_archivo);
            int j=0;
            while(lineas[j]!=null){
                escribir.println(lineas[j]);
                j++;
            }
            nuevo_archivo.close();            
            return true;            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
    }
    }
    public boolean Eliminar(String ruta, int id) {
        try {
            FileReader archivo = new FileReader(ruta);
            BufferedReader br = new BufferedReader(archivo);            
            String info;
            String[] palabras;
            String[] lineas =new String[50];
            while ((info = br.readLine()) != null) {
                palabras = info.split(";");
                int search_id = Integer.parseInt(palabras[0]);
                int i = 0;
                if (search_id != id) {
                    lineas[i] = info;
                    i++;
                }                
            }
            archivo.close();            
            FileWriter nuevo_archivo = new FileWriter(ruta);
            PrintWriter escribir = new PrintWriter(nuevo_archivo);
            int j=0;
            while(lineas[j]!=null){
                escribir.println(lineas[j]);
                j++;
            }
            nuevo_archivo.close();            
            return true;            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }        
    }
    public void GuardarHistorial(String nombre,String ubicacion,int codigo,int valor,String activo)
    {
        try {            
            String linea = nombre+";"+ubicacion+";"+codigo+";"+valor+";"+activo;
            FileWriter archivo = new FileWriter("historial.txt", true);
            PrintWriter escribir = new PrintWriter(archivo);
            escribir.println(linea);
            archivo.close();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void GuardarPromedio(String nombre,String ubicacion,int codigo,int valor,String activo)
    {
        try {            
            String linea = nombre+";"+ubicacion+";"+codigo+";"+valor+";"+activo;
            FileWriter archivo = new FileWriter("promedio.txt", true);
            PrintWriter escribir = new PrintWriter(archivo);
            escribir.println(linea);
            archivo.close();            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ObtenerDatosPromedio() {
        try {
            FileReader archivo = new FileReader("promedio.txt");
            BufferedReader br = new BufferedReader(archivo);
            String info;
            String[] palabras;
            while ((info = br.readLine()) != null) {
                palabras = info.split(";");
                int val = Integer.parseInt(palabras[3]);
                int codig = Integer.parseInt(palabras[2]);
                Historial nuevo = new Historial(palabras[0], palabras[1],codig,val,"" );
                Historial.promedios.add(nuevo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
