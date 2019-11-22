import java.io.IOException;
import java.net.DatagramPacket;

public class UDPServerMsg extends UDPServerBuilder implements Runnable {
	
	public void run() {

		 try {
			setConnection();
		} catch (IOException e1) { e1.printStackTrace(); }
		 
		while(true){
			try {
				 req = getTextSendingPacket(isA, "", size);
				 //System.out.println("Server waiting...");
				 s.receive(req);
				 String reponse = getMsg(req);
				 System.out.println("received : " + reponse);
				 
			 }
			 catch(IOException e) {
				 s.close();
				 System.out.println("IOException UDPServer");
				 break;
			 }
		}
	 }
	
}