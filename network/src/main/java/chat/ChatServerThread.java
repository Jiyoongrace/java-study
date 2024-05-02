package chat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {

    private String nickname;
    private Socket socket;
    List<Writer> listWriters;

    public ChatServerThread(Socket socket, List<Writer> listWriters) {
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

            String request = null;
            // 3. Request
            while(true) {
                request = br.readLine();// blocking
                if(request == null) {
                    ChatServer.log("closed by client");
                    doQuit(pw);
                    break;
                }
                ChatServer.log("received: " + request);
                pw.println(request);
            }

            // 4. Protocol
            String[] tokens = request.split(":");

            if("join".equals(tokens[0])) {
                doJoin(tokens[1], pw);
            } else if("message".equals(tokens[0])) {
                doMessage(tokens[1]);
            } else if("quit".equals(tokens[0])) {
                doQuit(pw);
            } else {
                ChatServer.log("error: 알 수 없는 요청( " + tokens[0] + ")");
            }


        } catch (SocketException e) {
            ChatServer.log("Socket Exception: " + e);
        } catch (IOException e) {
            ChatServer.log("error: " + e);
        } finally {
            try {
                if(socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void doJoin(String nickname, Writer writer) {
        this.nickname = nickname;

        String data = nickname + "님이 참여하였습니다.";
        broadcast(data);
        /* save: write pool */
        addWriter(writer);

        // ack
        PrintWriter pw = new PrintWriter(writer);
        pw.println("join:ok");
        pw.flush();
    }

    public void addWriter(Writer writer) {
        synchronized (listWriters) {
            listWriters.add(writer);
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
        String data = "message: " + "[" + nickname + "]" + message + "\r\n";
        broadcast(data);
    }

    private void doQuit(Writer writer) {
        removeWriter(writer);

        String data = nickname + "님이 퇴장하였습니다.";
        broadcast(data);
    }

    private void removeWriter(Writer writer) {
        synchronized (listWriters) {
            listWriters.remove(writer);
        }
    }
}
