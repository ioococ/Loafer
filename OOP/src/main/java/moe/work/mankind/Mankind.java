package moe.work.mankind;

import java.util.Objects;

/**
 * @Author: nekotako
 * @Description: mankind
 * @Date: 2023/8/30 19:44 星期三
 */

public class Mankind {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void getDailyWork() {
        System.out.println(name + "日常工作");
    }
}

class Teacher extends Mankind {

}

class Assistant extends Mankind {

}

class Student extends Mankind {
    private Teacher teacher;
    private Assistant assistant;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    @Override
    public String toString() {
        String studentSexStr = null;
        String teacherSexStr = null;
        String assistantSexStr = null;
        if (!Objects.equals(this.getSex(), null)) {
            studentSexStr = "性别：" + this.getSex() + "，";
        } else {
            studentSexStr = "";
        }
        if (!Objects.equals(teacher.getSex(), null)) {
            teacherSexStr = "，讲师性别：" + this.teacher.getSex();
        } else {
            teacherSexStr = "";
        }
        if (!Objects.equals(assistant.getSex(), null)) {
            assistantSexStr = "，辅导员性别：" + this.assistant.getSex();
        } else {
            assistantSexStr = "";
        }
        return this.getName() + "：{" + studentSexStr + "讲师：" + this.teacher.getName() + teacherSexStr + ", 辅导员：" + this.assistant.getName() + assistantSexStr + '}';
    }
}
