package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xuwei on 2018/1/12.
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10010);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(inputStreamReader);
        String info;
        while ((info = br.readLine()) != null) {
            System.out.println("我是服务器，客户端说："+info);
        }
        socket.shutdownInput();

        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("welcome");
        pw.flush();

        pw.close();
        os.close();
        br.close();
        inputStreamReader.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
