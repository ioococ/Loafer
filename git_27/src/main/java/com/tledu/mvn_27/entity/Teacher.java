package com.tledu.mvn_27.entity;

import lombok.*;

import java.util.Date;

/**
 * @author Mr.Wang
 * @date 23-6-26
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {
    private String name;
    private Integer age;
    private String sex;
    private String phone;
    private String constellation;
    private Integer idCard;
    private Date birthday;
}
