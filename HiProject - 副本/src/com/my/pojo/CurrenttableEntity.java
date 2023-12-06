package com.my.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "currenttable", schema = "manager", catalog = "")
public class CurrenttableEntity {
    private int id;
    private String bh;
    private String name;
    private Integer num;

    public CurrenttableEntity(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bh")
    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
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
    @Column(name = "num")
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrenttableEntity that = (CurrenttableEntity) o;
        return id == that.id && Objects.equals(bh, that.bh) && Objects.equals(name, that.name) && Objects.equals(num, that.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bh, name, num);
    }
}
