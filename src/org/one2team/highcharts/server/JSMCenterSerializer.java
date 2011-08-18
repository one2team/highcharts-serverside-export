package org.one2team.highcharts.server;

import java.lang.reflect.Type;

import org.one2team.highcharts.server.JSMSeries.JSMCenter;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class JSMCenterSerializer implements JsonSerializer<JSMCenter> {

	@Override
	public JsonElement serialize (JSMCenter center, Type arg1, JsonSerializationContext arg2) {
		if (center.getX () == null || center.getY () == null)
			return new JsonPrimitive ("");
		JsonArray r = new JsonArray ();
		r.add (new JsonPrimitive (center.getX ()));
		r.add (new JsonPrimitive (center.getY ()));
		return r;
	}

}
