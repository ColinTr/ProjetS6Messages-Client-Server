import java.io.IOException;

class TCPClientInfo extends TCPClientBuilder implements Runnable {
		public void run( ) {
		try {
			setSocket(); sInfo("The client sets the passive socket", s);
			s.close(); sInfo("The client closes a connexion", s);
		}
		catch(IOException e) {
			System.out.println("IOException TCPClientInfo");
		}
	}
}