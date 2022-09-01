package com.example.java17il2022.week5;


/**
 *  DB Cluster (leader - follower / master - slave / primary - secondary)
 *  write / read cluster
 *  single leader
 *          DB1 leader
 *          |       \         \
 *       DB2        DB3      DB4   followerS
 *        1. save data to leader
 *           send success response to user
 *           leader transfer data to all followers
 *        2. save data to leader + 1 ~ all followers
 *           send success response to user
 *           leader transfer data to other followers
 *
 *
 *  multi leader
 *       DB1 leader     DB2 leader      DB3 leader
 *     |    \
 *    followers         ..
 *    issue1
 *      insert to DB1
 *      delete from DB2
 *      DB1 try to synchronize new update to DB2
 *    issue2
 *      update DB1 row1
 *      update DB2 row2
 *      LWW (timestamp)
 *
 *  leader less = every node is leader
 *      consistent hashing
 *           DB1(0)
 *    DB6           DB2(10k)
 *
 *                   DBX(15k)
 *    DB5            DB3(20k).
 *          DB4
 *
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *    DB (id 1 ~ 10k)
 *    Sharding
 *      DB1(id 1 ~ 1k)  DB2(id 1k + 1 ~ 2k) ... ,  "add 1 DB(10k ~ 11k)"
 *      DB1(id % 3)   DB2(id % 3)    DB3(id % 3)   " "add 1 DB"
 *
 *      1. how do we locate Database instance
 *              a. config server / meta data server + gateway server  => MongoDB
 *              b. consistent hashing   =>  Cassandra
 *              c. assign 25k hash slots to different leaders  => Redis cluster
 *                  leader1(0 - 5k)         leader2(5k - 25k)
 *                |       \
 *              follower1    follower2
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *    Types of database
 *         Sequential IO :
 *              write : keep appending log
 *              read  : select all possible logs / files
 *                      merge all query -> get result
 *              LSM
 *                                                        log file6
 *                                                /                                 \
 *                                       log file4                                       log file5
 *                                 /            |               \
 *                immutable   log file1       log file2       log file3
 *
 *         Random IO
 *              B+ tree
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *    Mongodb (CP)
 *                         Gateway(mongos)     ---      config server(mongos)
 *                     /        \                \
 *            sharding1         sharding2       sharding3
 *          primary node
 *          secondary node
 *          secondary node
 *          id 1 ~  10k      id 10k + 1 ~ 20k
 *       timestamp / id
 *
 *          1. save id  -> select id by range
 *          2. save hashed(id)
 *          3. select non-partition key attributes
 *              eg. select * where name = 'xx'
 *              global secondary index
 *                  1. read index
 *                  2. read from sharding
 *
 *                  insert
 *                  begin / start global transaction (2pc / 3pc / SAGA)
 *                  1.update the database server
 *                  2.update the index in global index server
 *                  end transaction
 *    *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *    Cassandra(column based,  AP, LWW)  -  LSM tree
 *           DB1(0)
 *    DB6           DB2(10k)
 *
 *                   DBX(15k)
 *    DB5            DB3(20k).
 *           DB4
 *
 *
 *       cassandra node
 *       ->     memtable  ->  immutable Sorted String Table
 *         |
 *       commit log
 *
 *
 *           DB1(0)
 *    DB6           DB2(10k)
 *
 *                   DBX(15k)
 *    DB5            DB3(20k).
 *           DB4
 *
 *      replica factor = 3
 *      write consistency = 2
 *      write : insert data into DB3 , DB4, DB5
 *      read consistency = 2
 *      read :  read all data from node which has fastest network connection
 *              read hash value from other nodes
 *              compare hash value with data's hash
 *              if same => return data
 *              if not  => trigger read repair
 *                         return newest data
 *                      write
 *                    /         \
 *                  DB3         DB4         DB5
 *                                \         /
 *                                  read
 *     read + write <= replica factor
 *     read + write > replica factor
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *  Redis
 *                  leader1(0 - 5k)         leader2(5k - 25k)
 *                |       \
 *              follower1    follower2
 *     1. read through + write through
 *       server - cache - database
 *     2. cache aside
 *       server   ---    cache
 *        |
 *       database
 *       1. read from cache
 *          if find -> return data
 *          if not  -> read from database, save data into cache
 *                     return data
 *       2. write into database
 *          remove cache data
 *          update database
 *   *      *      *      *      *      *      *      *      *      *      *      *      *      *      *      *
 *   Homework:
 *      1. remove employee config setting from gateway
 *      2. let search service send rest request to employee service to fetch data
 *          /search?age=1,2,3
 *          /search?age=1&age=2&age=3
 *          input 5 ages -> return response with 5 different group result
 *          configure global thread pool
 *          use CompletableFuture to send request
 */