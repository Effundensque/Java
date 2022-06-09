package eu.ase.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServerSocket implements AutoCloseable{

	private DatagramSocket socket;
	private int bindPort;
	
	public UDPServerSocket() throws SocketException{
		bindPort=60001;
		socket=new DatagramSocket(bindPort);
	}
	
	public int getBindPort()
	{
		return bindPort;
	}
	
	public void processRequest() throws IOException
	{
		String messageReceived;
		byte[] bytes=new byte[256];
		DatagramPacket packet1 = new DatagramPacket(bytes,bytes.length);
		socket.receive(packet1);
		messageReceived = new String (packet1.getData());
		
		String sendMessage="";
		if (messageReceived.contains("Q?"))
		{
			sendMessage="UDPQ";
			bytes=new byte[256];
			bytes=sendMessage.getBytes();
			DatagramPacket sendPacket=new DatagramPacket(bytes,bytes.length,packet1.getAddress(),packet1.getPort());
			socket.send(sendPacket);
			
		}else
			if (messageReceived.contains("BYE"))
			{
				sendMessage="BYE ACK";
				bytes=new byte[256];
				bytes=sendMessage.getBytes();
				DatagramPacket sendPacket=new DatagramPacket(bytes,bytes.length,packet1.getAddress(),packet1.getPort());
				socket.send(sendPacket);
				socket.close();
				
			}
			else
			{
				
					sendMessage="ACK";
					bytes=new byte[256];
					bytes=sendMessage.getBytes();
					DatagramPacket sendPacket=new DatagramPacket(bytes,bytes.length,packet1.getAddress(),packet1.getPort());
					socket.send(sendPacket);
					
			}
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}


}
