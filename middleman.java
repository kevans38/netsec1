import java.net.*;
import java.io.*;

public class middleman{


	public static void main (String args[]){

		if (args.length != 1){

			System.err.println("Usage: java middleman <port #>");
			System.exit(1);
		}		

	
		int port = Integer.parseInt(args[0]);
		
		ServerSocket serversock;
		Socket clientsock;		
		
		BufferedReader input;		
		OutputStream output;

		try{
			
			/*Wait for client connection*/
			serversock = new ServerSocket(port);
			clientsock = serversock.accept();
			
			output = clientsock.getOutputStream();

			input = new BufferedReader(new InputStreamReader(clientsock.getInputStream()));
			
			/*This should be a random nonce string. I've just got it set to a specific number right now for testing*/
			String nonce ="00000324";
			byte[] to_send = nonce.getBytes();
			output.write(to_send, 0, to_send.length);
			

			//clientsock.close();
			

		}catch (IOException e){

			System.out.println(e);
		}

	}

}
