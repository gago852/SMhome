/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhomeh;

import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Habitacion {
    private Usuario usuario;
    private Archivo bases;
    private String nombreHabitacion;
    private String ubicacion;
    private int area;
    private int idHabitacion;
    public static ArrayList habitaciones =new ArrayList();

    public Habitacion(String nombreHabitacion, String ubicacion, int area) {
        this.nombreHabitacion = nombreHabitacion;
        this.ubicacion = ubicacion;
        this.area = area;
        bases=new Archivo();
    }
    
    public Habitacion(){
        
    }
    
    public static boolean AgregarHabitacion(String nombre, String ubicacion, int area){
        Habitacion nuevo=new Habitacion(nombre, ubicacion, area);
        //incompleto
        return true;
    }
    
    public boolean BorrarHabitacion(int pos){
        Habitacion info= (Habitacion) habitaciones.get(pos);
        //incompleto
        if (true) {
            return true;
        }else{
            return false;
        }
    }

    public String getNombreHabitacion() {
        return nombreHabitacion;
    }

    public void setNombreHabitacion(String nombreHabitacion) {
        this.nombreHabitacion = nombreHabitacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public static ArrayList getHabitaciones() {
        return habitaciones;
    }

    public static void setHabitaciones(ArrayList habitaciones) {
        Habitacion.habitaciones = habitaciones;
    }
    
    
}
