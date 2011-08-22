package org.one2team.highcharts.shared.dynamic;

import org.one2team.highcharts.shared.ChartOptions;

import com.google.gwt.shared.Array;

public interface Chart {
  
  void _destroy ();
  
  ChartOptions getOptions ();
  
  Array<Series> getSeries ();

}
