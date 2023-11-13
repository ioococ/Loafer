package user.entity;


import java.sql.Timestamp;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/11/10 14:44 星期五
 */

public class User {

    private long id;
    private String username;
    private String password;
    private String sex;
    private String phone;
    private String email;
    private java.sql.Timestamp birthday;
    private String nickname;
    private java.sql.Timestamp createdate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public java.sql.Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(java.sql.Timestamp birthday) {
        this.birthday = birthday;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public java.sql.Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(java.sql.Timestamp createdate) {
        this.createdate = createdate;
    }

    public User() {
    }

    public User(long id, String username, String password, String sex, String phone, String email, Timestamp birthday, String nickname, Timestamp createdate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.nickname = nickname;
        this.createdate = createdate;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", nickname='" + nickname + '\'' +
                ", createdate=" + createdate +
                '}';
    }
}
