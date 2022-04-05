import java.io.*;
import java.net.*;
import java.util.Scanner;
public class UDPServer
{
    public static void main(String[] args) throws Exception
    {
        DatagramSocket serverSocket= new DatagramSocket(9876);
        System.out.println("Server started");
        byte[] receivedata = new byte[1024];
        byte[] senddata = new byte[1024];
        DatagramPacket receivePacket= new DatagramPacket(receivedata,receivedata.length);
        serverSocket.receive(receivePacket);
        receivePacket.getData();
        InetAddress IPAdress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        System.out.println("client connected");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter msg to be sent");
        String msg= sc.nextLine();
        senddata=msg.getBytes();
        DatagramPacket sendPacket= new DatagramPacket(senddata,senddata.length,IPAdress,port);
        serverSocket.send(sendPacket);
        System.exit(0);


        
    }
}