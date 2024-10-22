package fr.efrei.pokemon.services;

import fr.efrei.pokemon.dto.CreatePocket;
import fr.efrei.pokemon.dto.UpdatePocket;
import fr.efrei.pokemon.dto.UpdateTrainer;
import fr.efrei.pokemon.models.Bag;
import fr.efrei.pokemon.models.Pocket;
import fr.efrei.pokemon.models.Pokemon;
import fr.efrei.pokemon.models.Trainer;
import fr.efrei.pokemon.repositories.PocketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PocketService {
    private final PocketRepository pocketRepository;

    public PocketService(PocketRepository pocketRepository) {
        this.pocketRepository = pocketRepository;
    }

    public List<Pocket> findAll(){
        return pocketRepository.findAll();
    }

    public Pocket findById(String id) {
        return pocketRepository.findById(id).orElse(null);
    }

    public void save(CreatePocket pocketBody) {
        Pocket pocket = new Pocket();
        pocket.setName(pocketBody.getName());
        pocket.setCapacity(pocketBody.getCapacity());
        if(pocket.getCapacity() < 1){
            pocket.setCapacity(1);
        }

//        String bagId = pocketBody.getBag();
//        Bag bag = bagService.findById(bagId);
//        if(bag != null) {
//            pocket.setBag(bag);
//        }
        pocketRepository.save(pocket);

    }

    public void update(String id, UpdatePocket pocketBody) {
        Pocket pocket = findById(id);
        if(pocketBody.getName() != null) {
            pocket.setName(pocketBody.getName());
        }
        if(pocketBody.getCapacity() > 0) {
            pocket.setCapacity(pocketBody.getCapacity());
        }


//        if(pocketBody.getBag() != null) {
//            String bagId = pocketBody.getBag();
//            Bag bag = bagService.findById(bagId);
//            if(bag != null) {
//                pocket.setBag(bag);
//            }
//        }
        pocketRepository.save(pocket);
    }

    public void delete(String id) {
        pocketRepository.deleteById(id);
    }
}
