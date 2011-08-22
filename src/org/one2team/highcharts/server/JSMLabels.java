package org.one2team.highcharts.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.one2team.highcharts.shared.Labels;
import org.one2team.highcharts.shared.Style;
import org.one2team.utils.JSMArray;


@XmlAccessorType(XmlAccessType.NONE)
@XmlType(namespace="chart-options")
public class JSMLabels extends JSMBaseObject implements Labels {

  public JSMLabels () {
  }
  
  @SuppressWarnings("unchecked")
  @Override
  @XmlTransient
  public JSMArray<Items> getItems () {
    if (items == null)
      items = new JSMArray<Items> ();
    
    return (JSMArray<Items>) items;
  }
  
  @XmlAccessorType(XmlAccessType.NONE)
  @XmlType(namespace="labels")
  public static class JSMItems implements Items {

    public JSMItems () {
      this.style = new JSMStyle ();
    }

    @Override
    public String getHtml () {
      return this.html;
    }
    
    @Override
    public Items setHtml (String html) {
      this.html = html;
      return this;
    }

    @Override
    public Style getStyle () {
      return style;
    }
    
    @Override
    public Items center (int centerPosition, double top) {
      getStyle ().setProperty ("left", centerPosition - (getHtml ().length () * 6) / 2 + "px");
      getStyle ().setProperty ("top", top + "px");
      return this;
    }

    private String html;

    private Style style;

  }

  @XmlTransient
  private Object items;
  
}
