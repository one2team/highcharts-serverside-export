package org.one2team.highcharts.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.one2team.highcharts.shared.Axis;
import org.one2team.highcharts.shared.DateTimeLabelFormats;
import org.one2team.highcharts.shared.Style;
import org.one2team.highcharts.shared.Title;
import org.one2team.utils.JSMArrayString;

import com.google.gwt.shared.Array;

@XmlAccessorType(XmlAccessType.NONE)
public class JSMAxis extends JSMBaseObject implements Axis {

	public JSMAxis () {
    this.labels = null;
    this.dateTimeLabelFormats = null;
    this.categories = null;
    this.title = null;
  }

  @Override
  @XmlTransient
  public JSMArrayString getCategories () {
  	if (categories == null)
  		categories = new JSMArrayString ();
    return (JSMArrayString) this.categories;
  }

	@Override
	public int getCategoriesLength () {
		return (categories != null) ? ((JSMArrayString)categories).size () : 0;
	}

  @Override
  public Title getTitle () {
  	if (title == null)
  		title = new JSMTitle ();
    return title;
  }

  @Override
  public Labels getLabels () {
  	if (this.labels == null)
  		this.labels = new JSMLabels ();
    return this.labels;
  }

  @Override
  public Axis setMin (double min) {
    this.min = min;
    return this;
  }
  
  @Override
  public Axis setMax (double max) {
    this.max = max;
    return this;
  }


  @Override
  public Axis setType (String type) {
    this.type = type;
    return this;
  }

  @Override
  public Axis setTickInterval (double tickInterval) {
    this.tickInterval = tickInterval;
    return this;
  }

  @Override
  public Axis setStartOnTick (boolean startOnTick) {
    this.startOnTick = startOnTick;
    return this;
  }

  @Override
  public Axis setShowFirstLabel (boolean showFirstLabel) {
    this.showFirstLabel = showFirstLabel;
    return this;
  }
  
  @Override
  public Axis setPlotLines (Array<PlotLines> plotLines) {
    this.plotLines = plotLines;
    return this;
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public Array<PlotLines> getPlotLines () {
    return (Array<PlotLines>) plotLines;
  }

  @Override
  public DateTimeLabelFormats getDateTimeLabelFormats () {
  	if (dateTimeLabelFormats == null)
  		this.dateTimeLabelFormats = new JSMDateTimeLabelFormats ();
    return dateTimeLabelFormats;
  }

  @Override
  public Axis setMaxZoom (int maxZoom) {
    this.maxZoom = maxZoom;
    return this;
  }

  @Override
  public boolean isShowFirstLabel () {
    return showFirstLabel;
  }

  @Override
  public boolean isStartOnTick () {
    return startOnTick;
  }

  @Override
  public int getMaxZoom () {
    return maxZoom;
  }

  @Override
  public double getMin () {
    return min;
  }
  
  @Override
  public double getMax () {
    return max;
  }

  @Override
  public double getTickInterval () {
    return tickInterval;
  }

  @Override
  public String getType () {
    return type;
  }

  @XmlElement
  public Integer maxZoom;

  @XmlElement
  public Boolean startOnTick;

  @XmlElement
  public Double tickInterval;

  @XmlElement
  public Boolean showFirstLabel;

  @XmlElement
  public Double min;
  
  @XmlElement
  public Double max;

  @XmlElement
  public String type;

  @XmlElement(type = JSMLabels.class)
  public Labels labels;

  public DateTimeLabelFormats dateTimeLabelFormats;

  @XmlTransient
  public Object categories;

  public  Object plotLines;

  public JSMTitle title;
  
  @XmlAccessorType(XmlAccessType.NONE)
  @XmlType(namespace="axis")
  public static class JSMLabels extends JSMBaseObject implements Labels {

    @Override
    public Labels setAlign (String align) {
      this.align = align;
      return this;
    }

    @Override
    public Labels setRotation (double rotation) {
      this.rotation = rotation;
      return this;
    }

		public Double getRotation () {
			return rotation;
		}

		public String getAlign () {
			return align;
		}

		@XmlElement
    public Double rotation;
    @XmlElement
    public String align;

  }
  
  public static class JSMPlotLines extends JSMBaseObject implements PlotLines {
    
    public JSMPlotLines () {
      this.label = new JSMLabel ();
    }
    
    @Override
    public PlotLines setLabel (Label label) {
      this.label = label;
      return this;
    }

    @Override
    public Label getLabel () {
      return label;
    }

    @Override
    public PlotLines setColor (String color) {
      this.color = color;
      return this;
    }

    @Override
    public String getColor () {
      return color;
    }

    @Override
    public PlotLines setDashStyle (String dashStyle) {
      this.dashStyle = dashStyle;
      return this;
    }

    @Override
    public String getDashStyle () {
      return dashStyle;
    }

    @Override
    public PlotLines setId (String id) {
      this.id = id;
      return this;
    }

    @Override
    public String getId () {
      return id;
    }

    @Override
    public PlotLines setValue (double value) {
      this.value = value;
      return this;
    }

    @Override
    public double getValue () {
      return value;
    }

    @Override
    public PlotLines setWidth (int width) {
      this.width = width;
      return this;
    }

    @Override
    public int getWidth () {
      return width;
    }

    @Override
    public PlotLines setZIndex (int zindex) {
      this.zindex = zindex;
      return this;
    }

    @Override
    public int getZIndex () {
      return zindex;
    }

    public int zindex;
    public int width;
    public double value;
    public String id;
    public String color;
    public String dashStyle;
    public Label label;
    
    public static class JSMLabel extends JSMBaseObject implements Label {
      
      public JSMLabel () {
        style = new JSMStyle ();
      }
      @Override
      public Label setAlign (String align) {
        this.align = align;
        return this;
      }

      @Override
      public String getAlign () {
        return align;
      }

      @Override
      public Label setVerticalAlign (String verticalAlign) {
        this.verticalAlign = verticalAlign;
        return this;
      }

      @Override
      public String getVerticalAlign () {
        return verticalAlign;
      }

      @Override
      public Label setRotation (double rotation) {
        this.rotation = rotation;
        return this;
      }

      @Override
      public double getRotation () {
        return rotation;
      }

      @Override
      public Label setText (String text) {
        this.text = text;
        return this;
      }

      @Override
      public String getText () {
        return text;
      }

      @Override
      public Label setTextAlign (String textAlign) {
        this.textAlign = textAlign;
        return this;
      }

      @Override
      public String getTextAlign () {
        return textAlign;
      }

      @Override
      public Label setX (double x) {
        this.x = x;
        return this;
      }

      @Override
      public double getX () {
        return x;
      }

      @Override
      public Label setY (double y) {
        this.y = y;
        return this;
      }

      @Override
      public double getY () {
        return y;
      }
      
      
      @Override
      public Label setStyle (Style style) {
        this.style = style;
        return this;
      }
      
      @Override
      public Style getStyle () {
        return style;
      }

      
      public String align;
      public String verticalAlign;
      public double rotation;
      public String text;
      public String textAlign;
      public double x;
      public double y;
      public Style style;

    }
  }

}
