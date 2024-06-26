package httpd;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private Socket socket;
	private final String DOCUMENT_ROOT = "network/webapp";
	
	public RequestHandler(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
			consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort());

			String request = null;

			while(true) {
				String line = br.readLine();

				// 브라우저에서 연결을 끊으면...
				if(line == null) {
					break;
				}

				// SimpleHttpServer는 HTTP Header만 처리
				if("".equals(line)) {
					break;
				}

				// request header의 첫 줄만 처리
				if(request == null) {
					request = line;
					break;
				}
			}

			// 요청 처리
			consoleLog(request);

			String[] tokens = request.split(" "); // GET /user/join.html HTTP 1.1
			if("GET".equals(tokens[0])) {
				responseStaticResource(outputStream, tokens[1], tokens[2]);
			} else {
				// methods: POST, PUT, DELETE, GET, HEAD, CONNECT
				// SimpleHttpServer에서는 무시(400 Bad Request)
				reponse400Error(outputStream, tokens[2]);
//				System.out.println(outputStream);
//				System.out.println(tokens[2].toString());
			}
		} catch(Exception ex) {
			consoleLog("error:" + ex);
		} finally {
			// clean-up
			try{
				if(socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch(IOException ex) {
				consoleLog("error:" + ex);
			}
		}			
	}

	private void reponse400Error(OutputStream outputStream, String protocol) throws IOException {

		File file = new File(DOCUMENT_ROOT + "/error/400.html");
		if(!file.exists()) {
			response404Error(outputStream, protocol);
			return;
		}

		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());

		outputStream.write((protocol + " 400 Bad Request\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\n").getBytes("UTF-8"));
		outputStream.write("\n".getBytes());
		outputStream.write(body);

	}

	private void responseStaticResource(OutputStream outputStream, String url, String protocol) throws IOException {
		// default(welcome) file set
		if("/".equals(url)) {
			url = "/index.html";
		}

		File file = new File(DOCUMENT_ROOT + url);
		if(!file.exists()) {
			response404Error(outputStream, protocol);
			return;
		}

		// nio
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());

		// 예제 응답입니다.
		// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
		// outputStream.write("HTTP/1.1 200 OK\r\n".getBytes("UTF-8"));
		// outputStream.write("Content-Type:text/html; charset=utf-8\r\n".getBytes("UTF-8"));
		// outputStream.write("<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes("UTF-8"));

		outputStream.write((protocol + "200 OK\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\n").getBytes("UTF-8"));
		outputStream.write("\n".getBytes());
		outputStream.write(body);
	}

	private void response404Error(OutputStream outputStream, String protocol) throws IOException {
		File file = new File(DOCUMENT_ROOT + "/error/404.html");
		if(!file.exists()) {
			System.out.println("file not found:" + file.getAbsolutePath());
			return;
		}

		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());

		outputStream.write((protocol + " 404 Not Found\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\n").getBytes("UTF-8"));
		outputStream.write("\n".getBytes());
		outputStream.write(body);
	}

	public void consoleLog(String message) {
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}
}
