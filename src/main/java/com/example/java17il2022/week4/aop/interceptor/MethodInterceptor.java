package com.example.java17il2022.week4.aop.interceptor;


import com.example.java17il2022.week4.aop.MethodInvocation;

public interface MethodInterceptor {
    Object invoke(MethodInvocation mi) throws Throwable;
}
