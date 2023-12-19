package backEnd;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*数据库查询的中间层*/
public class database {
    // 注册
    public static Boolean Register(String username, String phone, String password,String checkbox){
        if(checkbox.equals("user")) {
            // 用户注册
            String sql = "insert into user(u_name,u_password,u_phone) values(?,?,?);";
            Object[] list = {username, password, phone};
            return dbOperation.update(sql, list);
        }
        else {
            // 管理员注册
            String sql = "insert into admin(a_name,a_password,a_phone) values(?,?,?);";
            Object[] list = {username, password, phone};
            return dbOperation.update(sql, list);
        }
    }
    //
    public static List<Map<String,Object>> register_phone_judge(String phone,String checkbox){
        if(checkbox.equals("user")) {
            String sql = "select * from user where u_phone = ?;";
            return dbOperation.executeQuery(sql, phone);
        }
        else {
            String sql = "select * from admin where u_phone = ?;";
            return dbOperation.executeQuery(sql,phone);
        }
    }

    // 登录
    public static List<Map<String,Object>> Login(String phone, String password, int identify){
        String sql_1 ="select * from user where u_phone = ? and u_password =?;";
        String sql_2 ="select * from admin where a_phone = ? and a_password =?;";
        if (identify==1)
            // 用户
            return dbOperation.executeQuery(sql_1,phone,password);
        else
            // 管理员
            return dbOperation.executeQuery(sql_2,phone,password);
    }

    // 查询所有商品
    public static List<Map<String,Object>> product_all(){
        String sql="select * from product;";
            List <Map<String,Object> > mp=dbOperation.executeQuery(sql);
            return dbOperation.executeQuery(sql);
    }

    // 根据id搜索某样商品
    public static List<Map<String,Object>> productSearch_id(String id){
        String sql="select * from product where p_id=?;";
        return dbOperation.executeQuery(sql,Integer.valueOf(id));
    }

    // 查询指定管理者的商品(未使用)
    public static List<Map<String,Object>> product_admin(String phone){
        String sql="select p_describe,p_price,p_num from product,shopping,admin where a_phone=? and a_id=s_user_id and a_u=2 and s_product_id = p_id;";
        return dbOperation.executeQuery(sql,phone);
    }

    // 客户日志查询
    public static List<Map<String,Object>> log(){
        String sql="select * from log;";
        return dbOperation.executeQuery(sql);
    }
    // 客户日志添加
    public static void log_add(int p_id,String u_name,int operation) {
        String sql = "insert into log(l_username,l_operation,l_describe,l_price,l_num,l_time) values(?,?,?,?,?,?);";
        List<Map<String,Object>> listMaps = database.productSearch_id(String.valueOf(p_id));  // 对应商品搜索
        Date date = new Date();    // 时间设置
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = (String) dateFormat.format(date);
        if(operation==1){
            // 加入购物车操作
            Object[] list = {u_name,"加入购物车",listMaps.get(0).get("p_describe"),listMaps.get(0).get("p_price"),listMaps.get(0).get("p_num"),time};
            dbOperation.update(sql, list);
        }
        else if(operation==2){
            // 移出购物车操作
            Object[] list = {u_name,"移出购物车",listMaps.get(0).get("p_describe"),listMaps.get(0).get("p_price"),listMaps.get(0).get("p_num"),time};
            dbOperation.update(sql, list);
        }
        else {
            // 购买操作
            Object[] list = {u_name,"购买",listMaps.get(0).get("p_describe"),listMaps.get(0).get("p_price"),listMaps.get(0).get("p_num"),time};
            dbOperation.update(sql, list);
        }
    }
    // 销售统计查询
    public static List<Map<String,Object>> sales(){
        String sql="select * from product ;";
        return dbOperation.executeQuery(sql);
    }

    // 增加商品
    public static Boolean admin_add_product(String product_name,String product_price,String product_num,String phone){
        int num1 = dbOperation.executeQuery("select * from product;").size();
        String sql1 = "insert into product(p_describe,p_price,p_num,p_sale,p_sales_volume) values(?,?,?,?,?);";
        String sql2 = "insert into shopping(s_user_id,s_product_id,a_u) values(?,?,?);";
        String sql3 = "select a_id from admin where a_phone =?;";
        List<Map<String, Object>> listMaps1 = dbOperation.executeQuery(sql3,phone);
        int a_id = (int) listMaps1.get(0).get("a_id");
        Object[] list1 = {product_name, product_price, Integer.valueOf(product_num),0,0};
        dbOperation.update(sql1, list1);
        List<Map<String, Object>> listMaps2 = dbOperation.executeQuery("select * from product where p_describe =? and p_price=?;",product_name,product_price);
        Object[] list2 = {a_id, (int) listMaps2.get(0).get("p_id"), 2};
        return dbOperation.update(sql2, list2);
    }



