package com.myohanhtet.dirctonary.controller;

import com.myohanhtet.dirctonary.model.Dictionary;
import com.myohanhtet.dirctonary.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/v1")
public class MainController {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String password){
        Dictionary n = new Dictionary();

        dictionaryRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Dictionary> getAllUsers(){
        return dictionaryRepository.findAll();
    }
}
