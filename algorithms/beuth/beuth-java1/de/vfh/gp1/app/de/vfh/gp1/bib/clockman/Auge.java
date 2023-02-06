
/**
 * Ueberschrift: Clockman 
 * Beschreibung: Hier wird ein Auge fuer den Clockman implementiert. 
 * Copyright: Copyright (c) A. Schmidt 
 * Organisation: VFH - BHT Berlin 
 * @author A. Schmidt
 * @version 1.0
 */
package de.vfh.gp1.bib.clockman;

import java.awt.Color;
import java.awt.Graphics;

public class Auge
{
  /**
   * x-Position des Auges.
   * Wird so fuer die Methode fillOval benoetigt.
   */
  private int xAugeEcke;
  /**
   * y-Position des Auges.
   * Wird so fuer die Methode fillOval benoetigt.
   */
  private int yAugeEcke;
  /**
   * Breite des Auges.
   * Wird so fuer die Methode fillOval benoetigt.
   */
  private int breiteAuge;
  /**
   * Hoehe des Auges.        
   * Wird so fuer die Methode fillOval benoetigt
   */
  private int hoeheAuge;
  /**
   * x-Position der Pupille.        
   * Wird so fuer die Methode fillOval benoetigt
   */
  private int xPupilleEcke;
  /**
   *  y-Position der Pupille.
   * Wird so fuer die Methode fillOval benoetigt
   */
  private int yPupilleEcke;
  /**
   * Breite der Pupille.
   * Wird so fuer die Methode fillOval benoetigt
   */
  private int breitePupille;
  /**
   * Hoehe der Pupille.        
   * Wird so fuer die Methode fillOval benoetigt
   */
  private int hoehePupille;
  /**
   * X-Koordinate des Augenmittelpunktes
   */
  private int xMp;
  /**
   * Y-koordinate des Augenmittelpunktes
   */
  private int yMp;
  /**
   * Die Farbe des Augenhintergrunds. Vorbelegt mit weiss.
   */
  Color farbeAugenhintergrund = new Color(255,255,255);
  /**
   * Die Farbe der Pupille. Vorbelegt mit schwarz.
   */
  Color farbePupille          = new Color(0,0,0);

  /** Konstruktor fuer die Klasse.
  *
  * @param xMittelpunkt X-Mittelpunkt fuer das Auge.
  * @param yMittelpunkt Y-Mittelpunkt fuer das Auge.
  * @param Radius       Der Radius des gesamten Auges inkl. Augenhintergrund in Pixeln.
  */

  public Auge(int xMittelpunkt, int yMittelpunkt, int Radius)
  {
    xMp = xMittelpunkt;
    yMp = yMittelpunkt;
    // berechnen der Daten des Augenhintergrundes
    xAugeEcke     = xMittelpunkt - Radius;
    yAugeEcke     = yMittelpunkt - Radius;
    breiteAuge    = 2 * Radius;
    hoeheAuge     = 2 * Radius;
    // berechnen der Daten der Pupille
    xPupilleEcke  = xMittelpunkt - Radius / 4;
    yPupilleEcke  = yMittelpunkt - Radius / 4;
    breitePupille = Radius / 2;
    hoehePupille  = Radius / 2;
  }

  /** Diese Methode zeichnet auf dem Grafikkontext <tt>leinwand</tt> den Augenhintergrund und
   * die Pupille. Die Pupille wird so gezeichnet, dass das Auge in Richtung <tt>xBlickpunkt</tt> und
   * <tt>yBlickpunkt</tt> schaut.
   *
   * @param leinwand    Bezeichnet den Grafikkontext auf dem das Auge gezeichnet werden soll.
   * @param xBlickpunkt Die X-Koordinate des Punktes auf den das Auge "schauen" soll.
   * @param yBlickpunkt Die Y-Koordinate des Punktes auf den das Auge "schauen" soll.
   */
  public void zeichneAuge(Graphics leinwand, int xBlickpunkt, int yBlickpunkt)
  {
    // zeichne Augenhintergrund
    leinwand.setColor(farbeAugenhintergrund);
    leinwand.fillOval(xAugeEcke, yAugeEcke, breiteAuge, hoeheAuge);
    // Koordinaten in den Ursprung des Koordinatensystems verschieben
    int x = xBlickpunkt - xMp;
    int y = yBlickpunkt - yMp;

    if ((x != 0) && (y != 0)) // wenn also der Blickpunkt nicht auf dem Mittelpunkt liegt.
    {
      // Damit die Pupille nicht aus dem Rahmen des Augenhintergrundes faellt
      int hypot = Math.min(breiteAuge/2-breitePupille/2, (int)Math.sqrt(x*x + y*y));
      // Berechne den Winkel
      double winkel = Math.atan2(y, x);
      // Berechne die neuen Koordinaten
      x = (int) (hypot*Math.cos(winkel));
      y = (int) (hypot*Math.sin(winkel));
    }
    // Koordinaten wieder zurueck auf den Mittelpunkt des Auges schieben
    x += xMp;
    y += yMp;
    // zeichne Pupille an den neuen Koordinaten
    leinwand.setColor(farbePupille);
    leinwand.fillOval(x, y, breitePupille, hoehePupille);
  }

}