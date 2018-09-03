package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by xuw-e on 2018/9/3.
 */
public class StringCompression {
    //经过实践考证，当需要压缩的字符串长度越大时，压缩的效果越明显
    static String  code= "ISO-8859-1";
    public static String compress(String str) throws IOException {
        System.out.println("压缩之前的字符串大小："+str.length());
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(str.getBytes());
        gzip.close();
        return out.toString(code);
    }

    public static String uncompress(String str) throws IOException {
        System.out.println("压缩之后的字符串大小："+str.length());
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes(code));
        GZIPInputStream gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        return out.toString();
    }

    public static void main(String[] args) throws IOException {
        String source = new String(Files.readAllBytes(Paths.get("1.txt")));
        String gzipSource = compress(source);
        System.out.println("source length: " + source.length() + ", gzipSource length: " + gzipSource.length());
        System.out.println(source.equals(uncompress(gzipSource)));
    }

}
