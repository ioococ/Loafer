package cn.mybatis.pojo;


import java.time.LocalDate;
import java.time.LocalTime;

public class Spxsb {

  private long id;
  private String name;
  private double price;
  private LocalDate createDate;
  private LocalTime createTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public LocalDate getCreateDate() {
    return createDate;
  }

  public void setCreateDate(LocalDate createDate) {
    this.createDate = createDate;
  }


  public LocalTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalTime createTime) {
    this.createTime = createTime;
  }

}
