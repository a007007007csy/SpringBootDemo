//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.springbootdemo.demo03.controller;

import com.springbootdemo.demo03.dao.DepartmentDao;
import com.springbootdemo.demo03.dao.EmployeeDao;
import com.springbootdemo.demo03.entities.Department;
import com.springbootdemo.demo03.entities.Employee;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping({"/emps"})
    public String list(Model model) {
        Collection<Employee> employees = this.employeeDao.getAll();
        model.addAttribute("emps", employees);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping({"/emp"})
    public String toAddPage(Model model) {
        Collection<Department> departments = this.departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；
    // 要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping({"/emp"})
    public String addEmp(Employee employee) {
        this.employeeDao.save(employee);
        return "redirect:/emps";
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping({"/emp/{id}"})
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = this.employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = this.departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "emp/add";
    }

    //员工修改；需要提交员工id；
    @PutMapping({"/emp"})
    public String updateEmployee(Employee employee) {
        this.employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping({"/emp/{id}"})
    public String deleteEmployee(@PathVariable("id") Integer id) {
        this.employeeDao.delete(id);
        return "redirect:/emps";
    }
}
