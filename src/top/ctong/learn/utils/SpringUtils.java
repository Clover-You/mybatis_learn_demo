package top.ctong.learn.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

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
 * Spring工具类
 * </p>
 * @author Clover
 * @version V1.0
 * @class SpringUtils
 * @create 2021-08-09 9:13 下午
 */
@Component
public class SpringUtils implements BeanFactory, ApplicationListener<ApplicationContextEvent> {

    /**
     * 容器
     */
    private static ApplicationContext applicationContext;

    @Override
    public Object getBean(String s) throws BeansException {
        return applicationContext.getBean(s);
    }

    @Override
    public <T> T getBean(String s, Class<T> aClass) throws BeansException {
        return applicationContext.getBean(s, aClass);
    }

    @Override
    public <T> T getBean(Class<T> aClass) throws BeansException {
        return applicationContext.getBean(aClass);
    }

    @Override
    public Object getBean(String s, Object... objects) throws BeansException {
        return applicationContext.getBean(s, objects);
    }

    @Override
    public boolean containsBean(String s) {
        return applicationContext.containsBean(s);
    }

    @Override
    public boolean isSingleton(String s) throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton(s);
    }

    @Override
    public boolean isPrototype(String s) throws NoSuchBeanDefinitionException {
        return applicationContext.isPrototype(s);
    }

    @Override
    public boolean isTypeMatch(String s, Class<?> aClass) throws NoSuchBeanDefinitionException {
        return applicationContext.isTypeMatch(s, aClass);
    }

    @Override
    public Class<?> getType(String s) throws NoSuchBeanDefinitionException {
        return applicationContext.getType(s);
    }

    @Override
    public String[] getAliases(String s) {
        return applicationContext.getAliases(s);
    }

    /**
     * 通过容器时间监听拿到容器
     * @param applicationContextEvent 容器事件
     */
    @Override
    public void onApplicationEvent(ApplicationContextEvent applicationContextEvent) {
        System.out.println("ApplicationListener");
        this.applicationContext = applicationContextEvent.getApplicationContext();
    }

}
