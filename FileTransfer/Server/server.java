import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class server {
    public static void main (String[] args) throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(36065);
        Socket socket = serverSocket.accept();
        System.out.println("Accepted connection : " + socket);
        File transferFile = new File ("E:\\JAVA_Programs/FTP/Server/kelta.txt");
		
        byte [] b  = new byte [(int)transferFile.length()];
        FileInputStream fin = new FileInputStream(transferFile);
        BufferedInputStream bin = new BufferedInputStream(fin);
		
        bin.read(b,0,b.length);
        OutputStream os = socket.getOutputStream();
        System.out.println("Sending Files...");
        os.write(b,0,b.length);
        os.flush();
        socket.close();
        System.out.println("File has been transferred");
		
    }
    
}
