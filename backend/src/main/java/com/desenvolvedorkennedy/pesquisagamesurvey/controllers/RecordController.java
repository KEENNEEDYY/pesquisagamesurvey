package com.desenvolvedorkennedy.pesquisagamesurvey.controllers;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvedorkennedy.pesquisagamesurvey.dto.RecordDTO;
import com.desenvolvedorkennedy.pesquisagamesurvey.dto.RecordInsertDTO;
import com.desenvolvedorkennedy.pesquisagamesurvey.services.RecordService;

@RestController
@RequestMapping(value = "/records")
public class RecordController {

    @Autowired
    private RecordService service;
    
    @PostMapping
    public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto){
        return ResponseEntity.ok().body(service.insert(dto));
    }

   @GetMapping
    public ResponseEntity<Page<RecordDTO>> findAll(
        @RequestParam(value = "min", defaultValue = "") String min,
        @RequestParam(value = "max", defaultValue = "") String max,
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
        @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
        @RequestParam(value = "direction", defaultValue = "DESC") String direction
    ){
        Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
        Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);

        if (linesPerPage == 0 ) {
            linesPerPage = Integer.MAX_VALUE;
        }

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return ResponseEntity.ok().body(service.findByMomentsBetweenOrder(minDate, maxDate, pageRequest));
    }
}
