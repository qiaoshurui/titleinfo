package dao;

import modle.Title;
import util.DbUtil;
import util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TitleDao {
    /**
     * 增加题目
     * @param title
     * @return
     */
    public boolean addTitle(Title title) {
        String sql = "insert into title_table(id,content,type_id,difficult) values(null,?,?,?)";
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DbUtil.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, title.getContent());
            preparedStatement.setInt(2, title.getType_id());
            preparedStatement.setString(3, title.getDifficult());
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
     * 查询题目，模糊查询和准确查询
     * @param title
     * @return
     */
    public List<Title> getTitleList(Title title) {
        List<Title> retList_1 = new ArrayList<Title>();
        StringBuffer sqlString = new StringBuffer("select * from title_table tit left join title_type tp ON tit.`type_id`=tp.`id`");
        if (StringUtil.isNotEmpty(title.getContent())) {
            sqlString.append(" and type_id = " + title.getType_id());
        }
        if (title.getType_id() != 0) {
            sqlString.append(" and content like '%" + title.getContent() + "%'");
        }
        if (title.getId() != 0) {
            sqlString.append(" and tit.id =" + title.getId());
        }
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            con = DbUtil.getConnection();
            preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Title title1 = new Title();
                title1.setId(resultSet.getInt("id"));
                title1.setContent(resultSet.getString("content"));
                title1.setType_name(resultSet.getString("name"));
                title1.setDifficult(resultSet.getString("difficult"));
                retList_1.add(title1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeResource(con, preparedStatement, resultSet);
        }
        return retList_1;
    }
    /**
     * 题目的分页查询
     * pageNum 页数  countNum 每页的题目数
     */
    public List<Title> getTitleList(Title title,int pageNum,int countNum) {
        List<Title> retList_1 = new ArrayList<Title>();
        String sqlString = "select * from title_table tit left join title_type tp ON tit.`type_id`=tp.`id` limit ?,?";
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            con = DbUtil.getConnection();
            preparedStatement = con.prepareStatement(sqlString);
            preparedStatement.setInt(1, (pageNum - 1) * countNum);
            preparedStatement.setInt(2, countNum);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Title title1 = new Title();
                title1.setId(resultSet.getInt("id"));
                title1.setContent(resultSet.getString("content"));
                title1.setType_name(resultSet.getString("name"));
                title1.setDifficult(resultSet.getString("difficult"));
                retList_1.add(title1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.closeResource(con, preparedStatement, resultSet);
        }
        return retList_1;

    }
    /**
     * 随机出题 随机出三个数字a,b,c
     */
    public List<Title> randomNumber(int a,int b,int c,int d,int f){
        List<Title> retList_1 = new ArrayList<Title>();
        String sqlString = "select * from title_table tt left join title_type ty on tt.type_id = ty.id where tt.id in(?,?,?,?,?)";
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            DbUtil.getConnection();
            con = DbUtil.getConnection();
            preparedStatement = con.prepareStatement(sqlString);
            preparedStatement.setInt(1,a);
            preparedStatement.setInt(2,b);
            preparedStatement.setInt(3,c);
            preparedStatement.setInt(4,d);
            preparedStatement.setInt(5,f);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Title title1 = new Title();
                title1.setId(resultSet.getInt("tt.id"));
                title1.setContent(resultSet.getString("content"));
                title1.setType_name(resultSet.getString("name"));
                title1.setType_id(resultSet.getInt("ty.id"));
                title1.setDifficult(resultSet.getString("difficult"));
                retList_1.add(title1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return retList_1;

    }

    /**
     * 删除题目的操作
     * @param id
     * @return
     */
    public boolean delete(int id) {
        String sql = "delete from title_table where id=?";
        Connection con = null;
        PreparedStatement preparedStatement=null;
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
     * 修改题目
     * @param title
     * @return
     */
        public boolean update(Title title) {
            String sql = "update title_table set content=?,type_id=?,difficult=? where id=?";
            Connection con = null;
            PreparedStatement preparedStatement = null;
            try {
                con = DbUtil.getConnection();
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, title.getContent());
                preparedStatement.setInt(2, title.getType_id());
                preparedStatement.setString(3, title.getDifficult());
                preparedStatement.setInt(4, title.getId());
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
