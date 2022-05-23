package com.jiuxiao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 员工实体类
 *
 * @author: WuDaoJiuXiao
 * @Date: 2022/05/22 09:05
 * @since: 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Integer gender;     //女：0  男：1
    private Department department;
    private Date birthday;
}