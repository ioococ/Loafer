package app.usermanger.dao.impl;

import app.usermanger.dao.UserDao;
import app.usermanger.entity.User;
import app.usermanger.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public User getUserByName(String name) {
        User user=null;
        Connection connection= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            connection= JDBCUtil.getConnection();
            String sql="select * from user where name=?";
            ps= connection.prepareStatement(sql);
            ps.setString(1,name);
            rs=ps.executeQuery();
            if (rs.next()) {
                user=new User(rs.getInt("id"),rs.getString("name"),rs.getString("password"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            JDBCUtil.close(rs);
            JDBCUtil.close(ps);
            JDBCUtil.close(connection);
        }
        return user;
    }

    @Override
    public Integer register(User user) {
        Integer num=0;
        Connection connection= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            connection= JDBCUtil.getConnection();
            String sql="insert into user(name,password) values (?,?)";
            ps= connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPwd());
            num=ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            JDBCUtil.close(rs);
            JDBCUtil.close(ps);
            JDBCUtil.close(connection);
        }
        return num;
    }

    @Override
    public List<User> getAll() {
        Connection connection= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<User> users=new ArrayList<>();
        try {
            connection= JDBCUtil.getConnection();
            String sql="select * from user";
            ps= connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                User user=new User(rs.getInt("id"),rs.getString("name"));
                users.add(user);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            JDBCUtil.close(rs);
            JDBCUtil.close(ps);
            JDBCUtil.close(connection);
        }
        return users;
    }
}
