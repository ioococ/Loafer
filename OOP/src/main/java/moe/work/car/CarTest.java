package moe.work.car;

import org.junit.Test;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/8/30 19:23 星期三
 */
public class CarTest {
    @Test
    public void car() {
        SubCar jili = new SubCar();
        SubCar changcheng = new SubCar();
        jili.setElectric(false);
        jili.setBrand("jili");
        changcheng.setBrand("changcheng");
        changcheng.setElectric(true);
        changcheng.setSpeed(120);
        System.out.println(jili.getSpeed());
        System.out.println(changcheng);
        jili.manualPilot("人工", 80);
        changcheng.autoPilot("自动", 120);
    }
}

