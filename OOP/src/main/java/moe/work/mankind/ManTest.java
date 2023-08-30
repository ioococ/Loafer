package moe.work.mankind;

import org.junit.Test;

/**
 * @Author: nekotako
 * @Description: test
 * @Date: 2023/8/30 19:51 星期三
 */

public class ManTest {
    @Test
    public void test() {
        Student xiaoMing = new Student();
        Student xiaoHong = new Student();
        xiaoMing.setName("小明");
        xiaoHong.setName("小红");
        Teacher mrSun = new Teacher();
        mrSun.setName("孙老师");
        Teacher missWang = new Teacher();
        missWang.setName("王老师");
        missWang.setSex("女");
        Assistant zs = new Assistant();
        zs.setName("张三");
        zs.setSex("男");
        Assistant ls = new Assistant();
        ls.setName("李四");
        xiaoMing.setTeacher(missWang);
        xiaoHong.setTeacher(mrSun);
        xiaoMing.setAssistant(zs);
        xiaoHong.setAssistant(zs);

        System.out.println(xiaoMing.toString());
        System.out.println(xiaoHong.toString());
    }
}
