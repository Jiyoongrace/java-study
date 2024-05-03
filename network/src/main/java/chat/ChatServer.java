package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

    public static final int PORT = 7000;
    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        List<PrintWriter> listWriters = new ArrayList<PrintWriter>();

        try {
            serverSocket = new ServerSocket();

            InetAddress inetAddress = InetAddress.getLocalHost();
            String hostAddress = inetAddress.getHostAddress();
            serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
            log("연결 기다림 " + hostAddress + ":" + PORT);

            while(true) {
                Socket socket = serverSocket.accept();
                new ChatServerThread(socket, listWriters).start();
            }

        } catch (IOException e) {
            // log("error: " + e);
            e.printStackTrace();
        } finally {
            try {
                if(serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void log(String message) {
        System.out.println("[ChatServer] " + Thread.currentThread().getId() + message);
    }
}
