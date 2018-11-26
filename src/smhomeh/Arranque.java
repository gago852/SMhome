/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhomeh;

/**
 *
 * @author gabriel
 */
public class Arranque {
    public static void main(String[] args) {
        Inicio abrir=new Inicio();
        Archivo open=new Archivo();
        open.ObtenerDatosUsuario();
        open.ObtenerDatosHab();
        open.ObtenerDatosSensores();
        open.ObtenerDatosHistorial();
        open.ObtenerDatoAlarma();
        open.ObtenerDatosPromedio();
        abrir.setVisible(true);
    }
}
