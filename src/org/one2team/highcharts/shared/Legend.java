//File              $Source: /var/lib/cvs2/highcharts-server/src/org/one2team/highcharts/shared/Legend.java,v $
//Last modified by  $Author: obt $
//Revision Date     $Revision: 1.1 $
//Tag Name          $Name:  $
//
//Copyright (c) 2000-2010 One2team All Rights Reserved.

package org.one2team.highcharts.shared;


public interface Legend {
  
  Legend setLayout (String layout);
  
  Legend setAlign (String align);
  
  Legend setVerticalAlign (String valign);
  
  Legend setX (int x);
  
  Legend setY (int y);
  
  Legend setEnabled (boolean enabled);

  String getLayout ();
  
  String getAlign ();
  
  String getVerticalAlign ();
  
  int getX ();
  
  int getY ();
  
  boolean getEnabled ();
  
  Legend setReversed (boolean reversed);

  boolean isReversed ();
}
