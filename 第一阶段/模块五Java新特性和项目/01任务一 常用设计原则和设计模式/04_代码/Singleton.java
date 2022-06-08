package com.lagou.task21;

public class Singleton {

    // 2.声明本类类型的引用指向本类类型的对象并使用private static关键字修饰
    private static Singleton sin = null;

    // 1.私有化构造方法，使用private关键字修饰
    private Singleton() {}

    // 3.提供公有的get方法负责将上述对象返回出去，使用public static关键字修饰
    public static /*synchronized*/ Singleton getInstance() {
        /*synchronized (Singleton.class) {
            if (null == sin) {
                sin = new Singleton();
            }
            return sin;
        }*/
        if (null == sin) {
            synchronized (Singleton.class) {
                if (null == sin) {
                    sin = new Singleton();
                }
            }
        }
        return sin;
    }
}
