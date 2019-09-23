import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerException;

import javax.print.DocFlavor.STRING;

//import jdk.internal.util.xml.impl.ReaderUTF16;

 class ServerSide
{
    public static void main(String [] args) throws ServerException,IOException
    {
        ServerSocket ss=new ServerSocket(9000);
        int count=0;
        System.out.println("server Started");
        while(true)
        {
            count++;
            Socket s=ss.accept();
            
            System.out.println(">> client_No "+count+"Started");
            ServerClientThread sct=new ServerClientThread(s,count);
            sct.start();
           // s.close();
        }
    
    }
}
class ServerClientThread extends Thread
{
    Socket sc;
    int client_No;
    ServerClientThread(Socket s, int count )
    {
        sc=s;
        client_No=count;
    }
    public void run()
    {
        try 
        {
            int  client_msg=0;
            int result;
           DataInputStream dis=new DataInputStream(sc.getInputStream());
          // DataOutputStream dos=new DataOutputStream(sc.getOutputStream());
          // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
           do 
           {
               result=dis.read();
               System.out.println(result);
                
           } while (client_msg!=1);
           System.out.println("ClientNO"+client_No+"closed Connection");
           dis.close();
            //dos.close();
            sc.close();

        } catch (Exception e) 

        {
        System.out.println(e);
        }
    }

}