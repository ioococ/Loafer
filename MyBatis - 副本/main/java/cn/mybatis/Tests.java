package cn.mybatis;

import cn.mybatis.mapper.Mapper;
import cn.mybatis.mapper.UserMapper;
import cn.mybatis.pojo.Usertable;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Tests {
    @Test
    public void InsertUser() throws Exception {
        InputStream iS = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sSFB = new SqlSessionFactoryBuilder();
        SqlSessionFactory sSF = sSFB.build(iS);
        //获取SqlSession        true事务自动提交
        SqlSession sS = sSF.openSession(true);
        //通过代理模式 创建UserMapper接口的代理实现对象 (userMapper)
        UserMapper userMapper = sS.getMapper(UserMapper.class);
        Mapper mapper = sS.getMapper(Mapper.class);
        //执行userMapper里的方法
//        int result = userMapper.insert();

//        List <Usertable> list  = userMapper.find();
//        for (Usertable u : list) {
//            System.out.println(u);
//        }

        Usertable ut = userMapper.findOne(1);
        System.out.println(ut);
    }

    @Test
    public void sPxsb() throws Exception {
        InputStream iS = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sSFB = new SqlSessionFactoryBuilder();
        SqlSessionFactory sSF = sSFB.build(iS);
        //获取SqlSession        true事务自动提交
        SqlSession sS = sSF.openSession(true);
        //通过代理模式 创建Mapper接口的代理实现对象 (Mapper)
        Mapper mapper = sS.getMapper(Mapper.class);
        if (mapper.existTable() == 1) {
            mapper.dropTable();
        } else {
            mapper.createTable();
        }
    }

    @Test
    public void FindTest() throws IOException {
        InputStream iS = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sSFB = new SqlSessionFactoryBuilder();
        SqlSessionFactory sSF = sSFB.build(iS);
        //获取SqlSession        true事务自动提交
        SqlSession sS = sSF.openSession(true);
        //通过代理模式 创建Mapper接口的代理实现对象 (Mapper)
        UserMapper mapper = sS.getMapper(UserMapper.class);
        Usertable usertable = mapper.findOn(1, "Super");
        System.out.println(usertable);
    }
    @Test
    public void insertOne() throws IOException {
        InputStream iS = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sSFB = new SqlSessionFactoryBuilder();
        SqlSessionFactory sSF = sSFB.build(iS);
        //获取SqlSession        true事务自动提交
        SqlSession sS = sSF.openSession(true);
        //通过代理模式 创建Mapper接口的代理实现对象 (Mapper)
        UserMapper mapper = sS.getMapper(UserMapper.class);
        int result = mapper.insertOne("WangWu","123456");
        System.out.println(result);
    }
    @Test
    public void updateOne() throws IOException {
        InputStream iS = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sSFB = new SqlSessionFactoryBuilder();
        SqlSessionFactory sSF = sSFB.build(iS);
        //获取SqlSession        true事务自动提交
        SqlSession sS = sSF.openSession(true);
        //通过代理模式 创建Mapper接口的代理实现对象 (Mapper)
        UserMapper mapper = sS.getMapper(UserMapper.class);
        int result = mapper.updatetOne("WangWu","123456");
        System.out.println(result);
    }
}
