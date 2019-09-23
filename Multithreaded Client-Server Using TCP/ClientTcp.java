import java.io.*;
import java.net.*;

class ClientTcp {
    public static void main(String[] args) throws Exception 
    {
        Socket sc = new Socket(InetAddress.getLocalHost(), 9999);
       // Console con = System.console();
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(sc.getOutputStream());
        DataInputStream dis = new DataInputStream(sc.getInputStream());
         String msg = "";
         System.out.println("enter the msg >>"+msg);
        while (!msg.equalsIgnoreCase("bye")) {
            msg = br.readLine();
            System.out.println("msg >>" + msg);    
            System.out.println("sent msg " + msg);

            dos.writeUTF(msg);
            String s = dis.readUTF();
            System.out.println("From Server: " + s);
        }
        dis.close();
        dos.close();
        sc.close();
    }
}