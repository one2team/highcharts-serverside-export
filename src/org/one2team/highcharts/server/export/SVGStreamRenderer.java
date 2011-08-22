package org.one2team.highcharts.server.export;

import java.io.ByteArrayOutputStream;
import java.io.Reader;
import java.io.StringReader;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.commons.io.IOUtils;
import org.one2team.highcharts.server.export.Renderer.PojoRenderer;

class SVGStreamRenderer<I> extends PojoRenderer<I> {

	@Override
	public void render () {
		ByteArrayOutputStream baos = null;
		Reader reader = null;
		try {
			baos = new ByteArrayOutputStream ();

			wrapped.setOutputStream (baos).render ();

			reader = new StringReader (baos.toString ());

			if (getOutputStream () == null)
				throw (new RuntimeException ("outputstream cannot be null"));
			
			transcoder.transcode (new TranscoderInput (reader), new TranscoderOutput (getOutputStream ()));

		} catch (TranscoderException e) {
			throw new RuntimeException (e);
		} finally {
			IOUtils.closeQuietly (baos);
			IOUtils.closeQuietly (reader);
		}
	}

	@Override
	public Renderer<I> setGlobalOptions (I options) {
		wrapped.setGlobalOptions (options);
		return this;
	}

	@Override
	public Renderer<I> setChartOptions (I options) {
		wrapped.setChartOptions (options);
		return this;
	}

	Transcoder getTranscoder () {
		return transcoder;
	}
	
	public SVGStreamRenderer (Renderer<I> wrapped, Transcoder transcoder) {
		this.wrapped = wrapped;
		this.transcoder = transcoder;
	}

	private final Renderer<I> wrapped;

	private final Transcoder transcoder;
}