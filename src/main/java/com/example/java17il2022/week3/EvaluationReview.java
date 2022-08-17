package com.example.java17il2022.week3;


import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
 *     CountDownLatch vs CyclicBarrier
 *
 *          Thread1(countDown), Thread2(countDown), Thread3(countDown, countDown)
 *                      |
 *                   Thread4(await)
 *
 *     Semaphore
 *
 *     Task : CPU VS IO
 *  1. ThreadPool
 *      Executors
 *      a. ThreadPoolExecutor
 *              [][][][][][][][][] blocking queue -> worker1
 *                                                -> worker2
 *      b. ForkJoinPool (Stealing algorithm)
 *              [][][][][][][][][] blocking queue -> worker1 [sub1][sub2][][][][]
 *                                               -> worker2 [sub3][][][][][]
 *      c. ScheduledThreadPool
 *
 *      d. Thread pool size
 *          CPU : core + 1
 *          IO  : 80% IO waiting + 20% CPU time = 10s
 *                8s IO waiting + 2s CPU
 *                1 / 20% = 5
 */
class ThreadPoolInitialization {

    private static final ExecutorService pool = Executors.newCachedThreadPool();

    public static void execute(String msg) {
        pool.submit(() -> System.out.println(msg));
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            execute("this is " + i);
        }
    }
}
/**
 *  CompletableFuture vs Future
 */
class CompletableFutureTest1 {

    private static final ExecutorService pool = Executors.newCachedThreadPool();


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Future<Integer> future = pool.submit(() -> 1);
//        int res = future.get();
//        System.out.println(res);
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }, pool);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> 2, pool);
        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(() -> 3, pool);
        //solution1
        List<Integer> list = Arrays.asList(cf1.join(), cf2.join(), cf3.join());
        System.out.println(list);
        //solution2
        CompletableFuture[] completableFutures = {cf1, cf2, cf3};
        CompletableFuture.allOf(completableFutures)
                .thenApply(xx -> {
                    List<Integer> res = new ArrayList<>();
                    for(CompletableFuture<Integer> future: completableFutures) {
                        res.add(future.join());
                    }
                    return res;
                }).thenApply(arrList -> arrList.toString())
                .thenAccept(str -> System.out.println(str))
                .join();
    }

}

/**
 *  2. StackOverFlow Error
 *  3. OutOfMemory Error
 *      [][][][][][][
 *      [][][o][][][]
 *      1. increase young gen size
 *      2. check memory leak
 *          heap dump -> memory analyzer / Jprofiler / Java mission control
 *          JConsole / real time GC monitors
 *      3. StrongReference / SoftReference / WeakReference / PhantomReference + ReferenceQueue
 *
 *  4. java pass by value
 */
class JavaPassByValue {
    private static void fun1() {
        List<Integer> list1 = new ArrayList<>();
        fun2(list1);
        System.out.println(list1);
    }
    // list1 -> obj
    // list2 ->null
    private static void fun2(List<Integer> list2) {
//        list2.add(5);
        list2 = Arrays.asList(1, 2, 3);
    }

