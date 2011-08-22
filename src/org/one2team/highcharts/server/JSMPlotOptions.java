package org.one2team.highcharts.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.one2team.highcharts.shared.PlotOptions;

@XmlAccessorType(XmlAccessType.NONE)
public class JSMPlotOptions extends JSMBaseObject implements PlotOptions {

	public JSMPlotOptions () {
    this.area = new JSMSeries ();
    this.areaspline = new JSMSeries ();
    this.bar = new JSMSeries ();
    this.column = new JSMSeries ();
    this.line = new JSMSeries ();
    this.pie = new JSMSeries ();
    this.series = new JSMSeries ();
    this.spline = new JSMSeries ();
  }

  @Override
  public JSMSeries getArea () {
    return area;
  }

  @Override
  public JSMSeries getAreaspline () {
    return areaspline;
  }

  @Override
  public JSMSeries getBar () {
    return bar;
  }

  @Override
  public JSMSeries getColumn () {
    return column;
  }

  @Override
  public JSMSeries getLine () {
    return line;
  }

  @Override
  public JSMSeries getPie () {
    return pie;
  }

  @Override
  public JSMSeries getSeries () {
    return this.series;
  }

  @Override
  public JSMSeries getSpline () {
    return this.spline;
  }
  
  @XmlType(namespace="plotoptions")
  @XmlAccessorType(XmlAccessType.NONE)
  public static class JSMSeries extends JSMBaseObject implements Series {
  
    public JSMSeries () {
    }
  	
  	@SuppressWarnings("unchecked")
		protected <T> T cast () {
  		return (T) this;
  	}
    
    @Override
    public String getStacking () {
      return this.stacking;
    }
  
    @Override
    public boolean isAllowPointSelect () {
      return this.allowPointSelect;
    }
  
    @Override
    public JSMSeries setAllowPointSelect (boolean allowPointSelect) {
      this.allowPointSelect = allowPointSelect;
			return this;
    }
  
    @Override
    @XmlElement
    public JSMSeries setStacking (String stacking) {
      this.stacking = stacking;
			return this;
    }
    
    @Override
    public Marker getMarker () {
    	if (this.marker == null)
    		this.marker = new JSMMarker ();
      return marker;
    }
    
    @Override
    public double getFillOpacity () {
      return fillOpacity;
    }
    
    @Override
    public JSMSeries setFillOpacity (double fillOpacity) {
      this.fillOpacity = fillOpacity;
			return this;
    }
    
    @Override
    public JSMDataLabels getDataLabels () {
    	if (this.dataLabels == null)
    		this.dataLabels = new JSMDataLabels ();
      return dataLabels;
    }
  
    @Override
    public JSMSeries setStates (States states) {
      this.states = states;
			return this;
    }
    
    @Override
    public States getStates () {
    	if (this.states == null)
        this.states = new JSMStates ();
      return this.states;
    }

		@Override
		public boolean isShadow() {
			// TODO Auto-generated method stub
			return shadow;
		}

		@Override
		public int getLineWidth() {
			return lineWidth;
		}

		@Override
		public JSMSeries setShadow(boolean shadow) {
			this.shadow = shadow;
			return this;
		}

		@Override
		public JSMSeries setLineWidth(int lineWidth) {
			this.lineWidth = lineWidth;
			return this;
		}

		@Override
		public JSMSeries setBorderWidth(int borderWidth) {
			this.borderWidth = borderWidth;
			return this;
		}

		@Override
		public int getBorderWidth() {
			return borderWidth;
		}
  
    @XmlElement(type = JSMStates.class)
    public States states;
    
    public JSMDataLabels dataLabels;
  
    public String stacking;
  
    public Marker marker; 
    
    @XmlElement
    public Boolean allowPointSelect;
    
    @XmlElement
    public Boolean shadow;
    
    @XmlElement
    public Integer lineWidth;
    
    @XmlElement
    public Double fillOpacity;
	
		public int borderWidth;
    
    public static class JSMStates extends JSMBaseObject implements States {
  
      public JSMStates () {
      }
      
      @Override
      public JSMSelect getSelect () {
      	if (this.select == null)
      		this.select = new JSMSelect ();
        return select;
      }
      
      @XmlElement(type=JSMSelect.class)
      public JSMSelect select;
  
      @XmlAccessorType(XmlAccessType.NONE)
      public static class JSMSelect extends JSMBaseObject implements Select{
        @Override
        public String getBorderColor () {
          return borderColor;
        }
        
