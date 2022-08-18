package com.example.java17il2022.week3;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

/**
 * volatile
 *
 * t1 is running
 * t2 is running +current value active
 * t1 finish
 */
class VolatileTestFence {
    private static volatile boolean active = true;

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 is running");
            while(active) {}
            System.out.println("t1 finish the while loop");
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 is running");
            active = false;
            System.out.println("current active value is : " + active);
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

/**
 * *   1. Singleton
 */
class EagerLoadingSingleton {
    private static final EagerLoadingSingleton instance = new EagerLoadingSingleton();

    private EagerLoadingSingleton() {}

    public static EagerLoadingSingleton getInstance() {
        return instance;
    }
}

class DoubleCheckLazyLoadingSingleton {
    private volatile static DoubleCheckLazyLoadingSingleton instance;

    private DoubleCheckLazyLoadingSingleton() {
    }

    public static DoubleCheckLazyLoadingSingleton getInstance() {
        if(instance == null) {
            synchronized (DoubleCheckLazyLoadingSingleton.class){
                if(instance == null) {
                    instance = new DoubleCheckLazyLoadingSingleton();
                }
            }
        }
        return instance;
    }
}

enum EnumSingleton {
    A, B;
}


 /**
 *  *  2. Factory
  *
  *   A {
  *       BFactory.getInstance();
  *   }
  */
 class ObjectFactory {
     private ObjectFactory() {}
     public static Object getInstance() {
         return new Object();
     }
 }

/**
 *  Builder
 *
 */

class BuilderTest {
    private static class Student {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public Student setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Student setAge(int age) {
            this.age = age;
            return this;
        }
    }

    public static void main(String[] args) {
        new StringBuilder().append("abc").append("abc").reverse().toString();
//        BuilderStudent stu = new BuilderStudent().setAge(1).setName("Tom");
    }
}
class MyBuilder {
    private String name;
    private int age;

    public MyBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public MyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public BuilderStudent build() {
        return new BuilderStudent(name, age);
    }
}
class BuilderStudent {
    private String name;
    private int age;
    //,..,,


    public BuilderStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
/**
*  *  3. Composition (Has-A)  vs  Inheritance (IS-A)
 */

class TreeNodeTest {
    private final class TreeNode {
        TreeNode left;
        TreeNode right;
    }
    //BFS -> print tree layer by layer
    public void BFSPrint(TreeNode root) {
        if(root == null) {
            return;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
                System.out.print(node);
            }
            System.out.println();
        }
    }
}


/**
*  *  4. Bridge
 */
class CalculatorBridge {
    private final Calculate calculate;

    public CalculatorBridge(Calculate calculate) {
        this.calculate = calculate;
    }

    public int execute(int a, int b) {
        return calculate.sum(a, b);
    }
}

interface Calculate {
    int sum(int a, int b);
}

class CalculateImpl1 implements Calculate {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
/**
*  *  5. Strategy
 */
class CalculatorStrategy {
    public int execute(int a, int b, Calculate calculate) {
        return calculate.sum(a, b);
    }
}
/**
*  *  6. Prototype
 *      clone() => shallow copy
 *                 deep copy
 */

/**
*  *  7. Template
 *      class Pizza {
 *          void xx() {}
 *      }
 *
 *      class HawaiiPizza extends Pizza {}
 *      class VeggiePizza extends Pizza {}
 */

/**
*  *  8. Observer
 */
class Topic {
    private final List<MyObserver> myObservers = new ArrayList<>();

    public void register(MyObserver observer) {
        myObservers.add(observer);
    }

    public void publish(String msg) {
        for(MyObserver observer: myObservers) {
            observer.receive(msg);
        }
    }
}

class MyObserver {
    public void receive(String msg) {
        System.out.println(msg);
    }
}

/**
 *     9. Facade
 *          "msg" -> switch(msg) ->   class1
 *                               ->   class2
 */


/**
 *    10. Adaptor
 */
class AdaptorExample {
    public static void run(Robot robot) {
        robot.robotExecute();
    }

    public static void main(String[] args) {
        Human h1 = () -> System.out.println("I'm human");
        run(new RobotAdaptor(h1));
    }
}

interface Robot {
    void robotExecute();
    void print();
}
interface Human {
    void humanExecute();
}
class RobotAdaptor implements Robot {
    private Human human;

    public RobotAdaptor(Human human) {
        this.human = human;
    }

    @Override
    public void robotExecute() {
        human.humanExecute();
    }

    @Override
    public void print() {
        //nothing
    }
}
/**
*  *  11. Decorator / Static Proxy
 */
class RobotProxy implements Robot {
    private final Robot robot;

    public RobotProxy(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void robotExecute() {
        System.out.println("before");
        robot.robotExecute();
        System.out.println("after");
    }

    @Override
    public void print() {
        System.out.println("before");
        robot.print();
        System.out.println("after");
    }
}

class StaticProxyTest {
    public static void main(String[] args) {
        Robot robot = new Robot() {
            @Override
            public void robotExecute() {
                System.out.println("this is execute");
            }

            @Override
            public void print() {
                System.out.println("this is print");
            }
        };
        Robot proxy = new RobotProxy(robot);
        proxy.robotExecute();
    }
}

/**
*  *  12. Dynamic Proxy
*/
class DynamicProxyTest {
    public static void main(String[] args) {
        Robot robot = new Robot() {
            @Override
            public void robotExecute() {
                System.out.println("this is execute");
            }

            @Override
            public void print() {
                System.out.println("this is print");
            }
        };
        Robot proxy = (Robot) Proxy.newProxyInstance(
                DynamicProxyTest.class.getClassLoader(),
                new Class[]{Robot.class},
                new RobotInvocationHandler(robot)
        );
        proxy.robotExecute();
        proxy.print();
    }
}

class RobotInvocationHandler implements InvocationHandler {
    private final Robot robot;

    public RobotInvocationHandler(Robot robot) {
        this.robot = robot;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        System.out.println(method);
        Object obj = method.invoke(robot, args);
        System.out.println("after");
        return obj;
    }
}

/**
 *  Tomorrow
 *      1. Reflection
 *      2. Dynamic Proxy
 *      3. MAVEN + JDBC
 */