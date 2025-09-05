package com.example.demo.DiTests;


import com.example.demo.Component.PersonComponent;
import com.example.demo.Dto.PersonDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;



@SpringBootTest
public class DiTests {

    @Autowired
    private PersonComponent personComponent;
    @Test
    public void t1(){
        System.out.println(personComponent);
    }

    @Autowired
    private PersonDto personDto;
    @Test
    public void t2(){
        System.out.println(personDto);
    }

    @Autowired
    private PersonDto person03;
    @Test
    public void t3(){
        System.out.println(person03);
    }

    @Autowired
    private PersonDto personBean;
    @Test
    public void t4(){
        System.out.println(personBean);
    }

    @Autowired
    private ApplicationContext applicationContext;
    @Test
    public void t5(){
        System.out.println(applicationContext.getBean("personBean"));
        System.out.println(applicationContext.getBean("person03"));
    }

}