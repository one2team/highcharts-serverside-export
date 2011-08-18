//File              $Source: /var/lib/cvs2/highcharts-server/src/org/one2team/highcharts/shared/ChartOptions.java,v $
//Last modified by  $Author: obt $
//Revision Date     $Revision: 1.1 $
//Tag Name          $Name:  $
//
//Copyright (c) 2000-2010 One2team All Rights Reserved.

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
