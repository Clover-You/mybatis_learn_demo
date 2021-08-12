package top.ctong.learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.ctong.learn.domain.Employee;
import top.ctong.learn.service.EmployeeService;

import java.util.List;

/**
 * █████▒█      ██  ▄████▄   ██ ▄█▀     ██████╗ ██╗   ██╗ ██████╗
 * ▓██   ▒ ██  ▓██▒▒██▀ ▀█   ██▄█▒      ██╔══██╗██║   ██║██╔════╝
 * ▒████ ░▓██  ▒██░▒▓█    ▄ ▓███▄░      ██████╔╝██║   ██║██║  ███╗
 * ░▓█▒  ░▓▓█  ░██░▒▓▓▄ ▄██▒▓██ █▄      ██╔══██╗██║   ██║██║   ██║
 * ░▒█░   ▒▒█████▓ ▒ ▓███▀ ░▒██▒ █▄     ██████╔╝╚██████╔╝╚██████╔╝
 * ▒ ░   ░▒▓▒ ▒ ▒ ░ ░▒ ▒  ░▒ ▒▒ ▓▒     ╚═════╝  ╚═════╝  ╚═════╝
 * ░     ░░▒░ ░ ░   ░  ▒   ░ ░▒ ▒░
 * ░ ░    ░░░ ░ ░ ░        ░ ░░ ░
 * ░     ░ ░      ░  ░
 * Copyright 2021 Clover.
 * <p>
 *
 * </p>
 * @author Clover
 * @version V1.0
 * @class EmployeeController
 * @create 2021-08-10 10:01 上午
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/{id}")
    @ResponseBody
    public String queryEmployee(@PathVariable Integer id) {
        try {
            Assert.notNull(id, "员工id不能为空");
            Employee query = employeeService.query(id);
            return query.toString();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "系统异常";
        }
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insert(Employee employee) {
        int insertResult = employeeService.insert(employee);
        return String.valueOf(insertResult);
    }

    @RequestMapping(value = "/insertReturnKey", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8;")
    @ResponseBody
    public String insertReturnKey(Employee employee) {
        // 新增employee
        employeeService.insertReturnKey(employee);
        return employee.toString();
    }

    @RequestMapping("/queryByNameAndId")
    @ResponseBody
    public String queryByNameAndId(String name, Integer id) {
        Employee result = employeeService.queryByNameAndId(name, id);
        return result.toString();
    }

    @RequestMapping(value = "/queryAll", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8;")
    @ResponseBody
    public String queryAll() {
        List<Employee> employees = employeeService.queryAll();
        return employees.toString();
    }

}
