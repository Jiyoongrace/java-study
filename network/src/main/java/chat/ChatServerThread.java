package chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {

    private String nickname;
    private Socket socket;
    List<PrintWriter> listWriters;

    public ChatServerThread(Socket socket, List<PrintWriter> listWriters) {
        this.socket = socket;
        this.listWriters = listWriters;
    }

    @Override
    public void run() {
        PrintWriter pw = null;
        BufferedReader br = null;
        try {
            // 1. Remote the Information
            InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
            String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
            int remotePort = inetRemoteSocketAddress.getPort();
            ChatServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

            // 2. get IOStream
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

            // 3. Request
            while(true) {
                String request = br.readLine();// blocking
                if(request == null) {
                    ChatServer.log("클라이언트로 부터 연결 끊김");
                    doQuit(pw);
                    break;
                }

                // 4. Protocol
                String[] tokens = request.split(":");
                if("join".equals(tokens[0])) {
                    doJoin(tokens[1], pw);
                } else if("message".equals(tokens[0])) {
                    doMessage(tokens[1]);
                } else if("quit".equals(tokens[0])) {
                    doQuit(pw);
                    break;
                }
            }

        } catch (SocketException e) {
            doQuit(pw);
            ChatServer.log("abnormal closed by client");
        } catch (IOException e) {
            doQuit(pw);
            ChatServer.log("error: " + e);
        } finally {
            try {
                if(socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                ChatServer.log("error: " + e);
            }
        }
    }

    public void doJoin(String nickname, PrintWriter pw) {
        this.nickname = nickname;

        String data = nickname + "님이 참여하였습니다.";
        broadcast(data);
        /* save: write pool */
        addWriter(pw);

        // ack
        pw.println("join:ok");
    }

    public void addWriter(Writer writer) {
        synchronized (listWriters) {
            listWriters.add((PrintWriter) writer);
        }
    }

    private void broadcast(String data) {
        synchronized (listWriters) {
            for(Writer writer : listWriters) {
                PrintWriter pw = (PrintWriter)writer;
                pw.println(data);
                pw.flush();
            }
        }
    }

    private void doMessage(String message) {
        String data = nickname + ": " + message;
        broadcast(data);
    }

    private void doQuit(Writer writer) {
        removeWriter(writer);

        if(nickname!= null) {
            String data = nickname + "님이 퇴장하였습니다.";
            broadcast(data);
        }
    }

    private void removeWriter(Writer writer) {
        synchronized (listWriters) {
            listWriters.remove(writer);
        }
    }
}
