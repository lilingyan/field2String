package com.lilingyan;

/**
 * @Author: lilingyan
 * @Date 2019/2/14 11:25
 */
public class StringUtils {

    /**
     * 空字符
     */
    public static final String EMPTY = "";
    /**
     * 字符串 is
     */
    public static final String IS = "is";
    /**
     * 字符串 get
     */
    public static final String GET = "get";

    public static String getField(SerializedLambda lambda) {
        String fieldName = StringUtils.resolveFieldName(lambda.getImplMethodName());
        return fieldName;
    }

    private static String resolveFieldName(String getMethodName) {
        if (getMethodName.startsWith(GET)) {
            getMethodName = getMethodName.substring(3);
        } else if (getMethodName.startsWith(IS)) {
            getMethodName = getMethodName.substring(2);
        }
        // 小写第一个字母
        return StringUtils.firstToLowerCase(getMethodName);
    }

    private static String firstToLowerCase(String param) {
        if (isEmpty(param)) {
            return EMPTY;
        }
        return param.substring(0, 1).toLowerCase() + param.substring(1);
    }

    private static boolean isEmpty(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
