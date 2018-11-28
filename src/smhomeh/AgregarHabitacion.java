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
import javax.swing.JTextField;

/**
 *
 * @author gabriel
 */
public class AgregarHabitacion extends JFrame implements ActionListener{

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    
    private JTextField jNombre;
    private JTextField jUbicacion;
    private JTextField jArea;
    
    private JButton jButton1;
    
    public AgregarHabitacion() {
        setLayout(null);
        
        jLabel1=new JLabel("AGREGAR HABITACION");
        jLabel1.setBounds(200, 20, 200, 30);
        add(jLabel1);
        
        jLabel2=new JLabel("Nombre:");
        jLabel2.setBounds(50, 100, 120, 30);
        add(jLabel2);
        
        jLabel3=new JLabel("Area:");
        jLabel3.setBounds(50, 140, 120, 30);
        add(jLabel3);
        
        jLabel4=new JLabel("Ubicacion:");
        jLabel4.setBounds(50, 180, 120, 30);
        add(jLabel4);
        
        jNombre=new JTextField();
        jNombre.setBounds(130, 100, 150, 20);
        add(jNombre);
        
        jArea=new JTextField();
        jArea.setBounds(130, 140, 150, 20);
        add(jArea);
        
        jUbicacion=new JTextField();
        jUbicacion.setBounds(130, 180, 150, 20);
        add(jUbicacion);
        
        jButton1=new JButton("Agregar");
        jButton1.setBounds(200, 250, 130, 30);
        jButton1.addActionListener(this);
        add(jButton1);
        
        setBounds(0, 0, 500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int area = Integer.parseInt(jArea.getText());
            if (Habitacion.AgregarHabitacion(jNombre.getText(), jUbicacion.getText(), area)) {
                JOptionPane.showMessageDialog(null, "Agregado!");
                this.setVisible(false);
            }
        } catch (NumberFormatException ex) {
            jArea.setText(null);
            JOptionPane.showMessageDialog(null, "en Area solo debe ingresar numeros");
        }
    }
    
    
    
    
}
