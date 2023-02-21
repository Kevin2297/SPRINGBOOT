package com.example.esercitazionecourse.repository;

import com.example.esercitazionecourse.domain.Corso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorsoRepository extends JpaRepository<Corso, Long> {
}