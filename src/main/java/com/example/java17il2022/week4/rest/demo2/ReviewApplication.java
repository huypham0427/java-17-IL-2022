package com.example.java17il2022.week4.rest.demo2;


/**
 *          [document]   ->
 * Http
 *      get
 *      post
 *      put
 *      delete
 *
 *      response body
 *      {
 *          "name": "xx"
 *      }
 *
 *      status code

 * Rest
 *
 *      /employee?age=  +  get http method
 *      /employee       +  post http method   =>
 *
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 * MVC
 * M            C               V
 * [DB   -  business logic]            - rest request -   [UI]
 *    *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 * DB   -   repository  -     service     -     controller
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 * em.find(id, Employee.class)   -   algorithm -     /employees
 *                                                  /employees/{id}
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *  1. design endpoints / rest api  +  database design
 *  *          endpoint          /employees
 *  *          request parameter none
 *  *          http method       get
 *  *          status code       200 404 500
 *  *          response body     json
 *  *          {
 *  *              "data": [
 *  *                  {
 *  *                      "name": "",
 *  *                      "id": xx
 *  *                  },
 *  *                  {name, id},
 *  *                  {name, id}
 *  *              ]
 *  *          }
 *      data flow design
 *
 *  2. repository interface
 *  3. service interface
 *     create all test cases
 *  4. controller
 *  5. repository impl + entity mapping
 *  6. service impl
 *  7. exception handling + global exception handling + customized error msg / customized error response
 *  8. security..
 */

