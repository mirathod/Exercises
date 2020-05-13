package org.milan.core.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Chat Server
 *
 * @author Milan Rathod
 */
public class ChatServer {

    private ServerSocket serverSocket;

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        try {
            server.start(6666);
        } catch (IOException e) {
            System.out.println("Error happened!");
        }
    }

    private void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);

        while (true) {
            new GreetTask(serverSocket.accept()).start();
        }
    }

    private void stop() throws IOException {
        serverSocket.close();
    }

    private static class GreetTask extends Thread {

        private Socket clientSocket;

        private PrintWriter printWriter;

        private BufferedReader bufferedReader;

        public GreetTask(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                printWriter = new PrintWriter(clientSocket.getOutputStream(), true);

                bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;

                while ((inputLine = bufferedReader.readLine()) != null) {
                    if (".".equals(inputLine)) {
                        printWriter.println("good bye");
                        break;
                    }
                    printWriter.println(inputLine);
                }

                bufferedReader.close();
                printWriter.close();
                clientSocket.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
