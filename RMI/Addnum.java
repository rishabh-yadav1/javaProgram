import java.rmi.*;
public interface Addnum extends Remote
{
    public int addno(int a,int b) throws Exception;
}