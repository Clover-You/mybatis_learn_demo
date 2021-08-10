package top.ctong.learn.dao;

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
 * Dao层基类
 * </p>
 * @author Clover
 * @version V1.0
 * @class BaseDao
 * @create 2021-08-09 9:58 上午
 */
public interface BaseDao<T> {

    /**
     * 新增
     * @param dao 新增的对象
     * @return 受影响行数
     */
    int insert(T dao);

    /**
     * 修改指定dao层
     * @param dao 修改后的dao层信息
     * @return 受影响行数
     */
    int update(T dao);

    /**
     * 通过id删除指定对象
     * @param id 删除的对象id
     * @return 受影响行数
     */
    int delete(Integer id);

    /**
     * 通过id查询一个对象
     * @param id 对象id
     * @return 通过id查询结果
     */
    T query(Integer id);

}
