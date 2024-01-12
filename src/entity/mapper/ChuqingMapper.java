package entity.mapper;

import entity.Chuqing;
import entity.Student;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChuqingMapper {
    private static Connection connection;

    static {
        try {
            connection = JdbcUtils.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Chuqing> select(){
        List<Chuqing> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select chuqing.*,student.* from chuqing,student where chuqing.sid=student.id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Chuqing chuqing = new Chuqing(
                        resultSet.getInt("chuqing.id"),
                        resultSet.getInt("chuqing.sid"),
                        resultSet.getString("chuqing.time"),
                        resultSet.getString("chuqing.statue")
                );
                chuqing.setStudent(new Student(
                        resultSet.getInt("student.id"),
                        resultSet.getString("student.name"),
                        resultSet.getString("student.sex"),
                        resultSet.getInt("student.age"),
                        resultSet.getString("student.classname")
                ));
                list.add(chuqing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public boolean delete(Integer id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from chuqing where id=?");
            preparedStatement.setInt(1,id);
            int i = preparedStatement.executeUpdate();
            return i!=0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean add(Chuqing chuqing){
        try {
            String sql = "insert into chuqing values(null,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,chuqing.getSid());
            preparedStatement.setString(2,chuqing.getTime());
            preparedStatement.setString(3,chuqing.getStatue());
            int i = preparedStatement.executeUpdate();
            return i!=0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Chuqing chuqing){
        try {
            String sql = "update chuqing set sid=?,time=?,statue=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,chuqing.getSid());
            preparedStatement.setString(2,chuqing.getTime());
            preparedStatement.setString(3,chuqing.getStatue());
            preparedStatement.setInt(4,chuqing.getId());
            int i = preparedStatement.executeUpdate();
            return i!=0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}




