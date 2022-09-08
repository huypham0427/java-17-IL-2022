package com.example.java17il2022.week6.test.fizzbuzz;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  requirement
 *      1. print 1 - 100:  number / fizz buzz
 *
 *
 *  corner cases
 *      1. from > to -> IllegalArgumentException
 *      2. negative number or 0 ? -> IllegalArgumentException
 *      3. [1, 1] -> single number
 *      4. [1, 3] -> print number + fizz
 *      5. [1, 5] -> print number + fizz + buzz
 *      6. [1, 15] -> print number + fizz + buzz + fizzbuzz
 *      7. [3, 3]
 *      8. [5, 5]
 *      9. [15, 15]
 *      10. [1, Integer.MAX_VALUE] -> time
 *
 *  solution
 *      1. public String fizzbuzzHelper(int number)
 *      2. use cache to cache the result
 *      3. use cache + pre-load the data into the cache
 */
public class Solution {
    private final Map<Integer, String> fizzbuzzMap;

    public Solution() {
        fizzbuzzMap = new ConcurrentHashMap<>();
    }

    public Solution(Map<Integer, String> fizzbuzzMap) {
        this.fizzbuzzMap = fizzbuzzMap;
    }

    public void fizzbuzz(int from, int to) {
        if(from > to || from <= 0 || to <= 0) {
            //log
            throw new IllegalArgumentException("input not valid");
        }
        for(int i = from; i <= to; i++) {
            String str = fizzbuzzHelper(i);
            System.out.println(str);
        }
    }

    public String fizzbuzzHelper(int number) {
        if(number <= 0) {
            //log
            throw new IllegalArgumentException("input not valid");
        }
        if(fizzbuzzMap.containsKey(number)) {
            return fizzbuzzMap.get(number);
        }
        String res;
        if(number % 3 == 0 && number % 5 == 0) {
            res = "fizzbuzz";
        } else if(number % 3 == 0) {
            res = "fizz";
        } else if(number % 5 == 0) {
            res = "buzz";
        } else {
            res = String.valueOf(number);
        }
        fizzbuzzMap.put(number, res);
        return res;
    }
}
