package cn.ckw.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName PropertyValues.java
 * @Description
 * @createTime 2022年12月24日 15:13:00
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv){
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    private PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue pv : propertyValueList){
            if (pv.getName().equals(propertyName)){
                return pv;
            }
        }
        return null;
    }
}
