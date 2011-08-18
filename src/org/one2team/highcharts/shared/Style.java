//File              $Source: /var/lib/cvs2/highcharts-server/src/org/one2team/highcharts/shared/Style.java,v $
//Last modified by  $Author: obt $
//Revision Date     $Revision: 1.1 $
//Tag Name          $Name:  $
//
//Copyright (c) 2000-2010 One2team All Rights Reserved.

package org.one2team.highcharts.shared;

public interface Style {
  
  Style setProperty(String property, String value);
  
  String getProperty(String property);
}
