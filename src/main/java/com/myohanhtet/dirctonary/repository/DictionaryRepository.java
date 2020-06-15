package com.myohanhtet.dirctonary.repository;

import com.myohanhtet.dirctonary.model.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
//CrudRepository<Dictionary, Long>
public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {

}
