package org.one2team.highcharts.shared;

import com.google.gwt.shared.Array;

public interface ChartOptions {
  
  Array<Series> getSeries ();
  
  Axis getXAxis ();
  
  Axis getYAxis ();
  
  Title getTitle ();
  
  Title getSubtitle ();
  
  Legend getLegend ();
  
  Chart getChart ();
  
  PlotOptions getPlotOptions ();
  
  Tooltip getTooltip ();
  
  Labels getLabels ();

  Credits getCredits();
  
}
