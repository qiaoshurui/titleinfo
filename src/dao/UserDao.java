package dao;
import modle.User;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UserDao {
    public UserDao() throws Exception {
    }
    /**
     * 用户登录,即查找表中是否有该用户的信息
     */
    public User login(User user) {
        String sql = "select * from user_table where name=? and password=?";
        User userRst = null;
        Connection con = null;
        PreparedStatement prst = null;
        ResultSet executeQuery = null;
        try {
            con = DbUtil.getConnection();
            prst = con.prepareStatement(sql);
            prst.setString(1, user.getName());
            prst.setString(2, user.getPassword());
            executeQuery = prst.executeQuery();
            if (executeQuery.next()) {
                userRst = new User();
                userRst.setId(executeQuery.getInt("id"));
                userRst.setName(executeQuery.getString("name"));
                userRst.setPassword(executeQuery.getString("password"));
                userRst.setPhone_number(executeQuery.getString("phone_number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeResource(con, prst, executeQuery);
        }
        return userRst;
    }

    /**
     * 修改用户密码
     * @param user
     * @param newPassword
     * @return
     */
    public String editPassword(User user,String newPassword) {
        String sql = "select * from user_table where name=? and password=?";
        PreparedStatement prst = null;
        int id = 0;
        Connection con = null;
        ResultSet executeQuery = null;
        try {
            con = DbUtil.getConnection();
            prst = con.prepareStatement(sql);
            prst.setString(1, user.getName());
            prst.setString(2, user.getPassword());
            executeQuery = prst.executeQuery();
            if (!executeQuery.next()) {
                String reString = "旧密码错误！";
                return reString;
            }
            id = executeQuery.getInt("id");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeResource(con, prst, executeQuery);
        }
        String reString = "修改失败";
        String sqlString = "update user_table set password=? where id=? ";
        int rst = 0;
        try {
//            Connection con = DbUtil.getConnection();
            prst = con.prepareStatement(sqlString);
            prst.setString(1, newPassword);
            prst.setInt(2, id);
            rst = prst.executeUpdate();
            if (rst > 0) {
                reString = "密码修改成功";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reString;
    }
    //注册,向user表中添加一条数据
    public boolean register(User user) {
        String sql = "insert into user_table(id,name,password,phone_number) values(null,?,?,?)";
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DbUtil.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPhone_number());
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeResource(con, preparedStatement);
        }
        return false;
    }
}
