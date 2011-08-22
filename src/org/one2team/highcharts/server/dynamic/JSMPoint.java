package org.one2team.highcharts.server.dynamic;

import org.one2team.highcharts.server.JSMBaseObject;
import org.one2team.highcharts.shared.dynamic.Point;

public class JSMPoint extends JSMBaseObject implements Point {
  
  public JSMPoint (org.one2team.highcharts.server.JSMPoint optionsPoint) {
    this.delegate = optionsPoint;
    this.graphic = new JSMElement ();
  }
  
  public JSMPoint () {
    this (new org.one2team.highcharts.server.JSMPoint ());
  }

  @Override
  public double getX () {
    return delegate.getX ();
  }

  public JSMPoint setX (double x) {
    this.delegate.setX (x);
    return this;
  }

  @Override
  public double getY () {
    return delegate.getY ();
  }
  
  @Override
  public String getColor () {
    return delegate.getColor ();
  }

  public JSMPoint setY (double y) {
    this.delegate.setY (y);
    return this;
  }
  
  @Override
  public JSMElement getGraphic () {
    return graphic;
  }

  public JSMPoint setGraphic (JSMElement graphic) {
    this.graphic = graphic;
    return this;
  }

  @Override
  public void selectPoint (boolean select, boolean accumulate) {
    isSelected = select;
  }
  
  boolean isSelected () {
    return isSelected;
  }

  private JSMElement graphic;
  
  private org.one2team.highcharts.server.JSMPoint delegate;
  
  private boolean isSelected;

}
