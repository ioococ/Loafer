package cn.my.update;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.lang.model.element.Parameterizable;
import java.util.List;

public class UDImp implements UserDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addUser(Spring user) {
        String sql = "insert into springuser(username, password) VALUE (?,?)";
        Object[] obj = new Object[]{
                user.getUsername(),
                user.getPassword()
        };

//        System.out.println(getJdbcTemplate());
        int flag = this.jdbcTemplate.update(sql,obj);
        return flag;
    }

    @Override
    public int updateUser(Spring user) {
        String sql = "update springuser set username=?,password=? where userId=?";
        Object[] params = new Object[] {
                user.getUsername(),
                user.getPassword(),
                user.getUserId()
        };
        int flag = -this.jdbcTemplate.update(sql,params);
        return flag;
    }

    @Override
    public int deleteUserById(int id) {
        String sql = "delete from springuser where userId=?";
        int flag = this.jdbcTemplate.update(sql,id);
        return flag;
    }

    @Override
    public Spring findUserById(int id) {
        String sql = "select*from spring where userId=?";
        //将结果集以反射形式映射到Java文件中
        //Spring 版本 >3.0 使用 BeanPropertyRowMapper
        //Spring 版本 <=3.0 使用 BeanPropertyRowMapper
        RowMapper<Spring> rowMapper = BeanPropertyRowMapper.newInstance(Spring.class);
        return this.jdbcTemplate.queryForObject(sql,rowMapper,id);
    }

    @Override
    public List<Spring> findAllUser() {
        String sql = "select*from spring";
        //将结果集以反射形式映射到Java文件中
        //Spring 版本 >3.0 使用 BeanPropertyRowMapper
        //Spring 版本 <=3.0 使用 BeanPropertyRowMapper
        RowMapper<Spring> rowMapper = BeanPropertyRowMapper.newInstance(Spring.class);
        return this.jdbcTemplate.query(sql,rowMapper);
    }
}
