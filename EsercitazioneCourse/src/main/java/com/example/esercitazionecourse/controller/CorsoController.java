package com.example.esercitazionecourse.controller;

import com.example.esercitazionecourse.domain.Corso;
import com.example.esercitazionecourse.repository.CorsoRepository;
import jakarta.annotation.Nonnull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class CorsoController {
    private final CorsoRepository corsoRepository;

    public CorsoController(CorsoRepository corsoRepository) {

        this.corsoRepository = corsoRepository;
    }
    @GetMapping("/corso")
    public ResponseEntity<Corso> getCorso() {
        Corso corso = new Corso(4, "corso_psicologia", "Corso secondo anno");
        return new ResponseEntity<Corso>(corso, HttpStatus.OK);
    }
    @PostMapping("/corso")
    public ResponseEntity<?> creaCorso(@RequestBody Corso corso) throws Exception {
        List<Corso> corsi = corsoRepository.findAll();
        HashMap<String, String> hash = new HashMap<>();
        hash.put("Error", "duplicate");
        for (Corso c : corsi) {
            if (c.getId() == corso.getId()) {
                return new ResponseEntity<>(hash, HttpStatus.OK);
            }
        }
        corsoRepository.save(corso);
        return new ResponseEntity<>(corso, HttpStatus.CREATED);
    }
    @PostMapping("/corso1")
    public ResponseEntity<?> creaCorso1(@RequestBody Corso corso) {
        if (corso.getNome().contains("corso_") && corso.getNome().length() > 8) {
            corsoRepository.save(corso);
            return new ResponseEntity<>(corso, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(corso, HttpStatus.NO_CONTENT);
    }
    @GetMapping("/corso3")
    public ResponseEntity<?> resituisciNumero() {
        List<Corso> corsi = corsoRepository.findAll();
        return new ResponseEntity<>(corsi.size(), HttpStatus.OK);
    }
    @GetMapping("/corso4")
    public ResponseEntity<?> resituisciNumero1() {
        List<Corso> corsi = corsoRepository.findAll();
        int k = 0;
        for (Corso c : corsi) {
            if (c.getNome().toLowerCase().contains("corso_")) {
                k++;
            }
        }
        return new ResponseEntity<>(k, HttpStatus.OK);
    }
    @DeleteMapping("/corso/{id}")
    public ResponseEntity<?> deleteCorso(@PathVariable int id, Corso corso) {
        System.out.println("Corso: " + id);
        corsoRepository.delete(corso);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/corsi")
    public ResponseEntity<?> getCorsi() {
        List<Corso> corsiList = corsoRepository.findAll();
        return new ResponseEntity<>(corsiList, HttpStatus.OK);
    }
    @GetMapping("/corso5")
    public ResponseEntity<?> getCorsiDescr() {
        List<Corso> corsiList = corsoRepository.findAll();
        List<Corso> corsiDesc= new ArrayList<>();
        for (Corso c : corsiList) {
            if(c.getDescrizione().length() < 20){
                corsiDesc.add(c);
            }
        }
        return new ResponseEntity<>(corsiDesc, HttpStatus.OK);
    }
}