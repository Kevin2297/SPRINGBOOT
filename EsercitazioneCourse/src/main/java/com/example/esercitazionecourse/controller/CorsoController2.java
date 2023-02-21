package com.example.esercitazionecourse.controller;

import com.example.esercitazionecourse.domain.Corso;
import com.example.esercitazionecourse.repository.CorsoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CorsoController2 {
    private final CorsoRepository corsoRepository;

    public CorsoController2(CorsoRepository corsoRepository) {
        this.corsoRepository = corsoRepository;
    }

    @GetMapping("/corso2/{id}")
    public ResponseEntity<?> findAll(@PathVariable("id") int id_numero) {
        List<Corso> corsoList = corsoRepository.findAll();
        for (Corso c : corsoList) {
            if (c.getId() == id_numero) {
                return new ResponseEntity<>(c, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(corsoList, HttpStatus.NO_CONTENT);
    }
}