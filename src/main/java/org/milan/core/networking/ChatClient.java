package org.milan.core.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Chat client
 *
 * @author Milan Rathod
 */
public class ChatClient {

    private Socket clientSocket;

    private PrintWriter printWriter;

    private BufferedReader bufferedReader;

    public String sendMessage(String message) {
        printWriter.println(message);
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            printWriter.println("Error happened");
            return null;
        }
    }

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);

        printWriter = new PrintWriter(clientSocket.getOutputStream(), true);

        bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public void stopConnection() throws IOException {
        bufferedReader.close();
        printWriter.close();
        clientSocket.close();
    }

}
