import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.net.Socket;
import java.nio.Buffer;


class MyClient
{
    public static void main(String[] args) throws Exception

    {
        Socket s=new Socket("localhost",6666);
        InputStream is=s.getInputStream();   
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        String str;
        while((str=br.readLine())!=null)
        {
            System.out.println("From Server"+str);
        }
        br.close();
        s.close();
        
    }
}
