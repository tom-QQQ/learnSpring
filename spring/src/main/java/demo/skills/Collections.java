package demo.skills;

import java.lang.reflect.Method;
import java.util.*;

/**
 * 集合相关的技巧
 * @author Ning
 * @date Create in 2019/1/7
 */
public class Collections {

    /**
     * 在泛型为String的集合中添加Integer类型数据
     * 泛型仅在编译时有效, 由于JVM的泛型擦除机制, 运行时没有泛型信息, 因此可以使用反射将不同于指定泛型的数据插入到集合中
     * @throws Exception NoSuchMethodException
     */
    public static void stringTypeAddInteger() throws Exception {

        List<String> list = new ArrayList<>();
        list.add("String");

        Class c = list.getClass();
        Method listAdd = c.getMethod("add", Object.class);

        listAdd.invoke(list, 20);
        System.out.println(list);

    }

    public static void main(String[] args) {

    }
}
