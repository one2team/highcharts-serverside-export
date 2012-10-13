import org.apache.commons.io.IOUtils;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextAction;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.tools.shell.Main;
import org.mozilla.javascript.tools.shell.ShellContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RhinoTest {
    static final Logger LOGGER = LoggerFactory.getLogger(RhinoTest.class);
    static private Scriptable SCRIPTABLE;
    static private List<Script> scripts;

    public static void main(String[] args) {
        ShellContextFactory cxFactory = Main.shellContextFactory;

        cxFactory.call(new ContextAction() {
            @Override
            public Object run(Context cx) {
                final Initiator initiator = new Initiator(cx).init();

                LOGGER.trace("Run script");
                try {
                    return initiator.execute();
                } finally {
                }
            }

            class Initiator {
                Initiator(Context context) {
                    this.cx = context;
                }

                Initiator init() {
                    if (SCRIPTABLE == null)
                        createScriptable();
                    initContext();
                    return this;
                }

                Object execute() {
                    return null;
                }

                void createScriptable() {

                    LOGGER.trace("init standard objects");
                    SCRIPTABLE = cx.initStandardObjects();

                    LOGGER.trace("set optimization level to -1");
                    cx.setOptimizationLevel(-1);// bypass the 64k limit // interpretive mode
                    attachJs("env.rhino-1.2.js");


                    LOGGER.trace("set optimization level to 9");
                    cx.setOptimizationLevel(9);

                }

                @SuppressWarnings("deprecation")
                private void attachJs(String jsFileName) {
                    InputStream in = null;
                    InputStreamReader reader = null;
                    if (LOGGER.isDebugEnabled()) LOGGER.debug("loading " + jsFileName);
                    try {
                        in = RhinoTest.class.getResourceAsStream(jsFileName);
                        if (in == null)
                            throw new RuntimeException("cannot find js file : " + jsFileName);

                        reader = new InputStreamReader(in);
                        if (scripts == null)
                            scripts = new ArrayList<Script>();
                        scripts.add(cx.compileReader(SCRIPTABLE, reader, jsFileName, 1, null));

                        if (LOGGER.isDebugEnabled()) LOGGER.debug("loaded " + jsFileName);
                    } catch (IOException e) {
                        throw new RuntimeException("cannot load js file : " + jsFileName, e);
                    } finally {
                        IOUtils.closeQuietly(in);
                        IOUtils.closeQuietly(reader);
                    }
                }

                void initContext() {
                    LOGGER.trace("set optimization level to -1");
                    cx.setOptimizationLevel(-1);// bypass the 64k limit // interpretive mode

                    for (Script s : scripts) {
                        s.exec(cx, SCRIPTABLE);
                    }

                }

                private final Context cx;
            }
        });


    }
}

