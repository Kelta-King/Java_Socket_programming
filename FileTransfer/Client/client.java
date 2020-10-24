import java.io.*;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws Exception {
        
		int filesize=1600; 
        int bytesRead;
        int currentTot = 0;
        
		Socket socket = new Socket("192.168.43.50",36065);
        byte [] bytearray  = new byte [filesize];
        InputStream is = socket.getInputStream();
        
		FileOutputStream fos = new FileOutputStream("E:\\JAVA_Programs/FTP/Client/kelta_king.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bytesRead = is.read(bytearray,0,bytearray.length);
        currentTot = bytesRead;

        do {
			
			bytesRead = is.read(bytearray, currentTot, (bytearray.length-currentTot));
			if(bytesRead >= 0){
			   currentTot += bytesRead;
			}
			
        } while(bytesRead > -1);

        bos.write(bytearray, 0 , currentTot);
        bos.flush();
        bos.close();
        socket.close();
		
    }
    
}
