package io;

import com.google.common.util.concurrent.RateLimiter;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;
import java.net.URI;

/**
 * Created by xuw-e on 2018/8/28.
 */
public class RateLimitInputStream {

    private static final double MAX_BYTES_PER_SECOND = 1000 * 500;
    private final RateLimiter limiter = RateLimiter.create(MAX_BYTES_PER_SECOND);

    private InputStream inputStream;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("kkk");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ggg");

            }
        });
        thread.start();
        thread.start();

    }
    @Test
    public void test() throws IOException {
        RateLimiter limiter = RateLimiter.create(MAX_BYTES_PER_SECOND);
        int bytesRead;
        byte[] buffer = new byte[10240];
        InputStream inputStream = new FileInputStream("3.jpg");
        System.out.println(RateLimitInputStream.class.getResource("./3.jpg"));
        System.out.println(RateLimitInputStream.class.getResource("../../"));
        System.out.println(RateLimitInputStream.class.getResource("../3.jpg"));
        OutputStream outputStream = new FileOutputStream("5.jpg");
        long t1 = System.currentTimeMillis();
//        int length = IOUtils.copy(inputStream, outputStream);
//        System.out.println(length);
        int count = 0;
        try {
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                limiter.acquire(bytesRead);
                count++;
            }
        } catch (Exception e) {

        }
        System.out.println(count);
        long t2 = System.currentTimeMillis();
        System.out.println("consume time: " + (t2-t1)/1000 + "s");

    }



}
