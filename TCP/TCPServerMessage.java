import java.io.IOException;

public class TCPServerMessage extends TCPServerBuilder implements Runnable{
	
	public void run() {
		try {
			setSocket();
			s = ss.accept();
			String messageLu = readMessage(s.getInputStream());
			System.out.println("Message lu : " + messageLu);
			s.close();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}