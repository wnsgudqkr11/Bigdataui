package com.example.demo.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/simple")
@Slf4j
public class SimpleController {

    @RequestMapping(value = "/test1",method= RequestMethod.GET)
    public void test1()
    {
        log.info("GET /simple/test1...");
    }
    @RequestMapping(value = "/test2",method= RequestMethod.GET)
    public String test2(){
        log.info("GET /simple/test2...");
        return "simple/abcd";
    }

    @RequestMapping(value = "/test3",method= {RequestMethod.GET,RequestMethod.POST})
    public void test3(){
        log.info("GET/POST /simple/test3...");
    }
}