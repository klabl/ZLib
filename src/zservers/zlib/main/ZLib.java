package zservers.zlib.main;

import java.util.logging.Logger;

public class ZLib implements ZMain {

	private static ZLib instance;

	private ZMain main;
	private Logger logger;

	static {

		instance = new ZLib();
	}

	private ZLib() {}

	static boolean setMainClass(ZMain main) {

		if(instance.main != null) return false;

		instance.main = main;
		instance.logger = main.getLogger();

        return true;
	}

	public static ZLib getInstance() {

		return instance;
	}

	@Override
	public void err(String... err) {

		if(main == null) return;

		main.err(err);
	}

	@Override
	public void err(Throwable ex, String... err) {

		if(main == null) return;

		main.err(ex, err);
	}

    @Override
    public void wrn(String... wrn) {

        if(main == null) return;

        main.wrn(wrn);
    }

    @Override
    public void wrn(Throwable ex, String... wrn) {

        if(main == null) return;

        main.wrn(ex, wrn);
    }

    @Override
	public void inf(String... inf) {

		if(main == null) return;

		main.inf(inf);
	}

	@Override
	public void dbg(String... dbg) {

		if(main == null) return;

		main.dbg(dbg);
	}

    @Override
    public void dbg(Throwable ex, String... dbg) {

        if(main == null) return;

        main.dbg(ex, dbg);
    }

    @Override
	public int getLogLevel() {

		if(main == null) return 0;
		return main.getLogLevel();
	}

	@Override
	public String getServerName() {

		if(main == null) return "UNDEFINED";
		return main.getServerName();
	}

	@Override
	public Logger getLogger() {

		return logger;
	}

    public String getVersion() {

        return "v0.1 Alpha";
    }
}
