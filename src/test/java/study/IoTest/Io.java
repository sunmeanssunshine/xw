package study.IoTest;

import java.io.*;

/**
 * Created by xuwei on 2017/5/22.
 */
public class Io {
    public static void main(String[] args) throws IOException {
        String fileName="D:"+File.separator+"node.txt";
        File f=new File(fileName);
        InputStream in=new FileInputStream(f);
        byte[] b=new byte[1024];
        int len = in.read(b);
        in.close();
        System.out.println("读入长度为："+len);
        System.out.println(new String(b, 0 , len));

        OutputStream out = new FileOutputStream(f, true);
        String str = "hello world!ccccssss  ";
        byte [] bytes = str.getBytes();
        out.write(bytes);
        out.close();

        String str1="ROLLENHOLT";
        ByteArrayInputStream input=new ByteArrayInputStream(str1.getBytes());
        ByteArrayOutputStream output=new ByteArrayOutputStream();
        int temp=0;
        while((temp=input.read())!=-1){
            char ch=(char)temp;
            output.write(Character.toLowerCase(ch));
        }
        String outStr=output.toString();
        input.close();
        output.close();
        System.out.println(outStr);
    }
}
