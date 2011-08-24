package org.one2team.highcharts.server;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonHelper {
	
	static String toJson (Object object) {
		return GSON.toJson(object);
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
  
  private static final String yyyy_MM_dd = "yyyyMMdd";
	private static final String USER_OBJECT = "userObject";

	private static final Gson GSON = createGson ();
}
