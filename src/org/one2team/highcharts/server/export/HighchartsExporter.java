package org.one2team.highcharts.server.export;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;
import org.one2team.highcharts.shared.ChartOptions;

public class HighchartsExporter {

	public HighchartsExporter(ExportType type) {
		this.type = type;
		this.renderer = 
			new SVGStreamRenderer (new SVGRenderer (),
				                     type.getTranscoder ());
	}

	public void export (ChartOptions chartOptions,
			                ChartOptions globalOptions,
			                File file) {
		
		FileOutputStream fos = null;
		try {
			renderer.setChartOptions (chartOptions)
					    .setGlobalOptions (globalOptions)
					    .setOutputStream (fos = new FileOutputStream (file))
					    .render ();

		} catch (Exception e) {
			e.printStackTrace ();
			throw (new RuntimeException (e));
		} finally {
			if (fos != null)
				IOUtils.closeQuietly (fos);
		}
	}

	public SVGStreamRenderer getRenderer () {
		return renderer;
	}

	public ExportType getType () {
		return type;
	}

	private final SVGStreamRenderer renderer;

	private final ExportType type;
}
