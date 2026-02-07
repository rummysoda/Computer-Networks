import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {

    public TCPClient() {}

    public static void main(String[] args) throws IOException {

	// IP Addresses will be discussed in detail in lecture 4
	String IPAddressString = "10.200.51.18";
	InetAddress host = InetAddress.getByName(IPAddressString);

	// Port numbers will be discussed in detail in lecture 5
	int port = 2011;

	// This is where we create a socket object
	// That creates the TCP conection
	System.out.println("TCPClient connecting to " + host.toString() + ":" + port);
	Socket clientSocket = new Socket(host, port);

	// Like files, we use readers and writers for convenience
	BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	Writer writer = new OutputStreamWriter(clientSocket.getOutputStream());

	// Sending a message to the server at the other end of the socket
	System.out.println("Sending a message to the server");
	writer.write("Hello Server!\n");
	writer.flush();
	// To make better use of bandwidth, messages are not sent
	// until the flush method is used

	// We can read what the server has said
	String response = reader.readLine();
	System.out.println("The server said : " + response);

	// Close down the connection
	clientSocket.close();
    }
}
