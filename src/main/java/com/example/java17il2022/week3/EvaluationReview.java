package com.example.java17il2022.week3;


import java.util.*;

interface A {
    int a = 5;
}

class IteratorExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {

        }
    }
}
/**
 * 1. OOD
 *      when do we use abstract class / when do we use interface
 *      a. class
 *      b. changeable values
 *      c. constructor
 *   Constructor
 *      class A {
 *
 *      }
 *
 *      class B extends A {
 *          private String name;
 *          public B(String name) {
 *              name = name;
 *          }
 *
 *          public void print() {
 *              //sout(name);
 *          }
 *      }
 *
 *      B b = new B("Tom");
 *      b.print();
 *
 * 2. Collection
 *      ArrayList vs Array
 *      When do we use ArrayList?
 *      When do we use LinkedList?
 *      Insert elements to index 0
 *      What is ConcurrentModificationException ?  (fail fast)
 *      equals vs hashCode
 *      HashMap
 *  3. Exception
 *           Throwable
 *         /        \
 *       Error      Exception
 *                    \
 *                   RuntimeException
 *      How to create customized RuntimeException
 *      How to create customized CompileTimeException
 *      Why do we need exception
 *          => log file
 *
 *  4. Time Complexity
 *     LinkedList O(N) -> search / remove from middle
 *                O(1) -> manipulate head / tail
 *     RedBlack tree O(logN) -> all operations
 *  5. String vs StringBuilder
 *  6. synchronized vs ReentrantLock
 *      public static synchronized void get() {}
 *      public synchronized void get() {}
 *      public void get() {
 *          synchronized(obj) {
 *              wait();
 *              notify();
 *          }
 *      }
 *      public void get() {
 *          synchronized(Student.class) {
 *
 *          }
 *      }
 *  7. volatile
 *      CPU                 CPU
 *      L1                  L1
 *      L2                  L2
 *
 *            Main memory
 *
 *  8. ConcurrentHashMap vs HashMap vs HashTable
 *  9. BlockingQueue
 *
 *  *****************************************
 *     CountDownLatch vs Semaphore vs CyclicBarrier
 *  1. ThreadPool
 *  2. StackOverFlow Error
 *  3. OutOfMemory Error
 *  4. JVM (tuning)
 *  DB
 *  1. query =>
 *      join
 *      group by
 *      rank() vs dense_rank()
 *  2. transaction
 *      why
 *  3. index
 *      B+ tree vs bitmap index
 *      execution plan + hint
 *  4. m - m vs 1 - m vs 1 - 1
 *
 */
class MyRuntimeException extends RuntimeException {
    public MyRuntimeException(String message) {
        super(message);
    }
}
class MyCompileTimeException extends Exception {

}

class ConstructorTestA {
    private int age;

    public ConstructorTestA(int age) {
        this.age = age;
    }
}

class ConstructorTestB extends ConstructorTestA {
    private String name;

//    public ConstructorTestB(String name) {
//        super();
//        this.name = name;
//    }


    public ConstructorTestB(int age) {
        super(5);
    }

    public void print() {
        System.out.println(name);
    }

    public static void main(String[] args) {
    }
}

class HashMapTest {
    private static class Student {
        String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return 5;
        }
    }

    public static void main(String[] args) {
        Map<Student, Integer> map = new HashMap<>();
        Student s1 = new Student("Tom");
        map.put(s1, 9);
        Student s2 = new Student("Tom");
        System.out.println(map.get(s2)); // 9
        s2.name = "Jerry";
        System.out.println(map.get(s2)); // ？
    }
}