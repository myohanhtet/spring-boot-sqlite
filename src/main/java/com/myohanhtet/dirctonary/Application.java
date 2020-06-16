package com.myohanhtet.dirctonary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.jdbc.Sql;

@SpringBootApplication
@Sql({"schema.sql", "data.sql"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}