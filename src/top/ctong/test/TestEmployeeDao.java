package top.ctong.test;

import lombok.extern.log4j.Log4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import top.ctong.learn.dao.EmployeeDao;
import top.ctong.learn.domain.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
 * @class TestEmployeeDao
 * @create 2021-08-09 8:20 下午
 */
@Log4j
public class TestEmployeeDao {

    private SqlSessionFactory sqlSessionFactory;

    /**
     * MyBatis配置文件路径
     */
    private static final String MYBATIS_CONFIG_PATH = "mybatis-config.xml";

    /**
     * 初始化SqlSessionFactory
     */
    @Before
    public void initMyBatis() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    /**
     * 测试查询接口
     */
    @Test
    public void testQuery() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            Employee param = new Employee();
            param.setEmpName("Clover");
            List<Employee> query = mapper.queryAll(param);
            log.info(query);
        }
    }

    @Test
    public void testQueryEmployeeByIds() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            List<Integer> ids = new ArrayList<>();
            //            ids.add(1);
            //            ids.add(3);
            //            ids.add(5);
            //            ids.add(7);
            List<Employee> employees = mapper.queryEmployeeByIds(ids);
            log.info(employees);
        }
    }

    @Test
    public void testQueryEmpByIdsUseChoose() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            Employee emp = new Employee();
            short gender = 1;
            emp.setGender(gender);
            List<Employee> emps = mapper.queryEmpByIdsUseChoose(emp);
            log.info(emps);
        }
    }

    @Test
    public void testUpdate() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            Employee emp = new Employee();
            emp.setId(1);
            emp.setEmpName("Clover You");
            mapper.update(emp);
        }
    }

    @Test
    public void testQueryEmpSql() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            sqlSession.clearCache();
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = mapper.queryInCache(1);
            log.info(employee);
            log.info("------------ 分割线 ------------");
            Employee employee2 = mapper.queryInCache(1);
            log.info(employee2);
            log.info("------------ 分割线: 判断是否是同一个对象 ------------");
            log.info("判断结果：" + (employee == employee2));
        }
    }

}
