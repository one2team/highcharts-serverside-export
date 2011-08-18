//File              $Source: /var/lib/cvs2/highcharts-server/src/org/one2team/highcharts/shared/Chart.java,v $
//Last modified by  $Author: obt $
//Revision Date     $Revision: 1.2 $
//Tag Name          $Name:  $
//
//Copyright (c) 2000-2010 One2team All Rights Reserved.

package org.one2team.highcharts.shared;

import org.one2team.highcharts.shared.SeriesType;


public interface Chart {
  
  int getMarginRight ();

	int getMarginBottom ();

	int getMarginLeft ();

	int getMarginTop ();

	String getZoomType ();

	String getBackgroundColor ();

	String getDefaultSeriesType ();

	Object getRenderTo ();

	int getWidth ();

	int getHeight ();

	Chart setMarginRight (int marginRight);
  
  Chart setMarginBottom (int marginBottom);
  
  Chart setMarginLeft (int marginLeft);
  
  Chart setMarginTop (int marginTop);
  
  Chart setZoomType (String zoomType);
  
  Chart setBackgroundColor (String backgroundColor);
  
  Chart setDefaultSeriesType (SeriesType type);

  Chart setWidth (int width);
  
  Chart setHeight (int height);
  
  
  
}
