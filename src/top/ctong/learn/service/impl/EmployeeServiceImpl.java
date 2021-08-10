package top.ctong.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ctong.learn.dao.EmployeeDao;
import top.ctong.learn.domain.Employee;
import top.ctong.learn.service.EmployeeService;

import java.io.Serializable;
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
 * @class EmployeeServiceImpl
 * @create 2021-08-10 10:00 上午
 */
@Service
public class EmployeeServiceImpl implements Serializable, EmployeeService {

    private static final long serialVersionUID = 1863674392751816610L;

    @Autowired
    private EmployeeDao employeeDao;

    /**
     * 新增
     * @param dao 新增的对象
     * @return 受影响行数
     */
    @Override
    public int insert(Employee dao) {
        return 0;
    }

    /**
     * 修改指定dao层
     * @param dao 修改后的dao层信息
     * @return 受影响行数
     */
    @Override
    public int update(Employee dao) {
        return 0;
    }

    /**
     * 通过id删除指定对象
     * @param id 删除的对象id
     * @return 受影响行数
     */
    @Override
    public int delete(Integer id) {
        //        return employeeDao.delete(id);
        return 0;
    }

    /**
     * 通过id查询一个对象
     * @param id 对象id
     * @return 通过id查询结果
     */
    @Override
    public Employee query(Integer id) {
        return new Employee();
    }

    /**
     * 通过dao层条件删除
     * @param dao dao层对象
     * @return 受影响行数
     */
    @Override
    public int delete(Employee dao) {
        return 0;
    }

    /**
     * 通过一个dao层对象条件查询一个对象
     * @param dao dao层对象
     * @return 通过dao层对象查询结果
     */
    @Override
    public Employee query(Employee dao) {
        return new Employee();
    }

    /**
     * 查询所有<T>数据
     * @return <T> 数据查询结果
     */
    @Override
    public List<Employee> queryAll() {
        return null;
    }

    /**
     * 通过一个dao层信息查询所有与其相关的数据
     * @param dao dao层信息
     * @return 通过dao层查询结果集
     */
    @Override
    public List<Employee> queryAll(Employee dao) {
        return null;
    }

}
