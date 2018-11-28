/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhomeh;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabriel
 */
public class ListaHabitacion extends JFrame{
    
    private JLabel jLabel;
    
    private JScrollPane jScrollPane;
    
    private JTable jTable;

    public ListaHabitacion() {
        setLayout(null);
        
        jScrollPane=new JScrollPane();
        
        jTable=new JTable();
        jScrollPane.setBounds(60, 60, 380, 220);
        jTable.setModel(new DefaultTableModel(new Object[][]{}, new String[]{}));
        jScrollPane.setViewportView(jTable);
        add(jScrollPane);
        
        jLabel=new JLabel("LISTA DE HABITACIONES");
        jLabel.setBounds(200, 20, 120, 30);
        add(jLabel);
        
        
        LlenarTabla();
        setBounds(0, 0, 500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void LlenarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        jTable.setModel(modelo);
        modelo.addColumn("Nombre");
        modelo.addColumn("Ubicacion");
        modelo.addColumn("Area");
        Object[] object = new Object[8];
        int n = Habitacion.habitaciones.size();
        for (int i = 0; i < n; i++) {
            Habitacion hab = (Habitacion) Habitacion.habitaciones.get(i);
            object[0] = hab.getNombreHabitacion();
            object[1] = hab.getUbicacion();
            object[2] = hab.getArea();
            modelo.addRow(object);
        }
    }
    
    
}
