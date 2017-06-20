package study.IoTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by xuwei on 2017/5/22.
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        String inFile = "C:\\1\\db\\bim_doc\\bim_doc.sql";
        String outFile = "D:\\sql.txt";
        //
        FileInputStream fin = new FileInputStream(inFile);
        FileOutputStream fout = new FileOutputStream(outFile);
        //
        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();
        //
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (Boolean.TRUE){
            buffer.clear();

            int r = fcin.read(buffer);
            if (r == -1){
                break;
            }
            buffer.flip();

            fcout.write(buffer);
        }


    }
}
