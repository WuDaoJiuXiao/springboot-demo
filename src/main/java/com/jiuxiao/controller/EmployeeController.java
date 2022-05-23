package com.jiuxiao.controller;

import com.jiuxiao.mapper.DepartmentMapper;
import com.jiuxiao.mapper.EmployeeMapper;
import com.jiuxiao.pojo.Department;
import com.jiuxiao.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 员工管理控制器
 *
 * @author: WuDaoJiuXiao
 * @Date: 2022/05/22 21:28
 * @since: 1.0.0
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 展示全部员工列表
     *
     * @param model
     * @return
     */
    @RequestMapping("/empList")
    public String employeeList(Model model) {
        Collection<Employee> employeeList = employeeMapper.getAllEmployees();
        model.addAttribute("empList", employeeList);
        return "employee/list";
    }

    /**
     * 跳转到增加用户页面
     *
     * @param model
     * @return
     */
    @GetMapping("/addEmp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentMapper.getAllDepartments();
        model.addAttribute("departments", departments);
        return "employee/add";
    }

    /**
     * 增加用户
     *
     * @param employee
     * @return
     */
    @PostMapping("/addEmp")
    public String addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
        return "redirect:/empList";
    }

    /**
     * 跳转到修改用户页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/updateEmp/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
        Employee emp = employeeMapper.getEmployeeById(id);
        model.addAttribute("emp", emp);
        Collection<Department> departments = departmentMapper.getAllDepartments();
        model.addAttribute("departments", departments);
        return "employee/update";
    }

    /**
     * 修改用户
     *
     * @param employee
     * @return
     */
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeMapper.updateEmployeeById(employee);
        return "redirect:/empList";
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeMapper.deleteEmployeeById(id);
        return "redirect:/empList";
    }
}