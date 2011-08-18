package org.one2team.highcharts.server.export;

import java.io.OutputStream;

import org.one2team.highcharts.shared.ChartOptions;

public interface Renderer {

	Renderer setChartOptions (ChartOptions options);

	Renderer setOutputStream (OutputStream outputStream);

	Renderer setGlobalOptions (ChartOptions options);


	void render ();
	public static abstract class PojoRenderer implements Renderer {

		@Override
		public Renderer setChartOptions (ChartOptions options) {
			this.options = options;
			return this;
		}

		@Override
		public Renderer setOutputStream (OutputStream output) {
			this.output = output;
			return this;
		}

		@Override
		public Renderer setGlobalOptions (ChartOptions options) {
			this.globalOptions = options;
			return this;
		}

		protected ChartOptions getChartOptions () {
			return options;
		}

		protected OutputStream getOutputStream () {
			return output;
		}

		protected ChartOptions getGlobalOptions () {
			return globalOptions;
		}

		private ChartOptions options;

		private OutputStream output;

		private ChartOptions globalOptions;

	}

}