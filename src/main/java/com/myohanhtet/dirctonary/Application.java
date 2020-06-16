package com.myohanhtet.dirctonary;

import com.myohanhtet.dirctonary.controller.MainController;
import com.myohanhtet.dirctonary.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
@Sql({"schema.sql", "data.sql"})
public class Application {

    @Autowired
    private static CSVService fileService;

    public static void main(String[] args){

        SpringApplication.run(Application.class, args);

    }

}