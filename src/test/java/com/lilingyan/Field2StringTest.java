package com.lilingyan;

import org.junit.Test;

/**
 * @Author: lilingyan
 * @Date 2019/2/14 11:20
 */
public class Field2StringTest {

    @Test
    public void field2String() throws Exception {
        //任意的方法
        String field = Field2StringUtil.field2String(String::valueOf);
        System.out.println(field);

        field = Field2StringUtil.field2String(TestBean::getName);
        System.out.println(field);

    }

}
