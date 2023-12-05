import ink.onei.dao.IAddressDao;
import ink.onei.entity.Address;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 数据库方法测试
 * @Date: 05/12/2023 14:43 Tuesday
 */

public class DBAddressTest {
    SqlSession session;
    IAddressDao addressDao;

    @Before
    public void before() throws IOException {
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        session = new SqlSessionFactoryBuilder().build(inputStream).openSession();
        addressDao = session.getMapper(IAddressDao.class);

    }

    @Test
    public void insert() {
        Address address = new Address("ShijiaZhuang", "050001", 21);
        Integer insert = addressDao.add(address);
    }

    @Test
    public void update() {
        Address address = new Address(51, "石家庄", "050001", 21);
        addressDao.updateAddressById(address);
    }

    @Test
    public void delete() {
        addressDao.deleteAddressById(51);
    }

    @Test
    public void select() {
        Address address = addressDao.getAddressById(1);
        System.out.println(address);
    }

    @Test
    public void selectList() {
        List<Address> allAddress = addressDao.getAllAddress();
        System.out.println(allAddress.size());
    }

    @After
    public void after() {
        session.commit();
    }
}
