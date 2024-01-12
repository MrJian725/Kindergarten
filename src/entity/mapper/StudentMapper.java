package entity.mapper;

import entity.Student;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentMapper {
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


    public List<Student> select(){
        List<Student> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("sex"),
                        resultSet.getInt("age"),
                        resultSet.getString("classname")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public boolean delete(Integer id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where id=?");
            preparedStatement.setInt(1,id);
            int i = preparedStatement.executeUpdate();
            return i!=0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Student student){
        try {
            String sql = "update student set name=?,sex=?,age=?,classname=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getSex());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setString(4,student.getClassname());
            preparedStatement.setInt(5,student.getId());
            int i = preparedStatement.executeUpdate();
            return i!=0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean add(Student student){
        try {
            String sql = "insert into student values(null,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getSex());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setString(4,student.getClassname());
            int i = preparedStatement.executeUpdate();
            return i!=0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}




