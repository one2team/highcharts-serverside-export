package org.one2team.highcharts.server.export.util;

import java.io.IOException;

import org.mozilla.javascript.tools.debugger.Main;
import org.one2team.highcharts.server.JSMDateTimeLabelFormats;
import org.one2team.highcharts.server.JSMDateTimeLabelFormatsSerializer;
import org.one2team.highcharts.server.JSMStyle;
import org.one2team.highcharts.server.JSMStyleSerializer;
import org.one2team.highcharts.shared.ChartOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SVGHighchartsHelper {

	SVGHighchartsHelper() {
	}
	
	public static String getSVG (final String generalOptions, final ChartOptions chartOptions) throws IOException {
  	return SVG_RENDERER_INTERNAL.getSVG (generalOptions, chartOptions);
  }
  
  public static String jsonify(Object o) {
  	return GSON.toJson(o);
  }
  
  public static String jsonifyDefaultGeneralOptions () {
  	StringBuilder sb = new StringBuilder ();
  	sb.append("{ 'global':{'useUTC':false}}");
  	return sb.toString ();
//  HighchartsLangInternat li = AtomServlet.getHighchartsLangInternat ();
//  StringBuilder sb = new StringBuilder ();
//  sb.append ("{'lang':{")
//  .append("'months': ").append (HighchartsDateFormat.months.asJson (li))
//  .append(", 'weekdays': ").append (HighchartsDateFormat.days.asJson (li))
//  .append("}, 'global':{'useUTC':false}}");
//  	return sb.toString ();
  }
  
  private static Gson createGson () {
  	GsonBuilder builder = new GsonBuilder();
  	return builder
  	.registerTypeAdapter (JSMDateTimeLabelFormats.class, new JSMDateTimeLabelFormatsSerializer ())
  	.registerTypeAdapter (JSMStyle.class, new JSMStyleSerializer ())
  	.setDateFormat(yyyy_MM_dd)
  	       .setExclusionStrategies (new ExclusionStrategy () {

						@Override
						public boolean shouldSkipClass (Class<?> arg0) {
							return false;
						}

						@Override
						public boolean shouldSkipField (FieldAttributes attributes) {
							return attributes.getName ().equals (USER_OBJECT);
						}
  	      	 
  	       }).create();
  }

	private static final Gson GSON = createGson ();
  private static final String yyyy_MM_dd = "yyyyMMdd";
	private static final String USER_OBJECT = "userObject";
  
  static final boolean DEBUG = false;

  static final boolean HIGHCHARTS_2_1_2 = true;

  static Main rhinoDebugger;

	private static final SVGRendererInternal SVG_RENDERER_INTERNAL = new SVGRendererInternal ();

  static final Logger LOGGER = LoggerFactory.getLogger (SVGHighchartsHelper.class);

}
