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
