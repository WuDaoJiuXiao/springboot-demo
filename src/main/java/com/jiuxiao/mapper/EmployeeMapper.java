package com.jiuxiao.mapper;

import com.jiuxiao.pojo.Department;
import com.jiuxiao.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * 员工数据库层
 *
 * @author: WuDaoJiuXiao
 * @Date: 2022/05/22 09:24
 * @since: 1.0.0
 */
@Repository
public class EmployeeMapper {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentMapper departmentMapper;

    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "梦情", "123@qq.com", 0, new Department(101, "市场部"), new Date(1997 - 1900, Calendar.NOVEMBER, 26)));
        employees.put(1002, new Employee(1002, "林枫", "752@qq.com", 1, new Department(102, "运营部"), new Date(1994 - 1900, Calendar.MAY, 3)));
        employees.put(1003, new Employee(1003, "荒天帝", "455@qq.com", 1, new Department(103, "采购部"), new Date(2001 - 1900, Calendar.JANUARY, 14)));
        employees.put(1004, new Employee(1004, "段欣叶", "454@qq.com", 0, new Department(104, "后勤部"), new Date(1986 - 1900, Calendar.DECEMBER, 10)));
        employees.put(1005, new Employee(1005, "段无道", "525@qq.com", 1, new Department(105, "财务部"), new Date(1999 - 1900, Calendar.AUGUST, 7)));
    }

    //主键自增
    private Integer initId = 1006;

    //增加员工信息
    public void addEmployee(Employee employee){
        employee.setId(initId++);
        employee.setDepartment(departmentMapper.getDepartmentById(employee.getDepartment().getDepartmentId()));
        employee.setBirthday(employee.getBirthday());
        employees.put(employee.getId(), employee);
    }

    //根据 id 删除员工信息
    public void deleteEmployeeById(Integer id){
        employees.remove(id);
    }

    //根据 id 修改员工信息
    public void updateEmployeeById(Employee employee){
        employee.setDepartment(departmentMapper.getDepartmentById(employee.getDepartment().getDepartmentId()));
        employee.setBirthday(employee.getBirthday());
        employees.put(employee.getId(), employee);
    }

    //查询所有员工信息
    public Collection<Employee> getAllEmployees(){
        return employees.values();
    }

    //根据 id 查询员工信息
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
}