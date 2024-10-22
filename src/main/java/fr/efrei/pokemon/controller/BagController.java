package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.dto.CreateBag;
import fr.efrei.pokemon.dto.UpdateBag;
import fr.efrei.pokemon.models.Bag;
import fr.efrei.pokemon.models.Pocket;
import fr.efrei.pokemon.services.BagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bags")
public class BagController {

    private final BagService bagService;

    @Autowired
    public BagController(BagService bagService) {
        this.bagService = bagService;
    }

    @GetMapping()
    public ResponseEntity<List<Bag>> findAllBags() {
        return new ResponseEntity<>(bagService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bag> findBagById(@PathVariable String id) {
        Bag bag = bagService.findById(id);
        if(bag == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bag, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateBag bag){
        bagService.save(bag);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        Bag bag = bagService.findById(id);
        if(bag == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bagService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody UpdateBag bagBody){
        Bag bag = bagService.findById(id);
        if(bag == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bagService.update(id, bagBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
