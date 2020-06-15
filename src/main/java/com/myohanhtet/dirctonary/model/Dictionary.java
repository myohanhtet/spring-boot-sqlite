package com.myohanhtet.dirctonary.model;

import javax.persistence.*;

@Entity
@Table(name = "dictionary")
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "word")
    private String word_en;

    @Column(name = "state")
    private String state;

    @Column(name = "def")
    private String def;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWord_en() {
        return word_en;
    }

    public void setWord_en(String word_en) {
        this.word_en = word_en;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public Dictionary(String word_en, String state, String def) {
        this.word_en = word_en;
        this.state = state;
        this.def = def;
    }
}
