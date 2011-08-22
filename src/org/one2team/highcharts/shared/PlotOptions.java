package org.one2team.highcharts.shared;

public interface PlotOptions {

	Series getArea();

	Series getAreaspline();

	Series getBar ();
	
	Series getColumn ();
  
	Series getLine ();
  
	Series getPie ();
  
	Series getSeries ();
  
	Series getSpline ();

	public interface Series {
    
    Marker getMarker ();
    
    String getStacking ();
    
    States getStates();
    
    double getFillOpacity();
    
    boolean isAllowPointSelect ();
    
    DataLabels getDataLabels ();
    
    boolean isShadow ();
    
    int getLineWidth ();
    
    Series setStates (States states);
    
    Series setStacking (String stacking);
    
    Series setFillOpacity (double fillOpacity);
    
    Series setAllowPointSelect (boolean allowPointSelect);
    
    Series setShadow (boolean shadow);
    
    Series setLineWidth (int lineWidth);
    
  	Series setBorderWidth (int borderWidth);
    
    int getBorderWidth ();
    
    public interface States {
      
      Select getSelect ();
      
      public interface Select {
        
        String getBorderColor ();

        String getColor ();

        int getBorderWidth ();
        
        Select setBorderColor (String borderColor);
        
        Select setColor (String color);
        
        Select setBorderWidth (int borderWidth);
      }
      
    }
    
    public interface DataLabels {

      DataLabels setColor (String color);
      
      DataLabels setDistance (int distance);

      DataLabels setEnabled (boolean enabled);

      DataLabels setFormatter (Object createBasicPercentFormatter);

      DataLabels setY (int y);

      DataLabels setX (int x);
      
      DataLabels setAlign (String align);
      
      DataLabels setRotation (double rotation);
      
      String getColor ();

      int getDistance ();

      boolean isEnabled ();

      Object getFormatter ();

      int getY ();

      int getX ();

      double getRotation ();
      
      String getAlign ();

      
    }
    
    public interface Marker {
      
      boolean isEnabled ();
      
      Marker setEnabled (boolean enabled);
      
      States getStates ();
      
      Marker setSymbol (String symbol);
      
      String getSymbol ();
      
      public interface States {
        
        Select getSelect ();
        
        Hover getHover ();
        
        public interface Hover {
          
          boolean isEnabled ();
          
          Hover setEnabled (boolean enabled);

        }
        
        public interface Select {
          
          Select setFillColor (String fillColor);
          
          Select setLineWidth (int lineWidth);
          
          Select setLineColor (String lineColor);
          
          String getFillColor ();
          
          String getLineColor ();
          
          int getLineWidth ();

        }

      }
    }
    
  }
  
}
