package com.example.java17il2022.week4.rest;


/**
 *  Web service (Rest / SOAP)
 *  Restful / Rest / Rest api / Restful Api / Restful endpoints / Rest endpoints (architecture)
 *      1. based on Http
 *          Http method:
 *              get : get
 *              post: create
 *                  insert into table values (jerry)
 *              put: update (idempotent)
 *                  update table set name = jerry where id = 1
 *              delete : delete
 *          Http endpoints / Apis:
 *              /noun
 *              /employees  + get : retrieving all employees
 *              /employees  + post : creating employees
 *              /employees/{id}  + get / put / delete
 *
 *              @PathVariable : /{id}/
 *              @RequestParm : /employees?ageLargerThan=xx&pageNum=1&pageCount=10
 *          Http status code
 *              2xx success
 *                  200 OK
 *                  201 Created
 *                  204 No Content
 *              3xx the request has more than one possible responses
 *              4xx bad request(client size error)
 *                  400 bad request
 *                  401 authentication fail
 *                  403 authorization fail
 *                  404 not found
 *              5xx internal server error(server side error)
 *          Http request body + response body
 *              post:
 *              request body
 *              {
 *                  "name": "Jerry"
 *              }
 *              response body
 *              {
 *                  "id": ..
 *              }
 *              get:
 *              response body
 *              {
 *                  "pageNum": ..,
 *                  "totalCount": xx,
 *                  "pageCount":..,
 *                  data: [
 *                      {
 *                          emp1 info
 *                      },
 *                      {
 *                          emp2 info
 *                      }
 *                  ]
 *              }
 *      2. stateless
 *   * * * *   * * * *   * * * *   * * * *   * * * *   * * * *   * * * *   * * * *   * * * *   * * * *   * * * *   * * * *   * * * *   * * * *   * * * *
 *  Spring MVC
 *       DispatcherServlet(SpringMVC)  /*   -> handler mapping -> controller class  -> /employees + get -> locate the get employee method
 *                      |
 *                   HttpMessageConverter(@ResponseBody)
 *                     |
 *                   Jackson
 *
 *
 *       DispatcherServlet(SpringMVC)  /*   -> handler mapping -> controller class  -> /employees + get -> locate the get employee method
 *                      |
 *                   ViewResolver
 *                     |
 *                   View
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *  Create 3 endpoints
 *      1. get all employees
 *          endpoint:
 *          request parameter
 *          http method:
 *          status code:
 *          response body:
 *      2. get employee by id
 *      3. create employee information
 *          endpoint:  /employees
 *          http method:  post
 *          status code:  201, 400,  500
 *          request body:
 *              {
 *                  "name":xx
 *              }
 *          response body:
 *              {
 *                  "id":xx
 *              }
 *              error response
 *              {
 *                  "message":..
 *                  "timestamp":..
 *              }
 *
 *
 *      1. get all employees
 *          endpoint          /employees
 *          request parameter none
 *          http method       get
 *          status code       200 404 500
 *          response body     json
 *          {
 *              "data": [
 *                  {
 *                      "name": "",
 *                      "id": xx
 *                  },
 *                  {name, id},
 *                  {name, id}
 *              ]
 *          }
 *
 *
 *
 *      2. get employee by id
 *          endpoint          /employees/{id}
 *          path variable {id}
 *          http method       get
 *          status code       200 404 500
 *          response body     json
 *
 *     3.
 *
 *  Tomorrow:
 *      1. RestTemplate
 *      2. impl project
 */
