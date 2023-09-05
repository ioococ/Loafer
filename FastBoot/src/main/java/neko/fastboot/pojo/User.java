package neko.fastboot.pojo;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class User {

  private long uID;
  private String name;
  private String password;
  private int age;
  private String sex;
  private String email;
  private java.sql.Date date;

  @Override
  public String toString() {
    return "User{" +
            "uID=" + uID + "  name=" + name  + "\tpassword=" + password  +"\tage=" + age +"\tsex=" + sex +"\tEmail=" + email +"\tdate=" + date +
            '}';
  }
}
