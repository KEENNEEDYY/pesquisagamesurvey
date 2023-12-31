package com.desenvolvedorkennedy.pesquisagamesurvey.dto;

import java.io.Serializable;
import java.time.Instant;

import com.desenvolvedorkennedy.pesquisagamesurvey.entities.Record;
import com.desenvolvedorkennedy.pesquisagamesurvey.entities.enums.Platform;

public class RecordDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private Instant moment;
    private String name;
    private Integer age;
    private String gameTitle;
    private Platform gamePlatform;
    private String genreName;

    public RecordDTO() {
    }
    
    public RecordDTO(Record entity) {
        this.id= entity.getId();
        this.moment = entity.getMoment();
        this.name = entity.getName();
        this.age = entity.getAge();
        this.gameTitle = entity.getGame().getTitle();
        this.gamePlatform = entity.getGame().getPlatform();
        this.genreName = entity.getGame().getGenre().getName();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return this.moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
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

    public String getGameTitle() {
        return this.gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public Platform getGamePlatform() {
        return this.gamePlatform;
    }

    public void setGamePlatform(Platform gamePlatform) {
        this.gamePlatform = gamePlatform;
    }

    public String getGenreName() {
        return this.genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
    
}
