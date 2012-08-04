function renderSVG (jsonOptions, jsonGeneralOptions) {
	n = Highcharts.createElement('div', null, null, null, true);

	Highcharts.setOptions (eval (jsonGeneralOptions));
	
	chartOptions = eval (jsonOptions);
	chartOptions.chart.renderTo=n;
	chartOptions.chart.forExport=true;

	chart = new Highcharts.Chart(chartOptions);
	svg = chart.getSVG ();
	chart.destroy ();
	Highcharts.discardElement (n);
	return svg;
}
