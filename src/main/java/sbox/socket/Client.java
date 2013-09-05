package sbox.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 9/4/13
 * Time: 11:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Client {

    private long id = System.currentTimeMillis();

    public void start() throws IOException {
        // Make connection and initialize streams
        Socket socket = new Socket("localhost", 6666);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Consume the initial welcoming messages from the server
        for (int i = 0; i < 3; i++) {
            System.out.println(in.readLine() + "\n");
        }

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("client " + id + " : " + in.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.start();
    }
}
