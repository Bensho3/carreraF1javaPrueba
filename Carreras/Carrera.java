package Carreras;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Carrera extends JFrame{
  private JLabel p1;
  private JLabel cab, cab2, cab3, cab4, meta;
  public static JProgressBar jbar, jbar2, jbar3, jbar4, aux;
  private JButton btnRun;
  public static ArrayList<Thread> arr;


  public Carrera(){
    setTitle("Carrera de Formula 1");
    setSize(1200, 720);
    setLayout(new BorderLayout());
    initComponents();
    this.setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  public void initComponents(){
    p1 = new JLabel();
    p1.setIcon(new ImageIcon("Carreras/Imagenes/fondo.PNG"));
    p1.setLayout(null);
    p1.setBounds(0,0,600,360);


    //etiquetas: Nombre/ posicion
    cab = new JLabel();
    cab.setIcon(new ImageIcon("Carreras/Imagenes/icono3.PNG"));
    cab2 = new JLabel();
    cab2.setIcon(new ImageIcon("Carreras/Imagenes/icono2.PNG"));
    cab3 = new JLabel();
    cab3.setIcon(new ImageIcon("Carreras/Imagenes/icono.PNG"));
    cab4 = new JLabel();
    cab4.setIcon(new ImageIcon("Carreras/Imagenes/icono4.PNG"));
    meta = new JLabel();
    meta.setIcon(new ImageIcon("Carreras/Imagenes/meta.PNG"));


    cab.setBounds(20, 20, 198, 134);
    cab2.setBounds(20, 160, 198, 134);
    cab3.setBounds(20, 300, 198, 134);
    cab4.setBounds(20, 440, 198, 134);
    meta.setBounds(1130, 20, 60, 480);

    //btnRun
    btnRun = new JButton("Iniciar Carrera");
    btnRun.setBounds(480, 600, 240, 60);

    EventoIniciar in = new EventoIniciar();

    btnRun.addActionListener(in);

    //JProgressBar
    jbar = new JProgressBar();
    jbar.setForeground(new Color(0,120,215));
    jbar.setStringPainted(true);
    jbar.setBounds(220, 30, 880, 40);

    jbar2 = new JProgressBar();
    jbar2.setForeground(Color.ORANGE);
    jbar2.setStringPainted(true);
    jbar2.setBounds(220, 170, 880, 40);


    jbar3 = new JProgressBar();
    jbar3.setForeground(new Color(51,255,0));
    jbar3.setStringPainted(true);
    jbar3.setBounds(220, 310, 880, 40);

    jbar4 = new JProgressBar();
    jbar4.setForeground(Color.DARK_GRAY);
    jbar4.setStringPainted(true);
    jbar4.setBounds(220, 450, 880, 40);

    p1.add(cab);
    p1.add(cab2);
    p1.add(cab3);
    p1.add(cab4);
    p1.add(meta);
    p1.add(btnRun);
    p1.add(jbar);
    p1.add(jbar2);
    p1.add(jbar3);
    p1.add(jbar4);
    add(p1);

  }


  public class EventoIniciar implements ActionListener{
    public void actionPerformed (ActionEvent ev){

      jbar.setValue(0);
      jbar2.setValue(0);
      jbar3.setValue(0);
      jbar4.setValue(0);

      arr = new ArrayList<Thread>();
      Thread aux;
      Correr c = new Correr();

      for(int i=0; i<4; i++){
        aux = new Thread(c);
        aux.setName("Monoplaza "+(i+1));
        arr.add(aux);
        arr.get(i).start();
      }
    }//evento
  }//clase interna
}//class JFrame
