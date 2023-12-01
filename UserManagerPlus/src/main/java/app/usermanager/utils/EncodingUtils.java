package app.usermanager.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 30/11/2023 11:14 Thursday
 */

public class EncodingUtils {
    public static void setCharacterEncoding(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }
}
