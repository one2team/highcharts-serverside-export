package examples;

import java.util.Calendar;

import org.one2team.highcharts.server.JSMHighchartsFactory;
import org.one2team.highcharts.shared.ChartOptions;
import org.one2team.highcharts.shared.HighchartsFactory;
import org.one2team.highcharts.shared.Point;
import org.one2team.highcharts.shared.Series;
import org.one2team.highcharts.shared.SeriesType;
import org.one2team.highcharts.shared.DateTimeLabelFormats.TimeUnit;

import com.google.gwt.shared.Array;

public class SamplesFactory {

	public static SamplesFactory getSingleton () {
		return SINGLETON;
	}

	public ChartOptions createTimeDataWithIrregularIntervals () {
		// http://highcharts.com/demo/spline-irregular-time
		ChartOptions chartOptions = factory.createChartOptions ();
		chartOptions.getChart ().setWidth (800).setHeight (600)
				.setDefaultSeriesType (SeriesType.spline).setMarginLeft (70)
				.setMarginTop (80);

		// titles
		chartOptions.getTitle ().setText (
				"Snow depth in the Vikjafjellet mountain, Norway");
		chartOptions.getSubtitle ().setText (
				"An example of irregular time data in Highcharts JS");

		// axis
		chartOptions.getXAxis ().setType ("datetime").getDateTimeLabelFormats ()
				.set (TimeUnit.month, "%e. %b").set (TimeUnit.year, "%b");
		chartOptions.getYAxis ().setMin (0).getTitle ().setText ("Snow depth (m)");

		// plotOptions
		chartOptions
				.getPlotOptions ()
				.getPie ()
				.setAllowPointSelect (true)
				.getDataLabels ()
				.setEnabled (true)
				.setColor ("#000000")
				.setFormatter (
						"function() {return '<b>'+ this.point.name +'</b>: '+ this.y +' %';}");

		Series newSeries = factory.createSeries ().setName ("Winter 2007-2008");
		chartOptions.getSeries ().pushElement (newSeries);
		newSeries
				.getData ()
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 9, 27)).setY (0))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 10, 10)).setY (0.6))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 10, 18)).setY (0.7))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 11, 2)).setY (0.8))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 11, 9)).setY (0.6))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 11, 16)).setY (0.6))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 11, 28)).setY (0.67))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 0, 1)).setY (0.81))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 0, 8)).setY (0.78))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 0, 12)).setY (0.98))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 0, 27)).setY (1.84))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 1, 10)).setY (1.8))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 1, 18)).setY (1.8))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 1, 24)).setY (1.92))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 2, 4)).setY (2.49))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 2, 11)).setY (2.79))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 2, 15)).setY (2.73))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 2, 25)).setY (2.61))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 3, 2)).setY (2.76))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 3, 6)).setY (2.82))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 3, 13)).setY (2.8))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 4, 3)).setY (2.1))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 4, 26)).setY (1.1))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 5, 9)).setY (0.25))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 5, 12)).setY (0));

		newSeries = factory.createSeries ().setName ("Winter 2008-2009");
		chartOptions.getSeries ().pushElement (newSeries);
		newSeries
				.getData ()
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 9, 18)).setY (0))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 9, 26)).setY (0.2))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 11, 1)).setY (0.47))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 11, 11)).setY (0.55))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 11, 25)).setY (1.38))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 0, 8)).setY (1.38))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 0, 15)).setY (1.38))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 1, 1)).setY (1.38))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 1, 8)).setY (1.48))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 1, 21)).setY (1.5))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 2, 12)).setY (1.89))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 2, 25)).setY (2.0))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 3, 4)).setY (1.94))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 3, 9)).setY (1.91))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 3, 13)).setY (1.75))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 3, 19)).setY (1.6))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 4, 25)).setY (0.6))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 4, 31)).setY (0.35))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 5, 7)).setY (0));

		newSeries = factory.createSeries ().setName ("Winter 2009-2010");
		chartOptions.getSeries ().pushElement (newSeries);
		newSeries
				.getData ()
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 9, 9)).setY (0))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 9, 14)).setY (0.15))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 10, 28)).setY (0.35))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1970, 11, 12)).setY (0.46))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 0, 1)).setY (0.59))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 0, 24)).setY (0.58))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 1, 1)).setY (0.62))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 1, 7)).setY (0.65))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 1, 23)).setY (0.77))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 2, 8)).setY (0.77))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 2, 14)).setY (0.79))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 2, 24)).setY (0.86))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 3, 4)).setY (0.8))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 3, 18)).setY (0.94))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 3, 24)).setY (0.9))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 4, 16)).setY (0.39))
				.pushElement (
						factory.createPoint ().setX (getDateUTC (1971, 4, 21)).setY (0));
		return chartOptions;
	}

	public ChartOptions createPieChart () {
		// http://highcharts.com/demo/pie-basic
		ChartOptions chartOptions = factory.createChartOptions ();
		chartOptions.getChart ().setWidth (800).setHeight (600).setMarginLeft (70)
				.setMarginTop (80);
		// title
		chartOptions.getTitle ().setText (
				"Browser market shares at a specific website, 2010");

		// plotOptions
		chartOptions
				.getPlotOptions ()
				.getPie ()
				.setAllowPointSelect (true)
				.getDataLabels ()
				.setEnabled (true)
				.setColor ("#000000")
				.setFormatter (
						"function() {return '<b>'+ this.point.name +'</b>: '+ this.y +' %';}");

		Series newSeries = factory.createSeries ().setName ("Browser share")
				.setType ("pie");
		chartOptions.getSeries ().pushElement (newSeries);
		newSeries
				.getData ()
				.pushElement (factory.createPoint ().setName ("Firefox").setY (45))
				.pushElement (factory.createPoint ().setName ("IE").setY (26.8))
				.pushElement (
						factory.createPoint ().setName ("Chrome").setY (12.8)
								.setSliced (true).setSelected (true))
				.pushElement (factory.createPoint ().setName ("Safari").setY (8.5))
				.pushElement (factory.createPoint ().setName ("Opera").setY (6.2))
				.pushElement (factory.createPoint ().setName ("Others").setY (0.7));

		return chartOptions;
	}

	public ChartOptions createColumnBasic () {
		// http://highcharts.com/demo/column-basic
		ChartOptions chartOptions = factory.createChartOptions ();

		chartOptions.getChart ().setDefaultSeriesType (SeriesType.column)
				.setWidth (800).setHeight (400).setMarginLeft (70).setMarginTop (80);

		// titles
		chartOptions.getTitle ().setText ("Monthly Average Rainfall");
		chartOptions.getSubtitle ().setText ("Source: WorldClimate.com");

		// xAxis
		chartOptions.getXAxis ().getCategories ().pushString ("Jan").pushString ("Feb")
				.pushString ("Mar").pushString ("Apr").pushString ("May").pushString ("Jun")
				.pushString ("Jul").pushString ("Aug").pushString ("Sep").pushString ("Oct")
				.pushString ("Nov").pushString ("Dec");
		// yAxis
		chartOptions.getYAxis ().setMin (0).getTitle ().setText ("Rainfall (mm)");

		// Legend
		chartOptions.getLegend ().setLayout ("vertical").setAlign ("left")
				.setVerticalAlign ("top").setX (100).setY (70);

		// PlotOptions
		chartOptions.getPlotOptions ().getColumn ().setBorderWidth (0);

		// Several series
		addSeries (chartOptions, "Tokyo", new double[] { 49.9, 71.5, 106.4, 129.2,
				144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4 });

		addSeries (chartOptions, "New York", new double[] { 83.6, 78.8, 98.5, 93.4,
				106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3 });

		addSeries (chartOptions, "London", new double[] { 48.9, 38.8, 39.3, 41.4,
				47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2 });

		addSeries (chartOptions, "Berlin", new double[] { 42.4, 33.2, 34.5, 39.7,
				52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1 });

		return chartOptions;
	}
	
	public String createJsonColumnBasic () {
		return "" +
         "{chart: {"
				+ " defaultSeriesType: 'column',"
				+ " width: 800,"
				+ " height: 400"
				+ "},"
				+ "title: {"
				+ "  text: 'Monthly Average Rainfall'"
				+ "},"
				+ "subtitle: {"
				+ "  text: 'Source: WorldClimate.com'"
				+ "},"
				+ "xAxis: {"
				+ "  categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']"
				+ "},"
				+ "yAxis: {"
				+ "  min: 0,"
				+ "  title: {"
				+ "    text: 'Rainfall (mm)'"
				+ "  }"
				+ "},"
				+ "legend: {"
				+ "  layout: 'vertical',"
				+ "  backgroundColor: '#FFFFFF',"
				+ "  align: 'left',"
				+ "  verticalAlign: 'top',"
				+ "  x: 100,"
				+ "  y: 70,"
				+ "  floating: true,"
				+ "  shadow: true"
				+ "},"
				+ "tooltip: {"
				+ "  formatter: function () {"
				+ "    return '' + this.x + ': ' + this.y + ' mm';"
				+ "  }"
				+ "},"
				+ "plotOptions: {"
				+ "  column: {"
				+ "    pointPadding: 0.2,"
				+ "    borderWidth: 0"
				+ "  }"
				+ "},"
				+ "series: [{"
				+ "  name: 'Tokyo',"
				+ "  data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]"
				+ ""
				+ "},"
				+ "{"
				+ "  name: 'New York',"
				+ "  data: [83.6, 78.8, 98.5, 93.4, 106.0, 84.5, 105.0, 104.3, 91.2, 83.5, 106.6, 92.3]"

				+ "},"
				+ "{"
				+ "  name: 'London',"
				+ "  data: [48.9, 38.8, 39.3, 41.4, 47.0, 48.3, 59.0, 59.6, 52.4, 65.2, 59.3, 51.2]"

				+ "},"
				+ "{"
				+ "  name: 'Berlin',"
				+ "  data: [42.4, 33.2, 34.5, 39.7, 52.6, 75.5, 57.4, 60.4, 47.6, 39.1, 46.8, 51.1]"

				+ "}]}";
	}


	private static long getDateUTC (int year, int month, int day) {
		Calendar cal = Calendar.getInstance ();
		cal.set (Calendar.YEAR, year);
		cal.set (Calendar.MONTH, month);
		cal.set (Calendar.DAY_OF_MONTH, day);
		return cal.getTimeInMillis ();
	}

	private void addSeries (ChartOptions chartOptions, String seriesName,
			double[] datas) {

		Series newSeries = factory.createSeries ().setName (seriesName);
		final Array<Point> seriesDatas = newSeries.getData ();
		for (double d : datas) {
			seriesDatas.pushElement (factory.createPoint ().setY (d));
		}
		chartOptions.getSeries ().pushElement (newSeries);
	}

	private SamplesFactory() {
		factory = new JSMHighchartsFactory ();
	}

	private static SamplesFactory SINGLETON = new SamplesFactory ();
	
	private final HighchartsFactory factory;

}
