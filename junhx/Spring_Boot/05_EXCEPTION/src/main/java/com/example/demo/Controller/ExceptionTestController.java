package com.example.demo.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
@Slf4j
@RequestMapping("/except")
public class ExceptionTestController {

//    @ExceptionHandler(FileNotFoundException.class)
//    public String exception_handler1(Exception e, Model model){
//        log.error("error : " + e);
//        model.addAttribute("ex",e);
//        return "except/error";
//    }
//    @ExceptionHandler(ArithmeticException.class)
//    public String exception_handler2(Exception e){
//        log.error("error : " + e);
//        return "except/error";
//    }

    @ExceptionHandler(Exception.class)
    public String exception_handler1(Exception e, Model model){
        log.error("Exception error : " + e);
        model.addAttribute("ex",e);
        return "except/error";
    }


    @GetMapping("/ex1")
    public void ex1() throws FileNotFoundException{
        log.info("GET /except/ex1...");
        throw new FileNotFoundException("파일을 찾을 수 없습니다..");
    }

    @GetMapping("/ex2/{num}/{div}")
    public String ex2(
            @PathVariable int num,
            @PathVariable int div,
            Model model
    ) throws ArithmeticException
    {
        log.info("GET /except/ex2...");
        model.addAttribute("result",(num/div));
        return "except/ex2";
    }
    @GetMapping("/ex3")
    public void ex3(){
        log.info("GET /except/ex3...");
    }
}