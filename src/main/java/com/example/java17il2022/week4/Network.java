package com.example.java17il2022.week4;

/**
 *  http://www.xxx.com/
 *  client <- IP ->  server
 *  IPV4 0.0.0.0  ~ 255.255.255.255
 *      public ip -> public ip
 *  1. input url in browser ?
 *      a. get destination public ip from DNS server
 *      b. build connection[source public ip1 + source port,  destination public ip2 + destination port]
 *          user1  get private ip1 from subnet  <->  router / NAT(public ip pool) <->   public ip1 + 8000  -> public ip2 + 9000
 *          user2  get private ip2 from subnet  <->  router / NAT(public ip pool) <->   public ip1 + 8001  -> public ip2 + 9000

 *          seq num 0
 *          client   ->   build connection  [ip header][tcp header][]   ->      server
 *                   <-   ack number  1      <-
 *                   ->
 *                     [socket builds connection]
 *                     [server will assign connection to thread A from thread pool]
 *          seq 1
 *          client   ->   data length 50   seq 1    -> server
 *                   <-   ack num 51
 *                   ->   data length 100  seq 51
 *
 *                   -> request1
 *                      [server processing request]
 *                      [thread A analyzes request + data, and run services/code]
 *                     DispatcherServlet(SpringMVC)  /*   -> handler mapping -> controller class  -> /employees + get -> locate the get employee method
 *                                                                                                   /employees + post -> locate the create employee function
 *                   <- response1
 *
 *                   ->   disconnect
 *                   <-   plz wait
 *                   <-   done
 *                   ->   ok
 *
 *                      [return thread A back to thread pool]
 *
 *
 *
 *  A   Application Layer : User interface  , Http        data
 *  P   Presentation Layer : SSL..
 *  S   Session Layer    : Socket
 *  T   Transport Layer  : Tcp / Udp            [tcp header][http][data]
 *  N   Network Layer    : IP , ip packet       [ip header][tcp header][http][data]
 *  D   Data Link Layer  : Ethernet, mac
 *  P   Physical Layer   : Cable    [101010101][011010][101010][101010101] -> destination
 *
 *
 *  {
 *      "key": "value"
 *  }
 *  <key>value</key>
 *
 *  2. Http(tcp)
 *      a. http method
 *          get => get data
 *          post => create data
 *          delete => remove data
 *          put => update data
 *      b. /employees
 *      c. header
 *      d. request body + response body
 *      e. status code
 *
 *  3. session vs cookie
 *      session
 *          client  ->  server
 *           <- session id <-
 *          client  - session id >  server
 *      client
 *          cookie
 *
 *  4. load balancer
 *                  client
 *                   |
 *                  |
 *              load balancer (running on ip address,  redirect request to ip1, ip2, ip3)
 *
 *      /           |           \
 *     node1        node2       node3
 *
 *
 *              client(ip1, ip2, ip3)
 *          /       |       \
 *       node1     node2     node3
 *
 *
 *     sticky session
 *  5. MVC
 *       view  (user interface)
 *        |
 *       controller (business logic)
 *        |
 *       model (repository + database)
 *
 *
 *   Tomorrow
 *      1. Rest api
 *      2. impl rest api
 *
 *   Homework
 *      1. provide get, post, put, delete endpoints for book + author project
 *      2. migrate project to spring boot(create Spring Initializer / download spring boot project from spring.io) platform
 *
 *      deadline : Friday Morning 10am CDT
 */