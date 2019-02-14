package com.lilingyan;

import lombok.Data;
import java.io.Serializable;

/**
 *  类名必须与java.lang.invoke.SerializedLambda一致
 * @Author: lilingyan
 * @Date 2019/2/14 11:13
 */
@Data
public class SerializedLambda implements Serializable {

    //serialVersionUID必须与java.lang.invoke.SerializedLambda一致
    private static final long serialVersionUID = 8025925345765570181L;

    //属性必须与java.lang.invoke.SerializedLambda一致
    private Class<?> capturingClass;
    private String functionalInterfaceClass;
    private String functionalInterfaceMethodName;
    private String functionalInterfaceMethodSignature;
    private String implClass;
    private String implMethodName;
    private String implMethodSignature;
    private int implMethodKind;
    private String instantiatedMethodType;
    private Object[] capturedArgs;

}
