package entity.mapper;

import entity.User;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserMapper {
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

    public boolean login(User user){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select count(*) from user where username=? and password=?");
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1)!=0?true:false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean register(User user){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into user values(null,?,?)");
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            int i = preparedStatement.executeUpdate();
            return i!=0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}




