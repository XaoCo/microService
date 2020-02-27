package com.cpllz.the16th;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.cpllz.the16th.*")
@MapperScan("com.cpllz.the16th.mapper")
public class The16thApplication {

    public static void main(String[] args) {
        SpringApplication.run(The16thApplication.class, args);
    }

}
