package entity.mapper;

import entity.Richangbiaoxian;
import entity.Student;
import entity.Tijian;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TijianMapper {
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

    public List<Tijian> select(){
        List<Tijian> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select tijian.*,student.* from tijian,student where tijian.sid=student.id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Tijian tijian = new Tijian(
                        resultSet.getInt("tijian.id"),
                        resultSet.getInt("tijian.sid"),
                        resultSet.getString("tijian.time"),
                        resultSet.getString("tijian.height"),
                        resultSet.getString("tijian.width"),
                        resultSet.getString("tijian.eent"),
                        resultSet.getString("tijian.other")
                );
                tijian.setStudent(new Student(
                        resultSet.getInt("student.id"),
                        resultSet.getString("student.name"),
                        resultSet.getString("student.sex"),
                        resultSet.getInt("student.age"),
                        resultSet.getString("student.classname")
                ));
                list.add(tijian);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean delete(Integer id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from tijian where id=?");
            preparedStatement.setInt(1,id);
            int i = preparedStatement.executeUpdate();
            return i!=0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Tijian tijian){
        try {
            String sql = "update tijian set sid=?,time=?,height=?,width=?,eent=?,other=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,tijian.getSid());
            preparedStatement.setString(2,tijian.getTime());
            preparedStatement.setString(3,tijian.getHeight());
            preparedStatement.setString(4,tijian.getWidth());
            preparedStatement.setString(5,tijian.getEent());
            preparedStatement.setString(6,tijian.getOther());
            preparedStatement.setInt(7,tijian.getId());
            int i = preparedStatement.executeUpdate();
            return i!=0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean add(Tijian tijian){
        try {
            String sql = "insert into tijian values(null,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,tijian.getSid());
            preparedStatement.setString(2,tijian.getTime());
            preparedStatement.setString(3,tijian.getHeight());
            preparedStatement.setString(4,tijian.getWidth());
            preparedStatement.setString(5,tijian.getEent());
            preparedStatement.setString(6,tijian.getOther());
            int i = preparedStatement.executeUpdate();
            return i!=0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}