    // 修改商品
    public static Boolean admin_modify_product(String product_name,String product_price,String product_num,String p_id){
        String sql = "update product set p_describe=?,p_price=?,p_num=?,p_sale=0,p_sales_volume=0 where p_id =?;";
        Object[] list = {product_name, product_price, Integer.valueOf(product_num),Integer.valueOf(p_id)};
        return dbOperation.update(sql, list);
    }

    // 删除商品
    public static Boolean admin_delete_product(String p_id){
        String sql = "delete from product where p_id=?;";
        Object[] list = {Integer.valueOf(p_id)};
        return dbOperation.update(sql, list);
    }

    // 查询用户信息
    public static List<Map<String,Object>> user_information_queryId(int id){
        String sql="select * from user where u_id=?;";
        return dbOperation.executeQuery(sql,id);
    }

    // 修改用户信息
    public static Boolean user_information_modify(int u_id,String u_name,String u_phone,String u_email,String u_password,String u_idcard){
        String sql = "update user set u_name=?,u_phone=?,u_email=?,u_password=?,u_idcard=? where u_id =?;";
        Object[] list = {u_name, u_phone, u_email,u_password,u_idcard,u_id};
        return dbOperation.update(sql, list);
    }

    // 加入购物车
    public static void shoppingCard_add(int u_id,String p_id,String u_name){
        // 先判断是否已经在购物车，不存在再添加
        String sql1="select * from shopping where s_user_id=? and s_product_id=? and a_u=1;";
        Object[] list1 = {u_id, p_id,};
        if(dbOperation.executeQuery(sql1, list1).size()==0){
            int num = dbOperation.executeQuery("select * from shopping;").size();
            String sql = "insert into shopping(s_user_id,s_product_id,a_u) values(?,?,?);";
            Object[] list = {u_id, p_id, 1};
            dbOperation.update(sql, list);
            // 加入日志
            database.log_add(Integer.parseInt(p_id),u_name,1);
        }
    }
    // 查找用户购物车信息
    public static List<Map<String,Object>> user_shoppingCart_queryId(int u_id){
        String sql="select p_describe,p_price,p_num,p_id from product,shopping where s_user_id=? and a_u=1 and s_product_id = p_id;";
        return dbOperation.executeQuery(sql,u_id);
    }
    // 删除购物车内的某个商品
    public static void user_product_delete(String p_id,int user_id){
        String sql = "delete from shopping where s_product_id =? and a_u=1 and s_user_id = ?;";
        Object[] list = {Integer.valueOf(p_id),user_id};
        dbOperation.update(sql, list);
    }
    // 删除购物车内某个商品2，与1的参数类型不同，且是购买后删除
    public static void user_product_delete2(int p_id,int user_id){
        String sql = "delete from shopping where s_product_id =? and a_u=1 and s_user_id = ?;";
        String sql2 = "update product set p_num=p_num-1 where p_id =?;";
        String sql1="update product set p_sale=p_sale+1 where p_id =?;";
        Object[] list = {p_id,user_id};
        dbOperation.update(sql2, p_id);
        dbOperation.update(sql1,p_id);
        dbOperation.update(sql, list);

    }
    // 清空购物车
    public static void user_product_deleteAll(int user_id){
        String sql = "delete from shopping where a_u=1 and s_user_id = ?;";
        dbOperation.update(sql, user_id);
    }
    // 发送邮件
    public static void email_send(int p_id,int user_id){
        List<Map<String,Object>> listMaps =  database.productSearch_id(String.valueOf(p_id));
        String sql = "insert into email(e_time,e_user_id,e_product,e_price,e_mark) values(?,?,?,?,?);";
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = (String) dateFormat.format(date);
        Object[] list = {time,user_id,listMaps.get(0).get("p_describe"),listMaps.get(0).get("p_price"),"已经发货"};
        dbOperation.update(sql, list);
    }
    // 查询邮件信息
    public static List<Map<String,Object>> user_eamil_queryId(int u_id){
        String sql="select * from email where e_user_id=?;";
        return dbOperation.executeQuery(sql,u_id);
    }

    // 搜索功能的实现
    public static List<Map<String,Object>> user_eamil_queryId(String product_name){

        List<Map<String,Object>> result = new ArrayList<>();
        for (int i = 0; i < product_name.length(); i++) {
            char item = product_name.charAt(i);
            String sql="select * from product where p_describe like '%"+item+"%';";
            List<Map<String,Object>> listMaps = dbOperation.executeQuery(sql);
            result.addAll(listMaps);
        }
        // 去重
        System.out.println(result);
        List<Map<String,Object>> result_ = result.stream()
                .collect(Collectors.groupingBy(group -> group.get("p_id").toString()))//根据map中id的value值进行分组, 这一步的返回结果Map<String,List<Map<String, Object>>>
                .values()//得到Set<Map.Entry<String, List<Map<String, Object>>>
                .stream()
                .map(maps -> {
                    return maps.stream()//m.getValue()的结果是 List<Map<String, Object>>
                            .flatMap(o -> o.entrySet().stream())//o.entrySet() 的结果是 Set<Map.Entry<String, Object>>
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (m1, m2) -> m2));
                }).toList();
        return result_;
    }
}
