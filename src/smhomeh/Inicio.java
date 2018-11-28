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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

/**
 *
 * @author gabriel
 */
public class Inicio extends JFrame implements ActionListener{
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    
    private JButton jButton1;
    private JButton jButton2;
    
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenu jMenu4;
    private JMenu jMenu5;
    
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JMenuItem jMenuItem4;
    private JMenuItem jMenuItem5;
    private JMenuItem jMenuItem6;
    private JMenuItem jMenuItem7;
    private JMenuItem jMenuItem8;
    private JMenuItem jMenuItem9;
    
    private JMenuBar jMenuBar1;
    
    
    
    private JTextField jId;    
    private JTextField jUser;

    public Inicio(){
        setLayout(null);
        
        jLabel1=new JLabel("INICIO DE SESION");
        jLabel1.setBounds(200, 50, 150, 20);
        add(jLabel1);
        
        jLabel2=new JLabel("USUARIO:");
        jLabel2.setBounds(100, 100, 150, 20);
        add(jLabel2);
        
        jLabel3=new JLabel("IDENTIFICACION:");
        jLabel3.setBounds(80, 150, 150, 20);
        add(jLabel3);
        
        jId=new JTextField();
        jId.setBounds(200, 150, 150, 20);
        add(jId);        
        
        jUser=new JTextField(); 
        jUser.setBounds(200, 100, 150, 20);
        add(jUser);
        
        jMenuItem1=new JMenuItem("Listar Usuarios");//menu1 jradio1
        
        jMenuItem2=new JMenuItem("Agregar");//menu1 jmenu2
        
        jMenuItem3=new JMenuItem("Agregar");//menu2 jmenu3
        
        jMenuItem4=new JMenuItem("Listar Habitaciones");//menu2 jmenu1
        
        jMenuItem5=new JMenuItem("Agregar Sensores");//menu3 jmenu4
        
        jMenuItem6=new JMenuItem("Listar Sensores");//menu3 jmenu5
        
        jMenuItem7=new JMenuItem("Generar Dia");//menu4 jmenu8
        
        jMenuItem8=new JMenuItem("Listar Historial");//menu5 jmenu9
        
        jMenuItem9=new JMenuItem("Cargar Archivo");//menu2 jmenu6         
        
        jButton1=new JButton("INGRESAR");
        jButton1.addActionListener(this);
        jButton1.setBounds(80, 200, 130, 30);
        add(jButton1);
        
        jButton2=new JButton("CERRAR SESION");
        jButton2.setBounds(280, 200, 130, 30);
        jButton2.addActionListener(this);
        add(jButton2);
        
        jMenu1=new JMenu("Usuarios");
        
        jMenu2=new JMenu("Habitaciones");
        
        jMenu3=new JMenu("Sensores");
        
        jMenu4=new JMenu("Generar Simulacion");
       
        jMenu5=new JMenu("Historial");
        
        jMenuBar1=new JMenuBar();
        
        
        jMenuItem1.addActionListener(this);
        jMenu1.add(jMenuItem1);
        
        
        jMenuItem2.addActionListener(this);
        jMenu1.add(jMenuItem2);
        
        jMenuItem3.addActionListener(this);
        jMenu2.add(jMenuItem3);
        
        jMenuItem4.addActionListener(this);
        jMenu2.add(jMenuItem3);
        
        jMenuItem5.addActionListener(this);
        jMenu3.add(jMenuItem5);
        
        jMenuItem6.addActionListener(this);
        jMenu3.add(jMenuItem6);
        
        jMenuItem7.addActionListener(this);
        jMenu4.add(jMenuItem7);
        
        jMenuItem8.addActionListener(this);
        jMenu5.add(jMenuItem8);
        
        jMenuItem9.addActionListener(this);  
        jMenu2.add(jMenuItem9);        
        
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);
        jMenuBar1.add(jMenu3);
        jMenuBar1.add(jMenu4);
        jMenuBar1.add(jMenu5);
        
         setJMenuBar(jMenuBar1);
        
        
        setBounds(0, 0, 500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jButton1) {
            try {
                String user = jUser.getText();
                int id = Integer.parseInt(jId.getText());
                Admin.comprobarSesion(user, id);
                jId.setText(null);
            } catch (Exception ex) {
                jId.setText(null);
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "en Identificación debe ingresar solo numeros");
            }
        }
        if (e.getSource()==jButton2) {
            Admin.sesion = null;
            jUser.setText(null);
            jId.setText(null);
            JOptionPane.showMessageDialog(null, "has cerrado session");
        }
        if (e.getSource()==jMenuItem1) {
            try {
                if (Admin.sesion.equals("admin") || Admin.sesion.equals("usuario")) {
                    int n = Usuario.usuarios.size();
                    if (n != 0) {
                        ListaUsuario abrir = new ListaUsuario();
                        abrir.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe registrar por lo menos un usuario");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "debes iniciar session");
            }
        }
        if (e.getSource() == jMenuItem2) {
            try {
                if (Admin.sesion.equals("admin")) {
                    AgregarUsuario add = new AgregarUsuario();
                    add.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "debes iniciar session como administrador");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "debes iniciar session");
            }
        }
        if (e.getSource()==jMenuItem3) {
            try {
                if (Admin.sesion.equals("admin")) {
                    AgregarHabitacion open = new AgregarHabitacion();
                    open.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "debes iniciar session como administrador");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "debes iniciar session");
            }
        }
        if (e.getSource()==jMenuItem4) {
            try {
                if (Admin.sesion.equals("admin") || Admin.sesion.equals("usuario")) {
                    ListaHabitacion open = new ListaHabitacion();
                    open.setVisible(true);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "debes iniciar session");
            }
        }
        if (e.getSource()==jMenuItem5) {
            try {
                if (Admin.sesion.equals("admin")) {
                    AgregarSensor open = new AgregarSensor();
                    open.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "debes iniciar session como administrador");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "debes iniciar session");
            }
        }
        if (e.getSource()==jMenuItem6) {
            try {
                if (Admin.sesion.equals("admin") || Admin.sesion.equals("usuario")) {
                    ListaSensor open = new ListaSensor();
                    open.setVisible(true);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "debes iniciar session");
            }
        }
        if (e.getSource()==jMenuItem7) {
            try {
                if (Admin.sesion.equals("admin") || Admin.sesion.equals("usuario")) {
                    Generar open = new Generar();
                    open.setVisible(true);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "debes iniciar session");
            }
        }
        if (e.getSource()==jMenuItem8) {
            try {
                if (Admin.sesion.equals("admin") || Admin.sesion.equals("usuario")) {
                    ListaHistorial open = new ListaHistorial();
                    open.setVisible(true);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "debes iniciar session");
            }
        }
        if (e.getSource()==jMenuItem9) {
            try {
                if (Admin.sesion.equals("admin")) {
                    CargarArchivoHabitacion open = new CargarArchivoHabitacion();
                    open.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "debes iniciar session como administrador");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "debes iniciar session");
            }
        }
    }
}
