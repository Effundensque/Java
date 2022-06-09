package eu.ase.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClientSocket implements AutoCloseable{

	private DatagramSocket socket;
	
	public UDPClientSocket() throws SocketException
	{
		socket=new DatagramSocket();
	}
	
	public String sendAndReceiveMsg(String msg, String ipAddr, int port) throws UnknownHostException
	{
		
		String messageReceived="";
		
		try
		{
			byte[] bytes = new byte[256];
			bytes=msg.getBytes();
			InetAddress address = InetAddress.getByName(ipAddr);
			DatagramPacket packet = new DatagramPacket(bytes,bytes.length,address,port);
			socket.send(packet);
			
			
			DatagramPacket packet1 = new DatagramPacket(bytes,bytes.length);
			socket.receive(packet1);
			messageReceived = new String (packet1.getData());
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return messageReceived;
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
