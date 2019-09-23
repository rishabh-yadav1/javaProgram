import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

//import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Output;

class MyServer
 {
     public static void main(String[] args) throws Exception
        {
           ServerSocket ss=new ServerSocket(6666);
           Socket s=ss.accept();
           System.out.println("con estd");       
           OutputStream os=s.getOutputStream();
           PrintStream ps=new PrintStream(os);
           String str="hello moto";
           ps.println(str);
            ps.println("bye");
          ps.close();
          ss.close();
          s.close();
        
        }
 
}