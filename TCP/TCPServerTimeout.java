import java.io.IOException;
import java.net.Socket;

class TCPServerTimeout extends TCPServerBuilder implements Runnable {
	
	public void run() {
		try {
			setSocket();
			while(true) {
				s = ss.accept();
				new Thread(new ServerTimeout(s)).start();
			}
		}
		catch(IOException e) {
			System.out.println("IOException TCPServerTimeout");
		}
	}
}

class ServerTimeout implements Runnable {
	private Socket s;
	ServerTimeout(Socket s) {this.s = s;}
	public void run() {
		try {
			s.setSoTimeout(1000);
			/** read operation, to do … */
			s.close();
		}
		catch(IOException e)
		{ System.out.println("IOException ServerTimeout"); }
	}
}