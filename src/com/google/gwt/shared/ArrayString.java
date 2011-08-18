//File              $Source: /var/lib/cvs2/o3-core/src/com/google/gwt/shared/ArrayString.java,v $
//Last modified by  $Author: obt $
//Revision Date     $Revision: 1.2 $
//Tag Name          $Name:  $
//
//Copyright (c) 2000-2010 One2team All Rights Reserved.

package com.google.gwt.shared;

public interface ArrayString /*extends Array<String>*/ {

  String getItem (int index);

  String join();

  String join(String separator);

  int length();
  
  void pushItem (String value);
  
  void setItem (int index, String value);

  ArrayString pushString (String value);

  ArrayString setString(int index, String value);

  void setLength(int newLength);

  String shiftItem ();

  void unshiftItem (String value);
}
