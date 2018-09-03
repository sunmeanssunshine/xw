package io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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


    @Test
    public void zip() throws IOException {
        String source = new String(Files.readAllBytes(Paths.get("1.txt")));
        String zipSource = ZipUtils.zip(source);
        String unZipSource = ZipUtils.unzip(zipSource);
        String gZipSource = ZipUtils.gzip(source);
        String unGZipSource = ZipUtils.gunzip(gZipSource);


        System.out.println(source.length());
        System.out.println(zipSource.length());
        System.out.println(source.equals(unZipSource));

        System.out.println(gZipSource.length());
        System.out.println(source.equals(unGZipSource));

    }
}
