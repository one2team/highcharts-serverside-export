package examples;

import java.io.File;

import org.one2team.highcharts.server.export.ExportType;
import org.one2team.highcharts.server.export.HighchartsExporter;
import org.one2team.highcharts.shared.ChartOptions;

import examples.SamplesFactory;

public class SimpleExport {

	public static void main (String[] args) {
		
		// This executable expects an export directory as input
		File exportDirectory = new File (args [0]);
		
		final SamplesFactory highchartsSamples = SamplesFactory.getSingleton ();
		
		// ====================================================================
		// ChartOptions creation
		// ----------------------
		//  The createHighchartsDemoColumnBasic method describes the creation of 
		//   a java chartOption. It is a java equivalent to javascript Highcharts sample
		//   (see http://highcharts.com/demo/column-basic)
		ChartOptions chartOptions1 = highchartsSamples.createColumnBasic ();

		// ====================================================================
		// Chart export
		// ----------------
		// Inputs :
		//    1. chartOptions : the java ChartOptions to be exported,
		//    2. exportFile  : file to export to.
		HighchartsExporter pngExporter = ExportType.png.createExporter ();
		pngExporter.export (chartOptions1, null, new File (exportDirectory, "column-basic.png"));
		
		// ====================================================================
		// Another example using the same exporter
		// ---------------------------------------
		ChartOptions chartOptions2 = highchartsSamples.createPieChart ();
		pngExporter.export (chartOptions2, null, new File (exportDirectory, "pie-chart.png"));
		
		// ====================================================================
		// An example exporting to JPEG
		// ---------------------------------------
		ChartOptions chartOptions3 = highchartsSamples.createTimeDataWithIrregularIntervals ();
		final HighchartsExporter jpegExporter = ExportType.jpeg.createExporter ();
		jpegExporter.export (chartOptions3, null, new File (exportDirectory, "time-data-with-irregular-intervals.jpeg"));
		
	}


}
