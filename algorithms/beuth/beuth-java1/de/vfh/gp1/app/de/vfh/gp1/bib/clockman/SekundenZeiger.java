
/**
 * Ueberschrift: Clockman
 * Beschreibung: Implementation der abstrakten Klasse Uhrzeiger. Hier wird der Sekundenzeiger definiert.
 * Copyright: Copyright (c) A. Schmidt
 * Organisation: VFH - BHT Berlin
 * @author A. Schmidt
 * @version 1.0
 */
package de.vfh.gp1.bib.clockman;

import java.awt.Color;
import java.awt.Graphics;

public class SekundenZeiger extends Uhrzeiger
{
  /** Konstruktor fuer die Klasse.
   *
   * @param xUrsprung X-Startpunkt fuer den Zeiger. Identisch mit der Mitte der Uhr.
   * @param yUrsprung Y-Startpunkt fuer den Zeiger. Identisch mit der Mitte der Uhr.
   * @param Laenge    Die Laenge des Zeigers in Pixeln.
   * @param Dicke     Die Dicke des Zeigers in Pixeln.
   * @param Farbe     Die Farbe des Zeigers.
   */
  public SekundenZeiger(int xUrsprung, int yUrsprung, int laengeZeiger, int Dicke, Color Farbe)
  {
    super(xUrsprung, yUrsprung, laengeZeiger, Dicke, Farbe);
  }

  /** Diese Methode zeichnet den Sekundenzeiger.
   *
   * @param Stunde Die aktuelle Sekunde, die gezeichnet werden soll.
   * @param g      Verweist auf den Grafikkontext, wo gezeichnet werden soll.
   */
  protected void zeichneZeiger(int Sekunde, Graphics g)
  {
    transform(radMINSEK*Sekunde);
    g.setColor(farbeZeiger);
    g.drawLine(xTransformiert[1], yTransformiert[1], xTransformiert[2], yTransformiert[2]);
  }

  /** Diese Methode erstellt die Zeigerkoordinaten und schreibt diese in die Basis Arrays.
   *
   * @param xUrsprung    X-Ursprung wo der Zeiger beginnen soll.
   * @param yUrsprung    Y-Ursprung wo der Zeiger beginnen soll.
   * @param laengeZeiger Die Laenge des Zeigers in Pixeln.
   * @param dickeZeiger  Die Dicke des Zeigers in Pixeln.
   */
  protected void initZeigerPunkte(int xUrsprung, int yUrsprung, int laengeZeiger, int dickeZeiger)
  {
    anzahlPunkte = 3;

    xBasis = new int[anzahlPunkte];
    yBasis = new int[anzahlPunkte];
    xTransformiert = new int[anzahlPunkte];
    yTransformiert = new int[anzahlPunkte];

    xBasis[0] = xUrsprung; yBasis[0] = yUrsprung;
    xBasis[1] = xUrsprung; yBasis[1] = yUrsprung - laengeZeiger/5;
    xBasis[2] = xUrsprung; yBasis[2] = yUrsprung + laengeZeiger;
  }

}