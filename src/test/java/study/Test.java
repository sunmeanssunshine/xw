package study;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by xuwei on 2017/5/5.
 */
public class Test {
    public static void main(String[] args) {
        String aa = "47c5b8fa73784b3cb70a6caf23a15de9,c7d63c4632ed442b8c65153cb3fa7143,900a2b205c6f4e67ac45dcf9fae3bd38,c2935210e3a44703a6a573c541675ce4,a602ecbf40f94e27bd174edf52295419,bb959a1382ae427f897fe84b0cae21be,b996736616c24ea39e5a229b6668d4b4,142df4b940ef42449d28d26c97adfe11,bb98a95813384430b7639358e2110ecf,a4dbbf6284f4452d85efcc60eff1d180,1036cb35185c4fdd8a3e739b15681ff8,b8292cd892bb4fc893b14187d3b59620,7dc5ae46535f40c3a089d8232247636f,e67b63526e13435b884288ba7d077c58,6c8602b52c604fbba7bf430582a4c159,849b1a2c6d73476e8fef788b7d4e06a3,a010f990dc074c83b352c82a807908f3,623c01c756f34be8a1f79f38d397c5ed,6277ac0531c5443d8f5af73fca23e3df";
        String [] bb = StringUtils.split(aa, ",");
        String cc = "";
        for (String a: bb){
            cc = cc + "'"+a+"',";
        }
        System.out.println(cc);
    }
}
