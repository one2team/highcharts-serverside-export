package examples;

import java.io.File;

import org.one2team.highcharts.server.export.ExportType;
import org.one2team.highcharts.server.export.HighchartsExporter;
import org.one2team.highcharts.shared.ChartOptions;

public class MultiExport {

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
//		
		long top2 = 0;
		long top = System.currentTimeMillis ();
		long total = 0;
		for (int i1=0;i1<10;i1++) {
			top2 = System.currentTimeMillis ();
			chartOptions1 = highchartsSamples.createColumnBasic ();
			total += (System.currentTimeMillis ()-top2);
			pngExporter.export (chartOptions1, null, new File (exportDirectory, "column-basic"+i1+".png"));
		}
		System.out.println("creation "+((total)/10));
		System.out.println("this is the end "+((System.currentTimeMillis ()-top-total)/10));
		
	}


}
