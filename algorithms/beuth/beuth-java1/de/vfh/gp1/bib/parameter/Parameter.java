package de.vfh.gp1.bib.parameter;
import java.awt.*;

public class Parameter extends java.applet.Applet{

  Color color;
  String text;

    public void init(){
    color = new Color (12, 71, 137);
    this.setBackground(color);
    text = getParameter("text");
    }
    public void paint(Graphics g) {
     g.setColor(Color.white);
    if (text == null){
        g.drawString("Sie haben keinen Parameter eingetragen", 30, 50);}
    else{
        g.drawString(text, 30, 50);
        }
      g.drawRect(10, 10, 250, 100);

    }
  }