package org.one2team.highcharts.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.mozilla.javascript.Scriptable;
import org.one2team.highcharts.shared.DateTimeLabelFormats;


public class JSMDateTimeLabelFormats extends JSMBaseObject implements DateTimeLabelFormats {

  public JSMDateTimeLabelFormats () {
    formats = null;
  }
  
  @Override
  public JSMDateTimeLabelFormats set (TimeUnit unit, String format) {
  	if (formats == null)
  		formats = new HashMap<TimeUnit,String> ();
    formats.put (unit, format);
    return this;
  }

  @Override
  public String getFormat (TimeUnit unit) {
    return (formats != null) ? formats.get (unit) : null;
  }
  
  public Map<TimeUnit,String> getFormats () {
  	return formats;
  }

	@Override
	public Object[] getIds () {
		if (formats == null)
			return new Object [0];
		final Set<TimeUnit> keys = formats.keySet ();
		Object[] ids = new Object[keys.size ()];
		int count = 0;
		for (TimeUnit tu: keys) {
			ids[count++] = tu.name ();
		}
		return ids;
	}

	@Override
	public Object get (String name, Scriptable start) {
		if (formats == null)
			return null;
		return get (name);
		
	}

	@Override
	public boolean has (String name, Scriptable start) {
		return (null != get (name));
	}

	private Object get (String name) {
		if (formats == null)
			return null;
		final Set<TimeUnit> keys = formats.keySet ();
		for (TimeUnit tu: keys) {
			if (tu.name ().equals (name))
				return formats.get (tu);
		}
		return null;
	}

  private Map<TimeUnit,String> formats;

}
