package com.myohanhtet.dirctonary.controller;

import com.myohanhtet.dirctonary.model.Dictionary;
import com.myohanhtet.dirctonary.model.ResponseDirctionary;
import com.myohanhtet.dirctonary.repository.DictionaryRepository;
import com.myohanhtet.dirctonary.service.CSVService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.mock.web.MockMultipartFile;

@Controller
@RequestMapping(path="/v1")
public class MainController {
    @Autowired
    DictionaryRepository dictionaryRepository;

    @Autowired
    CSVService fileService;

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String password){

        return "Saved";
    }

//    @PostMapping(path = "/entomm")
//    public List<Dictionary> en2mm(@RequestBody String en){
//
//       return dictionaryRepository.findByWord_enContaining(en);
//
//    }


    @GetMapping(path = "/upload")
    public String uploadDate() throws IOException {
        System.out.println("Upload Here");
        File file = new File("dblist.csv");

        MultipartFile multipartFile = new MockMultipartFile("dblist.csv",new FileInputStream(file));
            try {
                fileService.save(multipartFile);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }

            return "Success upload";

    }
}
