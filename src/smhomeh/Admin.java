/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhomeh;

import javax.swing.JOptionPane;

/**
 *
 * @author gabriel
 */
public class Admin {
    public static String sesion;
    public static void comprobarSesion(String usuario, int id){
        int n,i=0;
        boolean sw=false;
        n=Usuario.usuarios.size();
        while(i<n&&sw==false){
            Usuario us=(Usuario) Usuario.usuarios.get(i);
            if (us.getNombre().equals(usuario)&&us.getId()==id) {
                if (us.getRol().equals("Admin")) {
                    sw=true;
                    Admin.sesion="admin";
                    JOptionPane.showMessageDialog(null, "has iniciado como administrador");
                }else{
                    sw=true;
                    Admin.sesion="usuario";
                    JOptionPane.showMessageDialog(null, "has iniciado como usuario");
                }
            }else{
                i++;
            }
        }
        if (sw==false) {
            JOptionPane.showMessageDialog(null, "nombre de usuario o contraseña incorrectos");
        }
    }
}
