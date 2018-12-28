import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import java.util.*;

/**
 * Created by xuw-e on 2018/11/21.
 */
public class Console {
    public static void main(String[] args) {
//        Scanner reader = new Scanner(System.in);
//        System.out.println("please input password");
//        String input = reader.nextLine();
//        String password = "123qwe";
//        while (!password.equals(input)) {
//            System.out.println("error! please input password");
//            input = reader.nextLine();
//        }
//        System.out.println("ok!");
//        reader.close();
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(1);
        deque.offerLast(2);
        while (deque.peekFirst() != null) {
            System.out.println(deque.pollFirst());
        }
        Console.GssRole gssRole1 = GssRole.GSS_COMMON_USER;
        Map<Integer, Console.GssRole> map = new HashMap<>();
        map.put(1, gssRole1);
        System.out.println(GssRole.GSS_COMMON_USER.equals(map.get(1)));
    }

    @Test
    public void test() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setAge(1);
        student.setName("dd");
        students.add(student);
        Student student1 = new Student();
        student.setAge(2);
        student.setName("dg");
        students.add(student1);
        System.out.println(Arrays.asList(students).toArray());
        System.out.println(Arrays.asList(students).toString());

        String s = "[{\"orgId\":177066287452160,\"userId\":185961073840640,\"name\":\"徐伟\",\"mobile\":\"15195910029\",\"remark\":null,\"roles\":[{\"id\":\"gss-common-user\",\"tenantId\":null,\"name\":null,\"productCode\":\"gss\",\"deleted\":false,\"enabled\":true,\"defined\":null,\"authorities\":null,\"orgTypes\":null},{\"id\":\"gss-mgr\",\"tenantId\":null,\"name\":null,\"productCode\":\"gss\",\"deleted\":false,\"enabled\":true,\"defined\":null,\"authorities\":null,\"orgTypes\":null}]},\n" +
                "\t{\"orgId\":171038278431232,\"userId\":185961073840640,\"name\":\"徐伟\",\"mobile\":\"15195910029\",\"remark\":null,\"roles\":[{\"id\":\"gspm-common-user\",\"tenantId\":null,\"name\":null,\"productCode\":\"gspm\",\"deleted\":false,\"enabled\":true,\"defined\":null,\"authorities\":null,\"orgTypes\":null},{\"id\":\"gss-common-user\",\"tenantId\":null,\"name\":null,\"productCode\":\"gss\",\"deleted\":false,\"enabled\":true,\"defined\":null,\"authorities\":null,\"orgTypes\":null},{\"id\":\"gss-mgr\",\"tenantId\":null,\"name\":null,\"productCode\":\"gss\",\"deleted\":false,\"enabled\":true,\"defined\":null,\"authorities\":null,\"orgTypes\":null}]}]";

        List<UserRole> userRoles = JSONArray.parseArray(s, UserRole.class);
        System.out.println(Arrays.asList(userRoles).toString());
        Map<String, GssRole> map = new HashMap<>();
        map.put("1", GssRole.GSS_NULL);
        map.put("1", GssRole.GSS_COMMON_USER);
        System.out.println(Arrays.asList(map.keySet()));
        System.out.println(Arrays.asList(map.values()));
    }

    enum GssRole {
        //没有权限
        GSS_NULL("gss_null"),
        //gss普通用户权限
        GSS_COMMON_USER("gss_common_user"),
        //gss租户管理员用户权限
        GSS_MGR("gss_mgr");

        private String value;
        GssRole(String value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return value;
        }
    }
}
