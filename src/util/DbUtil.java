package util;
import java.io.InputStream;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

public class DbUtil {
    /**
     * 获取数据库的连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        //1.读取配置文件中的四个基本信息
        InputStream is= ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros= new Properties();
        pros.load(Objects.requireNonNull(is));
        String user =pros.getProperty("user");
        String password =pros.getProperty("password");
        String url =pros.getProperty("url");
        String driverClass =pros.getProperty("driverClass");
        //2.加载驱动
        Class.forName(driverClass);
        //3.获取链接
        Connection con= DriverManager.getConnection(url,user,password);
        System.out.println(con);
        return con;
    }
    /**
     * 关闭连接,增删改数据时需要关闭两个内容
     * @param conn
     * @param ps
     */
    public static void closeResource(Connection conn, Statement ps){
        try {
            if (ps !=null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn !=null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查找数据时，需要关闭三个内容
     * @param conn
     * @param ps
     * @param rs
     */

       public static void closeResource(Connection conn, Statement ps, ResultSet rs){
        try {
            if (ps !=null)
                ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn !=null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs !=null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
