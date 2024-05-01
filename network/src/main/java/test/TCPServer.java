package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            // 1. Server Socket 생성
            serverSocket = new ServerSocket();

            // 2. 바인딩(binding)
            // Socket에 InetSocketAddress[InetAddress(IP Address) + Port]를 바인딩 한다.
            // IP Address: 0.0.0.0: 특정 호스트 IP를 바인딩하지 않는다.
            // backlog는 대기중인 최대 연결 수
            serverSocket.bind(new InetSocketAddress("0.0.0.0", 5000), 10);

            // 3. accept
            Socket socket = serverSocket.accept(); // blocking
            System.out.println("연결 성공");

        } catch (IOException e) {
            System.out.println("[server] error: " + e);
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
}
