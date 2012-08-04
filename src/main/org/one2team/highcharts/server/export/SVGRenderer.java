package org.one2team.highcharts.server.export;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.one2team.highcharts.server.export.Renderer.PojoRenderer;
import org.one2team.highcharts.server.export.util.SVGHighchartsHelper;
import org.one2team.highcharts.server.export.util.SVGRendererInternal;

class SVGRenderer<T> extends PojoRenderer<T> {
	
	public SVGRenderer (SVGRendererInternal<T> internal) {
		this.internal = internal;//new SVGRendererInternal ();
	}

	@Override
	public void render () {
		String generalOptions = SVGHighchartsHelper.jsonifyDefaultGeneralOptions ();
		
		if (getChartOptions () == null)
			throw (new RuntimeException ("chartOptions must not be null"));
		
		ByteArrayInputStream byteStream = null;
		try {
			final String svg = internal.getSVG (generalOptions, getChartOptions ());
			if (svg == null)
				throw (new RuntimeException ("cannot generate svg"));
			byteStream = new ByteArrayInputStream (svg.getBytes ());
			IOUtils.copy (byteStream, getOutputStream());
		} catch (IOException e) {
			throw (new RuntimeException (e));
		} finally {
			IOUtils.closeQuietly (byteStream);
		}
	}
	
	private final SVGRendererInternal<T> internal;

}
