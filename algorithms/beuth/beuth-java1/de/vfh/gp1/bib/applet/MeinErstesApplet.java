/**
 * Überschrift:   Lerneinheiten
 * Beschreibung:
 * Copyright:     Copyright (c) 2001
 * Organisation:  VFH
 * @author Katrin Kraft
 * @version 1.0
 */

import java.awt.*;

public class MeinErstesApplet extends java.applet.Applet {

   public void paint(Graphics g) {
           g.drawRect(10, 10, 250, 100);
      g.drawString("Mein erstes Applet", 30, 50);

    }
}