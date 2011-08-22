package org.one2team.highcharts.shared.dynamic;

import com.google.gwt.shared.Array;

public interface Series {
  
  Array<Point> getData ();
  
  Element getGraph ();
  
  Element getArea ();
  
  String getName ();

}
