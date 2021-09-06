package dao;

import modle.Title;
import modle.TitleRecord;
import modle.Type;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TitleRecordDao {
    public TitleRecordDao() throws Exception {
    }

    /**
     * 添加一条已经做过的题目,这个添加没有添加下次出现的时间
     * @param titleRecord
     * @return
     */
    public boolean addTitleRecord(TitleRecord titleRecord) {
        String sql = "insert into title_record(id,title_id,create_date,next_date) values(null,?,?,null)";
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DbUtil.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, titleRecord.getTitle_id());
            preparedStatement.setString(2, titleRecord.getCreate_date());
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
     * 添加一条已经做过的题目,这个添加了下次出现的时间
     * @param titleRecord
     * @return
     */
    public boolean addTitleResultRecord(TitleRecord titleRecord) {
        String sql = "insert into title_record(id,title_id,create_date,next_date) values(null,?,?,?)";
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try {
            con = DbUtil.getConnection();
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, titleRecord.getTitle_id());
            preparedStatement.setString(2, titleRecord.getCreate_date());
            preparedStatement.setString(3, titleRecord.getNext_date());
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
     * 查找已经做过的题目
     * @param titleRecord1
     * @return
     */
    public List<TitleRecord> getTitleRecordList(TitleRecord titleRecord1){
        List<TitleRecord> retList = new ArrayList<TitleRecord>();
        TitleRecord titleRecord;
        String sqlString = "select * from title_record rec left join title_table tit ON rec.`title_id`=tit.`id` order by next_date desc";
        Connection con = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            con = DbUtil.getConnection();
            preparedStatement = con.prepareStatement(sqlString);
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                titleRecord = new TitleRecord();
                titleRecord.setId(resultSet.getInt("rec.id"));
                titleRecord.setContent(resultSet.getString("content"));
                titleRecord.setCreate_date(resultSet.getString("create_date"));
                titleRecord.setNext_date(resultSet.getString("next_date"));
                retList.add(titleRecord);
                System.out.println(retList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DbUtil.closeResource(con, preparedStatement, resultSet);
        }
        return retList;
    }
}
