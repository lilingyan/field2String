package com.lilingyan;

import java.io.Serializable;
import java.util.function.Function;

/**
 * 任意实现Serializable的@FunctionalInterface接口
 * @Author: lilingyan
 * @Date 2019/2/14 10:51
 */
public interface MyFunction<T,R> extends Function<T,R>, Serializable {
}
