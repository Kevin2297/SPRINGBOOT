package com.example.eseciziomonitor.Controller;
import com.example.eseciziomonitor.Domain.Canale;
import com.example.eseciziomonitor.Domain.Monitor;
import com.example.eseciziomonitor.Domain.MonitorUfficio;
import com.example.eseciziomonitor.Domain.TV;
import com.example.eseciziomonitor.Domain.EState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
@RestController
public class HomeController {
    @GetMapping("/tv")
    public ResponseEntity<TV> getTV() {
        TV tv = new TV("Nero", "LG", LocalTime.now(), new Canale("Italia1", 6, EState.SELECTED));
        return new ResponseEntity<TV>(tv, HttpStatus.OK);
    }
    @GetMapping("/monitorufficio")
    public ResponseEntity<MonitorUfficio> getMonitorUfficio() {
        Set<String> inputs = new HashSet<>();
        inputs.add("On");
        MonitorUfficio monitorufficio = new MonitorUfficio("Nero", "Dell", inputs);
        return new ResponseEntity<MonitorUfficio>(monitorufficio, HttpStatus.OK);
    }
    @PostMapping("/postmonitorufficio")
    public ResponseEntity<?> createMonitoruff(@RequestBody MonitorUfficio monitorufficio) {
        MonitorUfficio monitorufficio1 = monitorufficio;
        return new ResponseEntity<>(monitorufficio1, HttpStatus.CREATED);
    }
    @PutMapping("/monitor/{id}")
    public ResponseEntity <?> updateMonitor(@PathVariable ("id") long id_monitor, @RequestBody Monitor monitor) {
        Monitor monitor1 = new Monitor("Nero","samsung",1);
        if(monitor1.getId() == id_monitor)
            return new ResponseEntity<>(monitor1, HttpStatus.CREATED);
        return new ResponseEntity<>(monitor,HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/monitor/{id}")
    public ResponseEntity<?> deleteMonitor (@PathVariable long id){
        System.out.println("Monitor: " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/canale/{numero}")
    public ResponseEntity<?> updateCanale(@PathVariable ("numero") long numero_canale, @RequestBody Canale canale){
        Canale canale1 = new Canale("Italia1", 6, EState.SELECTED);
        if(canale1.getNumero() == numero_canale )
            return new ResponseEntity<>(canale1,HttpStatus.CREATED);
        return new ResponseEntity<>(canale,HttpStatus.NO_CONTENT);
    }
    @GetMapping("/risintonizza")
    public ResponseEntity<?> risintonizzaCanali(){
        TV tv = new TV("Blu","Philips",LocalTime.now(),new Canale("Rai 3", 3, EState.SELECTED),new Canale("Rai 2", 2, EState.NOT_SELECTED));
        tv.risintonizza();
        return new ResponseEntity<>(tv,HttpStatus.OK);
    }
    @DeleteMapping("/rimuovicanale/{numero}")
    public ResponseEntity<?> deletecanale (@PathVariable long numero){
        System.out.println("Canale: " + numero);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/aggiungicanale")
    public ResponseEntity<?> createCanale(@RequestBody Canale canale) {
        Canale canale1 = canale;
        return new ResponseEntity<>(canale1, HttpStatus.CREATED);
    }
}
