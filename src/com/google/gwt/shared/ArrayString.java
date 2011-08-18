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
