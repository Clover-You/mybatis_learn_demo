package top.ctong.learn.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.ctong.learn.utils.SpringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

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
 * MyBatis工厂
 * </p>
 * @author Clover
 * @version V1.0
 * @class MyBatisSqlSessionFactory
 * @create 2021-08-09 9:06 下午
 */
@Configuration
public class MyBatisSqlSessionFactory implements Serializable {

    private static final long serialVersionUID = 7157094465332447639L;

    /**
     * MyBatis配置文件路径
     */
    private static final String MYBATIS_CONFIG_PATH = "mybatis-config.xml";

    @Bean
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        System.out.println("getSqlSessionFactory");
        try (InputStream configStream = getConfigStream()) {
            return new SqlSessionFactoryBuilder().build(configStream);
        }
    }

    /**
     * 获取配置文件文件流
     * @return 文件流
     */
    public InputStream getConfigStream() throws IOException {
        return Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
    }

}
