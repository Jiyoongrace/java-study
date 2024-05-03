package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ChatClientThread extends Thread {
    private Socket socket;

    public ChatClientThread( Socket socket ) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
            String message = null;
            while (true) {
                message = br.readLine();
                if (message == null) {
                    break;
                }
                ChatClient.log(message);
            }
        } catch (SocketException e) {
            ChatClient.log("퇴장하셨습니다.");
        } catch (IOException e) {
            ChatClient.log("IOException : " + e);
        } finally {
            System.exit(0);
        }
    }
}
