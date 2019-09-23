import java.rmi.*;
import java.rmi.server.*;

public class AddNumImp extends UnicastRemoteObject  implements Addnum
{
    public AddNumImp() throws RemoteException
    {
            super();
    }
    public int addno(int a,int b)
    {
        return(a+b);
    }
}