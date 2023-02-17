package com.example.eseciziomonitor.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Canale {
    private String nome;
    private int numero;
    private EState state;
}
