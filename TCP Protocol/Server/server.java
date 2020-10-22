import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	
	public static void main(String[] args) throws IOException{
		
		System.out.println("server and port 6666");
		ServerSocket sskt = new ServerSocket(6666);
		Socket skt = sskt.accept();
		
		BufferedReader br= new BufferedReader(new InputStreamReader(skt.getInputStream()));
		String str = br.readLine();
		
		OutputStreamWriter osw = new OutputStreamWriter(skt.getOutputStream());
		PrintWriter out = new PrintWriter(osw);
		
		if (Integer.parseInt(str) == 0) {
			
			Process p = Runtime.getRuntime().exec("cmd /c dir");
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			r.readLine();
			String line;
			
			while ((line = r.readLine()) != null) {
				out.println(line);
				out.flush();
			}
			
		}
		else {
			
			Process p = Runtime.getRuntime().exec("cmd /c date /t");
			System.out.println("date ");
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			
			while ((line = r.readLine()) != null) {
				out.println(line);
				out.flush();
			}
			
		}
		
		skt.shutdownOutput();
		sskt.close();
		
	}
}