package com.tledu.mvn_27.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Mr.Wang
 * @date 23-6-25
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String studentName;
    private Integer studentAge;
    private String studentSex;

}
