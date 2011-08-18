package org.one2team.highcharts.server.export;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.batik.transcoder.image.TIFFTranscoder;

public enum ExportType {
	png {
		@Override
		protected Transcoder getTranscoder () {
			return new PNGTranscoder ();
		}
	}, jpeg {
		@Override
		protected Transcoder getTranscoder () {
			return new JPEGTranscoder ();
		}
	}, tiff {
		@Override
		protected Transcoder getTranscoder () {
			return new TIFFTranscoder ();
		}
	};
	
	public HighchartsExporter createExporter () {
		return new HighchartsExporter (this);
	}
	
	protected abstract Transcoder getTranscoder ();
}