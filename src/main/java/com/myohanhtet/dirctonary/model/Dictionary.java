package com.myohanhtet.dirctonary.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@ToString
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String word_en;

    private String state;

    private String def;

    public Dictionary(String word_en, String state, String def) {
        this.word_en = word_en;
        this.state = state;
        this.def = def;
    }
}
