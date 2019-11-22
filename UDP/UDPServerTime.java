import java.io.IOException;
import java.net.DatagramPacket;

public class UDPServerTime extends UDPServerBuilder implements Runnable {
	
	public void run() {
		
		long k = 0;

		 try {
			setConnection();
		} catch (IOException e1) { e1.printStackTrace(); }
		 
		while(true){
			try {
				 req = getTextSendingPacket(isA, "", size);
				 //System.out.println("Server waiting...");
				 s.receive(req);
				 long reponse = getTimeStamp(req);
				 System.out.println("received : " + (getTimeStamp()-reponse-k));
				 
			 }
			 catch(IOException e) {
				 s.close();
				 System.out.println("IOException UDPServer");
				 break;
			 }
		}
	 }
	
}