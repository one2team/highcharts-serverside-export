package org.one2team.highcharts.server.export.util;

import org.mozilla.javascript.ScriptableObject;

public class SVGRendererInternalJson extends SVGRendererInternal<String> {

	@Override
	protected Object callJavascript (final String generalOptions, final String chartOptions) {
		return ScriptableObject.callMethod (null, SCRIPTABLE, "renderSVGFromJson",  new Object [] {'(' + generalOptions + ')', '(' + chartOptions + ')'});
	}

}
