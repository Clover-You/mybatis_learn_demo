package top.ctong.learn.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.ctong.learn.domain.Employee;

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
 * Employee 持久层
 * </p>
 * @author Clover
 * @version V1.0
 * @class EmployeeDao
 * @create 2021-08-09 4:43 下午
 */
@Mapper
public interface EmployeeDao extends GenericDao<Employee> {

    /**
     * 通过员工名和员工id查询员工信息
     * @param empName 员工名
     * @param id 员工id
     * @return 员工详细信息
     */
    Employee queryByNameAndId(@Param("empName") String empName, @Param("id") Integer id);

    /**
     * 通过id列表查询指定员工
     * @param ids 员工id列表
     * @return 员工信息
     */
    List<Employee> queryEmployeeByIds(@Param("ids") List<Integer> ids);

    /**
     * 通过id列表查询指定员工，使用choose
     * @param emp 参数信息
     * @return 员工信息
     */
    List<Employee> queryEmpByIdsUseChoose(@Param("emp") Employee emp);

    /**
     * 从缓存中获取数据
     * @param id 员工id
     * @return 员工信息
     */
    Employee queryInCache(@Param("id") Integer id);
}
