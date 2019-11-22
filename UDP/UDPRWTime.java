import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;

public class UDPRWTime extends UDPRWEmpty{
	
	private byte[] sB; /** The buffer array. */
	private long tstamp; /** The timestamp. */
	
	/** To get the local time. */
	protected long getLocalTime() {
		return System.nanoTime();
	}
	
	/** To get the timestamp. */
	protected long getTimeStamp() {
		return System.currentTimeMillis();
	}
	
	/** To get a sending packet with a timestamp. */
	protected DatagramPacket getTimeSendingPacket(InetSocketAddress isA, int size) throws IOException {
		tstamp = getTimeStamp(); sB = toBytes(tstamp, new byte[size]);
		return new DatagramPacket(sB,0,sB.length,isA.getAddress(),isA.getPort());
	}
	
	/** To set the timestamp to a parametter packet. */
	protected void setTimeStamp(DatagramPacket dP) {
		tstamp = getTimeStamp(); sB = toBytes(tstamp, dP.getData());
	}
	
	private byte[] toBytes(long data, byte[] lbuf) {
		for(int i=0;i<8;i++)
		lbuf[i] = (byte)((data >> (7-i)*8) & 0xff);
		return lbuf;
	}
	
	/** To extract timestamp from a receiving packet. */
	protected long getTimeStamp(DatagramPacket dP) { return getLong(dP.getData()); }
		private long getLong(byte[] by) {
		value = 0;
		for (int i = 0; i < 8; i++) {
			value = (value << 8) + (by[i] & 0xff);
		}
		return value;
	}
		
	private long value;
}