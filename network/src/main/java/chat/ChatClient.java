package chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_IP = "0.0.0.0";
    public static void main(String[] args) {
        Scanner scanner = null;
        Socket socket = null;

        try {
            // 1. keyboard
            scanner = new Scanner(System.in);

            // 2. socket
            socket = new Socket();

            // 3. connect
            socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));

            // 4. IO Stream (reader, writer)
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

            // 5. join protocol
            System.out.print("닉네임 >> ");
            String nickname = scanner.nextLine();
            log(nickname + "님이 채팅방에 입장하였습니다.");
            String request = "join:" + nickname;
            pw.println(request);

            String ack = br.readLine();
            if("join:ok".equals(ack)) {
                System.out.println("입장하였습니다. 즐거운 채팅 되세요!");
            }

            // 6. ChatClientReceiveThread Start
            ChatClientThread chatClientThread = new ChatClientThread(socket);
            chatClientThread.start();

            // 8. keyboard
            while(true) {
                System.out.print(">> ");
                String input = scanner.nextLine();
                if("quit".equals(input)) {
                    // 8. quit protocol
                    pw.println(input);
                    pw.flush();
                    break;
                } else {
                    // 9. message protocol
                    pw.println("message: " + input);
                    pw.flush();
                }
            }

        } catch (SocketException e) {
            log("Socket Exception : " + e);
        } catch (IOException e) {
            log("error: " + e);
        } finally {
            try {
                scanner.close();
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void log(String message) {
        System.out.println(message);
    }
}
