
/**
 * Ueberschrift: Clockman 
 * Beschreibung: Abstrakte Klasse Uhrzeiger. Hier werden die Schnittstellen die die Zeiger definiert.
 *               Ausserdem wird hier die Funktion <tt>transform</tt> definert, die die neue Position des Zeigers berechnet. 
 * Copyright: Copyright (c) A. Schmidt 
 * Organisation: VFH - TFH Berlin 
 * @author A. Schmidt
 * @version 1.0
 */
package de.vfh.gp1.bib.clockman;

import java.awt.*;

abstract public class Uhrzeiger
{
  /**
   *Radianten pro Minute oder Sekunde.<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   *Dieser Werte wird zur Berechnung des Winkels benoetigt.
   */
  public static final double radMINSEK=0.104719755;
  /**
   *Radianten pro Stunde<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   *Dieser Werte wird zur Berechnung des Winkels benoetigt.
   */
  public static final double radSTUNDE=0.523598776;
  /**
   *Fuer die Originalkoordinaten des Zeigers
   */
  protected int[] xBasis, yBasis;
  /**
   *Speichert die transformierten Koordinaten
   */
  protected int[] xTransformiert, yTransformiert;
  /*
   *Speichert die Anzahl der Koordinatenpunkte
   */
  protected int anzahlPunkte;
  /*
   *Farbe des Zeigers
   */
  protected Color farbeZeiger;
  /*
   *Haelt den aktuellen Winkel fest
   */
  protected double aktuellWinkel;                     

  /** Konstruktor fuer die Klasse.
   *
   * @param xUrsprung X-Startpunkt fuer den Zeiger. Identisch mit der Mitte der Uhr.
   * @param yUrsprung Y-Startpunkt fuer den Zeiger. Identisch mit der Mitte der Uhr.
   * @param Laenge    Die Laenge des Zeigers in Pixeln.
   * @param Dicke     Die Dicke des Zeigers in Pixeln.
   * @param Farbe     Die Farbe des Zeigers.
   */
  public Uhrzeiger(int xUrsprung, int yUrsprung, int Laenge, int Dicke, Color Farbe)
  {
    farbeZeiger = Farbe;
    aktuellWinkel = 0.0;
    initZeigerPunkte(xUrsprung, yUrsprung, Laenge, Dicke);
  }

  abstract void initZeigerPunkte(int xUrsprung, int yUrsprung, int laengeZeiger, int dickeZeiger);

  abstract protected void zeichneZeiger(int StdMinSek, Graphics g);

  /** Diese Methode ist dafuer verantwortlich den Zeiger um <tt>winkel</tt> im Uhrzeigersinn zu drehen.
   * Es wird immer von den Koordinaten im Array <tt>Basis</tt> ausgegangen. Die neuen Werte werden
   * in den Array <tt>transformiert</tt> geschrieben.
   *
   * @param winkel Winkel um den der Zeiger gedreht werden soll. Dazu wird der akt. Wert, z.B. der Stunde, mit der
   *               entsprechnenden Konstante multipliziert. Im Falle von Stunden also <tt>radSTUNDE</tt>. Das Ergebnis
   *               wird dieser Funktion uebergeben, die daraus die neue Position des Zeigers berechnet.
   */
  protected void transform(double winkel)
  {
    for (int i=0; i<anzahlPunkte; i++)
    {
      xTransformiert[i] = (int)((xBasis[0]-xBasis[i])*Math.cos(winkel)-
                                (yBasis[0]-yBasis[i])*Math.sin(winkel)+
                                (xBasis[0]));
      yTransformiert[i] = (int)((xBasis[0]-xBasis[i])*Math.sin(winkel)+
                                (yBasis[0]-yBasis[i])*Math.cos(winkel)+
                                (yBasis[0]));
    }
  }

}