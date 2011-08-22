package org.one2team.highcharts.shared;

public interface DateTimeLabelFormats {

  enum TimeUnit {
    second, minute, hour, day, week, month, year;
  }
  
  DateTimeLabelFormats set(TimeUnit unit, String format);
  
  String getFormat (TimeUnit unit);
  
}
