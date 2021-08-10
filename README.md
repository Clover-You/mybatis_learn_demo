# 依赖

```
com.springsource.net.sf.cglib-2.2.0.jar
com.springsource.org.aopalliance-1.0.0.jar
com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
commons-logging-1.1.3.jar
hamcrest-core-1.3.jar
junit-4.13.1.jar
log4j-api-2.14.1.jar
log4j-core-2.14.1.jar
lombok-1.18.20.jar
mybatis-3.5.7.jar
mysql-connector-java-8.0.21.jar
slf4j-api-1.7.30.jar
spring-aop-4.0.0.RELEASE.jar
spring-aspects-4.0.0.RELEASE.jar
spring-beans-4.0.0.RELEASE.jar
spring-context-4.0.0.RELEASE.jar
spring-core-4.0.0.RELEASE.jar
spring-expression-4.0.0.RELEASE.jar
spring-test-4.0.0.RELEASE.jar
spring-web-4.0.0.RELEASE.jar
spring-webmvc-4.0.0.RELEASE.jar
```

# SpringMVC 整合MyBatis
这个整合不是通过官方提供的中间件，而是自己手撸的，源码在`top.ctong.learn.utils.WithMyBatis`

原理很简单，就是通过后置处理器`BeanFactoryPostProcessor`获取spring容器，然后扫描指定包，拿到所有mapper将其注册到容器
```java
sqlSession.getMapper(class);
configurableListableBeanFactory.registerSingleton(class.getName(), mapper);
```

注册的Bean是单例的，可能会有问题