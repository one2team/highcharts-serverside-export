package org.one2team.highcharts.server;

import org.one2team.highcharts.shared.Chart;
import org.one2team.highcharts.shared.SeriesType;


public class JSMChart extends JSMBaseObject implements Chart {
	@Override
  public Chart setMarginBottom (int marginBottom) {
    this.marginBottom = marginBottom;
    return this;
  }

  @Override
  public Chart setMarginRight (int marginRight) {
    this.marginRight = marginRight;
    return this;
  }

  @Override
  public Chart setZoomType (String zoomType) {
    this.zoomType = zoomType;
    return this;
  }

  @Override
  public String getZoomType () {
    return zoomType;
  }

  @Override
  public int getMarginRight () {
    return marginRight;
  }

  @Override
  public int getMarginBottom () {
    return marginBottom;
  }

  @Override
  public Object getRenderTo () {
    return renderTo;
  }

  public void setRenderTo (Object renderTo) {
		this.renderTo = renderTo;
	}
  
  @Override
  public Chart setBackgroundColor (String backgroundColor) {
    this.backgroundColor = backgroundColor;
    return this;
  }
  
  @Override
  public String getBackgroundColor () {
    return backgroundColor;
  }

  @Override
  public Chart setDefaultSeriesType (SeriesType type) {
    defaultSeriesType = type.name ();
    return this;
  }
  
  @Override
  public String getDefaultSeriesType () {
  	System.out.println("defaultSeriesType "+defaultSeriesType);
    return defaultSeriesType;
  }
  
	@Override
	public JSMChart setWidth(int width) {
		this.width = width;
		return this;
	}

	@Override
	public int getWidth() {
		return this.width;
	}
	@Override
	public JSMChart setHeight(int height) {
		this.height = height;
		return this;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

  @Override
  public Chart setMarginLeft (int marginLeft) {
    this.marginLeft = marginLeft;
    return this;
  }

  @Override
  public int getMarginLeft () {
    return marginLeft;
  }

  @Override
  public Chart setMarginTop (int marginTop) {
    this.marginTop = marginTop;
    return this;
  }

  @Override
  public int getMarginTop () {
    return marginTop;
  }

	public void setRenderer (Object renderer) {
		this.renderer = renderer;
	}

	public Object getRenderer () {
		return renderer;
	}

	public String zoomType;
  public String backgroundColor;
  public Integer marginRight;
  public Integer marginBottom;
  public Integer width;
  public Integer height;
  public String defaultSeriesType;
  public int marginLeft;
  public int marginTop;
  public Object renderTo;
  public Object renderer;

}
