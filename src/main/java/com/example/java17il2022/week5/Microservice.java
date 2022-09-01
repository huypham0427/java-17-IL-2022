package com.example.java17il2022.week5;


/**
 *  monolithic
 *
 *
 *  microservice
 *      why
 *      1. scalability
 *      2. different languages
 *      3. partial deployment
 *      4. team
 *      ..
 *
 *      how
 *      1. api gateway
 *          global unique id(log id, tx id..)
 *              UUID
 *              Database -> primary key
 *              Snowflake ->  timestamp + machine id + xx id + serial id
 *          rate limiter
 *              1. limit total request amount (token bucket)
 *
 *    Token generator  ----
 *                        |
 *                  \ O   X /
 *                   \_____/   -----> user
 *
 *              2. based on IP  1 request / s
 *
 *                   timestamp -> ->
 *                window [ip1, ip2, ip3 .... ]
 *
 *
 *      2. discovery service / service registration
 *              key: service name value: [ip1, ip2, ip3]
 *                 /
 *         serviceA  -> rest(service-B-name/uri/x) ->  serviceB
 *      3. client side load balancer library / algorithm
 *      4. centralized security service
 *      5. centralized configuration service
 *      6. circuit breaker
 *              open
 *              close
 *      7. message queue
 *      8. database cluster(single leader, multi leader or leaderless) + cache
 *          CAP -> sharding / scalability
 *      9. ci/cd
 *      10. container / linux
 *      11. centralized log service
 *       *       *       *       *       *       *       *       *       *       *       *       *       *       *       *       *       *       *
 *      1. what is a good api
 *          a. short response time / good performance
 *          b. handle different corner cases
 *          c. error handling + log
 *          d. security
 *          e. good documentation
 *          f. follow SOLID + rest api standard
 *          g. test
 *
 *      2. how do you start implementing restful api (TDD : test driven development)
 *          a. get requirements
 *          b. analyze requirements
 *          c. consider corner cases
 *          d. restful api(endpoint + request body / ..) + interface + abstract class + //TODO
 *          e. impl all test cases
 *          f. impl the TODO
 *          g. run test cases
 *          10. send pull request code review + merge code -> trigger jenkins pipeline
 *
 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  homework
 *      1. provide retry features in employee service (3 times)
 *      2. return customized exception to search service
 *      3. search service provide hystrix -> return default result / error msg (under close status)
 *      4. provide global exception handling in search service (controller advice + exception handler -> return 500 error code)
 *      5. learn message queue
 *         explain kafka partition + broker + consumer group + ack number in txt file
 *         explain diff between kafka and rabbit mq in txt file
 *  DeadLine : before Tuesday
 *

 */