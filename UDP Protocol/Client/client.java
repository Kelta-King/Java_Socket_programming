import java.io.*; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.net.SocketException; 

public class client {

    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket();
        
        byte[] bt1 = String.valueOf(0).getBytes();
		//here this i can contain values of 0 or 1
        InetAddress ia = InetAddress.getLocalHost();
		
		int port = 6666;
		
        DatagramPacket dp1 = new DatagramPacket(bt1,bt1.length,ia,port);
        ds.send(dp1);
		Boolean yo = true;
		int i = 0;
		
        while(true){
			
            byte[] bt2 = new byte[1024];
            DatagramPacket dp2 = new DatagramPacket(bt2, bt2.length);
            ds.receive(dp2);
            String output = new String(dp2.getData(), 0, dp2.getLength());
            System.out.println(output);		
			
        }

    }
}
