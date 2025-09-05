package com.example.demo.Component;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PersonComponent {
    private String name;
    private int age;
    private String addr;
    PersonComponent(){
        this.name="홍길동";
        this.age = 50;
        this.addr="대구";
    }
}