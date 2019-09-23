import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer
{
    public static void main(String args[] ) 
    {
        try 
        {
            ServerSocket ss=new ServerSocket(8888);
            Socket client=ss.accept();
            DataInputStream dis=new DataInputStream(client.getInputStream());
            int result=dis.read();
           System.out.println("Result= "+result);

            dis.close();
            ss.close();
            client.close();
        } catch (Exception e)
        {
            System.out.println(e);
        }

    }
}