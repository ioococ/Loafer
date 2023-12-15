package ink.onei.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: nekotako
 * @Description: 地址实体类
 * @Date: 15/12/2023 10:39 Friday
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Integer id;
    private String address;
    private String postcode;
    private Integer userId;

    public Address(String address, String postcode) {
        this.address = address;
        this.postcode = postcode;
    }

    public Address(String address, String postcode, Integer userId) {
        this.address = address;
        this.postcode = postcode;
        this.userId = userId;
    }
}
