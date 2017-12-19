package io.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * Created by xuwei on 2017/12/18.
 */
public class PipeTest {
    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();
        Pipe.SinkChannel sinkChannel = pipe.sink();
        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());

        buf.flip();

        while(buf.hasRemaining()) {
            sinkChannel.write(buf);
        }


        Pipe.SourceChannel sourceChannel = pipe.source();
        ByteBuffer bufRead = ByteBuffer.allocate(48);
        int bytesRead = sourceChannel.read(bufRead);

    }
}
