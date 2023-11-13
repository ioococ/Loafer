package user.dao;

import user.entity.User;
import user.utils.DBUtils;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/11/10 14:40 星期五
 */

public class UserDao {
    User user = null;
    Connection conn = null;


    public int add(User user) throws SQLException {
        conn = DBUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into users(username,password,createdate) values (?,?,?)");
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
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
    public User querySingleUser(String username, String password) throws SQLException {
        conn = DBUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from users where username = ? and password = ?");
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet resultSet = pstmt.executeQuery();
        if (resultSet.next()) {
            user = new User();
            user.setUsername(resultSet.getString("username"));
            user.setSex(resultSet.getString("sex"));
            user.setPhone(resultSet.getString("phone"));
            user.setEmail(resultSet.getString("email"));
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
    public User queryByUsername(String username) throws SQLException {
        conn = DBUtils.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("select * from users where username = ?");
        pstmt.setString(1, username);
        ResultSet resultSet = pstmt.executeQuery();
        if (resultSet.next()) {
            user = new User();
            user.setUsername(resultSet.getString("username"));
            user.setSex(resultSet.getString("sex"));
            user.setPhone(resultSet.getString("phone"));
            user.setEmail(resultSet.getString("email"));
        }
        DBUtils.close(resultSet, pstmt, conn);
        return user;
    }
}
