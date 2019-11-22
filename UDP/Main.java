public class Main {

	public static void main(String[] args) {
		new Thread(new UDPClientNTP()).start();
		new Thread(new UDPServerNTP()).start();
		//new Thread(new UDPClientTime()).start();
		//new Thread(new UDPServerTime()).start();
		//new Thread(new UDPClientMsg()).start();
		//new Thread(new UDPServerMsg()).start();
	}

}