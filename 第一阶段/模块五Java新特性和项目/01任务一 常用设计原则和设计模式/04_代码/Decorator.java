package com.lagou.task21;

public class Decorator implements Sourceable {
    private Sourceable source;

    public Decorator(Sourceable source) {
        this.source = source;
    }

    @Override
    public void method() {
        source.method(); // 保证原有功能不变
        System.out.println("化妆之后你会更美！");
    }
}
