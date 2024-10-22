package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.dto.CreatePocket;
import fr.efrei.pokemon.dto.UpdatePocket;
import fr.efrei.pokemon.models.Pocket;
import fr.efrei.pokemon.services.PocketService;
import fr.efrei.pokemon.services.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pockets")
public class PocketController {

    private final PocketService pocketService;

    public PocketController(PocketService pocketService) {
        this.pocketService = pocketService;
    }

    @GetMapping()
    public ResponseEntity<List<Pocket>> findAllPockets() {
        return new ResponseEntity<>(pocketService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pocket> findPocketById(@PathVariable String id) {
        Pocket pocket = pocketService.findById(id);
        if(pocket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pocket, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreatePocket pocket){
        pocketService.save(pocket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        Pocket pocket = pocketService.findById(id);
        if(pocket == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pocketService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody UpdatePocket pocketBody){
        Pocket pocket = pocketService.findById(id);
        if(pocket == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pocketService.update(id, pocketBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
