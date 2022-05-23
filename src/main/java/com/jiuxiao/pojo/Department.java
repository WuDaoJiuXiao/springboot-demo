package com.jiuxiao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门实体类
 *
 * @author: WuDaoJiuXiao
 * @Date: 2022/05/22 09:05
 * @since: 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Integer departmentId;
    private String departmentName;
}