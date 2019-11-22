import java.io.IOException;

import java.util.*;

public class UDPClientTime extends UDPClientBuilder implements Runnable {
	
	public void run(){
		
		try {
			setConnection();
		} catch (IOException e1) { e1.printStackTrace(); }
		
		while(true){
			try {
				req = getTimeSendingPacket(isA, size);
				setTimeStamp(req);
				s.send(req);
				Thread.sleep(250);
				//System.out.println("Client sent msg...");
				
			}
			catch(IOException | InterruptedException e) {
				s.close();
				System.out.println("IOException UDPClient");
			}
		}
	}
}