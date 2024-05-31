package Carreras;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Correr implements Runnable{

  public void run(){

    Random r = new Random();
    int incremento;
    int avance = 0;

    try{
      while(avance<100){
        incremento = r.nextInt(10);
        System.out.println(Thread.currentThread().getName()+" avanza : "+incremento);
        avance+= incremento;
        avanza(avance);
        Thread.sleep(1000);

      }
    }catch (InterruptedException e){
      System.out.println("Hilo interrumpido");
    }
  }


  public void avanza(int ava){

    switch(Thread.currentThread().getName()){
      case "Monoplaza 1":
        Carrera.jbar.setValue(ava);
        break;
      case "Monoplaza 2":
        Carrera.jbar2.setValue(ava);
        break;
      case "Monoplaza 3":
        Carrera.jbar3.setValue(ava);
        break;
      case "Monoplaza 4":
        Carrera.jbar4.setValue(ava);
        break;
      }

      if(ava>=100){
        detener();
        String gan = Thread.currentThread().getName();
        JOptionPane.showMessageDialog(null, "El ganador es: "+ gan, "Terminado", JOptionPane.INFORMATION_MESSAGE);
      }
    }//update

    private void detener(){
      for(int i=0; i<4; i++){
        Carrera.arr.get(i).interrupt();
      }
    }
}
