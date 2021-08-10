package top.ctong.learn.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import top.ctong.learn.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

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
 * @class User
 * @create 2021-08-09 10:00 上午
 */
@Data
@Repository
public class User implements Serializable {

    public static final User initUser() {
        User user = new User();
        user.setUserName("Clover");
        user.setAge(19);
        user.setSex("男");
        String birthday = "2002-04-13";
        user.setBirthday(DateUtils.string2Date(birthday, DateUtils.YYYY_MM_DD));
        return user;
    }

    private static final long serialVersionUID = 9047138840549222608L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"userName\":\"").append(userName).append('\"');
        sb.append(",\"age\":").append(age);
        sb.append(",\"sex\":\"").append(sex).append('\"');
        sb.append(",\"birthday\":\"").append(birthday).append('\"');
        sb.append('}');
        return sb.toString();
    }

}
