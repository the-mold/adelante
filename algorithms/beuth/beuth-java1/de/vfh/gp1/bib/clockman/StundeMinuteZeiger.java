
/**
 * Ueberschrift: Clockman 
 * Copyright: Copyright (c) A. Schmidt 
 * Organisation: VFH - BHT Berlin 
 * @author A. Schmidt
 * @version 1.0
 */
package de.vfh.gp1.bib.clockman;

import java.awt.Color;
import java.awt.Graphics;

public class StundeMinuteZeiger extends Uhrzeiger
{

  public StundeMinuteZeiger(int xUrsprung, int yUrsprung, int Laenge, int Dicke, Color Farbe)
  {
    super(xUrsprung, yUrsprung, Laenge, Dicke, Farbe);
  }

  public void zeichneZeiger(int StdMinSek, Graphics g)
  {
    transform(radMINSEK*StdMinSek);
    g.setColor(farbeZeiger);
    g.fillPolygon(xTransformiert, yTransformiert, anzahlPunkte);
  }

  void initZeigerPunkte(int xUrsprung, int yUrsprung, int laengeZeiger, int dickeZeiger)
  {
    xBasis[0] = xUrsprung;                    yBasis[0] = yUrsprung;
    xBasis[1] = xUrsprung - dickeZeiger / 2;  yBasis[1] = yUrsprung + dickeZeiger / 2;
    xBasis[2] = xBasis[1];                    yBasis[2] = yBasis[0] + laengeZeiger - dickeZeiger;
    xBasis[3] = xBasis[0];                    yBasis[3] = yBasis[0] + laengeZeiger;
    xBasis[4] = xBasis[0] + dickeZeiger;      yBasis[4] = yBasis[2];
    xBasis[5] = xBasis[4];                    yBasis[5] = yBasis[4];
  }
}