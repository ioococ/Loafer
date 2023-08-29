package moe.work;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: nekotako
 * @Description: 客户姓名添加和显示
 * @Date: 2023/8/29 16:23 星期二
 */

public class ShowName {
    public static void main(String[] args) {
        CustomerBiz wmk = new CustomerBiz();
        while (true) {
            Scanner oi = new Scanner(System.in);
            System.out.print("请输入客户的姓名：");
            String name = oi.nextLine();
            wmk.addName(name);
            System.out.print("继续输入吗?(y/n)：");
            String flags = oi.nextLine();
            if (flags.equals("n")) {
                break;
            }
        }
        wmk.showNames();
    }
}

class CustomerBiz {
    private ArrayList<String> names = new ArrayList<>();
    void addName(String name) {
        names.add(name);
    }

    void showNames() {
        System.out.println("***********************");
        System.out.println("     客户姓名列表");
        System.out.println("***********************");
        for (String name : names) {
            System.out.print(name + "\t");
        }
        System.out.println();
    }
}
