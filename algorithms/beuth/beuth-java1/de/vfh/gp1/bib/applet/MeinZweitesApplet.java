/**
 * Überschrift:   Lerneinheiten
 * Beschreibung:
 * Copyright:     Copyright (c) 2001
 * Organisation:  VFH
 * @author Katrin Kraft
 * @version 1.0
 */

import java.awt.*;

public class MeinZweitesApplet extends java.applet.Applet {
  //Instanzvariable:
  Color color;

    public void init(){
    color = new Color (12, 71, 137);
    this.setBackground(color);
    }
    public void paint(Graphics g) {
    g.setColor(Color.white);
    g.drawRect(10, 10, 250, 100);
    g.drawString("Mein zweites Applet", 30, 50);
  }
}