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
public class Generar extends JFrame implements ActionListener{
    
    public int n=Sensor.sensores.size();

    private JLabel jLabel1;
    
    private JButton jButton1;
    
    private JTable jTable1;
    private JScrollPane jScrollPane;
    
    public Generar() {
        setLayout(null);
        
        jLabel1=new JLabel("SIMULACION");
        jLabel1.setBounds(380, 20, 120, 20);
        add(jLabel1);
        
        jButton1=new JButton("EJECUTAR");
        jButton1.addActionListener(this);
        jButton1.setBounds(350, 390, 100, 30);
        add(jButton1);
        
        jScrollPane=new JScrollPane();
        
        jTable1=new JTable();
        jTable1.setModel(new DefaultTableModel(new Object[][]{}, new String[]{}));
        jScrollPane.setViewportView(jTable1);
        jScrollPane.setBounds(50, 50, 700, 300);
        add(jScrollPane);
        
        
        
        LlenarTabla();
        setBounds(0, 0, 800, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Historial.GenerarDemo();
    }
    
    private void LlenarTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo);
        modelo.addColumn("codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Ubicacion");
        modelo.addColumn("rangomin");
        modelo.addColumn("rangomax");
        modelo.addColumn("frecuencia de lectura");
        Object[] object = new Object[8];
        for (int i = 0; i < n; i++) {
            Sensor his = (Sensor) Sensor.sensores.get(i);
            object[0] = his.getCodigo();
            object[1] = his.getTipo();
            object[2] = his.getUbicacion();
            object[3] = his.getRangoMin();
            object[4] = his.getRangoMax();
            object[5] = his.getFrecuenAct();
            modelo.addRow(object);
        }
        JOptionPane.showMessageDialog(null, "estos son los sensores que se van a simular");
    }
}
