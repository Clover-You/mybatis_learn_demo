package top.ctong.test;

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
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        Employee param = new Employee();
        param.setId(8);
        Employee query = mapper.query(param);
//        Employee query = mapper.query(8);
        System.out.println(query.toString());
    }

}
