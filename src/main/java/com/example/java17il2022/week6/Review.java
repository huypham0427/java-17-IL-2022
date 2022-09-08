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
 *      1. EC2 + ASG
 *      2. Application loadbalancer
 *      3. Route53
 *      4. S3 + S3 glacier
 *      5. RDS
 *      6. SQS(dead letter queue / FIFO / standard queue)  + SNS
 *      7. (Network Access Control List)VPC(public / private subnet,  ip range) + NAT instance + internet gateway(public ip access)
 *      8. ECS + ECR + docker container
 *      9. IAM
 *      10. security group
 *      11. aws lambda
 *  Tomorrow : review interview questions
 */