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
public class Alarma {
    private String nombre;
    private String tipo;
    private String activacion;
    private Archivo bases;
    public static ArrayList alarmas=new ArrayList();

    public Alarma(String nombre, String tipo, String activacion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.activacion = activacion;
        bases=new Archivo();
    }
    
    public static void AgregarAlarma(String tipo, String activacion, String nombre){
        Alarma nuevo=new Alarma(nombre, tipo, activacion);
        nuevo.bases.GuardarAlarmas(nombre, tipo, activacion);
        alarmas.add(nuevo);
    }
    
    public boolean ActivacionAlarma(String tipo,int valor){
        int i=0,act=0,j=0,tam,n=Alarma.alarmas.size();
        String activa,comp="",tipsen="";
        String[] acti;
        boolean sw=false,sw2=false;
        while(sw2==false&&(i<n)){
            Alarma activacio=(Alarma) Alarma.alarmas.get(i);
            tipsen=activacio.getTipo();
            if (tipo.equals(tipsen)) {
                sw2=true;
            }else{
                i++;
            }
        }
        if (sw2==true) {
            Alarma activacio=(Alarma) Alarma.alarmas.get(i);
            activa=activacio.getActivacion();
            acti=activa.split(":");
            try {
                act=Integer.parseInt(acti[0]);
            } catch (NumberFormatException e) {
                act=5;
            }
            comp=acti[1];
            if (comp.equals("mayor")) {
                if (valor>act) {
                    return true;
                }else{
                    return false;
                }
            }else{
                if (valor<act) {
                    return true;
                }else{
                    return false;
                }
            }
        }else{
            return false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getActivacion() {
        return activacion;
    }

    public void setActivacion(String activacion) {
        this.activacion = activacion;
    }

    public static ArrayList getAlarmas() {
        return alarmas;
    }

    public static void setAlarmas(ArrayList alarmas) {
        Alarma.alarmas = alarmas;
    }
    
    
}
