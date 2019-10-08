package cn.liuyiyou.shop.config;

/**
 * Application constants.
 */
public final class Constants {

    // Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_.@A-Za-z0-9-]*$";
    
    public static final String SYSTEM_ACCOUNT = "system";
    public static final String DEFAULT_LANGUAGE = "zh-cn";
    public static final String ANONYMOUS_USER = "anonymoususer";

    public static final String OSS_URL = "https://oss.liuyiyou.com/";

    private Constants() {
    }
}
