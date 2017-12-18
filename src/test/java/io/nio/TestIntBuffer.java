package io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by xuwei on 2017/12/18.
 */
public class TestIntBuffer {
    public static void main(String[] args) throws IOException {
        // 分配新的int缓冲区，参数为缓冲区容量
        // 新缓冲区的当前位置将为零，其界限(限制位置)将为其容量。它将具有一个底层实现数组，其数组偏移量将为零。
        IntBuffer buffer = IntBuffer.allocate(8);

        for (int i = 0; i < buffer.capacity(); ++i) {
            int j = 2 * (i + 1);
            // 将给定整数写入此缓冲区的当前位置，当前位置递增
            buffer.put(j);
        }

        // 重设此缓冲区，将限制设置为当前位置，然后将当前位置设置为0
        buffer.flip();

        // 查看在当前位置和限制位置之间是否有元素
        while (buffer.hasRemaining()) {
            // 读取此缓冲区当前位置的整数，然后当前位置递增
            int j = buffer.get();
            System.out.print(j + "  ");
        }

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1000);


        FileInputStream fin = new FileInputStream("C:\\Users\\xuwei\\Documents\\api\\BOOT-INF\\classes\\application.yml");
        FileChannel fileChannel = fin.getChannel();
        fileChannel.read(byteBuffer);
        byteBuffer.flip();

        while (byteBuffer.remaining() > 0) {
            System.out.print((char) byteBuffer.get());
        }
        fin.close();
    }
}
