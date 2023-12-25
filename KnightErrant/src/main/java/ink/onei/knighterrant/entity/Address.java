package ink.onei.knighterrant.entity;

import java.io.Serializable;

/**
 * (Address)实体类
 *
 * @author makejava
 * @since 2023-12-25 10:23:24
 */
public class Address implements Serializable {
    private static final long serialVersionUID = -65944764759212650L;

    private Integer id;

    private String addressName;

    private String postcode;

    private Integer userId;

    private String location;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

