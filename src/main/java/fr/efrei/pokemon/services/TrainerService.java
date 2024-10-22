package fr.efrei.pokemon.services;

import fr.efrei.pokemon.dto.CreateTrainer;
import fr.efrei.pokemon.dto.UpdateTrainer;
import fr.efrei.pokemon.models.Pokemon;
import fr.efrei.pokemon.models.Trainer;
import fr.efrei.pokemon.repositories.TrainerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepository repository;
    private final PokemonService pokemonService;

    public TrainerService(TrainerRepository repository, PokemonService pokemonService) {
        this.repository = repository;
        this.pokemonService = pokemonService;
    }

    public List<Trainer> findAll() {
        return repository.findAll();
    }

    public Trainer findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void save(CreateTrainer trainerBody) {
        Trainer trainer = new Trainer();
        trainer.setName(trainerBody.getName());
        List<String> pokemonIds = trainerBody.getTeam();
        List<Pokemon> pokemonAAjouter = new ArrayList<>();
        for (String pokemonId : pokemonIds) {
            Pokemon pokemon = pokemonService.findById(pokemonId);
            if(pokemon != null) {
                pokemonAAjouter.add(pokemon);
            }
        }
        trainer.setTeam(pokemonAAjouter);

        repository.save(trainer);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }


    @Transactional
    public void update(String id, UpdateTrainer trainerBody) {
        Trainer trainer = findById(id);
        if(trainerBody.getName() != null) {
            trainer.setName(trainerBody.getName());
        }
        if(!trainerBody.getTeam().isEmpty() && trainerBody.getTeam() != null) {
            List<Pokemon> pokemonList = new ArrayList<>();
            List<String> pokemonIds = trainerBody.getTeam();
            for(String pokemonId : pokemonIds) {
                Pokemon pokemon = pokemonService.findById(pokemonId);
                if(pokemon != null) {
                    pokemonList.add(pokemon);
                }
            }
            pokemonList.addAll(trainer.getTeam());
            trainer.setTeam(pokemonList);
        }

        repository.save(trainer);
    }

}
