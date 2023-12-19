package backEnd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*定义数据库的增删查改操作*/
public class dbOperation {
    // 通用的增删改操作
    // sql中占位符的个数与可变形参的长度相同
    public static Boolean update(String sql, Object... args) {
        // 1、获取数据库的连接
        Connection conn = jdbcConnection.getConnection();
        // 2、预编译sql语句，返回PreparedStatement的实例
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3、填充占位符
            System.out.println(args.length);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            System.out.println(sql);
            System.out.println(ps);
            System.out.println("你干嘛，哎呦");
            // 4、执行
            ps.execute();
            // 5、资源关闭
            jdbcConnection.closeResource(conn, ps);
        }catch (Exception e) {
            e.getStackTrace();
            return false;
        }
        return true;
    }

    // 查询操作
    public static List<Map<String,Object>> executeQuery(String sql, Object...obj){
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        Connection con=jdbcConnection.getConnection();
        PreparedStatement pst=null;
        ResultSet rs=null;
        try {
            pst=con.prepareStatement(sql);
            if(obj!=null&&obj.length>0) {
                for(int i=0;i<obj.length;i++) {
                    pst.setObject(i+1, obj[i]);
                }
            }
            rs=pst.executeQuery();
            //把结果集转换为内存中一张虚拟表
            ResultSetMetaData rsmd=rs.getMetaData();
            //获取表中的列数
            int colCount=rsmd.getColumnCount();

            if(rs!=null) {
                while(rs.next()) {
                    Map<String,Object> mso=new HashMap<String,Object>();
                    for(int i=1;i<=colCount;i++) {
                        //rsmd.getColumnName(i);获取每列的列名
                        mso.put(rsmd.getColumnName(i), rs.getObject(i));
                    }
                    list.add(mso);
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }finally {
            jdbcConnection.closeResource(con, pst, rs);
        }
        return list;
    }
}
