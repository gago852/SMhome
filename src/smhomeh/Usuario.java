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
public class Usuario {
    
    private String nombre;
    private int id;
    private String rol;
    public static ArrayList usuarios=new ArrayList();
    public static ArrayList habitacionesUsadas=new ArrayList();
    public static ArrayList habitacionesAdmin=new ArrayList();
    private Archivo bases;

    public Usuario(String nombre, int id, String rol) {
        this.nombre = nombre;
        this.id = id;
        this.rol = rol;
        bases=new Archivo();
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public boolean AgregarUsuario(String nombre, int id, String rol){
        Usuario nuevo=new Usuario(nombre, id, rol);
        //incompleto
        return true;
    }
    
    public boolean BorrarUsuario(int pos){
        Usuario info= (Usuario) usuarios.get(pos);
        int idUser=info.getId();
        //incompleto
        if (true) {
            return true;
        }else{
            return false;
        }
    }    
}
