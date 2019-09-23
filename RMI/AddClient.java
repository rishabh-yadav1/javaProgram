import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.Naming.*;
import java.rmi.server.*;

public class AddClient
{
    public static void main(String args[])
    {
        String host="Localhost";
        try 
        {
            BufferedReader br= new  BufferedReader( new InputStreamReader(System.in));
            System.out.println("enter the first number");
            int a=Integer.parseInt(br.readLine());
            System.out.println("enter the second number");
            int b = Integer.parseInt(br.readLine());
            Addnum remobj=(Addnum)Naming.lookup("rmi://"+host+"/AddNum");
            System.out.println(remobj.addno(a,b));
        } catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}