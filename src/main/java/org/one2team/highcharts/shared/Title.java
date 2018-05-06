package org.one2team.highcharts.shared;


/**
 * Title of the chart.
 */
public interface Title {

  String getText ();

  int getMargin ();
  
  Title setText (String text);

  Title hide();

  Title setMargin (int i);
  
  Style getStyle ();
  
}
