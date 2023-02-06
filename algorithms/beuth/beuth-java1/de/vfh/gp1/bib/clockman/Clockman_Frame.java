
/**
 * Ueberschrift: Clockman_Frame
 * Beschreibung: Diese Klasse implementiert die Benutzerschnittstelle fuer den Clockman.
 * Copyright: Copyright (c) A. Schmidt
 * Organisation: VFH - BHT Berlin
 * @author A. Schmidt
 * @version 1.0
 */
package de.vfh.gp1.bib.clockman;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.Date;

public class Clockman_Frame extends Frame implements Runnable, WindowListener, KeyListener
{
  /**
   *This is a <b>doc</b> comment.
   */
  /**
   *@serial Gesicht clockmanGesicht
   */
  private static Gesicht clockmanGesicht;
  /**
   * @serial Color farbeGesicht
   */
  private Color farbeGesicht;
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

  /** Konstruktor fuer die Klasse
   *
   * @param Breite Die Breite des Fensters in Pixeln
   * @param Hoehe  Die Hoehe des Fensters in Pixeln
   */

  public Clockman_Frame(int xPos,int yPos,int Breite, int Hoehe)
  {
    this(Breite,Hoehe);
    this.setBounds(xPos,yPos,Breite,Hoehe);
  }

  public Clockman_Frame(int Breite, int Hoehe)
  {
    super("VFH Clockman");
    this.addWindowListener(this);
    this.addKeyListener(this);
    // registriere einen Window-Listener damit die Anwendung beendet werden kann
    addWindowListener(new FensterBeenden());
    // registriere einen Mouse-Listener um die Mausbewegung zu ueberwachen
    addMouseMotionListener(new MausBewegung());
    setBackground(Color.white);
    setSize(Breite, Hoehe);

    // Erstelle einen neuen Thread und starte ihn anschliessend
    clockmanThread = new Thread(this);
    clockmanThread.start();

    farbeGesicht = new Color(0,0,255);

    setVisible(true);
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
    clockmanGesicht.setzeFarbeGesicht(farbeGesicht);
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

  public void setzeGesichtsfarbe(Color neueFarbe) {
    farbeGesicht = neueFarbe;
  }

  /** Die main-Methode fuer die Klasse als Einstiegspunkt fuer den Interpreter.
   *
   */
/*  public static void main(String[] args)
  {
    Clockman_Frame Clockman = new Clockman_Frame(400, 300);
  }*/

  /** Klasse, die auf das Fensterereignis Window_Close reagiert und
   *  die Anwendung beendet.
   */
  class FensterBeenden extends WindowAdapter
  {
    public void windowClosing(WindowEvent e)
    {
      System.exit(0);
    }
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

  public void windowOpened(WindowEvent e)
  {
    //TODO: Diese Methode java.awt.event.WindowListener implementieren;
  }

  public void windowClosing(WindowEvent e)
  {
    this.hide();
  }

  public void windowClosed(WindowEvent e)
  {
    //TODO: Diese Methode java.awt.event.WindowListener implementieren;
  }

  public void windowIconified(WindowEvent e)
  {
    //TODO: Diese Methode java.awt.event.WindowListener implementieren;
  }

  public void windowDeiconified(WindowEvent e)
  {
    //TODO: Diese Methode java.awt.event.WindowListener implementieren;
  }

  public void windowActivated(WindowEvent e)
  {
    //TODO: Diese Methode java.awt.event.WindowListener implementieren;
  }

  public void windowDeactivated(WindowEvent e)
  {
    //TODO: Diese Methode java.awt.event.WindowListener implementieren;
  }

  public void keyTyped(KeyEvent e)
  {
    //TODO: Diese Methode java.awt.event.KeyListener implementieren;
  }

  public void keyPressed(KeyEvent e)
  {
    if(e.getKeyCode()==KeyEvent.VK_ESCAPE) this.hide()
    ;
  }

  public void keyReleased(KeyEvent e)
  {
    //TODO: Diese Methode java.awt.event.KeyListener implementieren;
  }

}