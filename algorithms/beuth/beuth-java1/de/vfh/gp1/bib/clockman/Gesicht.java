
/**
 * Ueberschrift: Clockman
 * Copyright: Copyright (c) A. Schmidt
 * Organisation: VFH - BHT Berlin
 * @author A. Schmidt
 * @version 1.0
 */
package de.vfh.gp1.bib.clockman;

import java.awt.*;

public class Gesicht
{
  /**
   *Farbe des Gesichtes
   */
  private Color farbeGesicht = new Color(0, 0, 255);
  /**
   *Farbe des Augenhintergrundes
   */
  private Color farbeAugeHintergrund = new Color(100, 175, 255);
  /**
   *Farbe des Auges
   */
  private Color farbeAuge = new Color(0,0,0);
  /**
   *x-Position des Gesichtes
   */
  private int xEckeGesicht;
  /**
   *y-Position des Gesichtes
   */
  private int yEckeGesicht;
  /**
   *Breite des Gesichtes
   */
  private int breiteGesicht;
  /**
   *H&ouml;he des Gesichtes
   */
  private int hoeheGesicht;
  /**
   *x-Position des Augenhintergrundes(links)
   */
  private int xEckeAugeHintergrundLinks;
  /**
   *y-Position des Augenhintergrundes(links)
   */
  private int yEckeAugeHintergrundLinks;
  /**
   *x-Position des Augenhintergrundes(rechts)
   */
  private int xEckeAugeHintergrundRechts;
  /**
   *y-Position des Augenhintergrundes(rechts)
   */
  private int yEckeAugeHintergrundRechts;
  /**
   *Breite des Augenhintergrundes(links und rechts)
   */
  private int breiteAugeHintergrund;
  /**
   *H&ouml;he des Augenhintergrundes(links und rechts)
   */
  private int hoeheAugeHintergrund;
  /**
   *x-Position der Iris
   */
  private int xEckeIris;
  /**
   *y-Position der Iris
   */
  private int yEckeIris;
  /**
   *Breite der Iris
   */
  private int breiteIris;
  /**
   *H&ouml;he der Iris
   */
  private int hoeheIris;

  public Gesicht(int xMittelpunkt, int yMittelpunkt, int Breite, int Hoehe)
  {
    int minDimension ;
    int xLinkesAugeMittelpunkt;
    int xRechtesAugeMittelpunkt;
    int yLinkesAugeMittelpunkt;
    int yRechtesAugeMittelpunkt;

    // Berechne die kleinste Dimension, damit der Kreis auch rund wird.
    minDimension  = Math.min(Breite, Hoehe);

    xEckeGesicht  = xMittelpunkt - minDimension / 2;
    yEckeGesicht  = yMittelpunkt - minDimension / 2;
    breiteGesicht = minDimension;
    hoeheGesicht  = minDimension;

    xLinkesAugeMittelpunkt  = xMittelpunkt - (minDimension / 4);
    xRechtesAugeMittelpunkt = xMittelpunkt + (minDimension / 4);
    yLinkesAugeMittelpunkt  = yMittelpunkt - (minDimension / 4);
    yRechtesAugeMittelpunkt = yMittelpunkt - (minDimension / 4);

    xEckeAugeHintergrundLinks  = xLinkesAugeMittelpunkt - (xMittelpunkt - xLinkesAugeMittelpunkt - 10);
    xEckeAugeHintergrundRechts = xRechtesAugeMittelpunkt - (xRechtesAugeMittelpunkt - xMittelpunkt - 10);
    yEckeAugeHintergrundLinks  = yLinkesAugeMittelpunkt - (yMittelpunkt - yLinkesAugeMittelpunkt - 10);
    yEckeAugeHintergrundRechts = yRechtesAugeMittelpunkt - (yMittelpunkt - yRechtesAugeMittelpunkt - 10);

    breiteAugeHintergrund = (xLinkesAugeMittelpunkt - xEckeAugeHintergrundLinks) * 2;
    hoeheAugeHintergrund = (yLinkesAugeMittelpunkt - yEckeAugeHintergrundLinks) * 2;
  }

  public Gesicht(Graphics leinwand)
  {
    Rectangle r;
    int minDimension;
    int xMittelpunkt, yMittelpunkt;

    r = leinwand.getClipBounds();
    // Berechne die kleinste Dimension, damit der Kreis auch rund wird.
    minDimension = Math.min(r.width, r.height);
    // Mittelpunkt berechnen, damit das Gesicht immer schoen mittig sitzt.
    xMittelpunkt = r.width / 2 + r.x;
    yMittelpunkt = r.height / 2 + r.y;

    xEckeGesicht = xMittelpunkt - minDimension / 2;
    yEckeGesicht = yMittelpunkt - minDimension / 2;
    breiteGesicht = minDimension;
    hoeheGesicht = minDimension;
  }

  public void zeichneGesicht(Graphics leinwand)
  {
    leinwand.setColor(farbeGesicht);
    leinwand.fillOval(xEckeGesicht, yEckeGesicht, breiteGesicht, hoeheGesicht);
    leinwand.setColor(farbeAugeHintergrund);
    leinwand.fillOval(xEckeAugeHintergrundLinks, yEckeAugeHintergrundLinks, breiteAugeHintergrund, hoeheAugeHintergrund);
    leinwand.fillOval(xEckeAugeHintergrundRechts, yEckeAugeHintergrundRechts, breiteAugeHintergrund, hoeheAugeHintergrund);
  }

  public void setzeFarbeGesicht(Color neueFarbe) {
    farbeGesicht = neueFarbe;
  }
}