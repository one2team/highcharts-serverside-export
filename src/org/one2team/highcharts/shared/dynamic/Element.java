//File              $Source: /var/lib/cvs2/highcharts-server/src/org/one2team/highcharts/shared/dynamic/Element.java,v $
//Last modified by  $Author: obt $
//Revision Date     $Revision: 1.1 $
//Tag Name          $Name:  $
//
//Copyright (c) 2000-2011 One2team All Rights Reserved.

package org.one2team.highcharts.shared.dynamic;

public interface Element {
  
  void attr (String property, String value);
  
  String ATTR_FILL = "fill";
  
  String ATTR_STROKE = "stroke";
  
}
