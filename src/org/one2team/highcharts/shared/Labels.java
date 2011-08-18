//File              $Source: /var/lib/cvs2/highcharts-server/src/org/one2team/highcharts/shared/Labels.java,v $
//Last modified by  $Author: obt $
//Revision Date     $Revision: 1.1 $
//Tag Name          $Name:  $
//
//Copyright (c) 2000-2011 One2team All Rights Reserved.

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
