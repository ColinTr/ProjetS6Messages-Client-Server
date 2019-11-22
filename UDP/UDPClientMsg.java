import java.io.IOException;

import java.util.*;

public class UDPClientMsg extends UDPClientBuilder implements Runnable {
	
	private Scanner sc; 
	
	public void run(){
		
		try {
			setConnection();
		} catch (IOException e1) { e1.printStackTrace(); }
		
		while(true){
			sc = new Scanner(System.in);
			String msg = sc.nextLine();
			if(msg.equals("quit")){
				s.close();
				sc.close();
				System.out.println("Client closed");
				return;
			}
			try {
				req = getTextSendingPacket(isA, "", size);
				setMsg(req, msg);
				s.send(req);
				//System.out.println("Client sent msg...");
				
			}
			catch(IOException e) {
				sc.close(); 
				s.close();
				System.out.println("IOException UDPClient");
			}
		}
	}
}