package de.vfh.gp1.bib.clockman;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.Date;

/**
 * Ueberschrift:  VFH Clockman
 * Beschreibung:  Dieses Paket implementiert den Clockman, der hier als Applikation und Applet zur Verfuegung steht.
 * Copyright:     Copyright (c) BHT Berlin. Alle Rights Reserved.
 * Organisation:  BHT Berlin - Virtuelle FH
 * @author vfh-autor 
 * @version 1.0
 */

public class Clockman_Applet extends Applet implements Runnable
{

  /**
   *This is a <b>doc</b> comment.
   */
  /**
   *@serial Gesicht clockmanGesicht
   */
  private static Gesicht clockmanGesicht;
  /**
   *@serial Auge AugeLinks,AugeRechts;
   */
  private Auge AugeLinks,AugeRechts;
  /**
   *@serial SekundenZeiger SekZeiger
   */
  private SekundenZeiger SekZeiger;
  /**
   *@serial StundenZeiger StdZeiger
   */
  private StundenZeiger StdZeiger;
  /**
   *@serial MinutenZeiger MinZeiger
   */
  private MinutenZeiger MinZeiger;
  /**
   *@serial int Stunde, Minute Sekunde;
   */
  private int Stunde, Minute, Sekunde;
  /**
   *@serial Thread clockmanThread
   */
  private Thread clockmanThread;
  /**
   *@serial Date aktuelleZeit
   */
  private Date aktuelleZeit = new Date();
  /**
   *@serial int xMausPos,yMausPos
   */
  private int xMausPos = 0,
              yMausPos = 0;



  boolean isStandalone = false;
  /**Parameterwert holen*/
  public String getParameter(String key, String def) {
    return isStandalone ? System.getProperty(key, def) :
      (getParameter(key) != null ? getParameter(key) : def);
  }

