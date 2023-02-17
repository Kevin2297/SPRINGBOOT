package com.example.eseciziomonitor.Domain;

import com.example.eseciziomonitor.Domain.Monitor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class MonitorUfficio extends Monitor {
    private Set<String> inputs;

    public MonitorUfficio() {

        super();
    }

    public MonitorUfficio(String colore, String marca) {

        setColore(colore);
        setMarca(marca);
    }

    public MonitorUfficio(String colore, String marca, Set<String> inputs) {
        this.inputs = inputs;

        setColore(colore);
        setMarca(marca);
        this.inputs = inputs;
    }

    public Set<String> getInputs() {
        return inputs;
    }

    public void setInputs(Set<String> inputs) {
        this.inputs = inputs;
    }

    public void addInput(String input)  {
        if (!inputs.contains(input)) {

            inputs.add(input);
        }  //ignore

    }
}