    public static void main(String[] args) {
        fun1();
    }
}
/**
 *  5. java 8
 *      employee {
 *          String name;
 *          int age;
 *      }
 *      List<Employees> emps;
 *      a. group by employees based on age, return map<age, List<emp>>
*/
class Java8Test {
    private static class Employee {
        String name;
        int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Tom", 1);
        Employee e2 = new Employee("Alex", 1);
        Employee e3 = new Employee("Jerry", 2);
        List<Employee> emps = Arrays.asList(e1, e2, e3);
        Map<Integer, List<Employee>> map = emps.stream().collect(
                HashMap::new,
                (m, employee) -> {
                    m.putIfAbsent(employee.age, new ArrayList<>());
                    m.get(employee.age).add(employee);
                },
                (m1, m2) -> {});
        System.out.println(map);
    }
}
/**
 *  java 8 questions
 *      1. intermediate operations vs terminal operations
 *          a. return value
 *          b. lazy loading
 *                  list.stream().map().filter().sorted()
 *                  ReferencedPipeline(stream) <-> ReferencedPipeline(map)  <->  ReferencedPipeline(filter)
 *      2. intermediate operations
 *          stateful operation vs stateless operations
 *
 *          list.stream().map().filter().collect
 *          1. ReferencedPipeline(stream) <-> ReferencedPipeline(map)  <->  ReferencedPipeline(filter) <->  ReferencedPipeline(terminal operation)
 *                  -------------------------------------------------------------------------------->>>>
 *          2. Sink1(list iterator)   ->    Sink2(function)   ->  Sink3(predicate)    ->  Sink(Collectors)
 *                  <<<<-------------------------------------------------------------------------------
 *          3. start running first sink list iterator
 *
 *
 *          Supplier<Iterator> itr = () -> list.iterator();
 *          itr.get()
 *
 *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   1. create project
 *   2. share it on github
 *      deadline : tomorrow 10am CDT
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


/**
 *  [key, 5]
 *  int preVal = map.getOrDefault(key, 0); //T1 : 5,  T2: 5
 *  map.put(key, preVal + cnt); //T1: put(key, 5 + 1),   T2: put(key, 5 + 2)
 *  //5 + 1 + 2
 *
 *  lost update
 *
 *  name    age      version
 *  'Tom',  3           2
 * * * * * * * * * * * * * * * * * * *
 *  DB
 *  employees (emp_id, name, salary, dept_id)
 *  departments (dept_id, name)
 *  1. query =>
 *      join:  inner join, cross join, outer join
 *      group by
 *           query1: count number of employee in each department, display department name and count?
                    select d.name as dep_name, count(e.emp_id) as ct
                    from departments d left join employee e on d.dept_id = e.dept_id
                    group by d.dept_id, d.name
 *      rank() vs dense_rank()
 *           query2: nth highest salary from employee table
 *                  select
 *                  from employees e1
 *                  where (n - 1) = (select count(distinct(e2.salary)) from employees e2 where e2.salary > e1.salary)
 *
 *                  select *
 *                  from (select e1.*, dense_rank() over (order by salary desc) as rank
 *                        from employees e1) t
 *                  where t.rank = n
 *  2. transaction
 *      why
 *      undo area
 *
 *         MVCC
 *       ->   [1, "Jerry", txid, rowid,  rollback pointer] -> [1, "Tom", txid..]
 *  3. index
 *      B+ tree vs
 *      bitmap index
 *          id,  sex       rowid                rowid     female    male
 *          1    male        xx                  xx         0         1
 *          2    female      xx                  xx         1         0
 *          3    female      xx                  xx         1         0
 *      execution plan(explain plan) + hint
 *          full table scan
 *          index access path
 *              index unique scan
 *              index range scan
 *              index full scan
 *              index fast full scan
 *          merge join
 *          hash join
 *          nested join
 *          Leading
 *          parallel
 *  4. m - m vs 1 - m vs 1 - 1
 *      stu  1 - m  class
 *      stu(stu_id(pk))
 *      class(class_id(pk), stu_id(fk))
 *
 *      stu  m - m class
 *      stu(stu_id)
 *      stu_class (id, stu_id, class_id)
 *      class(class_id)
 *
 *
 * Tomorrow :
 *  design patterns
 *  1. Singleton
 *  2. Factory vs Builder
 *  3. Composition
 *  4. Bridge
 *  5. Strategy
 *  6. Prototype
 *  7. Template
 *  8. Adaptor
 *  9. Decorator / Static Proxy
 *  10. Dynamic Proxy
 *  11. Observer
 *  12. Facade
 *
 * 1. Download database (Mysql, Oracle, PostgreSql, (in memory)Derby / H2)
 */