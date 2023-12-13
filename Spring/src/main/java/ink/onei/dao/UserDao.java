package ink.onei.dao;

import ink.onei.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户表操作
 * @Date: 2023/11/10 14:40 星期五
 */
@Repository
public class UserDao implements IUserDao {

    @Autowired
    Connection connection;

    /**
     * @param user
     * @return
     */
    @Override
    public Boolean insert(User user) throws SQLException {
        String sql = "insert into user(username,password,sex,phone,email,nickname,birthday,createdate) values (?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getSex());
        pstmt.setString(4, user.getPhone());
        pstmt.setString(5, user.getEmail());
        pstmt.setString(6, user.getNickname());
        pstmt.setDate(7, user.getBirthday());
        pstmt.setTimestamp(8, user.getCreatedate());
        return pstmt.execute();
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Boolean update(User user) throws SQLException {
        String sql = "update user set username=?,password=?,sex=?,phone=?,email=?,nickname=?,birthday=?,createdate=? where id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getSex());
        pstmt.setString(4, user.getPhone());
        pstmt.setString(5, user.getEmail());
        pstmt.setString(6, user.getNickname());
        pstmt.setDate(7, user.getBirthday());
        pstmt.setTimestamp(8, user.getCreatedate());
        pstmt.setInt(9, user.getId());
        return pstmt.execute();
    }

    /**
     * @param user
     * @return
     */
    @Override
    public Boolean delete(User user) throws SQLException {
        String sql = "delete from user where id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, user.getId());
        return pstmt.execute();
    }

    /**
     * 根据用户名和密码查用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     * @throws SQLException SQL异常
     */
    public User getSingleUser(String username, String password) throws SQLException {
        User user = new User();
        String sql = "select * from user where username = ? and password = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet resultSet = pstmt.executeQuery();
        if (resultSet.next()) {
            user = new User(resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("sex"),
                    resultSet.getString("phone"),
                    resultSet.getString("email"),
                    resultSet.getDate("birthday"),
                    resultSet.getString("nickname"),
                    resultSet.getTimestamp("createdate")
            );
        }
        return user;
    }

    public User getUserById(Integer id) throws SQLException {
        User user = new User();
        String sql = "select * from user where id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet resultSet = pstmt.executeQuery();
        if (resultSet.next()) {
            user = new User(resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("sex"),
                    resultSet.getString("phone"),
                    resultSet.getString("email"),
                    resultSet.getDate("birthday"),
                    resultSet.getString("nickname"),
                    resultSet.getTimestamp("createdate")
            );
        }
        return user;
    }

    /**
     * @return 返回所有用户信息 类型为List<User>
     */
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        User user = null;
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from user");
        while (resultSet.next()) {
            user = new User(resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("sex"),
                    resultSet.getString("phone"),
                    resultSet.getString("email"),
                    resultSet.getDate("birthday"),
                    resultSet.getString("nickname"),
                    resultSet.getTimestamp("createdate")
            );
            users.add(user);
        }
        return users;
    }
}
