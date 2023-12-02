package app.usermanager.servlet;

import patchca.color.SingleColorFactory;
import patchca.filter.predefined.*;
import patchca.service.ConfigurableCaptchaService;
import patchca.utils.encoder.EncoderHelper;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.Serial;
import java.util.Random;

/**
 * @Author: nekotako
 * @Description: 验证码
 * @Date: 02/12/2023 15:03 Saturday
 */

@WebServlet(value = "/getPatchca")
public class PatchcaServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -7712789116141404770L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 返回为图片类型
        response.setContentType("image/jpg");
        Random random = new Random();
        int counter = random.nextInt(5);
        ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
        switch (counter) {
            case 0:
                cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
                break;
            case 1:
                cs.setFilterFactory(new MarbleRippleFilterFactory());
                break;
            case 2:
                cs.setFilterFactory(new DoubleRippleFilterFactory());
                break;
            case 3:
                cs.setFilterFactory(new WobbleRippleFilterFactory());
                break;
            case 4:
                cs.setFilterFactory(new DiffuseRippleFilterFactory());
                break;
        }
        ServletOutputStream outputStream = response.getOutputStream();
        String challange = EncoderHelper.getChallangeAndWriteImage(cs, "png", outputStream);
        request.getSession().setAttribute("patchca", challange);
        outputStream.close();

    }
}
