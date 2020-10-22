import java.io.*;
import java.net.Socket;
public class client {
	
	 public static void main(String[] args) throws IOException {
		
		System.out.println("client at port 6666");
		String ip = "localhost";
		int port = 6666;
		Socket skt = new Socket(ip,port);
		
		OutputStreamWriter osw = new OutputStreamWriter(skt.getOutputStream());
		PrintWriter out = new PrintWriter(osw);
		
		out.println("1");
		out.flush();

		BufferedReader br = new BufferedReader(new InputStreamReader(skt.getInputStream()));
		String rslt;
		
		while ((rslt = br.readLine())!= null) {
			System.out.println(rslt);
		}
	}
}