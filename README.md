# 动态获取类中的字段名
平时开发时，经常需要使用到Bean类中的字段名字。  
比如在mybatis开发时，用到的字段就是Bean类字段的下划线格式。  

这个项目可以从Bean类的get等方法中，动态获取对应字段名，  
从而使代码在改变字段后，不会出现因为写死字段名而出现的未知bug。  

ep:
```java
    public class TestBean {
        private String name;
        public String getName() {
            return name;
        }
    }
    
    //晋国执行
    String field = Field2StringUtil.field2String(TestBean::getName);
    
    //返回
    field == "name"
```

*技术参考于@mybatisPlus*