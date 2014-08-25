package zservers.zlib.utilities;

import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReaderThread extends Thread {

	public static final Object LOCK = new Object();

	private Scanner in;
	private ConsoleReader reader;

	public ReaderThread(ConsoleReader reader) {

		this.reader = reader;
		in = new Scanner(new InputStreamReader(System.in));
		this.setDaemon(false);
	}

	public void run() {

		while(!isInterrupted()) {

			String line = "";
			try {

                do {

                    String prompt = reader.getPrompt();

                    System.out.print(prompt == null ? "> " : prompt);

                    line = in.nextLine();
                } while (line.equals(""));

                boolean wait;
                if (line.contains(" ")) {
                    String command = line.substring(0, line.indexOf(" "));

                    String args[] = line.substring(line.indexOf(" ") + 1, line.length()).split(" ");

                    wait = reader.command(command, args);
                } else {

                    wait = reader.command(line, new String[0]);
                }

                if (wait) {

//					long time = System.currentTimeMillis();
                    synchronized (LOCK) {
                        LOCK.wait(1000);
                    }
//					if(Math.abs(System.currentTimeMillis() - time) > 100) System.out.println("timeout: " + (Math.abs(System.currentTimeMillis())  - time));
                }

            } catch (NoSuchElementException ex) {

                System.err.println(" ReaderThread terminated, EOF");
                return;
			} catch(InterruptedException ex) {

				System.err.println(" ReaderThread terminated, interrupt");
				return;
			} catch(ThreadDeath death) {

				System.err.println(" ReaderThread terminated, death");
				throw death;
			}
		}
		System.err.println(" ReaderThread terminated, end");
	}
}
