/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhomeh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author gabriel
 */
public class AgregarUsuario extends JFrame implements ActionListener{
    
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    
    private JButton jButton1;
    
    private JComboBox jRol;
    
    private JTextField jNombre;
    private JTextField jId;
    
    private Archivo ejecutar;

    public AgregarUsuario() {
        setLayout(null);
        
        jLabel1=new JLabel("AGREGAR USUARIOS");
        jLabel1.setBounds(200, 20, 120, 30);
        add(jLabel1);
        
        jLabel2=new JLabel("Nombre:");
        jLabel2.setBounds(50, 100, 120, 30);
        add(jLabel2);
        
        jLabel3=new JLabel("Identificacion:");
        jLabel3.setBounds(50, 140, 120, 30);
        add(jLabel3);
        
        jLabel4=new JLabel("Rol:");
        jLabel4.setBounds(50, 180, 120, 30);
        add(jLabel4);
        
        jButton1=new JButton("Agregar");
        jButton1.setBounds(200, 250, 130, 30);
        jButton1.addActionListener(this);
        add(jButton1);
        
        jRol=new JComboBox();
        jRol.setModel(new DefaultComboBoxModel(new String[]{"Admin","User"}));
        jRol.setBounds(100, 180, 150, 20);
        add(jRol);
        
        jNombre=new JTextField();
        jNombre.setBounds(130, 100, 150, 20);
        add(jNombre);
        
        jId=new JTextField();
        jId.setBounds(150, 140, 150, 20);
        add(jId);
        
        ejecutar=new Archivo();
        setBounds(0, 0, 500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Usuario add = new Usuario();
        try {
            int id = Integer.parseInt(jId.getText());
            String rol = (String) jRol.getSelectedItem();
            if (add.AgregarUsuario(jNombre.getText(), id, rol)) {
                JOptionPane.showMessageDialog(null, "Agregado!");
                this.setVisible(false);
            }
        } catch (NumberFormatException ex) {
            jId.setText(null);
            JOptionPane.showMessageDialog(null, "en Identificación debe ingresar solo numeros");
        }
    }
    
    
}
