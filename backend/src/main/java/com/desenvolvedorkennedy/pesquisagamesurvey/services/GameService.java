package com.desenvolvedorkennedy.pesquisagamesurvey.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvedorkennedy.pesquisagamesurvey.dto.GameDTO;
import com.desenvolvedorkennedy.pesquisagamesurvey.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameDTO> findAll(){
        return repository.findAll().stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
    }
}
