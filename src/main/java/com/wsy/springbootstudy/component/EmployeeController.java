package com.wsy.springbootstudy.component;

import com.wsy.springbootstudy.dao.EmployeeDao;
import com.wsy.springbootstudy.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    //返回员工列表
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(){
        return"emp/add";
    }
}
