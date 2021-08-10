package top.ctong.learn.domain;

import lombok.Data;

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
 * 员工表
 * </p>
 * @author Clover
 * @version V1.0
 * @class Employee
 * @create 2021-08-09 4:41 下午
 */
@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = -6915954877566070374L;

    /**
     * id
     */
    private Integer id;

    /**
     * 员工名
     */
    private String empName;

    /**
     * 性别
     */
    private Short gender;

    /**
     * 邮箱
     */
    private String email;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":").append(id);
        sb.append(",\"empName\":\"").append(empName).append('\"');
        sb.append(",\"gender\":").append(gender);
        sb.append(",\"email\":\"").append(email).append('\"');
        sb.append('}');
        return sb.toString();
    }

}
