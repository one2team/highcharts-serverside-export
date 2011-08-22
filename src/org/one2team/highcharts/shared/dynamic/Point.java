package org.one2team.highcharts.shared.dynamic;

public interface Point {
  
  Element getGraphic ();
  
  double getX ();
  
  double getY ();
  
  void selectPoint (boolean select, boolean accumulate);
  
  String getColor ();

}
