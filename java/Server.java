import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Server
{
    public static void main(String[] args) throws Exception,FileNotFoundException
    {
        ServerSocket serversocket= new ServerSocket(5000);
        System.out.println("Server started");
        Socket sock= serversocket.accept();
        System.out.println("Connection established");
        InputStream istream=sock.getInputStream();
        BufferedReader  bufferedreader= new BufferedReader(new InputStreamReader(istream));
        String fname= bufferedreader.readLine();
        BufferedReader contentreader = new BufferedReader(new FileReader(fname));
        OutputStream ostream=sock.getOutputStream();
        PrintWriter pwrite= new PrintWriter(ostream,true);
        String str;
        while((str=contentreader.readLine())!=null)
        {
            pwrite.println(str);
        }
        System.out.println("File sent successfully");
        sock.close();
        serversocket.close();
        pwrite.close();
        bufferedreader.close();
        contentreader.close();

    }
}
