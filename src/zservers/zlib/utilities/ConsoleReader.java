package zservers.zlib.utilities;

public interface ConsoleReader {
	
	public boolean command(String command, String[] args);
	
	public String getPrompt();
}
