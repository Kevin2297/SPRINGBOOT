package com.example.monitor.DAO;


import com.example.monitor.domain.Monitor;
import com.example.monitor.mapper.MonitorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MonitorDaoJdbc {

    private JdbcTemplate jdbcTemplate;


    public MonitorDaoJdbc (JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Monitor> findAll() {

        return jdbcTemplate.query("SELECT * FROM elenco", new MonitorRowMapper());
    }

    public Monitor findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM elenco WHERE id = ?", new Object[] { id }, new MonitorRowMapper());
    }

    public void save(Monitor monitor) {
        jdbcTemplate.update("INSERT INTO elenco (marca, colore) VALUES (?, ?)", monitor.getMarca(), monitor.getColore());
    }

    public void update(Monitor monitor) {
        jdbcTemplate.update("UPDATE elenco SET marca = ?, colore = ? WHERE id = ?", monitor.getMarca(), monitor.getColore(), monitor.getId());
    }

    public void delete(int id) {

        jdbcTemplate.update("DELETE FROM elenco WHERE id = ?", id);
    }

}

