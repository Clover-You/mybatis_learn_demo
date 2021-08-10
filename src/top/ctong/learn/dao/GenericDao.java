package top.ctong.learn.dao;

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
 * 进一步封装BaseDao...BaseDao Plus
 * </p>
 * @author Clover
 * @version V1.0
 * @class GenericDao
 * @create 2021-08-09 10:13 上午
 */
public interface GenericDao<T> extends BaseDao<T> {

    /**
     * 通过dao层条件删除
     * @param dao dao层对象
     * @return 受影响行数
     */
    int delete(T dao);


    /**
     * 通过一个dao层对象条件查询一个对象
     * @param dao dao层对象
     * @return 通过dao层对象查询结果
     */
    T query(T dao);

    /**
     * 查询所有<T>数据
     * @return <T> 数据查询结果
     */
    List<T> queryAll();

    /**
     * 通过一个dao层信息查询所有与其相关的数据
     * @param dao dao层信息
     * @return 通过dao层查询结果集
     */
    List<T> queryAll(T dao);

}
