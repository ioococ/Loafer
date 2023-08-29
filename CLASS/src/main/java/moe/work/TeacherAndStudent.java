package moe.work;

/**
 * @Author: nekotako
 * @Description: 创建和使用对象示例
 * @Date: 2023/8/29 19:52 星期二
 */

public class TeacherAndStudent {
    public static void main(String[] args) {
        Student student = new Student();
        Teacher teacher = new Teacher();
        student.show("zs", "computer", "rap", 18);
        teacher.show("ls", "computer", "computer", 18);
    }
}

class Teacher {
    public void show(String name, String major, String course, int age) {
        System.out.println(name);
        System.out.println("专业方向：" + major);
        System.out.println("教授课程：" + course);
        System.out.println("教龄：" + age);
    }
}

class Student {

    public void show(String name, String grade, String hobby, int age) {
        System.out.println(name);
        System.out.println("年龄：" + age);
        System.out.println("就读于：" + grade);
        System.out.println("爱好：" + hobby);
    }
}
