import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client
{
    public static void main(String[] args) throws Exception,FileNotFoundException
    {
        Socket sock= new Socket("192.168.1.6",5000);
        System.out.println("Enter file name");
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String fname= reader.readLine();
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite= new PrintWriter(ostream,true);
        pwrite.println(fname);
        InputStream istream = sock.getInputStream();
        BufferedReader toread = new BufferedReader(new InputStreamReader(istream));
        String str;
        while((str=toread.readLine())!=null)
        {
            System.out.println(str);
        }
        pwrite.close();
        sock.close();
        toread.close();
    }
}