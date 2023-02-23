package com.example.monitor.controller;


import com.example.monitor.DAO.MonitorDaoJdbc;
import com.example.monitor.domain.Monitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitor")
public class MonitorController {
    @Autowired
    MonitorDaoJdbc monitorDao;

    @GetMapping
    public ResponseEntity<List<Monitor>> list(){

        return new ResponseEntity<>(monitorDao.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Monitor> get(@PathVariable int id) {
        return new ResponseEntity<>(monitorDao.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Monitor monitor) {
        monitorDao.save(monitor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Monitor monitor) {
        monitor.setId(id);
        monitorDao.update(monitor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        monitorDao.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
