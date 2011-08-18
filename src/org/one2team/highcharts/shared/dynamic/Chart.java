//File              $Source: /var/lib/cvs2/highcharts-server/src/org/one2team/highcharts/shared/dynamic/Chart.java,v $
//Last modified by  $Author: obt $
//Revision Date     $Revision: 1.1 $
//Tag Name          $Name:  $
//
//Copyright (c) 2000-2011 One2team All Rights Reserved.

package org.one2team.highcharts.shared.dynamic;

import org.one2team.highcharts.shared.ChartOptions;

import com.google.gwt.shared.Array;

public interface Chart {
  
  void _destroy ();
  
  ChartOptions getOptions ();
  
  Array<Series> getSeries ();

}
