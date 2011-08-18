package org.one2team.highcharts.server.export;

import org.one2team.highcharts.server.JSMHighchartsFactory;
import org.one2team.highcharts.shared.HighchartsFactory;

public class RendererFactory {
	
	public HighchartsFactory createHighchartsFactory () {
		return new JSMHighchartsFactory ();
	}
}
