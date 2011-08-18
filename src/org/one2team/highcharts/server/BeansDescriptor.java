package org.one2team.highcharts.server;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BeansDescriptor {
	public BeansDescriptor () {
		beansMap = new HashMap<Class<?>,BeansDescriptor.Beans> ();
	}
	
	public Method getGetter (Class<?> beanClass, String property) {
		return getBeans (beanClass).getGetter (property);
	}
	
	public Method getSetter (Class<?> beanClass, String property) {
		return getBeans (beanClass).getSetter (property);
	}
	
	public Field getField (Class<?> beanClass, String property) {
		return getBeans (beanClass).getField (property);
	}
	
	public Object [] getProperties (Class<?> beanClass) {
		return getBeans (beanClass).getProperties ();
	}

	public BeansDescriptor.Beans getBeans (Class<?> beanClass) {
		if (beanClass == null)
			return null;
		final BeansDescriptor.Beans r = beansMap.get (beanClass);
		if (r != null)
			return r;
		return initClass (beanClass, getBeans (beanClass.getSuperclass ()));
	}

	private BeansDescriptor.Beans initClass (Class<?> beanClass, BeansDescriptor.Beans superBeans) {
		BeansDescriptor.Beans beans = Beans.create (beanClass, superBeans);
		beansMap.put (beanClass, beans);
		return beans;
	}
	
	public static BeansDescriptor singleton () {
		return SINGLETON;
	}

	private static class Beans {
		
		private static class Bean {
			Bean () {
			}
			public Bean setField (Field field) {
				this.field = field;
				return this;
			}
			public Bean setGetter (Method getter) {
				this.getter = getter;
				return this;
			}
			public Bean setSetter (Method setter) {
				this.setter = setter;
				return this;
			}
			private Field field;
			private Method getter;
			private Method setter;
		}
		
		static BeansDescriptor.Beans create (Class<?> beanClass, Beans superBeans) {
			Map<String,Bean> beans = new HashMap<String,Bean> ();
			try {
				BeanInfo info = Introspector.getBeanInfo (beanClass);
				PropertyDescriptor[] propertyDescriptors = info.getPropertyDescriptors ();
				for (PropertyDescriptor pty : propertyDescriptors) {
					final String name = pty.getName ();
					if (superBeans != null && superBeans.containsBean (name))
						continue;
					final Bean bean = new Bean ();
					try {
						bean.setField (beanClass.getDeclaredField (name));
					} catch (SecurityException e) {
					} catch (NoSuchFieldException e) {
					}
					if (!PTYEXCEPTIONS.contains (name)) {
						bean.setGetter (pty.getReadMethod ());
						bean.setSetter (getWriteMethod (pty, beanClass));
					}
					beans.put (name, bean);
				}
			} catch (Exception e) {
			} catch (AssertionError e) {
			}

			for (Field f : beanClass.getDeclaredFields ()) {
				final String name = f.getName ();
				if (superBeans != null && superBeans.containsBean (name))
					continue;
				final Bean bean = new Bean ();

				if (!PTYEXCEPTIONS.contains (name)) {
					try {
						bean.setField (beanClass.getDeclaredField (name));
					} catch (SecurityException e) {
					} catch (NoSuchFieldException e) {
					}
				}
				beans.put (name, bean);
			}
			return new Beans (beans, superBeans);
		}

		private static Method getWriteMethod (PropertyDescriptor pty, Class<?> beanClass) {
			Method method = pty.getWriteMethod ();
			if (method != null)
				return method;
			String methodName = getWriteMethodName (pty.getName ());
			for (Method m: beanClass.getMethods ()) {
				if (methodName.equals (m.getName ()))
					return m;
			}
			// System.out.println("No write method <"+beanClass.getName ()+"."+methodName+">");
			return null;
		}
		
		private static String getWriteMethodName (String pty) {
			return "set" + pty.substring (0,1).toUpperCase ()+pty.substring (1);
		}

		Method getGetter (String property) {
			Bean b = getBean (property);
			return (b != null) ? b.getter : null;
//			return getters.get (property);
		}

		Method getSetter (String property) {
			Bean b = getBean (property);
			return (b != null) ? b.setter : null;
//			return setters.get (property);
		}

		Field getField (String property) {
			Bean b = getBean (property);
			return (b != null) ? b.field : null;
//			return setters.get (property);
		}
		
		Object [] getProperties () {
			List<Object> pties = new ArrayList<Object> ();
			Beans cur = this;
			while (cur != null) {
				pties.addAll (cur.beans.keySet ());
				cur = cur.superBeans;
			}
			return pties.toArray ();
		}
		
		private Bean getBean (String name) {
			Bean br = null;
			Beans cur = this;
			while (cur != null && br == null) {
				br = cur.beans.get (name);
				cur = cur.superBeans;
			}
			return br;
		}
		
		private boolean containsBean (String name) {
			Beans cur = this;
			while (cur != null ) {
				if (cur.beans.containsKey (name))
					return true;
				cur = cur.superBeans;
			}
			return false;
		}
		
		private Beans (Map<String,Bean> beans, Beans superBeans) {
			this.beans = beans;
			this.superBeans = superBeans;
		}
		
		private final Map<String,Bean> beans;
		private final Beans superBeans;
	}
	private final Map<Class<?>,BeansDescriptor.Beans> beansMap;

	private static final List<String> PTYEXCEPTIONS = Arrays.asList ("ids", "userObject", "class", "nodeType", "allIds", "parentScope", "innerHTML", "prototype", "__iterator__");


	private static final BeansDescriptor SINGLETON = new BeansDescriptor ();
}