function FormatWrapper(args) {
	if (args) {
		this.months = args.months;
		this.days = args.days;
		FormatWrapper.prototype.date = args.date;
	}
}

FormatWrapper.prototype = {
	date: "%m-%d-%Y",
	visitObject : function(elem) {
		for ( var pty in elem) {
			if (typeof (elem[pty]) == 'object')
				this.visitObject(elem[pty]);
			else if (pty == 'formatter') {
				this.visitFormatter(elem);
			}
		}
	},
	propagate: function() {
		if (Highcharts && this.months) {
			Highcharts.setOptions({
		      lang: {
		        months: this.months,
		        weekdays: this.days
		      },
		      global:{
		        useUTC: false
		      }
		    });	
		}
	},
	visitFormatter : function(elem) {
		elem.formatter = this.evalPath(window, elem.formatter);
	},
	evalPath: function(start,path) {
		try {
			var mots = path.split(".");
			var cur = start;
			for (var ind=0;ind<mots.length;ind++) {
				cur = cur[mots[ind]];
			}
			return cur;
		} catch (e) {
			try {
				return eval (path);
			} catch (e) {
			}
		}
	},
	basicDate : function() {
		return Highcharts.dateFormat(FormatWrapper.prototype.date, this.x) + '<br/>'
				+ this.series.name + ':' + '<b>' + this.y + '</b>';
	},
	basicDatePercent : function() {
		return Highcharts.dateFormat(FormatWrapper.prototype.date, this.x) + '<br/>'
				+ this.series.name + ':' + '<b>'
				+ Highcharts.numberFormat(this.y, 1) + '%</b>';
	},
	sharedDate : function() {
		var s = Highcharts.dateFormat(FormatWrapper.prototype.date, this.x);
		for (i = 0; i < this.points.length; i++) {
			var py = Highcharts.numberFormat(this.points[i].y, 0);
			s += '<br/>' + '<span style="color:' + this.points[i].series.color
					+ ';">' + this.points[i].series.name + +'</span>' + ': '
					+ '<b>' + py + '</b>';
		}
		return s;
	},
	basic : function() {
		var py = Highcharts.numberFormat(this.y);
		return this.x + '<br/>' + this.series.name + ' : ' + '<b>' + py
				+ '</b>';
	},
	basicPercent : function() {
		var percent = Highcharts.numberFormat(this.percentage, 0);
		return this.x + '<br/>' + this.series.name + ' : ' + '<b>' + percent
				+ '%</b> <br/>' + this.y;
	},
	pieToolTipPercent : function() {
		var percent = Highcharts.numberFormat(this.percentage, 0);
		return this.point.name + ' : <b>' + percent + '%</b> <br/>' + this.y;
	},
	pieLabelPercent : function() {
		var percent = Highcharts.numberFormat(this.percentage, 0);
		if (percent < 5)
			return '';
		return percent + '%';
	},
	pieLegendPercent : function() {
		var percent = Highcharts.numberFormat(this.percentage, 0);
		return this.point.name + ' : ' + percent + '%';
	},
	columnDataLabelsHorizontal : function() {
		if (this.point.y == 0)
			return "";
        if (this.point.y < 0)
        	this.series.options.dataLabels.y = -this.point.barH - 5;
        else
        	this.series.options.dataLabels.y = -5;
        return Highcharts.numberFormat(this.y);
	},
	columnDataLabelsVertical : function() {
		if (this.point.y == 0)
			return "";
		var offset = - this.point.y.toString ().length * 4;
        this.series.options.dataLabels.x = -3;
        if (this.point.y < 0) {
            this.series.options.dataLabels.y = -this.point.barH + offset;
        }
        else {
            this.series.options.dataLabels.y = offset;
        }
        return Highcharts.numberFormat(this.y);
	},
	barDataLabels : function() {
		if (this.point.y == 0)
			return "";
		var offset = 10;
		if (this.y < 0)
            this.series.options.dataLabels.x = this.point.barH + offset;
        else
            this.series.options.dataLabels.x = offset;
        return Highcharts.numberFormat(this.y);
	},
	columnDataStackedLabelsHorizontal : function() {
		if (this.point.y == 0)
			return "";
		var offset = 3;
    	this.series.options.dataLabels.y = this.point.barH / 2 + offset;
        return Highcharts.numberFormat(this.y);
	},
	columnDataStackedLabelsVertical : function() {
		if (this.point.y == 0)
			return "";
		var offset = 3;
        this.series.options.dataLabels.y = this.point.barH / 2 + offset;
        return Highcharts.numberFormat(this.y);
	},
	barDataStackedLabels : function() {
		if (this.point.y == 0)
			return "";
		var offset = 2;
		this.series.options.dataLabels.x = - this.point.barH / 2 - offset;
        return Highcharts.numberFormat(this.y);
	}
};