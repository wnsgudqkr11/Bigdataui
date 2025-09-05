package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

//@Getter
//@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Component
public class PersonDto {
    private String name;
    private int age;
    private String addr;
}