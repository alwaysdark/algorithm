package com.dark;

/**************************************
 * Copyright (C), Navinfo
 * Package: 
 * @Author: lifan
 * @Date: Created in 2021/3/11 16:21
 * @Description:
 **************************************/
public abstract class TemplatePattern {

    //模板方法
    public final void templateMethod(){

        method1();
        method2();//勾子方法
        method3();//抽象方法
    }
    private void method1(){
        System.out.println("父类实现业务逻辑");
    }
    public void method2(){
        System.out.println("父类默认实现，子类可覆盖");
    }
    protected abstract void method3();//子类负责实现业务逻辑
}
