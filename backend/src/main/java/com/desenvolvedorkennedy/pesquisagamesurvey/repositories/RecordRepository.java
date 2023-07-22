package com.desenvolvedorkennedy.pesquisagamesurvey.repositories;

import java.time.Instant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desenvolvedorkennedy.pesquisagamesurvey.entities.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    
    Page<Record> findByMomentBetweenOrderByMomentDesc(Instant startMoment, Instant endMoment, Pageable pageable);

    @Query("SELECT obj FROM Record obj WHERE" 
        + "(:min IS NULL OR obj.moment >= :min) AND"
        + "(:max IS NULL OR obj.moment <= :max)")
    Page<Record> findByMoments(@Param("min") Instant min,@Param("max")  Instant max, Pageable pageable);

    @Query("SELECT MIN(r.moment) FROM Record r")
    Instant findMinMoment();

    @Query("SELECT MAX(r.moment) FROM Record r")
    Instant findMaxMoment();

    @Query(nativeQuery = true, value = 
        "SELECT obj.* FROM tb_record obj "
        + "WHERE (:min IS NULL OR obj.moment >= :min) AND (:max IS NULL OR obj.moment <= :max) "
        + "ORDER BY obj.moment DESC OFFSET :offset ROWS FETCH NEXT :pageSize ROWS ONLY")
    Page<Record> findByMomentsSql(@Param("min") Instant min, 
                        @Param("max") Instant max, 
                        @Param("offset") int offset, 
                        @Param("pageSize") int pageSize, 
                        @Param("pageable") Pageable pageable);
}
