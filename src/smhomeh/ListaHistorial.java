/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhomeh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabriel
 */
public class ListaHistorial extends JFrame implements ActionListener{

    private JScrollPane jScrollPane;
    
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    
    private JTable jTable1;
    
    private JComboBox jCodigo;
    private JComboBox jHab;
    private JComboBox jTipo;
    
    private ButtonGroup buttonGroup1;
    
    private JRadioButton jListaHabit;
    private JRadioButton jListarSensor;
    private JRadioButton jListarTipo;
    private JRadioButton jListarTodo;
    
    
    
    
    
    
    public ListaHistorial() {
        setLayout(null);
        
        buttonGroup1=new ButtonGroup();
        
        jLabel1=new JLabel("habitacion:");
        jLabel1.setBounds(500, 520, 150, 20);
        add(jLabel1);
        
        jLabel2=new JLabel("tipo:");
        jLabel2.setBounds(120, 520, 150, 20);
        add(jLabel2);
        
        jLabel3=new JLabel("HISTORIAL:");
        jLabel3.setBounds(700, 20, 150, 20);
        add(jLabel3);
        
        jLabel4=new JLabel("opciones");
        jLabel4.setBounds(1100, 520, 150, 20);
        add(jLabel4);
        
        jLabel5=new JLabel("codigo:");
        jLabel5.setBounds(320, 650, 150, 20);
        add(jLabel5);
        
        jCodigo=new JComboBox();
        jCodigo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               
            }
        });
        jCodigo.setBounds(310, 680, 100, 20);
        add(jCodigo);
        
        jHab=new JComboBox();
        jHab.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String hab;
                hab = jHab.getSelectedItem().toString();
                for (int i = 0; i < Sensor.sensores.size(); i++) {
                    Sensor sen = (Sensor) Sensor.sensores.get(i);
                    if (hab.equals(sen.getUbicacion())) {
                        jTipo.addItem(sen.getTipo());
                    }
                }
            }
        });
        jHab.setBounds(480, 550, 150, 20);
        add(jHab);
        
        jTipo=new JComboBox();
        jTipo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String hab, tip;
                hab = jHab.getSelectedItem().toString();
                tip = jTipo.getSelectedItem().toString();
                for (int i = 0; i < Sensor.sensores.size(); i++) {
                    Sensor sen = (Sensor) Sensor.sensores.get(i);
                    if (hab.equals(sen.getUbicacion()) && tip.equals(sen.getTipo())) {
                        jCodigo.addItem(sen.getCodigo());
                    }
                }
            }
        });
        jTipo.setBounds(65, 550, 370, 20);
        add(jTipo);
        
        jScrollPane=new JScrollPane();
        jTable1=new JTable();
        jScrollPane.setBounds(30, 60, 1430, 440);
        jTable1.setModel(new DefaultTableModel(new Object[][]{}, new String[]{}));
        jScrollPane.setViewportView(jTable1);
        add(jScrollPane);
        
        jListarTodo=new JRadioButton("listar todo el historial sin promedio");
        jListarTodo.setBounds(880, 550, 250, 20);
        buttonGroup1.add(jListarTodo);
        jListarTodo.setSelected(true);
        jListarTodo.addActionListener(this);
        add(jListarTodo);
        
        jListarSensor=new JRadioButton("listar promedio de cada sensor por habitacion");
        jListarSensor.setBounds(880, 590, 300, 20);
        buttonGroup1.add(jListarSensor);
        jListarSensor.addActionListener(this);
        add(jListarSensor);
        
        jListarTipo=new JRadioButton("listar promeio d cada tipo por habitacion");
        jListarTipo.setBounds(880, 630, 300, 20);
        buttonGroup1.add(jListarTipo);
        jListarTipo.addActionListener(this);
        add(jListarTipo);
        
        jListaHabit=new JRadioButton("listar promedio de las habitacion");
        jListaHabit.setBounds(880, 660, 250, 20);
        buttonGroup1.add(jListaHabit);
        jListaHabit.addActionListener(this);
        add(jListaHabit);
        
        
        
        
        LlenarTabla();
        for (int i = 0; i < Habitacion.habitaciones.size(); i++) {
            Habitacion nuevo = (Habitacion) Habitacion.habitaciones.get(i);
            jHab.addItem(nuevo.getNombreHabitacion());
            Historial.Promedio();
        }
        
        setBounds(0, 0, 1500, 800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }   
    
    private void LlenarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo);
        modelo.addColumn("codigo del sensor");
        modelo.addColumn("Nombre de la alarma");
        modelo.addColumn("Ubicacion");
        modelo.addColumn("Valor");
        modelo.addColumn("Activado");
        Object[] object = new Object[8];
        int n = Historial.historiales.size();
        for (int i = 0; i < n; i++) {
            Historial s = (Historial) Historial.historiales.get(i);
            object[1] = s.getNombre();
            object[2] = s.getUbicacion();
            object[0] = s.getCodigo();
            object[3] = s.getValor();
            object[4] = s.getAct();
            modelo.addRow(object);
        }
    }
    
    private void LlenarTabla(int cod){
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo);
        modelo.addColumn("codigo del sensor");
        modelo.addColumn("Nombre de la alarma");
        modelo.addColumn("Ubicacion");
        modelo.addColumn("promedio");
        Object[] object = new Object[8];
        int n = Historial.promedios.size();
        int i = 0;
        boolean sw = false;
        while (i < n && sw == false) {
            Historial prom = (Historial) Historial.promedios.get(i);
            if (prom.getCodigo() == cod) {
                object[0] = prom.getCodigo();
                object[1] = prom.getNombre();
                object[2] = prom.getUbicacion();
                object[3] = prom.getValor();
                modelo.addRow(object);
                sw = true;
            }
            i++;
        }
    }
    
    private void LlenarTabla(String habitacion){
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo);
        modelo.addColumn("codigo del sensor");
        modelo.addColumn("Nombre de la alarma");
        modelo.addColumn("Ubicacion");
        modelo.addColumn("promedio");
        Object[] object = new Object[8];
        int n = Historial.promedios.size();
        for (int i = 0; i < n; i++) {
            Historial prom = (Historial) Historial.promedios.get(i);
            if (prom.getUbicacion().equals(habitacion)) {
                object[0] = prom.getCodigo();
                object[1] = prom.getNombre();
                object[2] = prom.getUbicacion();
                object[3] = prom.getValor();
                modelo.addRow(object);
            }
        }
    }
    
    private void LlenarTabla(String tipo, String habitacion){
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo);
        modelo.addColumn("codigo del sensor");
        modelo.addColumn("Nombre de la alarma");
        modelo.addColumn("Ubicacion");
        modelo.addColumn("promedio");
        Object[] object = new Object[8];
        int n = Historial.promedios.size();
        for (int i = 0; i < n; i++) {
            Historial prom = (Historial) Historial.promedios.get(i);
            if (prom.getNombre().equals(tipo) && prom.getUbicacion().equals(habitacion)) {
                object[0] = prom.getCodigo();
                object[1] = prom.getNombre();
                object[2] = prom.getUbicacion();
                object[3] = prom.getValor();
                modelo.addRow(object);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jListarTodo) {
            LlenarTabla();
        }
        if (e.getSource()==jListaHabit) {
            String hab;
            hab = jHab.getSelectedItem().toString();
            LlenarTabla(hab);
        }
        if (e.getSource()==jListarSensor) {
            int cod;
            cod = (int) jCodigo.getSelectedItem();
            LlenarTabla(cod);
        }
        if (e.getSource()==jListarTipo) {
            String hab, tip;
            hab = jHab.getSelectedItem().toString();
            tip = jTipo.getSelectedItem().toString();
            LlenarTabla(tip, hab);
        }
    }
    
}
