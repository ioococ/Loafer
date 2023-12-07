import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import ink.onei.dao.IUserDao;
import ink.onei.dto.PageInfos;
import ink.onei.entity.User;
import ink.onei.vo.PageInfoVO;
import ink.onei.vo.UserAndAddressVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 数据库方法测试
 * @Date: 05/12/2023 14:43 Tuesday
 */

public class DBUserTest {
    SqlSession session = null;
    IUserDao userDao;

    @Before
    public void before() throws IOException {
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @Test
    public void add() {
        User user = new User("root", "root", "男", "11111", "1@1.com", new Date(997718400), "root");
        Integer add = userDao.insert(user);
    }

    @Test
    public void update() {
        User user = new User("root", "P@$$vvr0d", "男", "11111", "1@1.com", new Date(997718400), "root");
        Integer add = userDao.updateUserById(user);
    }

    @Test
    public void updateDynamic() {
        User user = new User();
        user.setId(51);
//        user.setUsername("root");
//        user.setPassword("P@$$vvr0d");
//        user.setSex("男");
        user.setPhone("111112");
        user.setEmail("1@1.com");
//        user.setNickname("root");
        user.setBirthday(new Date(1080771840000L));
        Integer i = userDao.updateUserDynamic(user);
    }

    @Test
    public void delete() {
        session.delete("User.deleteUserById", 106);
    }

    @Test
    public void select() {
        User user = userDao.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void selectList() {
        List<User> allUser = userDao.getAllUser();
        System.out.println(allUser.size());
    }

    @Test
    public void selectAddrByUser() {
        UserAndAddressVO userAndAddressVO = userDao.userAndAddress(1);
        System.out.println(userAndAddressVO);
    }

    @Test
    public void selectAddrByUserWithJoin() {
        UserAndAddressVO userAndAddressVO = userDao.userAndAddressTwo(1);
        System.out.println(userAndAddressVO);
    }

    @Test
    public void getUserPage() {
        PageInfos pageInfos = new PageInfos();
        pageInfos.setPageNum(3);
        pageInfos.setPageSize(3);
        pageInfos.getPageStart();
        List<User> userList = userDao.getUserPage(pageInfos);
        int userCount = userDao.getUserCount();
        PageInfoVO result = new PageInfoVO(userList, userCount);
        System.out.println(result);
    }

    @Test
    public void getUserAutoPage() {
        User user = new User();
        user.setCreatedate(null);
        PageHelper.startPage(3, 3);
        List<User> usersDynamic = userDao.getUserDynamic(user);
        System.out.println(usersDynamic);

        PageInfo<User> of = PageInfo.of(usersDynamic);
        System.out.println(of);
    }

    @Test
    public void getAddressAndUserAutoPage() {
        User user = new User();
        user.setCreatedate(null);
        PageHelper.startPage(1, 1);
        UserAndAddressVO userAndAddressVO = userDao.userAndAddressTwo(1);
        System.out.println(userAndAddressVO);
    }

    @After
    public void after() {
        session.commit();
    }
}
