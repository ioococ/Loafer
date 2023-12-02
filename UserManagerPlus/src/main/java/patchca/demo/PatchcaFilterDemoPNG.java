package patchca.demo;

import patchca.color.SingleColorFactory;
import patchca.filter.predefined.*;
import patchca.service.ConfigurableCaptchaService;
import patchca.utils.encoder.EncoderHelper;

import java.awt.*;
import java.io.FileOutputStream;
import java.util.Random;

public class PatchcaFilterDemoPNG {
    public static void main(String[] args) throws Exception {
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
        FileOutputStream fos = new FileOutputStream("patcha.png");
        EncoderHelper.getChallangeAndWriteImage(cs, "png", fos);
        fos.close();
    }
}
