/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhomeh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author gabriel
 */
public class CargarArchivoHabitacion extends JFrame implements ActionListener{

    private JLabel jLabel1;    
    private JLabel jLabel2;    
    private JLabel jLabel3;

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    
    private JTextField jRuta;
    
    
    public CargarArchivoHabitacion() {
        
        setLayout(null);
        
        jRuta=new JTextField();
        jRuta.setBounds(120, 100, 200, 20);
        add(jRuta);
        
        jLabel1=new JLabel("Cargar Archivo");
        jLabel1.setBounds(20, 100, 150, 20);
        add(jLabel1);
        
        jLabel2=new JLabel("AGREGAR HABITACION POR ARCHIVO");
        jLabel2.setBounds(130, 30, 250, 20);
        add(jLabel2);
        
        jLabel3=new JLabel();
        jLabel3.setBounds(80, 150, 150, 20);
        add(jLabel3);
        
        jButton1=new JButton("Examinar");
        jButton1.addActionListener(this);
        jButton1.setBounds(340, 95, 130, 30);
        add(jButton1);
        
        jButton2=new JButton("Subir");
        jButton2.setBounds(80, 250, 130, 30);
        jButton2.addActionListener(this);
        add(jButton2);
        
        jButton3=new JButton("Cancelar");
        jButton3.setBounds(250, 250, 130, 30);
        jButton3.addActionListener(this);
        add(jButton3);
        
        
        
        
        
        setBounds(0, 0, 500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jButton1) {
            JFileChooser examinar = new JFileChooser();
            int ruta = examinar.showOpenDialog(this);
            if (ruta == JFileChooser.APPROVE_OPTION) {
                jRuta.setText(examinar.getSelectedFile().getPath());
            }
        }
        if (e.getSource()==jButton2) {
            try {
                FileReader archivo = new FileReader(jRuta.getText());
                BufferedReader br = new BufferedReader(archivo);
                String info;
                String[] palabras;
                while ((info = br.readLine()) != null) {
                    palabras = info.split(";");
                    int area = Integer.parseInt(palabras[2]);
                    Habitacion.AgregarHabitacion(palabras[0], palabras[1], area);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            jLabel3.setText("Archivo cargado");
        }
        if (e.getSource()==jButton3) {
            this.setVisible(false);
        }
    }
    
}
