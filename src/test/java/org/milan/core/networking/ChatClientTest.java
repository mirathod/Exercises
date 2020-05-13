package org.milan.core.networking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Test class for testing {@link ChatClient} and {@link ChatServer}
 *
 * @author Milan Rathod
 */
public class ChatClientTest {

    private ChatClient chatClient;

    @Before
    public void setup() throws IOException {
        new Thread(() -> {
            ChatServer server = new ChatServer();
            try {
                server.start(6666);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        chatClient = new ChatClient();

        chatClient.startConnection("127.0.0.1", 6666);
    }

    @Test
    public void testSendMessage() {
        Assert.assertEquals("hello server", chatClient.sendMessage("hello server"));

        Assert.assertEquals("!", chatClient.sendMessage("!"));

        Assert.assertEquals("good bye", chatClient.sendMessage("."));
    }

}