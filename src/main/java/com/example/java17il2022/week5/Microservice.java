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
 *          global unique id
 *          rate limiter
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
 */