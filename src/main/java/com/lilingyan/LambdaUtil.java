package com.lilingyan;

import java.io.*;

/**
 * @Author: lilingyan
 * @Date 2019/2/14 11:17
 */
public class LambdaUtil {

    /**
     * 使用自己的类接收lambda对象的元数据
     * @param lambda
     * @return
     * @throws Exception
     */
    public static SerializedLambda resolve(MyFunction lambda) throws Exception {
        if (!lambda.getClass().isSynthetic()) {
            throw new Exception("该方法仅能传入 lambda 表达式产生的合成类");
        }
        try (ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(LambdaUtil.serialize(lambda))) {
            @Override
            protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                Class<?> clazz = super.resolveClass(objectStreamClass);
                return clazz == java.lang.invoke.SerializedLambda.class ? SerializedLambda.class : clazz;
            }
        }) {
            return (SerializedLambda) objIn.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new Exception("This is impossible to happen", e);
        }
    }

    private static byte[] serialize(Object object) {
        if (object == null) {
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            oos.flush();
        } catch (IOException ex) {
            throw new IllegalArgumentException("Failed to serialize object of type: " + object.getClass(), ex);
        }
        return baos.toByteArray();
    }

}
