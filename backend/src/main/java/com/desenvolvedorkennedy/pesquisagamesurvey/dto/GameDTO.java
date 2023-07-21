package com.desenvolvedorkennedy.pesquisagamesurvey.dto;

import java.io.Serializable;

import com.desenvolvedorkennedy.pesquisagamesurvey.entities.Game;
import com.desenvolvedorkennedy.pesquisagamesurvey.entities.enums.Platform;

public class GameDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String title;
    private Platform platform;

    public GameDTO() {
    }

    public GameDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.platform = entity.getPlatform();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Platform getPlatform() {
        return this.platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

}
