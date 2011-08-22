package org.one2team.highcharts.shared;



public interface Title {

  String getText ();

  int getMargin ();
  
  Title setText (String text);

  Title setMargin (int i);
  
  Style getStyle ();
  
}
