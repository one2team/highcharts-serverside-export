
function renderSVGEchoue (oldChartOptions, jsonGeneralOptions, chartOptions) {
	n = Highcharts.createElement('div', null, null, null, true);
	var toto = eval (jsonGeneralOptions);
	Highcharts.setOptions.call (Highcharts, toto);
	
	var newChartOptions = chartOptions;
	
	new FormatWrapper ().visitObject(newChartOptions);
	var chartOptionsChart = newChartOptions.chart;
	chartOptionsChart.renderTo=n;
	chartOptionsChart.renderer='SVG';
	
	chart = new Highcharts.Chart(newChartOptions);
	var svg = n.innerHTML;

//	var svg = chart.container.innerHTML;
	// sanitize
	svg = svg
		.replace(/zIndex="[^"]+"/g, '') 
		.replace(/isShadow="[^"]+"/g, '')
		.replace(/symbolName="[^"]+"/g, '')
		.replace(/jQuery[0-9]+="[^"]+"/g, '')
		.replace(/isTracker="[^"]+"/g, '')
		.replace(/url\([^#]+#/g, 'url(#')
		/* This fails in IE < 8
		.replace(/([0-9]+)\.([0-9]+)/g, function(s1, s2, s3) { // round off to save weight
			return s2 +'.'+ s3[0];
		})*/ 
		
		// IE specific
		.replace(/id=([^" >]+)/g, 'id="$1"') 
		.replace(/class=([^" ]+)/g, 'class="$1"')
		.replace(/ transform /g, ' ')
		.replace(/:(path|rect)/g, '$1')
		.replace(/style="([^"]+)"/g, function(s) {
			return s.toLowerCase();
		});
		
	// IE9 beta bugs with innerHTML. Test again with final IE9.
	svg = svg.replace(/(url\(#highcharts-[0-9]+)&quot;/g, '$1')
		.replace(/&quot;/g, "'");
	if (svg.match(/ xmlns="/g).length == 2) {
		svg = svg.replace(/xmlns="[^"]+"/, '');
	}
	chart.destroy ();
	Highcharts.discardElement (n);
	
	return svg;
}

function renderSVGFromJson (jsonGeneralOptions, jsonChartOptions) {
	return renderSVGFromObject (jsonGeneralOptions, eval (jsonChartOptions));
}

function renderSVGFromObject (jsonGeneralOptions, chartOptions) {
	n = Highcharts.createElement('div', null, null, null, true);
	var toto = eval (jsonGeneralOptions);
	Highcharts.setOptions.call (Highcharts, toto);
	var newChartOptions = chartOptions;
	
	new FormatWrapper ().visitObject(newChartOptions);
	var chartOptionsChart = newChartOptions.chart;
	chartOptionsChart.renderTo=n;
	chartOptionsChart.renderer='SVG';
	
	chart = new Highcharts.Chart(newChartOptions);
	svg = chart.getSVG ();
	chart.destroy ();
	Highcharts.discardElement (n);
	return svg;
}
