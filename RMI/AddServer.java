import java.rmi.*;
import java.net.*;
public class AddServer
{
    public static void  main( String agrs[])
    {
        try 
        {
            AddNumImp locobj=new AddNumImp();
            Naming.rebind("rmi:///AddNum", locobj);
        } catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}