  /**Das Applet konstruieren*/
  public Clockman_Applet() {
   addMouseMotionListener(new MausBewegung());
  }
  /**Das Applet initialisieren*/
  public void init() {
    try {
      jbInit();
      starteUhr();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  /**Initialisierung der Komponenten*/
  private void jbInit() throws Exception {
  }
  /**Das Applet starten*/
  public void start() {
  }

  /** Diese Methode zeichnet den Clockman mitsamt seiner Augen und Zeiger auf den Bildschirm
   * @param g Ist der Grafikkontext auf dem gezeichnet wird.
   */
  public void paint(Graphics g)
  {
    // Zuerst holen wir uns die Groesse die Groesse der Zeichenflaeche. Wir erhalten mit der Methode getSize()
    // die ganze Groesse incl. Rahmen.
    Dimension groesseLeinwand = getSize();
    // Also muessen wir auch noch die Groesse des Fensterrahmen holen,
    // damit wir diese Masse abrechnen koennen.
    Insets groesseRahmen      = getInsets();
    // Nun berechnen wir den Mittelpunkt der Zeichenflaeche.
    int xMittelpunkt = (groesseLeinwand.width-(groesseRahmen.left+groesseRahmen.right)) / 2 + groesseRahmen.left;
    int yMittelpunkt = (groesseLeinwand.height-(groesseRahmen.top+groesseRahmen.bottom)) / 2 + groesseRahmen.top;
    // Jetzt brauchen wir noch die kleinste Dimension, die uebergeben wir dann als Groesse der Uhr.
    // Damit wird unsere Uhr immer schoen rund.
    int minDimension = Math.min(groesseLeinwand.width-(groesseRahmen.left+groesseRahmen.right),
                                groesseLeinwand.height-(groesseRahmen.top+groesseRahmen.bottom));

    // Erstelle ein nichtsichtbares Bild, das genauso gross wir unsere Zeichenflaeche ist.
    // Auf diesem "malen" wir die naechste Sekunde und bringen dann das ganze Bild auf einmal zur Ansicht.
    Image pufferBild  = createImage(groesseLeinwand.width, groesseLeinwand.height);
    Graphics pufferGC = pufferBild.getGraphics();

    // Nun benoetigen wir nur noch die Instanzen der Klassen fuer die Zeiger und die Augen.
    clockmanGesicht = new Gesicht(xMittelpunkt,
                                  yMittelpunkt,
                                  (groesseLeinwand.width-(groesseRahmen.left+groesseRahmen.right)),
                                  (groesseLeinwand.height-(groesseRahmen.top+groesseRahmen.bottom)));
    AugeLinks  = new Auge((int)(xMittelpunkt-minDimension/4), yMittelpunkt-minDimension/4, minDimension/8);
    AugeRechts = new Auge((int)(xMittelpunkt+minDimension/4), yMittelpunkt-minDimension/4, minDimension/8);
    SekZeiger  = new SekundenZeiger(xMittelpunkt,
                                    yMittelpunkt,
                                    minDimension/2,
                                    0,
                                    Color.black);
    MinZeiger  = new MinutenZeiger(xMittelpunkt,
                                   yMittelpunkt,
                                   minDimension/2,
                                   4,
                                   Color.cyan);
    StdZeiger  = new StundenZeiger(xMittelpunkt,
                                   yMittelpunkt,
                                   minDimension/3,
                                   10,
                                   Color.red);

    // Zeichne Gesicht und Augen
    clockmanGesicht.zeichneGesicht(pufferGC);
    AugeLinks.zeichneAuge(pufferGC, xMausPos, yMausPos);
    AugeRechts.zeichneAuge(pufferGC, xMausPos, yMausPos);
    // Zeichne die Zeiger
    StdZeiger.zeichneZeiger(aktuelleZeit.getHours(), pufferGC);
    MinZeiger.zeichneZeiger(aktuelleZeit.getMinutes(), pufferGC);
    SekZeiger.zeichneZeiger(aktuelleZeit.getSeconds(), pufferGC);
    // Zeichne den kleinen Uhrenmittelpunkt
    pufferGC.setColor(Color.white);
    pufferGC.fillOval(xMittelpunkt-(minDimension/30/2),
                      yMittelpunkt-(minDimension/30/2),
                      minDimension/30,
                      minDimension/30);
    // Jetzt zeichne das ganze Bild auf den sichtbaren Bereich
    g.drawImage(pufferBild, 0, 0, this);
  }

  public void update(Graphics g)
  {
      this.paint(g);
  }

  /**Das Applet anhalten*/
  public void stop() {
  }
  /**Das Applet loeschen*/
  public void destroy() {
  }
  /**Applet-Information holen*/
  public String getAppletInfo() {
    return "Applet-Information";
  }
  /**Parameter-Infos holen*/
  public String[][] getParameterInfo() {
    return null;
  }

  /** Implementation der Thread Routine
   *  Jede Sekunde wird die neue Zeit genommen und die
   *  Bildschirmansicht erneuert.
   */
  public void run()
  {
    // setzen der Prioritaet auf normal
    Thread.currentThread().setPriority(Thread.NORM_PRIORITY);

    // Wenn es einen clockmanThread gibt, dann
    // hole erneut die aktuelle Zeit und zeichne den Bildschirm neu.
    while(clockmanThread != null)
    {
      aktuelleZeit = new Date();
      repaint();
      try
      {
        Thread.sleep(1000);
      }
      catch(InterruptedException e)
      {
        System.err.print(e.getLocalizedMessage());
        System.exit(1);
      }
    }
    System.exit(0);
  }

  public void starteUhr()
  {
    // Erstelle einen neuen Thread und starte ihn anschliessend
    clockmanThread = new Thread(this);
    clockmanThread.start();
  }

  /** Der Destruktor fuer die Klasse
   */
  public void finalize()
  {
    // Stoppe den Thread
    if (clockmanThread != null)
    {
      clockmanThread.stop();
      clockmanThread = null;
    }

    clockmanGesicht = null;
    SekZeiger = null;
    MinZeiger = null;
    StdZeiger = null;

    System.gc();
  }

  /** Klasse, die auf das Ereignis Mouse_Move reagiert
   *  und die akt. Mauskoordinaten ausliest. Diese
   *  werden in globale Variablen geschrieben und der
   *  Bildschirm neu gezeichnet.
   */
  class MausBewegung extends MouseMotionAdapter
  {
    public void mouseMoved(MouseEvent e)
    {
      xMausPos = e.getX();
      yMausPos = e.getY();
      repaint();
    }
  }

}