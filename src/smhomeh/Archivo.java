/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhomeh;

import java.io.BufferedReader;
import java.io.FileReader;

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
                
            }
        } catch (Exception e) {
        }
    }
}
