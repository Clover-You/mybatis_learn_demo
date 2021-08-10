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
        try {
            // 获取指定包下所有class
            List<Class<?>> allClass = getClassByPackage(mapperPackage);
            // 通过@Mapper过滤无效class
            List<Class<?>> interfaceByWithMyBatis = getInterfaceByMapper(allClass);
            registerMyBatis(interfaceByWithMyBatis);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
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
    private List<Class<?>> getClassByPackage(String packageName) throws IOException, ClassNotFoundException {

        String path = packageName.replace(".", "/");
        String completePath = Thread.currentThread().getContextClassLoader().getResource("/" + path).toString()
                                    .replaceFirst("file:", "");
        File file = new File(completePath);
        List<Class<?>> clazz = new ArrayList<>();
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files == null) return clazz;
            for (File value : files) {
                if (value.isDirectory()) {
                    clazz.addAll(getClassByPackage(packageName + "." + value.getName()));
                }
                if (value.isFile()) {
                    String fileName = packageName + '.' + value.getName();
                    if (fileName.endsWith(".class")) {
                        fileName = fileName.substring(0, fileName.length() - 6);
                    }

                    Class<?> targetClass = getClass(fileName);

                    if (targetClass == null) continue;
                    clazz.add(targetClass);
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
     * mybatis
     */
    public interface RegisterMyBatisFactory {

        String getPackage();

    }

}