        @Override
        public int getBorderWidth () {
          return borderWidth;
        }
        
        @Override
        public String getColor () {
          return color;
        }
        
        @Override
        public Select setBorderColor (String borderColor) {
          this.borderColor=borderColor;
          return this;
        }
        
        @Override
        public Select setBorderWidth (int borderWidth) {
          this.borderWidth=borderWidth;
          return this;
        }
        
        @Override
        public Select setColor (String color) {
          this.color=color;
          return this;
        }
        
        public String color;
        public String borderColor;
        @XmlElement
        public Integer borderWidth;
        
      }
    }
    
    public static class JSMDataLabels extends JSMBaseObject implements DataLabels {
  
      @Override
      public JSMDataLabels setColor (String color) {
        this.color = color;
        return this;
      }
      
      @Override
      public DataLabels setDistance (int distance) {
        this.distance = distance;
        return this;
      }
      
      @Override
      public DataLabels setEnabled (boolean enabled) {
        this.enabled = enabled;
        return this;
      }
  
      @Override
      public DataLabels setFormatter (Object formatter) {
        this.formatter = formatter;
        return this;
      }
  
      @Override
      public DataLabels setAlign (String align) {
        this.align = align;
        return this;
      }

      @Override
      public DataLabels setRotation (double rotation) {
        this.rotation = rotation;
        return this;
      }

      @Override
      public String getColor () {
        return color;
      }
      
      @Override
      public int getDistance () {
        return distance;
      }
      
      @Override
      public boolean isEnabled () {
        return enabled;
      }
      
      @Override
      public Object getFormatter () {
        return formatter;
      }

			@Override
			public DataLabels setY (int y) {
				this.y = y;
				return this;
			}

			@Override
			public int getY () {
				return y;
			}

			@Override
			public DataLabels setX (int x) {
				this.x = x;
				return this;
			}

			@Override
			public int getX () {
				return x;
			}
      
      @Override
      public String getAlign () {
        return align;
      }

      @Override
      public double getRotation () {
        return rotation;
      }

      public String color;
      
      public boolean enabled;
  
      public Object formatter;
  
      public Integer x, y, distance;
      
      public String align = "center";
      
      public double rotation;
  
    }
    
    public static class JSMMarker extends JSMBaseObject implements Marker {
  
      public JSMMarker () {
      }
      
      @Override
      public Marker setEnabled (boolean enabled) {
        this.enabled = enabled;
        return this;
      }
  
      @Override
      public JSMStates getStates () {
      	if (this.states == null)
          this.states = new JSMStates ();
        return states;
      }
      
      @Override
      public boolean isEnabled () {
        return enabled;
      }
      
      @Override
      public String getSymbol () {
        return symbol;
      }
      
      @Override
      public Marker setSymbol (String symbol) {
        this.symbol = symbol;
        return this;
      }
      
      public String symbol;
      
      public boolean enabled;
      
      public JSMStates states;
      
      public static class JSMStates extends JSMBaseObject implements States {
  
        public JSMStates () {
          select = new JSMSelect ();
          hover = new JSMHover ();
        }
        
        @Override
        public JSMSelect getSelect () {
          return select;
        }
        
        @Override
        public JSMHover getHover () {
          return hover;
        }
        
        public JSMSelect select;
        
        public JSMHover hover;
        
        public static class JSMHover extends JSMBaseObject implements Hover {
  
          @Override
          public Hover setEnabled (boolean enabled) {
            this.enabled = enabled;
            return this;
          }
          @Override
          public boolean isEnabled () {
            return enabled;
          }
          
          public boolean enabled;
        }
        
        public static class JSMSelect extends JSMBaseObject implements Select {
          
          @Override
          public Select setFillColor (String fillColor) {
            this.fillColor = fillColor;
            return this;
          }
          
          @Override
          public Select setLineWidth (int lineWidth) {
            this.lineWidth = lineWidth;
            return this;
          }
          
          @Override
          public Select setLineColor (String lineColor) {
            this.lineColor = lineColor;
            return this;
          }
          
          @Override
          public String getFillColor () {
            return fillColor;
          }
          
          @Override
          public String getLineColor () {
            return lineColor;
          }
          
          @Override
          public int getLineWidth () {
            return lineWidth;
          }
          
          public String fillColor, lineColor;
          
          public int lineWidth;
          
        }
      }
    }
  }

  @XmlElement
  public final JSMSeries area, areaspline, line, pie, series, spline;
  
  public JSMSeries column, bar;
}
