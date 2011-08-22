package org.one2team.highcharts.server.export;

import java.io.OutputStream;

public interface Renderer<T> {

	Renderer<T> setChartOptions (T options);

	Renderer<T> setOutputStream (OutputStream outputStream);

	Renderer<T> setGlobalOptions (T options);

	void render ();
	
	public static abstract class PojoRenderer<T> implements Renderer<T> {

		@Override
		public Renderer<T> setChartOptions (T options) {
			this.options = options;
			return this;
		}

		@Override
		public Renderer<T> setOutputStream (OutputStream output) {
			this.output = output;
			return this;
		}

		@Override
		public Renderer<T> setGlobalOptions (T options) {
			this.globalOptions = options;
			return this;
		}

		protected T getChartOptions () {
			return options;
		}

		protected OutputStream getOutputStream () {
			return output;
		}

		protected T getGlobalOptions () {
			return globalOptions;
		}

		private T options, globalOptions;

		private OutputStream output;

	}

}