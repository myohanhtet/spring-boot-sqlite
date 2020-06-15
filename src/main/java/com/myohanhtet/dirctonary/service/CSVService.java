package com.myohanhtet.dirctonary.service;

import com.myohanhtet.dirctonary.helper.CSVHelper;
import com.myohanhtet.dirctonary.model.Dictionary;
import com.myohanhtet.dirctonary.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CSVService {
    @Autowired

    DictionaryRepository dictionaryRepository;

    public void save(MultipartFile file){

        try {
            List<Dictionary> dictionaries = CSVHelper.csvToDictionary(file.getInputStream());

            dictionaryRepository.save(dictionaries);

        } catch (IOException e){

            throw new RuntimeException("fail to store csv data: " + e.getMessage());

        }

    }

}
