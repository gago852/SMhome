/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhomeh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabriel
 */
public class ListaUsuario extends JFrame implements ActionListener{

    private JButton jButton1;
    
    private JLabel jLabel1;
    
    private JTable jUsuarios;
    
    private JScrollPane jScrollPane;
    
    private Archivo base;
    private Usuario users;
    
    public ListaUsuario() {
        setLayout(null);
        
        jButton1=new JButton("Borrar");
        jButton1.addActionListener(this);
        jButton1.setBounds(20, 310, 100, 30);
        add(jButton1);
        
        jScrollPane=new JScrollPane();
        
        jUsuarios=new JTable();
        jScrollPane.setBounds(60, 60, 380, 220);
        jUsuarios.setModel(new DefaultTableModel(new Object[][]{}, new String[]{}));
        jScrollPane.setViewportView(jUsuarios);
        add(jScrollPane);
        
        jLabel1=new JLabel("Lista de usuarios");
        jLabel1.setBounds(200, 20, 120, 30);
        add(jLabel1);
        
        base=new Archivo();
        users=new Usuario();
        
        LlenarTabla();
        setBounds(0, 0, 500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (Admin.sesion.equals("admin")) {
                int pos = jUsuarios.getSelectedRow();
                if (JOptionPane.showConfirmDialog(rootPane, "Realmente desea eliminar", "Borrar", JOptionPane.YES_NO_OPTION) == 0) {
                    if (users.BorrarUsuario(pos)) {
                        JOptionPane.showMessageDialog(null, "Eliminado");
                        LlenarTabla();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminado");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "debes iniciar session como administrador");
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "debes iniciar session");
        }
    }
    
    private void LlenarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        jUsuarios.setModel(modelo);
        modelo.addColumn("Nombre");
        modelo.addColumn("Rol");
        Object[] object = new Object[8];
        int n = Usuario.usuarios.size();
        for (int i = 0; i < n; i++) {
            Usuario user = (Usuario) Usuario.usuarios.get(i);
            object[0] = user.getNombre();
            object[1] = user.getRol();
            modelo.addRow(object);
        }
    }
}
