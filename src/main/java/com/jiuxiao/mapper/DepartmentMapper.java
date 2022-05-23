package com.jiuxiao.mapper;

import com.jiuxiao.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 部门数据库层
 *
 * @author: WuDaoJiuXiao
 * @Date: 2022/05/22 09:11
 * @since: 1.0.0
 */
@Repository
public class DepartmentMapper {
    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "市场部"));
        departments.put(102, new Department(102, "运营部"));
        departments.put(103, new Department(103, "采购部"));
        departments.put(104, new Department(104, "后勤部"));
        departments.put(105, new Department(105, "财务部"));
    }

    //获取所有的部门
    public Collection<Department> getAllDepartments(){
        return departments.values();
    }

    //根据 id 获得部门
    public Department getDepartmentById(Integer departmentId){
        return departments.get(departmentId);
    }
}