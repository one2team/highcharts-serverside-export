package org.one2team.highcharts.shared;

import org.one2team.highcharts.shared.PlotOptions.Series.States;

import com.google.gwt.shared.Array;

public interface Series {
  
  Array<Point> getData ();
  
  Series setData (Array<Point> data);

  String getName ();

  Series setName (String name);

  String getColor ();

  Series setColor (String color);

  String getType ();
  
  Series setType (String type);

  String getCenterX ();
  
  String getCenterY ();
  
  States getStates();
  
  Series setStates (States states);
  
  <T> T getUserObject ();

  void setUserObject (Object userObject);

  String getSize ();

  Series setSize (String size);

  Series setCenter (String centerX, String centerY);
  
}
