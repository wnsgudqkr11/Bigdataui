package com.example.demo.Config;

import com.example.demo.Dto.PersonDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonDtoConfig {

    @Bean
    public PersonDto person03(){
        return PersonDto.builder()
                .name("Zephyr")
                .addr("Daegu")
                .age(25)
                .build();
    }
    @Bean(name = "personBean")
    public PersonDto person04() {
        return PersonDto.builder()
                .name("Bella")
                .addr("Jeonju")
                .age(26)
                .build();
    }


}