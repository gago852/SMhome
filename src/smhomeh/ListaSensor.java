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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabriel
 */
public class ListaSensor extends JFrame{
    
    private JLabel jLabel;
    
    private JScrollPane jScrollPane;
    
    private JTable jTable;

    public ListaSensor() {
        setLayout(null);
        
        jScrollPane=new JScrollPane();
        
        jTable=new JTable();
        jScrollPane.setBounds(60, 60, 380, 220);
        jTable.setModel(new DefaultTableModel(new Object[][]{}, new String[]{}));
        jScrollPane.setViewportView(jTable);
        add(jScrollPane);
        
        jLabel=new JLabel("LISTA SENSORES");
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
        modelo.addColumn("Codigo");
        modelo.addColumn("Ubicacion");
        modelo.addColumn("Tipo");
        modelo.addColumn("Fecha");
        modelo.addColumn("rango minimo");
        modelo.addColumn("rango maximo");
        modelo.addColumn("frecuencia de actualizacion");
        Object[] object = new Object[8];
        int n = Sensor.sensores.size();
        for (int i = 0; i < n; i++) {
            Sensor s = (Sensor) Sensor.sensores.get(i);
            object[0] = s.getCodigo();
            object[1] = s.getUbicacion();
            object[2] = s.getTipo();
            object[3] = s.getFecha();
            object[4] = s.getRangoMin();
            object[5] = s.getRangoMax();
            object[6] = s.getFrecuenAct();
            modelo.addRow(object);
        }
    }
    
}
