function renderSVGFromObject (jsonGeneralOptions, chartOptions) {
//    n = Highcharts.createElement('div', null, null, null, true);
    var n = document.createElement('div');
    document.body.appendChild(n);

    var toto = eval (jsonGeneralOptions);
    Highcharts.setOptions.call (Highcharts, toto);
    var newChartOptions = chartOptions;

 //   new FormatWrapper ().visitObject(newChartOptions);
    var chartOptionsChart = newChartOptions.chart;
    chartOptionsChart.renderTo=n;
    chartOptionsChart.renderer='SVG';

    var additionalOptions = {};
    additionalOptions['container'] = n;

    chart = new Highcharts.Chart(newChartOptions);

    java.lang.System.out.println("HELLO WORLD -----------------------------");

    svg = chart.getSVG ();
    chart.destroy ();
    Highcharts.discardElement (n);
    return svg;
}
