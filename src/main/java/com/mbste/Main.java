package com.mbste;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Mapper()
@SpringBootApplication
public class Main
{
    public static void main(String... mbst){
        SpringApplication.run(Main.class,mbst);
    }
}
