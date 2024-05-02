package chat;

import java.io.BufferedReader;
import java.io.Writer;
import java.util.List;

public class ChatClientThread extends Thread {
    private BufferedReader bufferedReader;
    List<Writer> listWriters;

    public ChatClientThread(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run() {
        /* print the message at the console from the bufferedReader */
        try {
            while (true) {
                String message = bufferedReader.readLine();
                System.out.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
