package vip.dengwj2.utils;

public class StringUtil {
    private StringUtil() {}

    public static String getSetterMethodNameByFieldName(String fieldName) {
        return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }
}
