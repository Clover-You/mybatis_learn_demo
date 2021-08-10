package top.ctong.learn.utils;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

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
 * 整合Spring、MyBatis
 * </p>
 * @author Clover
 * @version V1.0
 * @class Test
 * @create 2021-08-10 10:48 上午
 */
@Configuration
public class WithMyBatis implements BeanFactoryPostProcessor {

    private SqlSessionFactory factory;

    private ConfigurableListableBeanFactory configurableListableBeanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
            throws BeansException {
        this.configurableListableBeanFactory = configurableListableBeanFactory;
        if (factory == null) {
            factory = configurableListableBeanFactory.getBean(SqlSessionFactory.class);
        }
        RegisterMyBatisFactory registerMyBatisFactory = configurableListableBeanFactory.getBean(
                RegisterMyBatisFactory.class);

        if (registerMyBatisFactory == null) return;
        String mapperPackage = registerMyBatisFactory.getPackage();
        // 获取指定包下所有class
        List<Class<?>> allClass = getClassByPackage(mapperPackage);
        // 通过@Mapper过滤无效class
        List<Class<?>> interfaceByWithMyBatis = getInterfaceByMapper(allClass);
        // 将所有Mapper注册到IOC中
        registerMyBatis(interfaceByWithMyBatis);
    }

    /**
     * 将MyBatis注册到IOC
     */
    private void registerMyBatis(List<Class<?>> mappers) {
        mappers.forEach(clazz -> {
            SqlSession sqlSession = factory.openSession();
            Object mapper = sqlSession.getMapper(clazz);
            configurableListableBeanFactory.registerSingleton(clazz.getName(), mapper);
        });
    }

    /**
     * 通过指定注解获取接口
     * @return 过滤结果
     */
    private List<Class<?>> getInterfaceByMapper(List<Class<?>> clazz) {
        return clazz.stream().filter(aClass -> {
            if (!aClass.isInterface()) return false;
            Mapper annotation = aClass.getAnnotation(Mapper.class);
            return annotation != null;
        }).collect(Collectors.toList());
    }

    /**
     * 通过包名获取所有类
     * @return 检索结果
     */
    private List<Class<?>> getClassByPackage(String packageName) {
        String path = packageName.replace(".", "/");
        // 获取指定包完整路径
        String completePath = Thread.currentThread().getContextClassLoader().getResource("/" + path).toString()
                                    .replaceFirst("file:", "");
        File file = new File(completePath);
        List<Class<?>> clazz = new ArrayList<>();
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files == null) return clazz;
            for (File target : files) {
                if (target.isDirectory()) {
                    // 如果是文件夹，那么递归它
                    clazz.addAll(getClassByPackage(packageName + "." + target.getName()));
                }

                if (target.isFile()) {
                    String fileName = packageName + '.' + target.getName();
                    if (fileName.endsWith(".class")) {
                        fileName = fileName.substring(0, fileName.length() - 6);
                        // 通过类加载器去加载它
                        Class<?> targetClass = getClass(fileName);

                        if (targetClass == null) continue;
                        clazz.add(targetClass);
                    }
                }
            }
        }
        return clazz;
    }

    /**
     * 通过类名加载类
     * @param className 类名
     * @return 类
     */
    private Class<?> getClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /**
     * mybatis，将其注册在容器中，整合器就可以获取到指定包名
     */
    public interface RegisterMyBatisFactory {

        /**
         * 获取mapper所在的包
         */
        String getPackage();

    }

}
