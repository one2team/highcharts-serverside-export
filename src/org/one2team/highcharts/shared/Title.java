//File              $Source: /var/lib/cvs2/highcharts-server/src/org/one2team/highcharts/shared/Title.java,v $
//Last modified by  $Author: obt $
//Revision Date     $Revision: 1.1 $
//Tag Name          $Name:  $
//
//Copyright (c) 2000-2010 One2team All Rights Reserved.

package org.one2team.highcharts.shared;



public interface Title {

  String getText ();

  int getMargin ();
  
  Title setText (String text);

  Title setMargin (int i);
  
  Style getStyle ();
  
}
