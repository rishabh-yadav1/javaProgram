import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerException;

import javax.sql.DataSource;

import java.io.*;

public class ServerTcp
{
    public static void main(String args[]) throws ServerException,IOException
    {
        ServerSocket ss=new ServerSocket(9999);
        //Socket s=ss.accept();
        int count=0;
        System.out.println("Server started");
        while(true)
        {
            Socket s = ss.accept();
            count++;
            System.out.println(">> Client no"+count+"Started");
            ServerClientThread sct=new ServerClientThread(s,count);
            sct.start();
            ss.close();
        }
    }
}
class ServerClientThread extends Thread
{
    Socket sc;
    int clientno;
    ServerClientThread(Socket c,int count)
    {
        sc=c;
        clientno=count;
    
    }
    public void run()
    {
        try
         {
                DataInputStream dis = new DataInputStream(sc.getInputStream());
                DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
              // Console con=System.console(); 
               String clientmsg, servermsg;
               do
                {
                    clientmsg = dis.readUTF();
                    System.out.println("From Client :" + clientmsg);
                    servermsg = br.readLine();
                    dos.writeUTF(servermsg);
                    dos.flush();
                } while (!clientmsg.equals("bye")) ;
                System.out.println("client"+clientno+"closed connection");
                dis.close();
                dos.close();
                sc.close(); 
        } catch (Exception e)
         
        {
            System.out.println(e);
        }
        
       
    }
}