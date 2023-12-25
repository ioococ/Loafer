package ink.onei.knighterrant.vo;

import ink.onei.knighterrant.entity.User;

/**
 * @Author: nekotako
 * @Description: 用户地址细节视图
 * @Date: 25/12/2023 11:40 Monday
 */

public class AddressDetailVO {
    private static final long serialVersionUID = -65944764759212650L;

    private Integer id;

    private String addressName;

    private String postcode;

    private Integer userId;

    private String location;

    private User user;


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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AddressDetailVO() {
    }

    public AddressDetailVO(Integer id, String addressName, String postcode, Integer userId, String location, User user) {
        this.id = id;
        this.addressName = addressName;
        this.postcode = postcode;
        this.userId = userId;
        this.location = location;
        this.user = user;
    }
}
