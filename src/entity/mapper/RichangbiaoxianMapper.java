package entity.mapper;

import entity.Chuqing;
import entity.Richangbiaoxian;
import entity.Student;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RichangbiaoxianMapper {
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

    public List<Richangbiaoxian> select(){
        List<Richangbiaoxian> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select richangbiaoxian.*,student.* from richangbiaoxian,student where richangbiaoxian.sid=student.id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Richangbiaoxian richangbiaoxian = new Richangbiaoxian(
                        resultSet.getInt("richangbiaoxian.id"),
                        resultSet.getInt("richangbiaoxian.sid"),
                        resultSet.getString("richangbiaoxian.time"),
                        resultSet.getString("richangbiaoxian.info"),
                        resultSet.getString("richangbiaoxian.grade")
                );
                richangbiaoxian.setStudent(new Student(
                        resultSet.getInt("student.id"),
                        resultSet.getString("student.name"),
                        resultSet.getString("student.sex"),
                        resultSet.getInt("student.age"),
                        resultSet.getString("student.classname")
                ));
                list.add(richangbiaoxian);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean delete(Integer id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from richangbiaoxian where id=?");
            preparedStatement.setInt(1,id);
            int i = preparedStatement.executeUpdate();
            return i!=0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Richangbiaoxian richangbiaoxian){
        try {
            String sql = "update richangbiaoxian set sid=?,time=?,info=?,grade=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,richangbiaoxian.getSid());
            preparedStatement.setString(2,richangbiaoxian.getTime());
            preparedStatement.setString(3,richangbiaoxian.getInfo());
            preparedStatement.setString(4,richangbiaoxian.getGrade());
            preparedStatement.setInt(5,richangbiaoxian.getId());
            int i = preparedStatement.executeUpdate();
            return i!=0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean add(Richangbiaoxian richangbiaoxian){
        try {
            String sql = "insert into richangbiaoxian values(null,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,richangbiaoxian.getSid());
            preparedStatement.setString(2,richangbiaoxian.getTime());
            preparedStatement.setString(3,richangbiaoxian.getInfo());
            preparedStatement.setString(4,richangbiaoxian.getGrade());
            int i = preparedStatement.executeUpdate();
            return i!=0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}




