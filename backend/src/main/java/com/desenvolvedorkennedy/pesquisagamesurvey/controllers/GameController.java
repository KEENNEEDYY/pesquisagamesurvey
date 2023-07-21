package com.desenvolvedorkennedy.pesquisagamesurvey.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvedorkennedy.pesquisagamesurvey.dto.GameDTO;
import com.desenvolvedorkennedy.pesquisagamesurvey.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService service;
    
    @GetMapping
    public ResponseEntity<List<GameDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
}
