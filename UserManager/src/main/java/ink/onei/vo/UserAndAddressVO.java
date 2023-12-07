package ink.onei.vo;

import ink.onei.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户地址视图
 * @Date: 07/12/2023 11:24 Thursday
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAndAddressVO {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "sex")
    private String sex;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private java.sql.Date birthday;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "createdate")
    private java.sql.Timestamp createdate = new Timestamp(System.currentTimeMillis());

    List<Address> addressList;

}
