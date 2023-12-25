package ink.onei.knighterrant.vo;

import ink.onei.knighterrant.entity.Address;

import java.util.List;

/**
 * @Author: nekotako
 * @Description: 用户细节视图
 * @Date: 25/12/2023 11:26 Monday
 */

public class UserDetailVO {
    private static final long serialVersionUID = -19507133095810156L;

    private Integer id;

    private String userName;

    private Integer age;

    private String sectName;

    private List<Address> addressList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSectName() {
        return sectName;
    }

    public void setSectName(String sectName) {
        this.sectName = sectName;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
