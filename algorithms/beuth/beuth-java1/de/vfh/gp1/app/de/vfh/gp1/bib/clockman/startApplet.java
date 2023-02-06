package de.vfh.gp1.bib.clockman;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class startApplet extends Applet implements ActionListener
{
  /**
   *@serial Button start
   */
  Button start =new Button("Start Clockman");
  static int instanzen=0;
 
  //Das Applet konstruieren
  public startApplet()
  {
  }

  //Das Applet initialisieren
  public void init()
  {
    start.addActionListener(this);
    this.add(start);
  }

  //Das Applet starten
  public void start()
  {
    instanzen=0;  
  }

  //Das Applet anhalten
  public void stop()
  {
  }

  //Das Applet loeschen
  public void destroy()
  {
  }

  //Applet-Information holen
  public String getAppletInfo()
  {
    return "Applet-Information";
  }

  //Parameter-Infos holen
  public String[][] getParameterInfo()
  {
    return null;
  }

  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource()==start){
       int xPos=0;
       int yPos=0;
       if (instanzen==0){xPos=10;yPos=10; instanzen++;}
       else if (instanzen==1){xPos=310;yPos=10;instanzen++;}
       else if (instanzen==2){xPos=10;yPos=310;instanzen++;}
       else if (instanzen==3){xPos=310;yPos=310;instanzen++;}
       else {xPos=-1;};
       if (xPos>-1) new Clockman_Frame(xPos,yPos,300,300);
    }
  }
}