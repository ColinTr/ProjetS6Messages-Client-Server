import java.io.IOException;

public class TCPClientMessage extends TCPClientBuilder implements Runnable{
	
	public void run() {
		try {
			setSocket();
			writeMessage(s.getOutputStream(), "Bonjour j'aime le beurre !");
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}