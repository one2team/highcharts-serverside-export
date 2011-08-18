//File              $Source: /var/lib/cvs2/o3-core/src/org/one2team/highcharts/shared/SeriesTypeVisitor.java,v $
//Last modified by  $Author: obt $
//Revision Date     $Revision: 1.1 $
//Tag Name          $Name:  $
//
//Copyright (c) 2000-2011 One2team All Rights Reserved.

package org.one2team.highcharts.shared;




public interface SeriesTypeVisitor<IN, OUT> {
  
  OUT visitTable (SeriesType type, IN in);
  
  OUT visitColumn (SeriesType type, IN in);
  
  OUT visitArea (SeriesType type, IN in);
  
  OUT visitAreaspline (SeriesType type, IN in);
  
  OUT visitBar (SeriesType type, IN in);
  
  OUT visitLine (SeriesType type, IN in);
  
  OUT visitPie (SeriesType type, IN in);
  
  OUT visitScatter (SeriesType type, IN in);
  
  OUT visitSpline (SeriesType type, IN in);

}
