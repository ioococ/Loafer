package ink.onei.vo;

import ink.onei.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @Author: nekotako
 * @Description: 地址用户视图
 * @Date: 07/12/2023 11:24 Thursday
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressAndUserVO {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "userid")
    private Integer userid;

    private User user;

}
