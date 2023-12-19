package backEnd;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

/*操作数据库的工具类*/
public class jdbcConnection {
    // 获取数据库连接
    public static Connection getConnection(){
        Connection conn = null;
        try {
            // 1.设置参数
            String user="root";
            String password="ljc006690";
            String url="jdbc:mysql://localhost:3306/root";
            String s="com.mysql.cj.jdbc.Driver";
            // 2、加载驱动
            Class.forName(s);
            // 3、获取连接
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn!=null){
                try {
                    System.out.println("connect successfully!");
                    return conn;
                } catch (Exception e) {
                    System.out.println("connect false!");
                    e.printStackTrace();
                }
            }
        }
        return conn;
    }
    // 关闭数据库连接1
    public static void closeResource(Connection conn, Statement ps){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
                System.out.println("release successfully!");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //关闭数据库连接2(closeResource方法重载)
    public static void closeResource(Connection conn, Statement ps, ResultSet rs){
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs!=null){
            try {
                rs.close();
                System.out.println("release successfully!");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
