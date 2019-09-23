import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSide
{
    public static void main(String []args)  throws Exception
    {
        Socket s=new Socket(InetAddress.getLocalHost(),9000);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        DataInputStream dis=new DataInputStream(s.getInputStream());
        DataOutputStream dos=new DataOutputStream(s.getOutputStream());
        String msg="";
        int a,result;
        while(!msg.equalsIgnoreCase("bye"))
        {
            a=Integer.parseInt(br.readLine());
            result=a*a;
            //System.out.println(result);
            dos.write(result);

        }
       // dis.close();
        dos.close();
        s.close();
    }
}