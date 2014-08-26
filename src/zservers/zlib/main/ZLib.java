package zservers.zlib.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ZLib {

    public static final ZLib INSTANCE = new ZLib();

	public static final Logger LOG = LogManager.getLogger("ZServers.ZLib");

    public static final String VERSION = "0.1.0-alpha";

	private ZLib() {

        //TODO move the log4j2.xml file outside the jar file
    }
}
