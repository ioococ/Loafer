package com.my.pojo;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Customer {
  private int id;
  private String name;
  private String address;
  private Set<Orders> orders;

  public Set<Orders> getOrders() {
    return orders;
  }

  public void setOrders(Set<Orders> orders) {
    this.orders = orders;
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
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer that = (Customer) o;
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(address, that.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, address);
  }
}
