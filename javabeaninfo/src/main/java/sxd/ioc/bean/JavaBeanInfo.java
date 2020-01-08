package sxd.ioc.bean;

import java.beans.*;
import java.net.URL;
import java.util.stream.Stream;

/**
 * @program java-bean-info
 * @description: 获取javaBean的信息
 * @author: sonny
 * @create: 2019/12/27 20:53
 */
public class JavaBeanInfo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(
                property -> {
                    System.out.println(property);
                }
        );

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(
                propertyDescriptor -> {
                    propertyDescriptor.setPropertyEditorClass(StringToInteger.class);
                    System.out.println(propertyDescriptor.getName());
                    System.out.println(propertyDescriptor.getPropertyEditorClass().getName());
                }
        );
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(
                property -> {
                    System.out.println(property);
                }
        );



    }

    static class StringToInteger extends PropertyEditorSupport {
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }

}
