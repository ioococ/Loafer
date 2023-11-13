package user;

import org.junit.Test;
import user.utils.DBUtils;
import user.utils.PropertyUtils;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/11/10 15:15 星期五
 */

public class UtilsTest {
    @Test
    public void propertyTest() throws IOException, SQLException {
//        System.out.println(DBUtils.getConnection());
        System.out.println(PropertyUtils.get("url"));
    }
}
