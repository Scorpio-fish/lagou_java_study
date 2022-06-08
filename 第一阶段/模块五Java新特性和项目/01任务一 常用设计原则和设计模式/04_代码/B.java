package com.lagou.task21;

public class B/* extends A*/ {
    private A a;  // 合成复用原则

    public B(A a) {
        this.a = a;
    }

    public void test() {
        // 调用A类中的show方法，请问如何实现？
        a.show();
    }
}
