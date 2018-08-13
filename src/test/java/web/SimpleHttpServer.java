package web;


import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xuwei on 2018/2/5.
 */
public class SimpleHttpServer {

    static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>(4);

    static String basePath ;
    static ServerSocket serverSocket;

    static int port = 8088;

    public static void setPort(int port) {
        if (port > 0) {
            SimpleHttpServer.port = port;
        }
    }

    public static void setBasePath(String basePath) {
        if (basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()) {
            SimpleHttpServer.basePath = basePath;
        }
    }

    public static void start() throws IOException {
        serverSocket = new ServerSocket(port);
        Socket socket;
        while ((socket = serverSocket.accept()) != null) {
//            threadPool.execute(new HttpRequestHandler(socket));
            Thread thread = new Thread(new HttpRequestHandler(socket));
            thread.start();
        }
        serverSocket.close();
    }

    static class HttpRequestHandler implements Runnable {

        private Socket socket;
        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("worker begin");
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;
            byte[] buff = new byte[1024];
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();

                System.out.println(header);
                String filePath = header.split(" ")[1];
                out = new PrintWriter(socket.getOutputStream());
                if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {
                    in = new FileInputStream(new File(basePath,filePath));
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i = 0;
                    while ((i = in.read()) != -1) {
                        baos.write(i);
                    }
                    byte[] array = baos.toByteArray();

                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: weixu");
                    out.println("Content-Type: image/jpeg");
                    //out.println("Content-Disposition: attachment; filename=" + filePath);
                    out.println("Content-Length: " + array.length);
                    out.println("");
                    File file = new File(basePath, "2.jpg");
                    OutputStream outputStream = new FileOutputStream(file);
                    IOUtils.copy(new ByteArrayInputStream(array), outputStream);
                    socket.getOutputStream().write(array, 0, array.length);
                    System.out.println(out);
                } else {
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(basePath,filePath))));
                    out = new PrintWriter(socket.getOutputStream());
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: weixu");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    //out.println("Content-Disposition: attachment; filename=" + filePath);
                    out.println("");
                    while ((line = br.readLine()) != null) {
                        out.println(line);
                    }
                }
                out.flush();

            } catch ( Exception e) {
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
            } finally {
                close(br, in, reader, out, socket);
            }
        }
    }

    private static void close(Closeable... closeables) {
        if (closeables != null) {
            for (Closeable closeable : closeables) {
                try {
                    closeable.close();
                } catch (Exception e) {
                   // e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            String baseUrl = "C:\\Users\\79927\\IdeaProjects\\xw\\src\\test\\java\\web\\";
            SimpleHttpServer.setBasePath(baseUrl);
            SimpleHttpServer.start();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
