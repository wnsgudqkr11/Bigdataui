package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonDto {
    private String name;
    private int age;
    private String addr;
}