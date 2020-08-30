package org.milan.networking;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for testing {@link ChatClient} and {@link ChatServer}
 *
 * @author Milan Rathod
 */
class ChatClientTest {

    private ChatClient chatClient;

    private ChatServer chatServer;

    @BeforeEach
    void setup() throws IOException {
        chatServer = new ChatServer();
        new Thread(() -> {
            try {
                chatServer.start(6666);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        chatClient = new ChatClient();

        chatClient.startConnection("127.0.0.1", 6666);
    }

    @AfterEach
    void cleanup() throws Exception {
        chatClient.stopConnection();
    }

    @Test
    @Disabled
    void testSendMessage() {
        assertEquals("hello server", chatClient.sendMessage("hello server"));

        assertEquals("!", chatClient.sendMessage("!"));

        assertEquals("good bye", chatClient.sendMessage("."));
    }

}