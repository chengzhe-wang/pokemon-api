package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.dto.CreateTrainer;
import fr.efrei.pokemon.dto.UpdateTrainer;
import fr.efrei.pokemon.models.Trainer;
import fr.efrei.pokemon.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController
{
    private final TrainerService service;
    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService service, TrainerService trainerService){
        this.service = service;
        this.trainerService = trainerService;
    }

    @GetMapping
    public ResponseEntity<List<Trainer>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> findById(@PathVariable String id){
        Trainer trainer = service.findById(id);
        if(trainer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(trainer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateTrainer trainer){
        service.save(trainer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        Trainer trainer = service.findById(id);
        if(trainer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody UpdateTrainer trainerBody){
        Trainer trainer = trainerService.findById(id);
        if(trainer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(id, trainerBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
