package backEnd;

import org.eclipse.jdt.internal.compiler.env.ISourceType;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/*测试数据库用*/
public class test {

    public static boolean isNum(String str) {
        try {
            new BigDecimal(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static void main(String[] args) throws Exception {
//        String sql1="insert into user(u_id,u_name,u_password,u_phone,u_idcard,u_email) values(?,?,?,?,?,?);";
//        Object []list={7,"呵呵哒","123456","10086","",""};
//        dbOperation.update(sql1,list);
//
//        String sql ="select * from user;";
//        List<Map<String,Object>> list1 = dbOperation.executeQuery(sql);
//        System.out.println(list1.size());
//
//        List<Map<String,Object>> a = database.Login("123", "123",1);
//        System.out.println(a);
//        System.out.println(a.size());

//        database.Register("李建成","1549252532","1234566","user");
//            if(isNum("12r3"))
//                System.out.println("1");
//            else
//                System.out.println("2");

//        String sql2 = "select a_id from admin where a_phone =?;";
//        List<Map<String, Object>> listMaps1 = dbOperation.executeQuery(sql2,"123");
//        System.out.println(listMaps1.get(0).get("a_id"));

//        database.admin_modify_product("10","美丽的书包","100","30");
        // 获取时间
//        Date date = new Date();
//        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        System.out.println((String) dateFormat.format(date));

//        String sql2 = "select * from product where p_id=1;";
//        List<Map<String, Object>> listMaps = dbOperation.executeQuery(sql2);
//        int sum=0;
//        for (Map<String, Object> map : listMaps) {
//            sum+=Integer.parseInt((String) map.get("p_price"));
//        }
//        System.out.println(sum);

        // int转String
//        int a =1;
//        String b=String.valueOf(a);
//        System.out.println(b);
//        String product_name="双";
//
//        List<Map<String,Object>> result = new ArrayList<>();
//        for (int i = 0; i < product_name.length(); i++) {
//            char item = product_name.charAt(i);
//            String sql="select * from product where p_describe like '%"+item+"%';";
//            List<Map<String,Object>> listMaps = dbOperation.executeQuery(sql);
//            result.addAll(listMaps);
//        }
//        // 去重
//        List<Map<String,Object>> result_ = result.stream()
//                .collect(Collectors.groupingBy(group -> group.get("p_id").toString()))//根据map中id的value值进行分组, 这一步的返回结果Map<String,List<Map<String, Object>>>
//                .values()//得到Set<Map.Entry<String, List<Map<String, Object>>>
//                .stream()
//                .map(maps -> {
//                    return maps.stream()//m.getValue()的结果是 List<Map<String, Object>>
//                            .flatMap(o -> o.entrySet().stream())//o.entrySet() 的结果是 Set<Map.Entry<String, Object>>
//                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (m1, m2) -> m2));
//                }).toList();
//        System.out.println(result_);
    }
}
