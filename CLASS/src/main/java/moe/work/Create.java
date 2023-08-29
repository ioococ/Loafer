package moe.work;

/**
 * @Author: nekotako
 * @Description: 创建账户
 * @Date: 2023/8/29 20:21 星期二
 */

public class Create {
    public static void main(String[] args) {
        createUser hmjmf = new createUser();
        createUser kljc = new createUser();
        hmjmf.show("hmjmf", "hmjmf");
        kljc.show("kljc", "kljc");

    }
}

class createUser {
    public void show(String username, String password) {
        System.out.println("姓名：" + username + "，密码：" + password);
    }
}
