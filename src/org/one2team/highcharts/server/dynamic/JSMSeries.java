package org.one2team.highcharts.server.dynamic;

import org.one2team.highcharts.server.JSMBaseObject;
import org.one2team.highcharts.shared.dynamic.Point;
import org.one2team.highcharts.shared.dynamic.Series;
import org.one2team.utils.JSMArray;


public class JSMSeries extends JSMBaseObject implements Series {
  
  public JSMSeries (org.one2team.highcharts.server.JSMSeries optionsSeries) {
    this.delegate = optionsSeries;
    this.data = new JSMArray<Point> ();
  }
  
  
  public JSMSeries () {
    this (new org.one2team.highcharts.server.JSMSeries());
  }

  @SuppressWarnings("unchecked")
  @Override
  public JSMArray<Point> getData () {
    return (JSMArray<Point>) data;
  }

  @Override
  public JSMElement getGraph () {
    return graph;
  }
  
  public JSMSeries setGraph (JSMElement graph) {
    this.graph = graph;
    return this;
  }

  @Override
  public JSMElement getArea () {
    return area;
  }
  
  public JSMSeries setArea (JSMElement area) {
    this.area = area;
    return this;
  }
  
  @Override
  public String getName () {
    return delegate.getName ();
  }

  private final org.one2team.highcharts.server.JSMSeries delegate;

  private final Object data;
  
  private JSMElement graph;
  
  private JSMElement area;

}
