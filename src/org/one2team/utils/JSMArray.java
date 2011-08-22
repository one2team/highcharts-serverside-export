package org.one2team.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.one2team.highcharts.server.BeansDescriptor;

import com.google.gwt.shared.Array;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class JSMArray<E> extends ArrayList<E> implements Array<E>, Scriptable {

  private static final long serialVersionUID = 1L;

  public JSMArray () {
//    list = new ArrayList<E> ();
  }
  
  @Override
  public E getItem (int index) {
    return get (index);
  }

  @Override
  public int length () {
    return size ();
  }

  public Integer getLength () {
    return size ();
  }

  @Override
  public JSMArray<E> setElement (int index, E value) {
  	setItem (index, value);
  	return this;
  }

  @Override
  public void setItem (int index, E value) {
    if (size() > index)
      set (index, value);
    else if (size () == index)
      add (index, value);
    else {
      while (size () < index)
        add (null);
      add (index, value);
    }
  }

  @Override
  public JSMArray<E> pushElement (E value) {
  	pushItem (value);
  	return this;
  }

  @Override
  public void pushItem (E value) {
    add (value);
  }

	@Override
	public String getClassName () {
		return "Array";
	}

	@Override
	public Object get (String name, Scriptable start) {

		final Method getter = BeansDescriptor.singleton ().getGetter (getClass(), name);
		if (getter == null)
			return Undefined.instance;;
		try {
			return getter.invoke (this, new Object [0]);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		// System.out.println("undefined "+getClass ()+";"+name);
		return Undefined.instance;
	}

	@Override
	public Object get (int index, Scriptable start) {
		final E item = getItem (index);
		// System.out.println("array {length:"+length ()+"} ["+index+"] : "+item);
		return item;
	}

	@Override
	public boolean has (String name, Scriptable start) {
		return null != BeansDescriptor.singleton ().getGetter (getClass(), name);
	}

	@Override
	public boolean has (int index, Scriptable start) {
		return (0<=index && index < length ());
	}

	@Override
	public void put (String name, Scriptable start, Object value) {
		
	}

	@Override
	public void put (int index, Scriptable start, Object value) {
		// System.out.println("put {length:"+length ()+"} ["+index+"]");
		
	}

	@Override
	public void delete (String name) {
		
	}

	@Override
	public void delete (int index) {
		
	}

	@Override
	public Scriptable getPrototype () {
		return null;
	}

	@Override
	public void setPrototype (Scriptable prototype) {
		
	}

	@Override
	public Scriptable getParentScope () {
		return null;
	}

	@Override
	public void setParentScope (Scriptable parent) {
	}

	@Override
	public Object[] getIds () {

    Object[] result = new Object[length ()];
    int i = length ();
    while (--i >= 0)
        result[i] = new Integer(i);
    return result;
	}

	@Override
	public Object getDefaultValue (Class<?> hint) {
		return null;
	}

	@Override
	public boolean hasInstance (Scriptable instance) {
		return false;
	};
}
