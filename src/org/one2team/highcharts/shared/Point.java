//File              $Source: /var/lib/cvs2/highcharts-server/src/org/one2team/highcharts/shared/Point.java,v $
//Last modified by  $Author: obt $
//Revision Date     $Revision: 1.1 $
//Tag Name          $Name:  $
//
//Copyright (c) 2000-2011 One2team All Rights Reserved.

package org.one2team.highcharts.shared;

public interface Point {
  
  Point setX (double x);

  double getX ();
  
  Point setY (double y);

  double getY ();

  Point setSelected (boolean selected);

  boolean getSelected ();

  Point setColor (String color);
  
  String getColor ();
  
  Point setName (String name);
  
  String getName ();
  
  Point setSliced (boolean sliced);

  boolean isSliced ();
}