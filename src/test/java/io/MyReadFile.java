package io;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.*;

/**
 * Created by xuwei on 2017/12/15.
 */
public class MyReadFile {
    public static void main(String[] args) {
        File file = new File("C:\\Program Files\\Glodon\\GBIM\\3.5\\bin\\Cloud\\LogFile\\2017-12-14.log");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int length = fileInputStream.available();
            for (int i = 0; i < length; i++) {
                System.out.print((char)fileInputStream.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writeOneFile() throws Exception {
        File inFile = new File("C:\\Program Files\\Glodon\\GBIM\\3.5\\bin\\Cloud\\LogFile\\2017-12-14.log");
        File outFile = new File("d:/222.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);
        IOUtils.copy(new FileInputStream(inFile), fileOutputStream);

    }
}
