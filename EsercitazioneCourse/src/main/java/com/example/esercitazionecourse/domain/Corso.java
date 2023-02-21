package com.example.esercitazionecourse.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "corso")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Corso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    private String nome;

    private String descrizione;

}