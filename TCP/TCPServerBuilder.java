import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServerBuilder extends TCPFile {
	ServerSocket ss;
	Socket s;
	InetSocketAddress isA;
	TCPServerBuilder() {
		s = null;
		ss = null;
		isA = null;
	}
	protected void setSocket() throws IOException {
		isA = new InetSocketAddress("localhost",8090);
		ss = new ServerSocket(isA.getPort()); 
		ss.setSoTimeout(5000);
		setStreamBuffer(ss.getReceiveBufferSize());
	}
}
class TCPServerHello extends TCPServerBuilder implements Runnable {
	public void run() {
		try {
			System.out.println("TCPServer launched ...");
			setSocket();
			s = ss.accept();
			System.out.println("Hello, the server accepts");
			s.close();
			ss.close();
		}
		catch(IOException e) {
			System.out.println("IOException TCPServerHello");
		}
	}
} 