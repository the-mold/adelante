package de.vfh.gp1.bib.clockman;

import java.applet.*;

/**
 * Ueberschrift: Clockman
 * Copyright: Copyright (c) A. Schmidt
 * Organisation: VFH - BHT Berlin
 * @author A. Schmidt
 * @version 1.0
 */

public class Clockman extends Applet
{
  private Clockman_Frame Clockman1 = null;

  //Das Applet konstruieren
  public Clockman()
  {
  }

  //Das Applet initialisieren
  public void init()
  {
    Clockman1 = new Clockman_Frame(100,100,300,300);
  }

  //Das Applet starten
  public void start()
  {
  }

  //Das Applet anhalten
  public void stop()
  {
  }

  //Das Applet loeschen
  public void destroy()
  {
    Clockman1 = null;
  }

  //Applet-Information holen
  public String getAppletInfo()
  {
    return "Applet-Information";
  }

  //Parameter-Infos holen
  public String[][] getParameterInfo()
  {
    return null;
  }

}