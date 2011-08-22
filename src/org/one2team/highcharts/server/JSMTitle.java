package org.one2team.highcharts.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.one2team.highcharts.shared.Style;
import org.one2team.highcharts.shared.Title;


@XmlAccessorType(XmlAccessType.NONE)
public class JSMTitle extends JSMBaseObject implements Title {
  
  public JSMTitle () {
    this.style = null;
    this.text = new String ("");
  }
  
  @Override
  public String getText () {
    return this.text;
  }

  @Override
  public int getMargin () {
    return this.margin;
  }

  @Override
  public Title setMargin (int margin) {
    this.margin = margin;
    return null;
  }

  @Override
  public Title setText (String text) {
    this.text = text;
    return this;
  }
  
  @Override
  public Style getStyle () {
  	if (style == null)
  		style = new JSMStyle ();
    return style;
  }

  @XmlElement
  public String text;
  
  public Style style;

  @XmlElement
  public Integer margin;

}
