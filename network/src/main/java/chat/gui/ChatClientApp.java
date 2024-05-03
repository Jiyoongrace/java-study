package chat.gui;

import chat.ChatServer;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP = "0.0.0.0";
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">> ");
			name = scanner.nextLine();
			
			if (!name.isEmpty()) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();

		socket = new Socket();

        try {
            socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			log(name + "님이 채팅방에 입장하였습니다.");
			new ChatWindow(name, socket).show();

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
        	String request = "join:" + name + "\r\n";
			pw.println(request);

		} catch (IOException e) {
            e.printStackTrace();
        }

	}

	public static void log(String message) {
		System.out.println(message);
	}
}
