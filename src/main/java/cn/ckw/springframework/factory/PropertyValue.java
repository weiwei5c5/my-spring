package cn.ckw.springframework.factory;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName PropertyValue.java
 * @Description
 * @createTime 2022年12月24日 15:13:00
 */
public class PropertyValue {

    private final String name;

    private final Object value;


    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
