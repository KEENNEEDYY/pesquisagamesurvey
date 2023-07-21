package com.desenvolvedorkennedy.pesquisagamesurvey.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvedorkennedy.pesquisagamesurvey.entities.Record;
import com.desenvolvedorkennedy.pesquisagamesurvey.dto.RecordDTO;
import com.desenvolvedorkennedy.pesquisagamesurvey.dto.RecordInsertDTO;
import com.desenvolvedorkennedy.pesquisagamesurvey.repositories.RecordRepository;
import com.desenvolvedorkennedy.pesquisagamesurvey.repositories.GameRepository;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public RecordDTO insert(RecordInsertDTO dto) {
        Record entity = new Record();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setMoment(Instant.now());
        entity.setGame(gameRepository.getReferenceById(dto.getGameId()));
        return new RecordDTO(recordRepository.save(entity));
    }
    
}
