import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

class TcpClient
{
    public static void main(String[] args)
    {
        try 
        {
            Socket client=new Socket("localHost",8888);
            DataOutputStream dos=new DataOutputStream(client.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int a,b;
            System.out.println("enter the two number");
            a=Integer.parseInt(br.readLine());
            //b=Integer.parseInt(br.readLine());
            int result= a*a;

            dos.write(result);
            client.close();
        } catch (Exception e) 
        {
            System.out.println(e);
        }    
    }
}