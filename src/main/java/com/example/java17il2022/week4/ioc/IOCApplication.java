package com.example.java17il2022.week4.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *  SOLID :
 *      Single Responsibility
 *      Open close
 *      Liskov substitution
 *      Interface segregation
 *      Dependency inversion
 *
 *  Spring: IOC, AOP
 *  IOC: inversion of control
 *          class A {
 *              private B b;
 *
 *              public void get() {
 *                  b.print();
 *              }
 *          }
 *
 *          class C {
 *              private B b;
 *          }
 *
 *          class B {
 *
 *          }
 *  Dependency Injection
 *      1. IOC container: Application Context(Map + Factory)
 *      2. class level: @Component / @Service / @Repository / @Controller
 *        method level: @Bean
 *      3. @Autowired
 *          (field injection) / constructor injection / setter injection
 *          by type vs by name(@Qualifier, reference name)
 *      4. bean scope: singleton(default) / prototype / request / session / global session
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   AOP
 *
 *   @Aspect
 *   class MyAspect {
 *      @Before
 *      @PointCut("location")
 *      public void executeBefore1() {
 *          System.out.println("this is 1st before logic");
 *          //log current timestamp
 *      }
 *
 *      @After
 *      @PointCut("location")
 *      public void executeAfter1() {
 *          System.out.println("this is 1st after logic");
 *          //log current timestamp
 *      }
 *
        @Before
 *      @PointCut("location")
 *      public void executeBefore2() {
 *          System.out.println("this is 2nd before logic");
 *          //log current timestamp
 *      }
 *
 *      @After
 *      @PointCut("location")
 *      public void executeAfter2() {
 *          System.out.println("this is 2nd after logic");
 *          //log current timestamp
 *      }
 *   }
 *
 *   location: public void print() => "abc"
 *
 *   "this is 1st before logic"
 *   "this is 2nd before logic"
 *   "abc"
 *   "this is 1st after logic"
 *   "this is 2nd  after logic"
 *
 *
 *
 */

@SpringBootApplication
public class IOCApplication {
    private static IOCBean ioca1;
    private static IOCBean ioca2;
    private static IOCBean ioca3AOP;

    @Autowired
    public IOCApplication(@Qualifier("myAOP") IOCBean a3) {
        IOCApplication.ioca3AOP = a3;
    }

    public static void main(String[] args) {
        SpringApplication.run(IOCApplication.class, args);
        ioca3AOP.print();
    }
}

interface IOCBean {
    void print();
}

@Component("aaa")
//@Scope("prototype")
class MyIOCA implements IOCBean{
    @Autowired
    private IOCB iocb;


    @Override
    public void print() {
        System.out.println(iocb);
    }
}

@Component
class IOCB {
    @Override
    public String toString() {
        return "IOCB{}";
    }
}

@Component
class IOCC implements IOCBean{
    @Override
    public void print() {

    }
}