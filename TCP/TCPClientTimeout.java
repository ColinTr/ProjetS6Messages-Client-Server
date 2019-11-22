import java.io.IOException;

class TCPClientTimeout extends TCPClientBuilder implements Runnable {
	public void run() {
		try {
			setSocket();
			s.close();
		}
		catch(IOException e) {
			System.out.println("IOException TCPClientTimeout");
		}
	}
}