// WAP to view information about the person bean class using BeanInfo interface

import java.beans.BeanDescriptor;
import java.beans.Introspector;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;
import java.io.Serializable;

class persons implements Serializable {
    private String name;
    private int age;

    public persons() {}

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class personsBeanInfo extends SimpleBeanInfo {
    @Override
    public BeanDescriptor getBeanDescriptor() {
        return new BeanDescriptor(persons.class);
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor name = new PropertyDescriptor("name", persons.class);
            PropertyDescriptor age = new PropertyDescriptor("age", persons.class);
            return new PropertyDescriptor[] {name, age};
        } catch (IntrospectionException e) {
            System.out.println(e);
            return null;
        }
    }
}

class main {
    public static void main(String[] args) throws IntrospectionException {
        java.beans.BeanInfo info = Introspector.getBeanInfo(persons.class);
        BeanDescriptor descriptor = info.getBeanDescriptor();
        System.out.println("class name : " + descriptor.getName());

        PropertyDescriptor[] propertyDescriptors = info.getPropertyDescriptors();

        System.out.println("Properties: ");
        for (PropertyDescriptor prop : propertyDescriptors) {
            System.out.println("Property Name: " + prop.getName());
            System.out.println("Property Type: " + prop.getPropertyType());
            System.out.println("Read Method: " + prop.getReadMethod());
            System.out.println("Write Method: " + prop.getWriteMethod());
            System.out.println("-------------------------");
        }
    }
}
 