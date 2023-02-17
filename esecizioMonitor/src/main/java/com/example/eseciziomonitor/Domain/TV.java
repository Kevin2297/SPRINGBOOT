package com.example.eseciziomonitor.Domain;

import com.example.eseciziomonitor.Domain.Canale;
import com.example.eseciziomonitor.Domain.EState;
import com.example.eseciziomonitor.Domain.Monitor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
public class TV extends Monitor {
    private List<Canale> canali = new ArrayList<>();
    private LocalTime ora;

    public TV() {

        super();
    }

    public TV(String colore, String marca) {

        super();
    }

    public TV(String colore, String marca, LocalTime ora, Canale... canali) {

        this.ora = ora;
        setColore(colore);
        setMarca(marca);
        this.canali = Arrays.asList(canali);
    }

    public void checkChannels() throws Exception {

        boolean[] b = new boolean[1];

        canali.forEach(canale -> {

            if (canale.getState().equals(EState.SELECTED)) {

                b[0] = true;
            }
        });

        if (!b[0]) throw new Exception("Nessun canale selezionato.");

        for (Canale canale : canali) {
            if (canale.getNome() == null || canale.getNome().equals("")) {

                throw new NullPointerException("Canale senza nome");
            }
        }
    }

    public void risintonizza() {
        Collections.shuffle(canali);
        canali.forEach(canale -> canale.setState(EState.NOT_SELECTED));
        canali.get(0).setState(EState.SELECTED);
    }

    public void removeCanale(String nome) {

        canali.forEach(canale -> {

            if (canale.getNome().equals(nome)) {

                canali.remove(canale);
            }
        });
    }

    public List<Canale> getCanali() {
        return canali;
    }

    public void setCanali(List<Canale> canali) {
        this.canali = canali;
    }



    public void turnTvOn() {

        System.out.println("tv accesa");
    }


    public void changeChannel(int i) {

        boolean b = false;

        for (Canale canale : getCanali()) {
            canale.setState(EState.NOT_SELECTED);
            if (canale.getNumero() == i) {

                canale.setState(EState.SELECTED);
                b = true;
            }
        }
    }
}
