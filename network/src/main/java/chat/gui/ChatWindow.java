package chat.gui;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.Socket;
import java.util.Base64;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private Socket socket;

	public ChatWindow(String name, Socket socket) {
		this.socket = socket;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);

		textArea.append(name + "님이 입장하였습니다. 즐거운 채팅 되세요!\n");

		new ChatClientThread(socket).start();
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(actionEvent -> sendMessage());

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		textField.requestFocus();

		// IO Stream 받아오기
		// ChatClientThread 생성
	}

	private void sendMessage() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
            String message = textField.getText();

			if("quit".equals(message)) {
				finish();
			}

			// Base64 인코딩
			String encodedString = Base64.getEncoder().encodeToString(message.getBytes("utf-8"));

			String request = "message: " + encodedString + "\r\n";
			pw.println(request);

			// 보내고 메세지 비우기
			textField.setText("");
			textField.requestFocus();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void updateTextArea(String message) {
		if (message != null && !message.startsWith("join:ok")) {
			textArea.append(message);
			textArea.append("\n");
		}
	}


	private void finish() {
		// quit protocol 구현
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			String request = "quit\r\n";
			pw.println(request);
			System.out.println("퇴장하였습니다.");
			System.exit(0);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		// exit java application
		System.exit(0);
	}


	private class ChatClientThread extends Thread {
		Socket socket = null;

		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
                while (true) {
                    String message = br.readLine();
                    updateTextArea(message);
                }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
