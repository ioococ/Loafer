package cn.mybatis.mapper;

public interface Mapper {
    int existTable();
    void dropTable();
    void createTable();
}
