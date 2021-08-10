package top.ctong.learn.utils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * 日期工具类
 * </p>
 * @author Clover
 * @version V1.0
 * @class DateUtils
 * @create 2021-08-09 10:30 上午
 */
public class DateUtils {

    private DateUtils() {
        // 工具类，不允许初始化
    }

    /**
     * 年月日格式
     */
    public static final String YYYY_MM_DD = "YYYY-MM-DD";

    /**
     * 字符串转日期格式
     * @param da 日期字符串
     * @param pattern 目标格式
     * @return 日期对象
     */
    public static final Date string2Date(String da, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(da);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
