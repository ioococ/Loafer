package neko.fastboot.pojo;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {

  private long uID;
  private String name;
  private String password;
  private long age;
  private long sex;
  private String email;
  private java.sql.Date date;

}
