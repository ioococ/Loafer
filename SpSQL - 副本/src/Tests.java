import cn.my.update.Spring;
import cn.my.update.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tests {
    public ApplicationContext init() {
        String XmlFile = "beans.xml";
        ApplicationContext aC = new ClassPathXmlApplicationContext(XmlFile);
        return aC;
    }

    @Test
    public void addUser() {
        ApplicationContext aC = init();
        UserDao userDao = aC.getBean("userDao", UserDao.class);
        Spring user = new Spring();
        user.setUsername("ZhangSan");
        user.setPassword("123456");
        int flag = userDao.addUser(user);
        if (flag == 1) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }
    public void updateUser() {

    }
}
