import java.io.*;
import java.net.*;
import java.util.Scanner;
public class UDPClient
{
    public static void main(String[] args) throws Exception     
    {
       BufferedReader infromuser = new BufferedReader(new InputStreamReader(System.in));
       DatagramSocket clientSocket=new DatagramSocket();
       InetAddress IPAdress = InetAddress.getByName("localhost");
       byte[] senddata=new byte[1024];
       byte[] receivedata=new byte[1024];
       System.out.println("Enter start to connect server");
       String sen=infromuser.readLine();
       senddata=sen.getBytes();
       DatagramPacket sendPacket = new DatagramPacket(senddata,senddata.length,IPAdress,9876);
       clientSocket.send(sendPacket);
       DatagramPacket receivePacket= new DatagramPacket(receivedata,receivedata.length);
       clientSocket.receive(receivePacket);
       String msen= new String(receivePacket.getData());
       System.out.println("Message received from server is "+msen);
    }
}