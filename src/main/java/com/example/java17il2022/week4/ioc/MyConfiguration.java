package com.example.java17il2022.week4.ioc;

import com.example.java17il2022.week4.aop.JdkAOPInvocationHandler;
import com.example.java17il2022.week4.aop.ProxyMethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyConfiguration {

    @Autowired
    @Qualifier("aaa")
    private IOCBean iocBean;

    @Bean("myAOP")
    public IOCBean getMyAOP() {
        IOCBean myIOCA = (IOCBean) Proxy.newProxyInstance(
                MyIOCA.class.getClassLoader(),
                new Class[]{IOCBean.class},
                new JdkAOPInvocationHandler(iocBean, new MyIOCAAspect())
        );
        return myIOCA;
    }
}
