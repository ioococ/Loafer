package app.usermanager.servlet;

import app.usermanager.utils.Captcha;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serial;

/**
 * @Author: nekotako
 * @Description: 验证码
 * @Date: 02/12/2023 15:03 Saturday
 */

@WebServlet(value = "/getCaptcha")
public class CaptchaServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -7712789116141404770L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 返回为图片类型
        response.setContentType("image/jpg");

        Captcha captcha = Captcha.getIntance();
        captcha.set(150,50);
        String captchaCode = captcha.generateCheckcode();
        BufferedImage captchaImage = captcha.generateCheckImg(captchaCode);
        request.getSession().setAttribute("captcha", captchaCode);
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(captchaImage, "jpg", outputStream);


    }
}
