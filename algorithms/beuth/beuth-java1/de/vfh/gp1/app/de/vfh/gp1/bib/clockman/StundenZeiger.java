
/**
 * Ueberschrift: Clockman
 * Beschreibung: Implementation der abstrakten Klasse Uhrzeiger. Hier wird der Stundenzeiger definiert.
 * Copyright: Copyright (c) A. Schmidt
 * Organisation: VFH - BHT Berlin
 * @author A. Schmidt
 * @version 1.0
 */
package de.vfh.gp1.bib.clockman;

import java.awt.Color;
import java.awt.Graphics;

public class StundenZeiger extends Uhrzeiger
{
  /** Konstruktor fuer die Klasse.
   *
   * @param xUrsprung X-Startpunkt fuer den Zeiger. Identisch mit der Mitte der Uhr.
   * @param yUrsprung Y-Startpunkt fuer den Zeiger. Identisch mit der Mitte der Uhr.
   * @param Laenge    Die Laenge des Zeigers in Pixeln.
   * @param Dicke     Die Dicke des Zeigers in Pixeln.
   * @param Farbe     Die Farbe des Zeigers.
   */
  public StundenZeiger(int xUrsprung, int yUrsprung, int Laenge, int Dicke, Color Farbe)
  {
    super(xUrsprung, yUrsprung, Laenge, Dicke, Farbe);
  }

  /** Diese Methode zeichnet den Stundenzeiger.
   *
   * @param Stunde Die aktuelle Stunde, die gezeichnet werden soll.
   * @param g      Verweist auf den Grafikkontext, wo gezeichnet werden soll.
   */
  public void zeichneZeiger(int Stunde, Graphics g)
  {
    transform(radSTUNDE*Stunde);
    g.setColor(farbeZeiger);
    g.fillPolygon(xTransformiert, yTransformiert, anzahlPunkte);
  }

  /** Diese Methode erstellt die Zeigerkoordinaten und schreibt diese in die Basis Arrays.
   *
   * @param xUrsprung    X-Ursprung wo der Zeiger beginnen soll.
   * @param yUrsprung    Y-Ursprung wo der Zeiger beginnen soll.
   * @param laengeZeiger Die Laenge des Zeigers in Pixeln.
   * @param dickeZeiger  Die Dicke des Zeigers in Pixeln.
   */
  void initZeigerPunkte(int xUrsprung, int yUrsprung, int laengeZeiger, int dickeZeiger)
  {
    anzahlPunkte = 6;

    xBasis = new int[anzahlPunkte];
    yBasis = new int[anzahlPunkte];
    xTransformiert = new int[anzahlPunkte];
    yTransformiert = new int[anzahlPunkte];

    xBasis[0] = xUrsprung;                    yBasis[0] = yUrsprung;
    xBasis[1] = xUrsprung - dickeZeiger / 2;  yBasis[1] = yUrsprung + dickeZeiger / 2;
    xBasis[2] = xBasis[1];                    yBasis[2] = yBasis[0] + laengeZeiger - dickeZeiger;
    xBasis[3] = xBasis[0];                    yBasis[3] = yBasis[0] + laengeZeiger;
    xBasis[4] = xBasis[0] + dickeZeiger / 2;  yBasis[4] = yBasis[2];
    xBasis[5] = xBasis[4];                    yBasis[5] = yBasis[1];
  }
}