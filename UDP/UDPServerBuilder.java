import java.io.IOException;
import java.net.*;

public class UDPServerBuilder extends UDPRWText {
	InetSocketAddress isA; // the address
	DatagramSocket s; // the socket object
	DatagramPacket req, rep; // to prepare the request and reply messages
	final int size = 2048; // the default size for the buffer array
	 /** The builder. */ 
	UDPServerBuilder() {
		s = null; req = rep = null;
	}
	
	protected void setConnection() throws IOException {
		isA = new InetSocketAddress("localhost",8080);
		s = new DatagramSocket(isA.getPort());
		s.setSoTimeout(6000);
	}
	
}

class UDPServerHello extends UDPServerBuilder implements Runnable {
	/** The main run method for threading. */
	public void run( ) {
		try {
			 setConnection();
			 req = new DatagramPacket(new byte[size],size);
			 s.receive(req);
			 System.out.println("request received");
			 rep = new DatagramPacket(new byte[size],0,size,req.getSocketAddress());
			 s.send(rep);
			 System.out.println("reply sent");
			 s.close();
		 }
		 catch(IOException e) {
			 System.out.println("IOException UDPServer");
		 }
	 }
}