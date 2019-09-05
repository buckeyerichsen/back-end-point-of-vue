package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @CrossOrigin(origins = "http://192.168.0.102:8081")
    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "You did not fill anything in") String name) {
        long myGreetingId = 23820924;
        return new Greeting(myGreetingId, name);
    }

    @CrossOrigin(origins = "http://192.168.0.102:8081")
    @RequestMapping(value = "/mypostendpoint", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Greeting greetingJson(HttpEntity<String> httpEntity) {
        String myJson = httpEntity.getBody();
        System.out.println(myJson);
        // json contains the plain json string
        return new Greeting(123, "TESTING");
    }
}