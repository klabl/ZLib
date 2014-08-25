package zservers.zlib.main;

import java.util.logging.Logger;

public interface ZMain {

	public void err(String... err);
	public void err(Throwable ex, String... err);

    public void wrn(String... wrn);
    public void wrn(Throwable ex, String... wrn);

	public void inf(String... inf);

	public void dbg(String... dbg);
    public void dbg(Throwable ex, String... dbg);

	public Logger getLogger();

	public int getLogLevel();
	public String getServerName();
}
