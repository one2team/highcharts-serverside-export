package org.one2team.highcharts.server.export;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.one2team.highcharts.server.export.Renderer.PojoRenderer;
import org.one2team.highcharts.server.export.util.SVGHighchartsHelper;
import org.one2team.highcharts.server.export.util.SVGRendererInternal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class SVGRenderer<T> extends PojoRenderer<T> {
	
	public SVGRenderer (SVGRendererInternal<T> internal) {
		this.internal = internal;//new SVGRendererInternal ();
	}

	@Override
	public void render () {
		String generalOptions = SVGHighchartsHelper.jsonifyDefaultGeneralOptions ();
		if (LOGGER.isDebugEnabled ()) LOGGER.debug ("generalOptions : " +generalOptions);
		
		if (getChartOptions () == null)
			throw (new RuntimeException ("chartOptions must not be null"));
		String chartOptions = "";//SVGHighchartsHelper.jsonify (getChartOptions ());
		if (LOGGER.isDebugEnabled ()) LOGGER.debug ("chartOptions : " +chartOptions);
		
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

  private static final Logger LOGGER = LoggerFactory.getLogger (SVGRenderer.class);

}
