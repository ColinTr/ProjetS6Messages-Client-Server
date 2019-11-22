import java.io.IOException;

public class TCPClientLMessage extends TCPClientBuilder implements Runnable{
	
	public void run() {
		try {
			setSocket();
			setStreamBuffer(9999999);
			loopWriteMessage(s.getOutputStream(), 1);
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}