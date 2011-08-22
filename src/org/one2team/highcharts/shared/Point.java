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