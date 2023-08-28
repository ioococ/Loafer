package moe.nekotako;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: nekotako
 * @Date: 2023/8/28 16:42
 */
public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("moe.nekotako.BuyClothes");
//        clazz = Main.class;
        Object instance = clazz.newInstance();
        Method singleThreadMethod = clazz.getDeclaredMethod("singleThread");
        singleThreadMethod.invoke(instance);
    }
}
