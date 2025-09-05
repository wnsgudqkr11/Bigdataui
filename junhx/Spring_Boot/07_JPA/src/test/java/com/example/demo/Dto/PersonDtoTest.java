package com.example.demo.Dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonDtoTest {

    @Test
    public void t1(){
        PersonDto dto = new PersonDto("홍길동", 50, "대구");
        System.out.println(dto);
    }

    @Test
    public void t2(){
        PersonDto dto = PersonDto.builder()
                .age(20)
                .name("티모")
                .build();
        System.out.println(dto);
    }
}