package org.one2team.highcharts.shared;

import com.google.gwt.shared.Array;
import com.google.gwt.shared.ArrayString;

public interface Axis {
  
  enum Type {
    linear, datetime;
  }

  Title getTitle ();

  Labels getLabels ();
  
  DateTimeLabelFormats getDateTimeLabelFormats ();

  <T> T getUserObject ();

  ArrayString getCategories ();

  int getCategoriesLength ();

  Array<PlotLines> getPlotLines();

	int getMaxZoom ();

	double getMin ();

	double getMax ();

	boolean isShowFirstLabel ();

	boolean isStartOnTick ();

	double getTickInterval ();

	String getType ();

	Axis setMin (double min);
  
  Axis setMax (double max);

  Axis setType (String type);

  Axis setTickInterval (double tickInterval);

  Axis setStartOnTick (boolean startOnTick);

  Axis setShowFirstLabel (boolean showFirstLabel);

  void setUserObject (Object userObject);
  
  Axis setMaxZoom (int maxZoom);
  
  Axis setPlotLines (Array<PlotLines> plotLines);
  
  public interface Labels {
    
    Labels setAlign (String align);
    
    Labels setRotation (double r);

  }
  
  public interface PlotLines {
    
    Label getLabel();

		String getColor();

		String getDashStyle();

		String getId();

		double getValue();

		int getWidth();

		int getZIndex();

		PlotLines setLabel (Label label);
    
    PlotLines setColor (String color);
    
    PlotLines setDashStyle (String dashStyle);
    
    PlotLines setId (String id);
    
    PlotLines setValue (double value);
    
    PlotLines setWidth (int width);
    
    PlotLines setZIndex (int zindex);
    
    public interface Label {
      
      String getAlign();

			String getVerticalAlign();

			double getRotation();

			String getText();

			String getTextAlign();

			double getX();

			double getY();

			Style getStyle();

			Label setAlign (String align);
      
      Label setVerticalAlign (String verticalAlign);
      
      Label setRotation (double rotation);
      
      Label setText (String text);
      
      Label setTextAlign (String textAlign);
      
      Label setX (double x);
      
      Label setY (double y);

      Label setStyle(Style style);
      
    }
    
  }

}
