package com.lex.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    /*@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")*/
    /*@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")*/
/*    @RateLimiter(name="default")*/
    @Bulkhead(name = "sample-api")
    public String sampleApi() {
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
        logger.info("Sample Api call received");
//        return forEntity.getBody();
        return "sample-api";
    }

    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }
}