import com.my.cglib.BBeanFactory;
import com.my.cglib.BookDao;
import com.my.proxy.BeanFactory;
import com.my.proxy.UDImp;
import com.my.proxy.UserDao;
import org.junit.Test;
public class Tests {
    @Test
    public void testw(){
        UserDao userDao = BeanFactory.getBean();
        userDao.save();
    }
    @Test
    public void testx(){
        UserDao userDao = new UDImp();
        userDao.save();
    }
    @Test
    public void bookTestx(){
        BookDao bookDao = BBeanFactory.getBean();
        bookDao.save();
    }
}
