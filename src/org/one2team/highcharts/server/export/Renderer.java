package org.one2team.highcharts.server.export;

import java.io.OutputStream;

public interface Renderer<I> {

	Renderer<I> setChartOptions (I options);

	Renderer<I> setOutputStream (OutputStream outputStream);

	Renderer<I> setGlobalOptions (I options);

	void render ();
	
	public static abstract class PojoRenderer<I> implements Renderer<I> {

		@Override
		public Renderer<I> setChartOptions (I options) {
			this.options = options;
			return this;
		}

		@Override
		public Renderer<I> setOutputStream (OutputStream output) {
			this.output = output;
			return this;
		}

		@Override
		public Renderer<I> setGlobalOptions (I options) {
			this.globalOptions = options;
			return this;
		}

		protected I getChartOptions () {
			return options;
		}

		protected OutputStream getOutputStream () {
			return output;
		}

		protected I getGlobalOptions () {
			return globalOptions;
		}

		private I options, globalOptions;

		private OutputStream output;

	}

}