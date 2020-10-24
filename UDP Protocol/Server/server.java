import java.io.*; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.net.SocketException; 

public class server {

    public static void main(String[] args) throws IOException {
        
		DatagramSocket ds = new DatagramSocket(6666);

		System.out.println("Server is listing on port 6666");

        byte[] bt1 = new byte[1024];
        DatagramPacket dp1 = new DatagramPacket(bt1,bt1.length);
        ds.receive(dp1);
		
        int num = Integer.parseInt(new String(dp1.getData(),0,dp1.getLength()).trim());
        System.out.println(num);

        if (num == 0) {
            Process p = Runtime.getRuntime().exec("cmd /c dir");
            BufferedReader reader = new BufferedReader(new
            InputStreamReader(p.getInputStream()));
            String line=reader.readLine();
            
			while (line!=null) {
            
				byte[] bt2 = (line+"").getBytes();
                InetAddress ia = InetAddress.getLocalHost();
                DatagramPacket dp2 = new DatagramPacket(bt2,bt2.length,ia,dp1.getPort());
                ds.send(dp2);
                line = reader.readLine();

            }
        }
        else{
			
            Process p = Runtime.getRuntime().exec("cmd /c date /t");
            BufferedReader reader = new BufferedReader(new
            InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine())!=null) {
				
                byte[] b2 = (line+"").getBytes();
                InetAddress ia = InetAddress.getLocalHost();
                DatagramPacket dp2 = new DatagramPacket(b2,b2.length,ia,dp1.getPort());
                ds.send(dp2);
                line=reader.readLine();

            }
        }
    }
}
