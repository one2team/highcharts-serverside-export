package org.one2team.highcharts.shared;

import com.google.gwt.shared.Array;


public interface Labels {
  
  Array<Items> getItems ();
  
  public interface Items {
    
    String getHtml ();
    
    Items setHtml (String html);
    
    Style getStyle ();

    Items center (int centerPosition, double top);

  }

}
