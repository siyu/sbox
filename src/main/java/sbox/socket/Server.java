package sbox.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: siyu798
 * Date: 9/4/13
 * Time: 11:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Server {
    private int port = 6666;
    private ServerSocket serverSocket;
    private int clientId = 0;
    private Socket clientSocket;

    public void start() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server socket created");
        while (true) {
            System.out.println("Waiting for client to connect...");
            Socket newClientSocket = serverSocket.accept();
            if (clientSocket == null || clientSocket.isClosed()) {
                System.out.println("client connected: " + newClientSocket.toString());
                new Thread(new UpperService(newClientSocket,clientId++)).start();
            }
            else {
                System.out.println("There's already a client socket connected");
                newClientSocket.close();
            }
        }
    }

    private class UpperService implements Runnable {

        private int clientId;

        private UpperService(Socket socket, int clientId) {
            clientSocket = socket;
            this.clientId = clientId;
        }


        @Override
        public void run() {
            try {
                System.out.println("started echo service for clientId=" + clientId);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);

                out.println("Hello, you are client id" + clientId + ".");
                out.println("Enter a line with only a period to quit\n");

                while (true) {
                    String input = in.readLine();
                    if (input == null || input.equals(".")) {
                        break;
                    }
                    out.println(input.toUpperCase());
                }
            } catch (IOException e) {
                System.out.println("Error handling client# " + clientId + ": " + e);
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }
}
