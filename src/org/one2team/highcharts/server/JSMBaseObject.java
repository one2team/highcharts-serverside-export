package org.one2team.highcharts.server;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.one2team.highcharts.shared.Jsonify;


@XmlAccessorType(XmlAccessType.NONE)
public class JSMBaseObject implements Scriptable, Jsonify {

  public JSMBaseObject () {
    super ();
    this.userObject = null;
  }

  @SuppressWarnings("unchecked")
  public <T> T getUserObject () {
    return (T) this.userObject;
  }

  public void setUserObject (Object userObject) {
    this.userObject = userObject;
  }

	public void setInnerHTML (Object innerHTML) {
		this.innerHTML = innerHTML;
	}

	public Object getInnerHTML () {
		return innerHTML;
	}

  @XmlTransient
  public Object innerHTML;
  
  @XmlTransient
  public Object userObject;

	@Override
	public String getClassName () {
		return getClass ().getName ();
	}

	@Override
	public Object get (String name, Scriptable start) {
		Object result = null;
		Field f = getPropertyField (name);
		if (f != null) {
			try {
				result = f.get (this);
			} catch (IllegalArgumentException e) {
				result = Undefined.instance;
			} catch (IllegalAccessException e) {
				result = Undefined.instance;
			}
		} else {
			final Method getter = getPropertyGetter (name);
			if (getter == null) {
	//			// System.out.println("no getter for "+getClass ()+"."+name);
	//			new RuntimeException ().printStackTrace ();
				// System.out.println(getClass().toString ()+";get;"+name+";"+"getter-null"+";"+Undefined.instance.toString ()+";"+Undefined.instance.getClass ().toString ());
				return Undefined.instance;
			}
			try {
				result = getter.invoke (this, new Object [0]);
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
				e.printStackTrace();
	//			// System.out.println("coucou");
			}
	//		// System.out.println("undefined "+getClass ()+";"+name);
		}
		result = (result!=null) ? result : Undefined.instance;
		// System.out.println(getClass().toString ()+";get;"+name+";"+trace+";"+result.toString ()+";"+result.getClass ().toString ());
		return result;
	}

	@Override
	public Object get (int index, Scriptable start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean has (String name, Scriptable start) {
		// System.out.println(getClass().toString ()+";has;"+name);
		Field f = getPropertyField (name);
		if (f != null)
			return true;
		return (null != getPropertyGetter (name));
	}

	@Override
	public boolean has (int index, Scriptable start) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void put (String name, Scriptable start, Object value) {
		Field f = getPropertyField (name);
		if (f != null) {
			try {
				f.set (this, value);
			} catch (IllegalArgumentException e) {
			} catch (IllegalAccessException e) {
			}
			return;
		}
		Method setter = getPropertySetter (name);
		if (setter == null) {
			// System.out.println("no setter for "+getClass ()+"."+name);
		}
		try {
			setter.invoke (this, new Object[] {value});
		} catch (Exception e) {
			throw new RuntimeException (e);
		}
		/*
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

	@Override
	public void put (int index, Scriptable start, Object value) {
	}

	@Override
	public void delete (String name) {
		// System.out.println("delete<"+getClass()+";"+name+";");
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Scriptable getParentScope () {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParentScope (Scriptable parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] getIds () {
		// System.out.println(getClass().toString ()+";getIds");
		return BeansDescriptor.singleton ().getProperties (getClass());
	}

	@Override
	public Object getDefaultValue (Class<?> hint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasInstance (Scriptable instance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toJson () {
		return GsonHelper.toJson(this);
	}

	private Field getPropertyField (String property) {
		final Class<? extends JSMBaseObject> class1 = getClass ();
		
		final Field field = BeansDescriptor.singleton ().getField (class1, property);
		return field;
	}

	private Method getPropertyGetter (String property) {
		final Class<? extends JSMBaseObject> class1 = getClass ();
		
		final Method getter = BeansDescriptor.singleton ().getGetter (class1, property);
		return getter;
	}

	private Method getPropertySetter (String property) {
		final Class<? extends JSMBaseObject> class1 = getClass ();
		
		final Method setter = BeansDescriptor.singleton ().getSetter (class1, property);
//		// System.out.println("setter<"+class1+";"+property+";"+setter);
		return setter;
	}

}