package ink.onei.bootstarter.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author nekotako
 * @since 2024-01-04 09:34:00
 */

@Data
@TableName("user")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 277996717475075872L;

    @TableId
    private Integer id;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("sex")
    private String sex;
    @TableField("phone")
    private String phone;
    @TableField("email")
    private String email;
    @TableField("nickname")
    private String nickname;
    @TableField("birthday")
    private Date birthday;
    @TableField("createdate")
    private Date createdate;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

