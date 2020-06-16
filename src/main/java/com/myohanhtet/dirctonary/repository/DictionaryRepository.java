package com.myohanhtet.dirctonary.repository;

import com.myohanhtet.dirctonary.model.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Documented;
import java.util.List;

//CrudRepository<Dictionary, Long>
//JpaRepository<Dictionary, Long>
@Repository
public interface DictionaryRepository extends CrudRepository<Dictionary, Long> {

//    List<Dictionary> findByWord_enContaining(String en);

}
