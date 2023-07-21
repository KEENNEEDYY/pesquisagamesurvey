package com.desenvolvedorkennedy.pesquisagamesurvey.dto;

import java.io.Serializable;

import com.desenvolvedorkennedy.pesquisagamesurvey.entities.Record;

public class RecordInsertDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private String name;
    private Integer age;
    private Long gameId;

    public RecordInsertDTO() {
    }

    public RecordInsertDTO(Record entity) {
        this.name = entity.getName();
        this.age = entity.getAge();
        this.gameId = entity.getId();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getGameId() {
        return this.gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
    
}
