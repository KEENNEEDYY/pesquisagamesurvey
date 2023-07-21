package com.desenvolvedorkennedy.pesquisagamesurvey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desenvolvedorkennedy.pesquisagamesurvey.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    
}
