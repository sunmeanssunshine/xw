package io.nio;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by xuwei on 2018/2/5.
 */
public class PipeExample {
    public static void main(String[] args) throws IOException {

        final PipedOutputStream pipedOutputStream = new PipedOutputStream();
        final PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

        Runnable runnable1 = () -> {
            try {
                pipedOutputStream.write("hello kopshome".getBytes());
            } catch (IOException e) {
            }
        };

        Runnable runnable2 = () -> {
            try {
                int data = pipedInputStream.read();
                while (data != -1) {
                    System.out.println((char) data);
                    data = pipedInputStream.read();
                }
            } catch (IOException e) {
            }
        };

        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }
}
