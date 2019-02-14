package com.lilingyan;

/**
 * @Author: lilingyan
 * @Date 2019/2/14 13:11
 */
public class Field2StringUtil {

    public static <T>String field2String(MyFunction<T,Object> lambda) throws Exception {
        return StringUtils.getField(LambdaUtil.resolve(lambda));
    }

}
