package org.one2team.highcharts.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.one2team.highcharts.shared.Point;


@XmlAccessorType(XmlAccessType.NONE)
public class JSMPoint extends JSMBaseObject implements Point {
  
  public JSMPoint () {
  }

  @Override
  public double getY () {
    return this.y;
  }

  @Override
  public double getX () {
    return this.x;
  }
  @Override
  public boolean getSelected () {
    return this.selected;
  }
  
  @Override
  public String getColor () {
    return color;
  };

  @Override
  public String getName () {
    return name;
  }
  
  @Override
  public Point setX (double x) {
    this.x = x;
    return this;
  }

  @Override
  public Point setY (double y) {
    this.y = y;
    return this;
  }

  @Override
  public Point setSelected (boolean selected) {
    this.selected = selected;
    return this;
  }
  
  @Override
  public Point setSliced (boolean sliced) {
    this.sliced = sliced;
    return this;
  }
  
  @Override
  public Point setColor (String color) {
    this.color = color;
    return this;
  }
  
  @Override
  public Point setName (String name) {
    this.name = name;
    return this;
  }
  
  @Override
  public boolean isSliced () {
    return sliced;
  }
  
  @XmlElement
  public Double x;
  @XmlElement
  public Double y;
  public Boolean selected, sliced;
  public String color;
  public String name;

}