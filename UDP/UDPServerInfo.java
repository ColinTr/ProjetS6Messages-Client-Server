import java.io.IOException;

class UDPServerInfo extends UDPServerBuilder implements Runnable {
	
	public void run() {
		try {
			setConnection(); socketInfo("Server sets the connection",s);
			s.close(); socketInfo("Server closes the connection",s);
		}
		catch(IOException e)
		{
			System.out.println("IOException UDPClient");
		}
	}
}