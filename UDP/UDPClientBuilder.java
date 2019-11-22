import java.io.IOException;
import java.net.*;

class UDPClientBuilder extends UDPRWText {
	InetSocketAddress isA;
	DatagramSocket s;
	DatagramPacket req, rep;
	final int size = 2048;
	
	UDPClientBuilder() {
		isA = null; s = null; req = rep = null;
	}
	
	protected void setConnection() throws IOException {
		s = new DatagramSocket();
		s.setSoTimeout(6000);
		isA = new InetSocketAddress("192.168.43.164",8080);
		/** we can include more setting, later … */
	}
	
}

class UDPClientHello extends UDPClientBuilder implements Runnable {
	
	public void run() {
		
		try {
			setConnection();
			req = new DatagramPacket(new byte[size],0,size,isA.getAddress(),isA.getPort());
			s.send(req);
			System.out.println("request sent");
			rep = new DatagramPacket(new byte[size],size);
			s.receive(rep);
			System.out.println("reply received");
			s.close();
		}
		catch(IOException e) {
			System.out.println("IOException UDPClient");
		}
		
	}
}