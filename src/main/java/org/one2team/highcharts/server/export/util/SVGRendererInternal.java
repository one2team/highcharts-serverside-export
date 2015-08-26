package org.one2team.highcharts.server.export.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.tools.debugger.Main;
import org.mozilla.javascript.tools.debugger.ScopeProvider;

public abstract class SVGRendererInternal<T> {
	
		protected abstract Object callJavascript (final String generalOptions, final T chartOptions);
	  
		public String getSVG (final String generalOptions, final T chartOptions) throws IOException {
	    SVGHighchartsHelper.LOGGER.debug ("get svg for highcharts export functions with rhino");
	    Object call;
	    if (SVGHighchartsHelper.DEBUG) {
	      SVGHighchartsHelper.LOGGER.debug ("launching rhino debugger");
	      SVGHighchartsHelper.rhinoDebugger = new Main("rhino-debugger");

	      SVGHighchartsHelper.rhinoDebugger.attachTo(getContextFactory ());
	      SVGHighchartsHelper.rhinoDebugger.setScopeProvider(new ScopeProvider () {
	        @Override
	        public Scriptable getScope () {
	          return org.mozilla.javascript.tools.shell.Main.getGlobal ();
	        }
	      });

	      SVGHighchartsHelper.rhinoDebugger.pack();
	      SVGHighchartsHelper.rhinoDebugger.setSize(1600, 1000);
	      SVGHighchartsHelper.rhinoDebugger.setVisible(true);
	    }
	    
	    call = getContextFactory ().call (new ContextAction() {
	      @Override
	      public Object run (Context cx) {
	        final Initiator initiator = new Initiator (cx).init ();
	        
	        SVGHighchartsHelper.LOGGER.trace ("call renderSVG method on json");
	        if (SVGHighchartsHelper.LOGGER.isTraceEnabled ()) SVGHighchartsHelper.LOGGER.trace ("\n" + chartOptions);
	        if (SVGHighchartsHelper.LOGGER.isTraceEnabled ()) SVGHighchartsHelper.LOGGER.trace ("\n" + generalOptions);
	        if (SVGHighchartsHelper.DEBUG) {
	          SVGHighchartsHelper.rhinoDebugger.doBreak ();
	        }
	        try {
	          return initiator.execute ();
	        } finally {
	          if (SVGHighchartsHelper.DEBUG) {
	            SVGHighchartsHelper.rhinoDebugger.detach ();
	            SVGHighchartsHelper.rhinoDebugger.dispose ();
	          }
	        }
	      }

	      class Initiator {
					Initiator (Context context) {
						this.cx = context;
					}
					
					Initiator init () {
						if (SCRIPTABLE == null)
							createScriptable ();
						initContext ();
						return this;
					}
					
					Object execute () {
						return callJavascript (generalOptions, chartOptions);
					}

					void createScriptable () {

						SVGHighchartsHelper.LOGGER.trace ("set langage version to 1.6");
		        cx.setLanguageVersion (Context.VERSION_1_6);
		        
		        SVGHighchartsHelper.LOGGER.trace ("init standard objects");
		        if (SVGHighchartsHelper.DEBUG)
		          SCRIPTABLE = cx.initStandardObjects (org.mozilla.javascript.tools.shell.Main.getGlobal ());
		        else
		          SCRIPTABLE = cx.initStandardObjects ();
		        
		        SVGHighchartsHelper.LOGGER.trace ("set optimization level to -1");
		        cx.setOptimizationLevel (-1);// bypass the 64k limit // interpretive mode
		        attachJs ("env.rhino-1.2.js");
		        
		        
		        if (!SVGHighchartsHelper.DEBUG) {
		          SVGHighchartsHelper.LOGGER.trace ("set optimization level to 9");
		          cx.setOptimizationLevel (9);
		        }
		        
		        attachJs ("jquery-1.4.3.min.js");
		        
		        if (SVGHighchartsHelper.HIGHCHARTS_2_1_2) {
		          attachJs ("highcharts-2.1.2.src.js");
		          attachJs ("exporting-2.1.2.src.js");
		          attachJs ("svg-renderer-highcharts-2.1.2.js");
		        } else {
		          attachJs ("prepare-dom-highcharts-2.1.4.js");
		          attachJs ("highcharts-2.1.4.src.js");
		          attachJs ("exporting-2.1.4.js");
		          attachJs ("svg-renderer-highcharts-2.1.4.js");
		        }
		        attachJs ("add-BBox.js");
		        attachJs ("formatWrapper.js");
					}
				  
				  @SuppressWarnings("deprecation")
					private void attachJs (String jsFileName) {
				    InputStream in = null;
				    InputStreamReader reader = null;
				    if (SVGHighchartsHelper.LOGGER.isDebugEnabled ())SVGHighchartsHelper.LOGGER.debug ("loading " + jsFileName);
				    try {
				      in = SVGHighchartsHelper.class.getResourceAsStream (jsFileName);
				      if (in == null)
				        throw new RuntimeException ("cannot find js file : " + jsFileName);
				      
				      reader = new InputStreamReader (in);
				      if (scripts == null)
								scripts = new ArrayList<Script> (); 
//				      scr.exec(cx, SCRIPTABLE);
							scripts.add (cx.compileReader (SCRIPTABLE, reader, jsFileName, 1, null));
				      
				      if (SVGHighchartsHelper.LOGGER.isDebugEnabled ())SVGHighchartsHelper.LOGGER.debug ("loaded " + jsFileName);
				    } catch (IOException e) {
				      throw new RuntimeException ("cannot load js file : " + jsFileName, e);
				    } finally {
				      IOUtils.closeQuietly (in);
				      IOUtils.closeQuietly (reader);
				    }
				  }
				  
					void initContext () {
////						String toutou = chartOptions;
////						String turlututu = "var turlututu = '({\"chart\":{\"width\":800,\"formatter\":\"function() {return this.point.name ;}\",\"height\":600,\"marginLeft\":70,\"marginTop\":80},\"plotOptions\":{\"area\":{\"borderWidth\":0},\"areaspline\":{\"borderWidth\":0},\"line\":{\"borderWidth\":0},\"pie\":{\"dataLabels\":{\"color\":\"#000000\",\"enabled\":true,\"align\":\"center\",\"rotation\":0.0},\"allowPointSelect\":true,\"borderWidth\":0},\"series\":{\"borderWidth\":0},\"spline\":{\"borderWidth\":0},\"column\":{\"borderWidth\":0},\"bar\":{\"borderWidth\":0}},\"series\":[{\"data\":[{\"y\":45.0,\"name\":\"Firefox\"},{\"y\":26.8,\"name\":\"IE\"},{\"y\":12.8,\"selected\":true,\"sliced\":true,\"name\":\"Chrome\"},{\"y\":8.5,\"name\":\"Safari\"},{\"y\":6.2,\"name\":\"Opera\"},{\"y\":0.7,\"name\":\"Others\"}],\"name\":\"Browser share\",\"type\":\"pie\"}],\"title\":{\"text\":\"Browser market shares at a specific website, 2010\"}})';";
//						String turlututu = "var turlututu = '({\"chart\":{\"width\":800,\"height\":400,\"defaultSeriesType\":\"column\",\"marginLeft\":70,\"marginTop\":80},\"legend\":{\"align\":\"left\",\"layout\":\"vertical\",\"verticalAlign\":\"top\",\"x\":100,\"y\":70},\"plotOptions\":{\"area\":{\"borderWidth\":0},\"areaspline\":{\"borderWidth\":0},\"line\":{\"borderWidth\":0},\"pie\":{\"borderWidth\":0},\"series\":{\"borderWidth\":0},\"spline\":{\"borderWidth\":0},\"column\":{\"borderWidth\":0},\"bar\":{\"borderWidth\":0}},\"series\":[{\"data\":[{\"y\":49.9},{\"y\":71.5},{\"y\":106.4},{\"y\":129.2},{\"y\":144.0},{\"y\":176.0},{\"y\":135.6},{\"y\":148.5},{\"y\":216.4},{\"y\":194.1},{\"y\":95.6},{\"y\":54.4}],\"name\":\"Tokyo\"},{\"data\":[{\"y\":83.6},{\"y\":78.8},{\"y\":98.5},{\"y\":93.4},{\"y\":106.0},{\"y\":84.5},{\"y\":105.0},{\"y\":104.3},{\"y\":91.2},{\"y\":83.5},{\"y\":106.6},{\"y\":92.3}],\"name\":\"New York\"},{\"data\":[{\"y\":48.9},{\"y\":38.8},{\"y\":39.3},{\"y\":41.4},{\"y\":47.0},{\"y\":48.3},{\"y\":59.0},{\"y\":59.6},{\"y\":52.4},{\"y\":65.2},{\"y\":59.3},{\"y\":51.2}],\"name\":\"London\"},{\"data\":[{\"y\":42.4},{\"y\":33.2},{\"y\":34.5},{\"y\":39.7},{\"y\":52.6},{\"y\":75.5},{\"y\":57.4},{\"y\":60.4},{\"y\":47.6},{\"y\":39.1},{\"y\":46.8},{\"y\":51.1}],\"name\":\"Berlin\"}],\"title\":{\"text\":\"Monthly Average Rainfall\"},\"subtitle\":{\"text\":\"Source: WorldClimate.com\"},\"xAxis\":{\"categories\":[\"Jan\",\"Feb\",\"Mar\",\"Apr\",\"May\",\"Jun\",\"Jul\",\"Aug\",\"Sep\",\"Oct\",\"Nov\",\"Dec\"]},\"yAxis\":{\"min\":0.0,\"title\":{\"text\":\"Rainfall (mm)\"}}})'";
////						String turlututu = "var turlututu = '({\"chart\":{\"width\":800,\"formatter\":\"function() {return \'<b>\'+ this.point.name +\'</b>: \'+ this.y +\' %\';}\",\"height\":600,\"marginLeft\":70,\"marginTop\":80},\"plotOptions\":{\"area\":{\"borderWidth\":0},\"areaspline\":{\"borderWidth\":0},\"line\":{\"borderWidth\":0},\"pie\":{\"dataLabels\":{\"color\":\"#000000\",\"enabled\":true,\"align\":\"center\",\"rotation\":0.0},\"allowPointSelect\":true,\"borderWidth\":0},\"series\":{\"borderWidth\":0},\"spline\":{\"borderWidth\":0},\"column\":{\"borderWidth\":0},\"bar\":{\"borderWidth\":0}},\"series\":[{\"data\":[{\"y\":45.0,\"name\":\"Firefox\"},{\"y\":26.8,\"name\":\"IE\"},{\"y\":12.8,\"selected\":true,\"sliced\":true,\"name\":\"Chrome\"},{\"y\":8.5,\"name\":\"Safari\"},{\"y\":6.2,\"name\":\"Opera\"},{\"y\":0.7,\"name\":\"Others\"}],\"name\":\"Browser share\",\"type\":\"pie\"}],\"title\":{\"text\":\"Browser market shares at a specific website, 2010\"}})';";
////						String replace = chartOptions.replace ('\n', ' ');
////						replace = replace.replace ("\'", "\\\'");
////						String turlututu = "var turlututu = '("+replace+");";//{\"chart\":{\"width\":800,\"height\":600,\"marginLeft\":70,\"marginTop\":80},\"plotOptions\":{\"area\":{\"borderWidth\":0},\"areaspline\":{\"borderWidth\":0},\"line\":{\"borderWidth\":0},\"pie\":{\"dataLabels\":{\"color\":\"#000000\",\"enabled\":true,\"align\":\"center\",\"rotation\":0.0},\"allowPointSelect\":true,\"borderWidth\":0},\"series\":{\"borderWidth\":0},\"spline\":{\"borderWidth\":0},\"column\":{\"borderWidth\":0},\"bar\":{\"borderWidth\":0}},\"series\":[{\"data\":[{\"y\":45.0,\"name\":\"Firefox\"},{\"y\":26.8,\"name\":\"IE\"},{\"y\":12.8,\"selected\":true,\"sliced\":true,\"name\":\"Chrome\"},{\"y\":8.5,\"name\":\"Safari\"},{\"y\":6.2,\"name\":\"Opera\"},{\"y\":0.7,\"name\":\"Others\"}],\"name\":\"Browser share\",\"type\":\"pie\"}],\"title\":{\"text\":\"Browser market shares at a specific website, 2010\"}})';";
//						StringReader reader = new StringReader (turlututu);
//						try {
//							Script script = cx.compileReader (SCRIPTABLE, reader, null, 1, null);
//							script.exec (cx, SCRIPTABLE);
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						SVGHighchartsHelper.LOGGER.trace ("set langage version to 1.6");
		        cx.setLanguageVersion (Context.VERSION_1_6);
		        
		        
		        SVGHighchartsHelper.LOGGER.trace ("set optimization level to -1");
		        cx.setOptimizationLevel (-1);// bypass the 64k limit // interpretive mode

		        for (Script s: scripts) {
		        	s.exec(cx, SCRIPTABLE);
		        }
						
					}
					private final Context cx;
				}
	    });
	    
	    if (call == null)
	      throw new NullPointerException ("problem during svg generation");
	      
	    String svg = call.toString ();
	    //post treatement
	    if (SVGHighchartsHelper.HIGHCHARTS_2_1_2) {
	      svg = svg.substring (svg.indexOf ("<svg"), svg.indexOf ("</div>"));
	    } else 
	      svg = svg.replace ("clippath", "clipPath");
	    
	    if (SVGHighchartsHelper.LOGGER.isTraceEnabled ()) SVGHighchartsHelper.LOGGER.trace ("svg rendered : \n" + svg);
	    return svg;
	  }

		private static ContextFactory getContextFactory () {
			return org.mozilla.javascript.tools.shell.Main.shellContextFactory;
		}
	  protected Scriptable SCRIPTABLE;
		private List<Script> scripts;
		
	}