package com.example.java17il2022.week6;

/**
 *  How do you design restful api / impl restful api
 *      1. analyze requirements
 *      2. design api : endpoint, request body, response body, header, status code, http method..
 *      3. table + entities + pojo
 *      4. MVC -> [service repository] interface
 *      5. test
 *      6. MVC -> controller service repository implementation
 *  Security
 *      1. authentication
 *      2. authorization + JWT
 *      3. https
 *      4. CSRF
 *      5. Sql injection
 *      6. log injection
 *      ..
 *  Microservice - deployment
 *      1. docker vs vm
 *      2. kubernetes / ECS
 *  Microservice - disadvantages
 *      1. consider complex fail tolerance(circuit breaker)
 *      2. strong consistency vs eventually consistency => global transaction
 *      3. hard to decide services boundary
 *      4. cost..
 *      ..
 *  <<design intensive data application>>
 *
 *  -> AWS introduction next week
 *      region, zone
 *      1. EC2 + ASG    ASG[EC2-1,  EC2-2,  EC2-3]
 *      2. Application Loadbalancer
 *                   ALB
 *                 /    \  /path
 *             target   ASG
 *
 *      3. Route53 (DNS)
 *      4. S3 <-> S3 glacier
 *          /xx/xxx/file
 *         a. image / video
 *         b. log
 *      5. RDS(Mysql, Postgre, Oracle)
 *      6. SQS(dead letter queue / FIFO / standard queue)  + SNS
 *      7. (Network Access Control List)VPC(public / private subnet,  ip range) + NAT instance + internet gateway(public ip access)
 *
 *                                    internet gateway
 *                                      route table
 *            private subnet[  EC2-1 ]              public  subnet[  EC2 - 2]
 *            ip range ip1 ~ ip5(CIDR)              CIDR block
 *
 *      8. ECS + ECR + docker container
 *         ECR(docker image repository)
 *         ECS + task definition
 *                  ECS(centralized controller)
 *
 *        docker container1             docker container3
 *        docker container2             docker container4
 *         EC2 - 1                          EC2 - 2
 *      (installed agent)                (installed agent)
 *
 *
 *                  ECS(centralized controller)
 *
 *        docker container1             docker container3
 *        docker container2             docker container4
 *         Fargate-1                        Fargate-2
 *
 *
 *      9. IAM
 *                  root account(do not use / share this account)
 *               /      \           \
 *            account1  account2    account3
 *          role list1    2             3
 *      10. security group(firewall)
 *      11. user(NY) -> edge location(NY data center) -> website(other country)
 *                     cache the result from that website
 *      12. KMS
 *
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  1. download google chat in your phone (turn on the notification)
 *  2. login your marketing email
 *  3. add renqing.yang@antra.com
 *
 */