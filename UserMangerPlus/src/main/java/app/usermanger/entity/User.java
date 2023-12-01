package app.usermanger.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String pwd;
    public User(String name,String pwd){
        this.name=name;
        this.pwd=pwd;
    }
    public User(Integer id,String name){
        this.id=id;
        this.name=name;
    }
}
