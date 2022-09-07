package com.example.java17il2022.week6;


/**
 *  Agile Scrum / Daily work
 *  Sprint = 1 ~ 4 weeks
 *  Production backlog = todo list of project
 *  Story = description of the task :
 *          example, when user visit xx api, they couldn't find xxx attributes / data, we have to display xxx attributes in this page..
 *          example, we need text message verification for users
 *  Ticket = bugs / issues
 *          example, user get error message when they click xxx button
 *  1. Sprint planning meeting (grooming section)
 *     get "stories" / "tickets" from "production backlog"
 *     evaluate / assign points to different stories / tickets
 *          1 point = 2h job
 *          1 point = easiest job, 2 points = ... ,  3 points,  5 points, 8 points..  (fibonacci)
 *  2. Daily stand up meeting (15 ~ 30 min)
 *     [Stories]
 *     TDD after daily stand up
 *      a. get tasks -> check out new feature branch
 *      b. design / analyze
 *      c. write test
 *      d. impl code
 *      e. push the code to feature branch
 *      f. pull request code review
 *          coding review:
 *              1. logic + features
 *              2. time / space complexity + multi-threading
 *              3. redundant code
 *                      if()
 *                      else if()
 *                      else if()
 *                      else if()
 *                      else if()
 *                      else if()
 *                      else if()
 *                      ...
 *              4. OOD + design patterns
 *              5. security => Are you saving user password into the log? ..
 *              6. exception + log
 *              7. documentation
 *      g. merge to xx branch
 *      h. trigger jenkins pipeline
 *              1. pull code from git (git hook plugin)
 *              2. build
 *              3. test
 *                     code coverage -> 80 ~ 90 %
 *                     security scan ->
 *                     bugs scan ->
 *                     flaws scan ->
 *                     redundant code scan ->
 *                     -> generate reports to "Sonarqube"
 *              4. package -> war / jar / docker image
 *              5. deploy
 *                  solution1: deploy to temporary node / server -> run test -> deploy to QA env
 *                  solution2: deploy to QA env -> run test -> rollback to previous version
 *              6. send notification if failed
 *      [Tickets / Bugs]
 *      Production Support
 *       a. get + read "bug report"
 *       b. search "Splunk" by using keyword
 *          code issue
 *       c. reproduce bug in your local env
 *       d. fix the issue + rewrite test cases
 *       e. optional: meeting with leader / manager
 *          network / configuration issue / system configuration
 *       c. aws / server configurations
 *       d. network delay
 *       e. network issues
 *          dirty data
 *       c. rollback the data -> see the issues
 *
 *  3. Retrospective meeting
 *  4. Demo review meeting (every 3 - 5 sprints)
 *  5. Other meetings
 *          a. meetings with BA / QA / Manager /  front developers
 *          b. design meetings
 *          c. ..
 *    *     *     *     *     *     *     *     *     *     *     *     *     *     *     *     *     *     *     *     *     *     *     *     *
 *  Git
 *  master branch   ------------O---------O-------------------O----------------- (production branch)
 *                              |           \               /       /
 *  release branch  ------------X------------X------------X----------------------
 *
 *  QA branch      ----------X------------X------------X--------------------------------
 *                           \                                                       /
 *  Feature branch            X---------- ---------- ---------- ---------- ----------
 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *  Unit Test
 *      1. Junit / TestNG
 *
 *      2. Mockito
 *      3. PowerMock
 *  Integration Test
 *      1. postman (tool)
 *      2. mockmvc (code)
 *          perform().expect..
 *
 *  homework :
 *      1. set up swagger (conflict with common module)
 *      2. create fizz buzz function
 *           value % 3 == 0 -> print fizz
 *           value % 5 == 0 -> print buzz
 *           value % 3 & value % 5 == 0 -> print fizzbuzz
 *          print value from input1 to input2
 *          use junit + mockito
 *
 *
 *
 */
