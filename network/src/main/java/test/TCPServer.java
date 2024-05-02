package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

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
            // System.out.println("연결 성공");
            // ----- 여기까지 서버 소켓

            // 여기부터 클라이언트
            // Client IP Address + Port
            try {
                InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
                String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
                int remotePort = inetRemoteSocketAddress.getPort();
                System.out.println("[server] connected by client[" + remoteHostAddress + ":" + remotePort + "]");

                // 4. IO Stream 받아오기
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();

                while(true) {
                    System.out.println("try to read");
                    // 5. 데이터 읽기
                    byte[] buffer = new byte[256];
                    int readByteCount = is.read(buffer); // blocking

                    if(readByteCount == -1) {
                        // 클라이언트가 정상적으로 종료(close() 호출)
                        System.out.println("[server] closed by client");
                        break;
                    }
                    String data = new String(buffer, 0, readByteCount, "utf-8");
                    System.out.println("[server] received: " + data);

                    // 6. 데이터 쓰기
                    os.write(data.getBytes("utf-8"));
                }
                // cmd 창에서 실행 가능
                // C:\poscodx2024\java-study\network\target\classes>java test.TCPServer

            } catch (SocketException e) {
                System.out.println("[server] Socket Exception " + e);
            } catch (IOException e) {
                System.out.println("[server] error: " + e);
            } finally {
                try {
                    if(socket != null && !socket.isClosed()) {
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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
