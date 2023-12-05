package cn.manager.service;

import java.util.List;

public interface Mapper {
    int existTable();

    void createTable(String tableName);

    void insertInfo(String name, float price);

//    List<Productinfo> Query(float price);
}

