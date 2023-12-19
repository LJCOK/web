package backEnd;

import java.sql.Connection;
import java.sql.SQLException;

public class test_ {
    public static void main(String[] args) {
        Connection conn = null;
//        try {
            // 获取数据库连接
            conn = jdbcConnection.getConnection();
            if (conn != null) {
                System.out.println("数据库连接成功！");
                // 进行其他数据库操作...
            } else {
                System.out.println("数据库连接失败！");
            }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("数据库连接失败！");
//        } finally {
//            // 关闭数据库连接
//            jdbcConnection.closeResource(conn, null);
//        }
    }
}
