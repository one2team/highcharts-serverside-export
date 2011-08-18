package com.google.gwt.shared;

public interface Array<E> {

  int length ();
  
  E getItem (int index);
  
  // Javascript compatibles signatures : setItem / pushItem
  void setItem (int index, E value);
  
  void pushItem (E value);
  
  // Java compatible signatures : setElement / pushElement : same behavior as setItem / pushItem
  Array<E> setElement (int index, E value);
  
  Array<E> pushElement (E value);
  
}
