package app.goodsmanager.dao;

import app.goodsmanager.entity.User;
import app.goodsmanager.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户表操作
 * @Date: 2023/11/10 14:40 星期五
 */

public class UserDao {
    User user = null;
    Connection conn = null;


    public int add(User user) throws SQLException {
        conn = DBUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into user(username,password,nickname) values (?,?,?)");
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(2, user.getNickname());
        int row = pstmt.executeUpdate();
        DBUtils.close(pstmt, conn);
        return row;
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
        conn = DBUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from user where username = ? and password = ?");
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet resultSet = pstmt.executeQuery();
        if (resultSet.next()) {
            user = new User(resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("nickname")
            );
        }
        DBUtils.close(resultSet, pstmt, conn);
        return user;
    }

    /**
     * 根据用户名查用户
     *
     * @param username 用户名
     * @return 用户对象
     * @throws SQLException SQL异常
     */
    public User getUserByName(String username) throws SQLException {
        conn = DBUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from user where username = ?");
        pstmt.setString(1, username);
        ResultSet resultSet = pstmt.executeQuery();
        if (resultSet.next()) {
            user = new User(resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("nickname")
            );
        }
        DBUtils.close(resultSet, pstmt, conn);
        return user;
    }

    /**
     * @return 返回所有用户信息 类型为List<User>
     * @throws SQLException SQL异常
     */
    public List<User> queryAllUsers() throws SQLException {
        conn = DBUtils.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from user");
        List<User> users = new ArrayList<>();
        while (resultSet.next()) {
            user = new User(resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("nickname")
            );
            users.add(user);
        }
        DBUtils.close(resultSet, stmt, conn);
        return users;
    }

    /**
     * 根据ID删除用户
     *
     * @return 返回影响行数 类型为int
     * @throws SQLException SQL异常
     */
    public int deleteUserById(int id) throws SQLException {
        conn = DBUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("delete from user where id=?");
        pstmt.setInt(1, id);
        int rows = pstmt.executeUpdate();
        DBUtils.close(pstmt, conn);
        return rows;
    }

}
