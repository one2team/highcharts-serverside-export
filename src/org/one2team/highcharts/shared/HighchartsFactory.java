package org.one2team.highcharts.shared;

public interface HighchartsFactory {
	
  ChartOptions createChartOptions ();

  Series createSeries ();

  Point createPoint ();

}
