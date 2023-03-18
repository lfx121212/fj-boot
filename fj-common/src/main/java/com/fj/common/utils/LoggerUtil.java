package com.fj.common.utils;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * <p>
 * 日志工具类
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/19 0:21
 */
public class LoggerUtil {
    public static final Logger LOGGER = LogManager.getLogger("");
    private static String link = null;

    public LoggerUtil() {
    }

    public static void printInfo(int type, Object message, String errorCode, String remark) {
        StringBuilder strBuilder = new StringBuilder();
        if (null != message && !"".equals(message.toString().trim())) {
            strBuilder.append(message.toString().trim());
        }

        if (null != errorCode && !"".equals(errorCode.trim())) {
            strBuilder.append(errorCode.trim());
        }

        if (null != remark && !"".equals(remark.trim())) {
            strBuilder.append(remark.trim());
        }

        String str = "<----- " + strBuilder.toString() + " ----->\t " + link;
        switch (type) {
            case 1:
                LOGGER.info(str);
                break;
            case 2:
                LOGGER.error(str);
                break;
            case 3:
                LOGGER.debug(str);
                break;
            case 4:
                LOGGER.warn(str);
                break;
            case 5:
                LOGGER.fatal(str);
                break;
            case 6:
                LOGGER.trace(str);
                break;
            default:
                LOGGER.info(str);
        }

        link = null;
    }

    public static void printInfo(Object message) {
        getDebugInfo();
        printInfo(1, message);
    }

    public static void printErr(Object message) {
        getDebugInfo();
        printInfo(2, message);
    }

    public static void printErr(Object message, StackTraceElement[] lvStacks) {
        getDebugInfo(lvStacks);
        printInfo(2, message);
    }

    public static void printDebug(Object message) {
        getDebugInfo();
        printInfo(3, message);
    }

    public static void printWarning(Object message) {
        getDebugInfo();
        printInfo(4, message);
    }

    public static void printInfo(int type, Object message) {
        getDebugInfo();
        printInfo(type, message, (String)null);
    }

    public static void printInfo(int type, Object message, String errorCode) {
        getDebugInfo();
        printInfo(type, message, errorCode, (String)null);
    }

    private static String getDebugInfo(StackTraceElement[] lvStacks) {
        if (null == link) {
            link = lvStacks[0].toString();
        }

        return link;
    }

    private static String getDebugInfo() {
        StackTraceElement[] lvStacks = Thread.currentThread().getStackTrace();
        if (null == link) {
            link = lvStacks[3].toString();
        }

        return link;
    }

    private static Logger initLogger(Level Level) {
        return LOGGER;
    }
}
