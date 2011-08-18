//File              $Source: /var/lib/cvs2/highcharts-server/src/org/one2team/highcharts/shared/DateTimeLabelFormats.java,v $
//Last modified by  $Author: obt $
//Revision Date     $Revision: 1.1 $
//Tag Name          $Name:  $
//
//Copyright (c) 2000-2010 One2team All Rights Reserved.

package org.one2team.highcharts.shared;

public interface DateTimeLabelFormats {

  enum TimeUnit {
    second, minute, hour, day, week, month, year;
  }
  
  DateTimeLabelFormats set(TimeUnit unit, String format);
  
  String getFormat (TimeUnit unit);
  
}
