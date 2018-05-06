package org.one2team.highcharts.server.export;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.one2team.highcharts.server.export.util.SVGRendererInternal;

public class HighchartsExporter<T> {

	public HighchartsExporter(ExportType type, SVGRendererInternal<T> internalRenderer) {
		this.type = type;
		this.renderer = 
			new SVGStreamRenderer<T> (new SVGRenderer<T> (internalRenderer),
				                     type.getTranscoder ());
	}

	public void export (T chartOptions,
			                T globalOptions,
			                File file) {
		
		try {
            OutputStream fos = new FileOutputStream (file);
            export(chartOptions, globalOptions, fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace ();
			throw (new RuntimeException (e));
		}
	}

    public void export (T chartOptions,
                        T globalOptions,
                        OutputStream file) {
        try {
            render (chartOptions, globalOptions, file);
        } catch (Exception e) {
            e.printStackTrace ();
            throw (new RuntimeException (e));
        } finally {
            if (file != null) {
                IOUtils.closeQuietly(file);
            }
        }
    }

    private void render (T chartOptions,
                                 T globalOptions,
                                 OutputStream out)  {
        renderer.setChartOptions (chartOptions)
                .setGlobalOptions (globalOptions)
                .setOutputStream ( out )
                .render ();
    }


	public SVGStreamRenderer<T> getRenderer () {
		return renderer;
	}

	public ExportType getType () {
		return type;
	}

	private final SVGStreamRenderer<T> renderer;

	private final ExportType type;
}
