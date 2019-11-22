import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;

public class UDPServerNTP extends UDPServerBuilder implements Runnable {
	
	public void run() {
		
		try {
			 setConnection();
			 req = new DatagramPacket(new byte[size], size);
			 s.receive(req);
			 
			 req = getTimeSendingPacket((InetSocketAddress)req.getSocketAddress(), size);
			 s.send(req);
			 s.close();
			 return;
		 }
		 catch(IOException e) {
			 System.out.println("IOException UDPServerNTP");
		 }
	}
}