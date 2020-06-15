package com.myohanhtet.dirctonary.controller;

import com.myohanhtet.dirctonary.helper.CSVHelper;
import com.myohanhtet.dirctonary.model.Dictionary;
import com.myohanhtet.dirctonary.repository.DictionaryRepository;
import com.myohanhtet.dirctonary.service.CSVService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.mock.web.MockMultipartFile;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Autowired
    CSVService fileService;

//    @GetMapping(path="/add")
//    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String password){
//
//
//        dictionaryRepository.save(n);
//        return "Saved";
//    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Dictionary> getAllUsers(){
        return dictionaryRepository.findAll();
    }

    @GetMapping(path = "/upload")
    public String uploadDate() throws IOException {
        System.out.println("Upload Here");
        File file = new File("dblist.csv");
        FileInputStream input =new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("dblist.csv",new FileInputStream(file));


            try {
                fileService.save(multipartFile);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }

            return "Success upload";

    }
}
