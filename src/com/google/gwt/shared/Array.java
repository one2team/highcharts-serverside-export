//File              $Source: /var/lib/cvs2/o3-core/src/com/google/gwt/shared/Array.java,v $
//Last modified by  $Author: obt $
//Revision Date     $Revision: 1.2 $
//Tag Name          $Name:  $
//
//Copyright (c) 2000 One2team All Rights Reserved.

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
