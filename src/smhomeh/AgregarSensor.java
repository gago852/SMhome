/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhomeh;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author gabriel
 */
public class AgregarSensor extends JFrame implements ActionListener{

    private JLabel jLabel1;
    
    private JButton jButton1;
    private JButton jButton2;
    
    private JTextField jRuta;
    
    
    private Archivo base=new Archivo();
    
    public AgregarSensor() {
        
        setLayout(null);
        
        jRuta=new JTextField();
        jRuta.setBounds(120, 100, 200, 20);
        add(jRuta);
        
        jLabel1=new JLabel("Cargar Archivo");
        jLabel1.setBounds(20, 100, 150, 20);
        add(jLabel1);
        
        jButton1=new JButton("Examinar");
        jButton1.addActionListener(this);
        jButton1.setBounds(340, 95, 130, 30);
        add(jButton1);
        
        jButton2=new JButton("Subir");
        jButton2.setBounds(80, 250, 130, 30);
        jButton2.addActionListener(this);
        add(jButton2);
        
        
        
        
        
        
        
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
                Random randon = new Random();
                File s_file = new File(jRuta.getText());
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dB = factory.newDocumentBuilder();
                Document doc = dB.parse(s_file);
                doc.getDocumentElement().normalize();
                NodeList sensores = doc.getElementsByTagName("Sensor");
                for (int i = 0; i < sensores.getLength(); i++) {
                    int ranmax = 0;
                    int ranmin = 2;
                    Node n_sensor = sensores.item(i);
                    if (n_sensor.getNodeType() == Node.ELEMENT_NODE) {
                        Element ele = (Element) n_sensor;
                        int Id = Integer.parseInt(ele.getAttribute("id"));
                        String ubicacion = ele.getElementsByTagName("Ubicacion").item(0).getTextContent();
                        String tipo = ele.getElementsByTagName("Tipo").item(0).getTextContent();
                        String fecha = ele.getElementsByTagName("Fecha").item(0).getTextContent();
                        while (ranmax < ranmin) {
                            ranmax = (int) (randon.nextDouble() * 3000);
                            ranmin = (int) (randon.nextDouble() * 50);
                        }
                        Sensor.AgregarSensor(tipo, Id, ubicacion, fecha, ranmin, ranmax, (int) (randon.nextDouble() * 60 + 1));
                    }
                }
                doc.getDocumentElement().normalize();
                NodeList eventos = doc.getElementsByTagName("Evento");
                for (int i = 0; i < eventos.getLength(); i++) {

                    Node n_evento = eventos.item(i);
                    if (n_evento.getNodeType() == Node.ELEMENT_NODE) {
                        Element ele = (Element) n_evento;
                        String nombre = ele.getAttribute("nombre");
                        String tipo = ele.getElementsByTagName("Tipo-Sensor").item(0).getTextContent();
                        String valor = ele.getElementsByTagName("Valor").item(0).getTextContent();

                        Alarma.AgregarAlarma(tipo, valor, nombre);
                    }
                }
                JOptionPane.showMessageDialog(null, "Guardado!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
}
