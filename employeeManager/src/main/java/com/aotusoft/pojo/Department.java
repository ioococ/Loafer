package com.aotusoft.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//部门表
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
    private Integer id;
    private String departmentName;
}
