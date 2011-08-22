package org.one2team.highcharts.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.one2team.highcharts.shared.Legend;


@XmlAccessorType(XmlAccessType.NONE)
public class JSMLegend extends JSMBaseObject implements Legend {

  @Override
  @XmlElement
  public Legend setAlign (String align) {
    this.align = align;
    return this;
  }

  @Override
  @XmlElement
  public Legend setLayout (String layout) {
    this.layout = layout;
    return this;
  }

  @Override
  @XmlElement
  public Legend setVerticalAlign (String verticalAlign) {
    this.verticalAlign = verticalAlign;
    return this;
  }

  @Override
  public Legend setX (int x) {
    this.x = x;
    return this;
  }

  @Override
  public Legend setY (int y) {
    this.y = y;
    return this;
  }

  @Override
  public String getAlign () {
    return align;
  }

  @Override
  public String getLayout () {
    return layout;
  }

  @Override
  public String getVerticalAlign () {
    return verticalAlign;
  }

  @Override
  public int getX () {
    return x;
  }

  @Override
  public int getY () {
    return y;
  }
  
  @Override
  public boolean getEnabled () {
    return enabled;
  }

  @Override
  public Legend setEnabled (boolean enabled) {
    this.enabled = enabled;
    return this;
  }
  
  @Override
  public Legend setReversed (boolean reversed) {
    this.reversed = reversed;
    return this;
  }
  
  @Override
  public boolean isReversed () {
    return reversed;
  }

  public Boolean reversed;
  public Boolean enabled;
  public String align;
  public String layout;
  public String verticalAlign;
  @XmlElement
  public Integer x;
  @XmlElement
  public Integer y;

}
