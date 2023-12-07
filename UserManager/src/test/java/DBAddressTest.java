import ink.onei.dao.IAddressDao;
import ink.onei.entity.Address;
import ink.onei.vo.AddressAndUserVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
        Integer insert = addressDao.insert(address);
    }

    @Test
    public void insertBatch() {
        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(new Address("ShijiaZhuang", "050001", 21));
        addresses.add(new Address("1", "2", 3));
        addresses.add(new Address("4", "5", 6));
        Integer insert = addressDao.insertBatch(addresses);
    }

    @Test
    public void update() {
        Address address = new Address(51, "石家庄", "050001", 21);
        addressDao.updateAddressById(address);
    }

    @Test
    public void updateDynamic() {
        Address address = new Address();
        address.setId(51);
        address.setAddress("ShiJiaZhuang");
        addressDao.updateAddressDynamic(address);
    }


    @Test
    public void delete() {
        addressDao.deleteAddressById(51);
    }

    @Test
    public void deleteDynamic() {
        List<Integer> list = new ArrayList<>();
        list.add(56);
        list.add(57);
        list.add(58);
        addressDao.deleteBatch(list);
    }

    @Test
    public void select() {
        Address address = addressDao.getAddressById(1);
        System.out.println(address);
    }

    @Test
    public void selectDynamic() {
        Address address = new Address();
        address.setAddress("1");
        address.setPostcode("2");
        Address addressInfo = addressDao.getAddressDynamic(address);
        System.out.println(addressInfo);
    }

    @Test
    public void selectList() {
        List<Address> allAddress = addressDao.getAllAddress();
        System.out.println(allAddress.size());
    }

    @Test
    public void selectUserByAddr(){
        AddressAndUserVO addressAndUserVO = addressDao.AddrAndUserVo(1);
        System.out.println(addressAndUserVO);
    }

    @Test
    public void selectUserByAddrWithJoin(){
        AddressAndUserVO addressAndUserVO = addressDao.AddrAndUserVoTwo(1);
        System.out.println(addressAndUserVO);
    }

    @After
    public void after() {
        session.commit();
    }
}
