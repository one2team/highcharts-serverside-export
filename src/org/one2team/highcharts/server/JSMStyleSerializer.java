package org.one2team.highcharts.server;

import java.util.Map;

public class JSMStyleSerializer extends JSMSerializer<JSMStyle> {

	@Override
	public Map<String, String> getProperties (JSMStyle instance) {
		return instance.getProperties ();
	}

}
