package com.example.java17il2022.week6;


/**
 *  1. client -> rest request -> server
 *     response
 *     a. pagination
 *     b. email -> attached file
 *     c. email -> download link
 *
 *     flow:
 *          request
 *          handle request ->
 *                  upload data to xx
 *                  send email to user
 *          response
 *  2. message queue (cache + disk)
 *
 *     producer(server)  ->  message queue(server)  ->  consumer(server)
 *
 *     Asynchronous flow:
 *          request
 *          push msg ->  message queue(server)  ->  consumer(server)
 *          receive ok from message queue
 *          response
 *
 *     a. queue model
 *          producer1                                           consumer1 [3]
 *          producer2     ->  message queue [1][2][3] ->        consumer2 [1]
 *          producer3                                           consumer3 [2]
 *     b. pub - sub model
 *          producer1                                           consumer1 [3]
 *          producer2     ->  message queue [1][2][3] ->        consumer2 [3]
 *          producer3                                           consumer3 [3]
 *     c. Rabbit MQ / Active MQ
 *          producer1                                           consumer1 [3]
 *          producer2     ->  message queue [1][2][3] ->        consumer2 [1]
 *          producer3                                           consumer3 [2]
 *                                                              + consumer4, 5, 6(horizontal scaling)
 *     d. Kafka
 *                              same topic                     consumer group1 (pull message)
 *          producer1           partition1 [msg1]                   consumer1(partition1, partition2)
 *          producer2    ->     partition2 [msg3]     ->            consumer2(partition3)
 *          producer3           partition3 [msg2]             consumer group2 (pull message)
 *                                                                  consumer1(partition1, partition2, partition3)
 *                                                            consumer group3
 *                                                                  consumer1
 *                                                                      ..
 *
 *                                                                  consumer(partition amount + 1)
 *
 *          cluster
 *          broker1(t1p1-leader, t1p2-follower, t1p3-follower)
 *
 *                      broker2(t1p1-follower, t1p2-leader, t1p3-follower)
 *
 *          broker3(t1p1-follower, t1p2-follower, t1p3-leader)
 *     c. SQS (queue) + visibility timeout
 *          producer1                                           consumer1 [3]
 *          producer2     ->  message queue [1][2][3] ->        consumer2 [1]
 *          producer3                                           consumer3 [2]
 *       SNS (pub - sub)
 *         SNS -> SQS
 *             -> SQS
 *             -> SQS
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   user -> request -> producer(server)  ->  message queue(server) ->
 *                         |
 *                       database
 *   case1:
 *      1. insert data into database
 *      producer shutdown
 *      2. push msg to message queue
 *   case2:
 *      1. push msg to message queue
 *      producer shutdown
 *      2. insert data into database
 *
 *
 *   CDC + outbox pattern
 *
 *   user -> request ->  server1
 *                         |
 *                       database  ->   change data capture server / monitor server(producer) -> message queue(server) -> consumer
 *                                                                                                                          |
 *                                                                                                                        cache(finished message id)
 *
 *      1. insert msg into outbox table
 *         insert user data into other tables
 *      2.  change data capture server / monitor server reads data from outbox table
 *
 *
 *  duplicate messages issue
 *      1. generate same message id for same message info
 *      2. cache
 *      3. idempotent service
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *   global transaction
 *   1. 2PC
 *                      user
 *                      |
 *                     server
 *                     |
 *                  coordinator
 *                 /        \
 *              DB1         DB2
 *       step1: prepare stage
 *       step2: commit stage
 *
 *   2. SAGA pattern
 *      user ->  service1   ->   message queue ->  service2  -> message queue  ->       service3          ->   send ok email / success notification to user
 *                 |                                  |                                   |
 *          +10   commit db1                        commit db2                          commit db3
 *
 *              service1    <-  message queue <-  service2
 *                  |
 *         -10    commit db1
 *     *       *       *       *       *       *       *       *       *       *       *       *       *       *       *       *
 *     dead letter queue ->
 *
 *      *      *      *      *      *      *      *      *      *      *      *      *      *      *      *      *      *      *
 *    Tomorrow:
 *        Agile + Scrum + debug + CI/CD
 */