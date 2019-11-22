import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

class TCPClientBuilder extends TCPFile {
	Socket s;
	InetSocketAddress isA;
	TCPClientBuilder() {
		s = null;
		isA = null;
	}
	protected void setSocket() throws IOException {
		isA = new InetSocketAddress("localhost",8090);
		//isA = new InetSocketAddress("192.168.43.134",8080); //Yang
		//isA = new InetSocketAddress("192.168.43.164",8080); //Guillaume
		s = new Socket(isA.getHostName(), isA.getPort());
		s.setSoTimeout(1000);
		setStreamBuffer(s.getSendBufferSize());
	}
}
class TCPClientHello extends TCPClientBuilder implements Runnable {
	public void run() {
		try {
			System.out.println("TCPClientHello launched ...");
			setSocket();
			System.out.println("Hello, the client is connected");
			s.close();
		}
		catch(IOException e) {
			System.out.println("IOException TCPClientHello");
		}
	}
} 