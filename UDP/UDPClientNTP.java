import java.io.IOException;
import java.net.DatagramPacket;

public class UDPClientNTP extends UDPClientBuilder implements Runnable {
	
	public void run(){
		
		try {
			setConnection();
			req = getTimeSendingPacket(isA, size);
			s.send(req);
			
			rep = new DatagramPacket(new byte[size], size);
			s.receive(rep);
			long T4 = getTimeStamp(); 
			long T1 = getTimeStamp(req);
			System.out.println("Estimation k = "+ ((T4-T1)/2));
			s.close();
			return;
		}
		catch(IOException e) {
			System.out.println("IOException UDPClientNTP");
		}
	}
}