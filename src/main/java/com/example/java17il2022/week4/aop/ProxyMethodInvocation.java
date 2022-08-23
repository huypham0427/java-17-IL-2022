package com.example.java17il2022.week4.aop;

import com.example.java17il2022.week4.aop.interceptor.MethodInterceptor;

import java.lang.reflect.Method;
import java.util.List;

public class ProxyMethodInvocation implements MethodInvocation{

    private List<MethodInterceptor> interceptors;
    private int idx;
    private Object originObj;
    private Method originMethod;
    private Object[] args;

    public ProxyMethodInvocation(List<MethodInterceptor> interceptors, Object originObj, Method originMethod, Object[] args) {
        this.interceptors = interceptors;
        this.originObj = originObj;
        this.originMethod = originMethod;
        this.args = args;
    }

    @Override
    public Object proceed() throws Throwable{
        if(idx >= interceptors.size()) {
            return executeOriginalMethod();
        }
        MethodInterceptor interceptor = interceptors.get(idx++);
        return interceptor.invoke(this);
    }

    private Object executeOriginalMethod() throws Throwable{
        originMethod.setAccessible(true);
        return originMethod.invoke(originObj, args);
    }
}
/**
 *  [before, after, before, after,   around]
 *                                   idx
 *
 *    before
 *      print  "this is first before"
 *      return  after
 *  *              Object result = mi.proceed();
 *  *                              before
 *  *                                  print "this is 2nd before"
 *  *                                  return after
 *  *                                          Object result = mi.proceed();
 *  *                                                          return real original function
 *  *                                          print "this is after"
 *  *                                          return result
 *  *              print "this is 1st after"
 *  *              return result;
 */