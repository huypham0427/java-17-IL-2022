package com.example.java17il2022.week4.ioc;

import com.example.java17il2022.week4.aop.MethodInvocation;
import com.example.java17il2022.week4.aop.advice.After;
import com.example.java17il2022.week4.aop.advice.Around;
import com.example.java17il2022.week4.aop.advice.Before;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyIOCAAspect {
    @Before
    public void before1() {
        System.out.println("this is 1st before");
    }

    @After
    public void after1() {
        System.out.println("this is 1st after");
    }

    @Before
    public void before2() {
        System.out.println("this is 2nd before");
    }

    @After
    public void after2() {
        System.out.println("this is 2nd after");
    }

    @Around
    public Object around1(MethodInvocation mi) throws Throwable{
        System.out.println("this is 1st before around");
        Object result = mi.proceed();
        System.out.println("this is 1st after around");
        return result;
    }

    @Around
    public Object around2(MethodInvocation mi) throws Throwable{
        System.out.println("this is 2nd before around");
        Object result = mi.proceed();
        System.out.println("this is 2nd after around");
        return result;
    }

}
