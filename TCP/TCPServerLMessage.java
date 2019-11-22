import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TCPServerLMessage extends TCPServerBuilder implements Runnable {
	public void run() {
		try {
			setSocket();
			while(true){
				s = ss.accept();
				new Thread(new ServerLMessageAccept(s)).start();
			}
			
		}
		catch(IOException e) {
			System.out.println("IOException TCPServerTimeout");
		}
	}
}

class ServerLMessageAccept extends TCPServerBuilder implements Runnable {
	private Socket s;
	ServerLMessageAccept(Socket s) {this.s = s;}
	public void run() {
		try {
			s.setSoTimeout(1000);
			InputStream in = s.getInputStream();
			setStreamBuffer(s.getSendBufferSize());
			long volumeDonneesEchangees = 0;
			int inRead = 0;
			do{
				String messageLu = new String(buffer, 0, inRead);
				System.out.println(messageLu);
				volumeDonneesEchangees += inRead;
				inRead = in.read(buffer);
			}
			while(inRead != -1);
			System.out.println("Volume total lu = " + volumeDonneesEchangees);
			in.close();
			s.close();
		}
		catch(IOException e)
		{ System.out.println("IOException ServerTimeout"); }
	}
}