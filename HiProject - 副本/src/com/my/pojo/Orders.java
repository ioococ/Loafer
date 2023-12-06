package com.my.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Orders {
    private int id;
    private String spname;
    private Integer customerId;

    public Orders() {
    }

    public Orders(String spname) {
        this.spname = spname;
    }

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId", referencedColumnName = "Id")
    private com.my.pojo.Customer Customer;

    public com.my.pojo.Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(com.my.pojo.Customer customer) {
        Customer = customer;
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "spname")
    public String getSpname() {
        return spname;
    }

    public void setSpname(String spname) {
        this.spname = spname;
    }

    @Basic
    @Column(name = "customerId")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders that = (Orders) o;
        return id == that.id && Objects.equals(spname, that.spname) && Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spname, customerId);
    }
}
