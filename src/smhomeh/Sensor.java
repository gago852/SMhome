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
public class Sensor {
    private String tipo;
    private int codigo;
    private String ubicacion;
    private String fecha;
    private Archivo bases;
    private int rangoMin;
    private int rangoMax;
    private int frecuenAct;
    public static ArrayList sensores=new ArrayList();

    public Sensor(String tipo, int codigo, String ubicacion, String fecha, int rangoMin, int rangoMax, int frecuenAct) {
        this.tipo = tipo;
        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.rangoMin = rangoMin;
        this.rangoMax = rangoMax;
        this.frecuenAct = frecuenAct;
        bases=new Archivo();
    }
    
    public static void AgregarSensor(String tipo, int codigo, String ubicaicion, String fecha, int rangoMin, int rangoMax, int frecuenAct){
        Sensor nuevo=new Sensor(tipo, codigo, ubicaicion, fecha, rangoMin, rangoMax, frecuenAct);
        nuevo.bases.GuardarSensores(codigo, ubicaicion, tipo, fecha, rangoMax, rangoMin, frecuenAct);
        sensores.add(nuevo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getRangoMin() {
        return rangoMin;
    }

    public void setRangoMin(int rangoMin) {
        this.rangoMin = rangoMin;
    }

    public int getRangoMax() {
        return rangoMax;
    }

    public void setRangoMax(int rangoMax) {
        this.rangoMax = rangoMax;
    }

    public int getFrecuenAct() {
        return frecuenAct;
    }

    public void setFrecuenAct(int frecuenAct) {
        this.frecuenAct = frecuenAct;
    }
    
    
    
    
}
