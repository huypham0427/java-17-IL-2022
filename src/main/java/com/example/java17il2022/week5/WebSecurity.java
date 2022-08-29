package com.example.java17il2022.week5;

/**
 * encoding:
 * text([1010101][010011])  -> encoding algorithm -> [101][010][101][010][110][100][1010] -> decoding -> text
 *
 *  -> this is english
 *  -> xxx&*&8
 * encoding (ASCII character)
 *
 * encryption:
 * Symmetric encryption -> same key
 * Asymmetric encryption -> public key + private key
 *
 * 1. authentication
 *      post => login
 * 2. authorization
 *      token = XJAKLSDFLJASLDKJFLKASJFAS
 *      JWT token = Json Web Token
 *          Header.Payload.Signature
 *          encoding(Header.Payload.encryption(Header.Payload))
 * 3. https = http + SSL / TLS
 *      one way SSL
 *      client  ->    hello   ->    server (private key)
 *          <-   certificate + public key <-
 *       [exchange public key + private key to symmetric key]
 *          ->   public key[random string] ->
 *          <-   hashed random string  <-
 *         [generate symmetric key based on random string]
 *          ->   symmetric key[data]  ->
 *           <-   symmetric key[data]  <-
 *  4. Sql Injection
 *  5. CSRF (session attack)
 *  6. DDOS
 *      horizontal scaling
 *      static page
 *      CDN -> cache at edge location
 *      firewall block list
 *      rate limiter
 *  7. log injection
 *  ..
 *
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  1. configure authentication manager
 *  2. use JWTFilter to verify jwt token
 *     store user info into security context
 *  3. use UsernamePasswordAuthenticationFilter to get user password + username
 *  4. AbstractUserDetailsAuthenticationProvider verifies user identity
 *          a. retrieve user info from UserDetailsService.loadUserByUsername(username)
 *          b. compare the user details with user authentication object(from the request)
 *  5. save user info into SecurityContext(ThreadLocal)
 *  6. verify role in @PreAuthorize("hasAuthority('xx')")
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   interview questions
 *      1. how to keep your application / restful api secured
 *      2. how does https / ssl / tls work
 *      3. how to use spring security
 *      4. what is sql injection
 *      5. what is CSRF attack
 *      6. what is log injection
 *      7. what is JWT token
 *      8. what is OAuth 2.0
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *  v
 *   Tomorrow
 *      1. microservice introduction(40min)
 *      2. review spring cloud library
 *      weather service in github (multi module project)
 */