package dao;
import modle.Type;
import util.DbUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class TypeDao {
    public TypeDao() throws Exception {
    }

    /**
     * 添加题目类型
     * @param type
     * @return
     */
    public boolean addType(Type type) {
        String sql = "insert into title_type(id,name,info) values(null,?,?)";
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DbUtil.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, type.getName());
            preparedStatement.setString(2, type.getInfo());
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

    /**
     * 查找题目类型
     * @param type
     * @return
     */
    public List<Type> getTypeList(Type type) {
        List<Type> retList = new ArrayList<Type>();
        String sqlString = "select * from title_type";
        if (StringUtil.isNotEmpty(type.getName())) {
            sqlString += " where name like '%" + type.getName() + "%'";
        }
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            con = DbUtil.getConnection();
            preparedStatement = con.prepareStatement(sqlString);
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Type type_1 = new Type();
                type_1.setId(resultSet.getInt("id"));
                type_1.setName(resultSet.getString("name"));
                type_1.setInfo(resultSet.getString("info"));
                retList.add(type_1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeResource(con, preparedStatement, resultSet);
        }
        return retList;
    }

    /**
     * 题目类型的删除
     * @param id
     * @return
     */
    public boolean delete(int id) {
        String sql = "delete from title_type where id=?";
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DbUtil.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
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

    /**
     * 改变题目类型
     * @param type
     * @return
     */
     public boolean update(Type type) {
         String sql = "update title_type set name=?,info=? where id=?";
         Connection con = null;
         PreparedStatement preparedStatement = null;
         try {
             con = DbUtil.getConnection();
             preparedStatement = con.prepareStatement(sql);
             preparedStatement.setString(1, type.getName());
             preparedStatement.setString(2, type.getInfo());
             preparedStatement.setInt(3, type.getId());
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