/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhomeh;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class Historial {
    public static ArrayList historiales=new ArrayList();
    public static ArrayList promedios=new ArrayList();
    private Archivo bases;
    private String nombre;
    private int codigo;
    private String ubicacion;
    private int valor;
    private String act;

    public Historial(String nombre,String ubicacion , int codigo, int valor, String act) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.valor = valor;
        this.act = act;
        bases=new Archivo();
    }
    
    public static void Promedio(){
        String ubi="",nomb="";
        int cod=0,sum=0,cont=0,val,n=Historial.historiales.size(),j;
        for (int i = 0; i < Sensor.sensores.size(); i++) {
            Sensor sen=(Sensor) Sensor.sensores.get(i);
            for (j = 0; j < Historial.historiales.size(); j++) {
                Historial his=(Historial) Historial.historiales.get(j);
                if (sen.getCodigo()==his.getCodigo()) {
                    val=his.getValor();
                    sum=sum+val;
                    cont=cont+1;
                }
            }
            ubi=sen.getUbicacion();
            nomb=sen.getTipo();
            cod=sen.getCodigo();
            AgregarPromedio(nomb, ubi, cod, sum/cont, "");
            j=0;
        }
    }
    
    public static void GenerarDemo(){
        String tip,activa,nombr,ubicacio;
        int ranggoMax,ranggoMin,frecAct,val,codig;
        boolean acti;
        
        Generar gen=new Generar();
        Random randon=new Random();
        for (int i = 0; i < gen.n; i++) {
            int r=0;
            Sensor his=(Sensor) Sensor.sensores.get(i);
            boolean sw=false;
            nombr=his.getTipo();
            ubicacio=his.getUbicacion();
            codig=his.getCodigo();
            frecAct=his.getFrecuenAct();
            int p=Alarma.alarmas.size();
            while(r<p&&sw==false){
                Alarma activacion=(Alarma) Alarma.alarmas.get(r);
                tip=activacion.getTipo();
                if (nombr.equals(tip)) {
                    sw=true;
                }else{
                    r++;
                }
            }
            if (sw) {
                Alarma activacion=(Alarma) Alarma.alarmas.get(r);
                ranggoMax=his.getRangoMax();
                ranggoMin=his.getRangoMin();
                for (int j = 0; j < 1440; j=j+frecAct) {
                    val=(int)(randon.nextDouble()*ranggoMax+ranggoMin);
                    acti=activacion.ActivacionAlarma(nombr, val);
                    if (acti) {
                        activa="si";
                    }else{
                        activa="no";
                    }
                    Historial.AgregarHistorial(nombr, ubicacio, codig, val, activa);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "simulacion terminada");
    }
    
    public static void AgregarHistorial(String tipo,String ubicacion,int codigo,int valor,String activo){
        Historial his=new Historial(tipo, ubicacion, codigo, valor, activo);
        his.bases.GuardarHistorial(tipo, ubicacion, codigo, valor, activo);
        historiales.add(his);
    }
    
    public static void AgregarPromedio(String tipo,String ubicacion,int codigo,int valor,String activo){
        Historial his=new Historial(tipo, ubicacion, codigo, valor, activo);
        his.bases.GuardarPromedio(tipo, ubicacion, codigo, valor, activo);
        promedios.add(his);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }
    
    
}
