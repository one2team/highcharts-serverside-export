package org.one2team.highcharts.server.dynamic;

import org.one2team.highcharts.server.JSMBaseObject;
import org.one2team.highcharts.shared.ChartOptions;
import org.one2team.highcharts.shared.Point;
import org.one2team.highcharts.shared.SeriesType;
import org.one2team.highcharts.shared.dynamic.Chart;
import org.one2team.highcharts.shared.dynamic.Series;
import org.one2team.utils.JSMArray;

import com.google.gwt.shared.Array;

public class JSMChart extends JSMBaseObject implements Chart {
  
  @SuppressWarnings("unchecked")
  public JSMChart (ChartOptions options) {
    this.options = options;
    this.series = new JSMArray<Series> ();
    Array<org.one2team.highcharts.shared.Series> s = options.getSeries ();
    SeriesType dst = SeriesType.valueOf (options.getChart ().getDefaultSeriesType ());
    for (int i = 0; i < s.length (); i ++) {
      org.one2team.highcharts.server.JSMSeries si = (org.one2team.highcharts.server.JSMSeries) s.getItem (i);
      JSMSeries sd = new JSMSeries (si);
      ((JSMArray<Series>) series).pushItem (sd);
      switch (dst) {
        case line:
        case spline:
          sd.setGraph (new JSMElement ());
          //$FALL-THROUGH$
        case area:
        case areaspline:
          sd.setArea (new JSMElement ());
          break;
        default:
          break;
      }
      
      Array<Point> optionsData = si.getData ();
      for (int j = 0; j < optionsData.length (); j ++) {
        sd.getData ().pushItem (new JSMPoint ((org.one2team.highcharts.server.JSMPoint) optionsData.getItem (j)));
      }
    }
  }

  @Override
  public void _destroy () {
    this.destroyed = true;
  }
  
  public boolean isDetroyed (){
    return destroyed;
  }

  @Override
  public ChartOptions getOptions () {
    return options;
  }

  @SuppressWarnings("unchecked")
  @Override
  public JSMArray<Series> getSeries () {
    return (JSMArray<Series>) series;
  }
  
  private Object series;
  
  private ChartOptions options;

  private boolean destroyed;

}
