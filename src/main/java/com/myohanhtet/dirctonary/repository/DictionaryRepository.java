package com.myohanhtet.dirctonary.repository;

import com.myohanhtet.dirctonary.model.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//CrudRepository<Dictionary, Long>
//JpaRepository<Dictionary, Long>

public interface DictionaryRepository extends CrudRepository<Dictionary, Long> {

    Dictionary findByWord(String en);
}
