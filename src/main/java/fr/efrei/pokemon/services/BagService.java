package fr.efrei.pokemon.services;

import fr.efrei.pokemon.dto.CreateBag;
import fr.efrei.pokemon.dto.UpdateBag;
import fr.efrei.pokemon.dto.UpdatePocket;
import fr.efrei.pokemon.models.Bag;
import fr.efrei.pokemon.models.Pocket;
import fr.efrei.pokemon.models.Trainer;
import fr.efrei.pokemon.repositories.BagRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BagService {

    private final BagRepository bagRepository;
    private final TrainerService trainerService;
    private final PocketService pocketService;

    public BagService(BagRepository bagRepository, TrainerService trainerService, PocketService pocketService) {

        this.bagRepository = bagRepository;
        this.trainerService = trainerService;
        this.pocketService = pocketService;
    }

    public List<Bag> findAll(){

        return bagRepository.findAll();
    }

    public Bag findById(String id){

        return bagRepository.findById(id).orElse(null);
    }

    public void save(CreateBag bagBody){
        Bag bag = new Bag();
        bag.setCapacity(bagBody.getCapacity());
        if(bag.getCapacity() < 1){
            bag.setCapacity(1);
        }

        //Set Trainer
        String trainerId = bagBody.getTrainer();
        Trainer trainer = trainerService.findById(trainerId);
        if(trainer != null) {
            bag.setTrainer(trainer);
        }

        //Set Pockets
        List<String> pocketIds = bagBody.getPocket();
        List<Pocket> pocketsAAjouter = new ArrayList<>();
        for(String pocketId : pocketIds){
            Pocket pocket = pocketService.findById(pocketId);
            if(pocket != null) {
                pocketsAAjouter.add(pocket);
            }
        }
        bag.setPocket(pocketsAAjouter);

        bagRepository.save(bag);

    }

    public void update(String id, UpdateBag bagBody) {
        Bag bag = findById(id);
        if(bagBody.getCapacity() > 0) {
            bag.setCapacity(bagBody.getCapacity());
        }

        //Update Trainer
        if(bagBody.getTrainer() != null) {
            String trainerId = bagBody.getTrainer();
            Trainer trainer = trainerService.findById(trainerId);
            if(trainer != null) {
                bag.setTrainer(trainer);
            }
        }

        //Update Pockets
        if(bagBody.getPocket() != null && !bagBody.getPocket().isEmpty()) {
            List<Pocket> pocketList = new ArrayList<>();
            List<String> pocketIds = bagBody.getPocket();
            for(String pocketId : pocketIds){
                Pocket pocket = pocketService.findById(pocketId);
                if(pocket != null) {
                    pocketList.add(pocket);
                }
            }
            pocketList.addAll(bag.getPocket());
            bag.setPocket(pocketList);
        }

        bagRepository.save(bag);
    }

    public void delete(String id){
        bagRepository.deleteById(id);
    }


}
