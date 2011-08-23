package org.one2team.highcharts.server.export.util;

import org.mozilla.javascript.tools.debugger.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SVGHighchartsHelper {

	SVGHighchartsHelper() {
	}
  
  public static String jsonifyDefaultGeneralOptions () {
  	StringBuilder sb = new StringBuilder ();
  	sb.append("{ 'global':{'useUTC':false}}");
  	return sb.toString ();
  }
  
  static final boolean DEBUG = false;

  static final boolean HIGHCHARTS_2_1_2 = true;

  static Main rhinoDebugger;

  static final Logger LOGGER = LoggerFactory.getLogger (SVGHighchartsHelper.class);

}
