package com.desenvolvedorkennedy.pesquisagamesurvey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desenvolvedorkennedy.pesquisagamesurvey.entities.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    
}
