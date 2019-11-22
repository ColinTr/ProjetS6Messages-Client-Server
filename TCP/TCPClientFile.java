import java.io.FileInputStream;
import java.io.IOException;

public class TCPClientFile extends TCPClientBuilder implements Runnable{
	public void run() {
		try {
			setSocket();
			setStreamBuffer(9999999);
			//FileInputStream fis = new FileInputStream();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}