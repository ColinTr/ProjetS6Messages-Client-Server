import java.net.*;
import java.io.*;
class TCPClient implements Runnable {
	private Socket s; // the client socket
	private InetSocketAddress isA; // the remote address
	/** The builder. */
	TCPClient() {
		s = null;
		isA = new InetSocketAddress("192.168.43.134",8085);
	}
	/** The main method for threading. */
	public void run() {
		try {
			System.out.println("TCPClient launched ...");
			s = new Socket(isA.getHostName(), isA.getPort());
			System.out.println("Hello, the client is connected");
			s.close();
		}
		catch(IOException e) {
			System.out.println("IOException TCPClient");
		}
	}
}