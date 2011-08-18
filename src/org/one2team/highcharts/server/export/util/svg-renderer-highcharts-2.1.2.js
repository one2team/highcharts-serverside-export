
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

function renderSVG (oldChartOptions, jsonGeneralOptions, chartOptions) {
	n = Highcharts.createElement('div', null, null, null, true);
	var toto = eval (jsonGeneralOptions);
	Highcharts.setOptions.call (Highcharts, toto);
//	alert("toto");
//	var turlututu = "{'chart':{}}";
//	var turlututu = '({"chart":{"width":800,"height":600,"marginLeft":70,"marginTop":80},"plotOptions":{"area":{"borderWidth":0},"areaspline":{"borderWidth":0},"line":{"borderWidth":0},"pie":{"dataLabels":{"color":"#000000","enabled":true,"align":"center","rotation":0.0},"allowPointSelect":true,"borderWidth":0},"series":{"borderWidth":0},"spline":{"borderWidth":0},"column":{"borderWidth":0},"bar":{"borderWidth":0}},"series":[{"data":[{"y":45.0,"name":"Firefox"},{"y":26.8,"name":"IE"},{"y":12.8,"selected":true,"sliced":true,"name":"Chrome"},{"y":8.5,"name":"Safari"},{"y":6.2,"name":"Opera"},{"y":0.7,"name":"Others"}],"name":"Browser share","type":"pie"}],"title":{"text":"Browser market shares at a specific website, 2010"}})';
//	chartOptions = titi;//eval (turlututu);
	var newChartOptions = chartOptions;
//	var newChartOptions = eval (turlututu);//myDup (chartOptions);
//	var newChartOptions = eval (oldChartOptions);
	
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
