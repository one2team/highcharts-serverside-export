package org.one2team.highcharts.server.export.util;

import org.mozilla.javascript.ScriptableObject;
import org.one2team.highcharts.shared.ChartOptions;

public class SVGRendererInternalChartOption extends SVGRendererInternal<ChartOptions> {

    @Override
    protected Object callJavascript(final String generalOptions, final ChartOptions chartOptions) {
        if (SVGHighchartsHelper.HIGHCHARTS_2_1_2) {
            return ScriptableObject.callMethod(null, SCRIPTABLE, "renderSVGFromObject", new Object[]{'(' + generalOptions + ')', chartOptions});
        } else {
            return ScriptableObject.callMethod(null, SCRIPTABLE, "renderSVGFromObject", new Object[]{'(' + generalOptions + ')', chartOptions});
        }
    }

}
