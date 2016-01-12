/*
 * Name: Seanmichael Stanley
 * TA: Matt English
 * Date: 4/14/14
 * Homework 3
 * Section D
 */

//Copyright (C) 2003 Zheli Erwin Yu
//
//This file is part of ATCJ.
//
//ATCJ is free software; you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation; either version 2 of the License, or
//(at your option) any later version.
//
//ATCJ is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with ATCJ; if not, write to the Free Software
//Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

package eyu.atc;

import java.lang.Object;
import java.applet.Applet;
import java.io.*;

public class ATC extends Applet
{
  public static boolean debug_flag = false;

  protected ATCUI ui = null;
  protected ATCInputhandler input_handler = null;
  protected ATCData data = null;

  protected boolean applet_flag = false;

  public String codeBase = null;

  protected String game = null;
  protected Reader input_reader = null;

  public ATC() { super(); }
  public ATC( String s ) { super(); game = new String(s); }
  public ATC( ATC ao ) 
  { 
    super( ); 
    ui = ao.ui;
    input_handler = ao.input_handler;
    data = ao.data;
    applet_flag = ao.applet_flag;
  }

  public void init()
  {
    applet_flag = true;
    codeBase = getCodeBase().toString();
  }
  public void start()
  {
    startATC();
  }
  public void stop()
  {
    stopATC();
  }

  public void startATC()
  {
    if( !applet_flag )
    {
      codeBase = ClassLoader.getSystemResource(".").toString();
      try{
        input_reader = new FileReader( "config/"+game );
      }catch( FileNotFoundException e )
      {
        System.err.println("Cannot open config file!");
        System.exit(0);
      }
    }
    else
    {
      game = getParameter("GAME");
      input_reader = new StringReader( getParameter("CONFIG") );
    }

    if( input_reader == null ) return;

    printCopyright();

    ui = new ATCUI_impl( this );

    input_handler = new ATCInputhandler_impl( this );
    data = new ATCData( this );
      data.setConfig( new ATCConfig_from_stream( game, input_reader ) );
      data.setRecord( new ATCRecord_impl() );
      data.initData();
  }

  public synchronized void stopATC()
  {
    if( data != null )
      data.gameOver( null );
    if( ui != null )
      ui.close();
    ui = null;
    input_handler = null;
    data = null;

    if( !applet_flag )
      System.exit(0);
  }

  public ATCUI getUI()
  { return ui; }
  public ATCInputhandler getInputhandler()
  { return input_handler; }
  public ATCData getData()
  { return data; }

  protected void printCopyright()
  {
    System.out.println("ATCJ: Air Traffic Controller Game");
    System.out.println("Copyright (C) 2003 Zheli Erwin Yu.");
    System.out.println("This is free software; see the source for copying conditions.  There is NO");
    System.out.println("warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.\n");
  }
};

