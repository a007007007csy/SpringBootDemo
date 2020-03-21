//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.springbootdemo.demo03.entities;

public class Department {
    private Integer id;
    private String departmentName;

    public Department() {
    }

    public Department(int i, String string) {
        this.id = i;
        this.departmentName = string;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String toString() {
        return "Department [id=" + this.id + ", departmentName=" + this.departmentName + "]";
    }
}
