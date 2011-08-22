package org.one2team.highcharts.server;

import java.util.HashMap;
import java.util.Map;

import org.mozilla.javascript.Scriptable;
import org.one2team.highcharts.shared.Style;


public class JSMStyle extends JSMBaseObject implements Style {
	
	public JSMStyle () {
		properties = null;
	}

	@Override
	public Style setProperty (String property, String value) {
		if (properties == null)
			properties = new HashMap<String, String> ();
		properties.put (property, value);
		return this;
	}
  
  @Override
  public String getProperty (String property) {
    return (properties != null) ? properties.get (property) : null;
  }
  
	public Map<String, String> getProperties () {
		return properties;
	}

	@Override
	public Object[] getIds () {
		if (properties == null)
			return new Object [0];
		return properties.keySet ().toArray ();
	}

	@Override
	public Object get (String name, Scriptable start) {
		if (properties == null)
			return null;

		return properties.get (name);
	}


	@Override
	public boolean has (String name, Scriptable start) {
		return properties != null && properties.containsKey (name);
	}

	@Override
	public void put (String name, Scriptable start, Object value) {
		setProperty (name, (String) value);
	}

	private Map<String, String> properties;

}
