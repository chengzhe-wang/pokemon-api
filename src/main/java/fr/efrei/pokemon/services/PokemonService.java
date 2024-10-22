package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Pokemon;
import fr.efrei.pokemon.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }


    public List<Pokemon> findAll(){
        return pokemonRepository.findAll();
    }

    public Pokemon findById(String id){
        return pokemonRepository.findById(id).orElse(null);
    }

    public void save(Pokemon pokemon){
        pokemonRepository.save(pokemon);
    }

    public void delete(String id){
        pokemonRepository.deleteById(id);
    }

    public void update(String id, Pokemon pokemonBody){
        Pokemon pokemonAModifier = findById(id);
        pokemonAModifier.setType(pokemonBody.getType());
        pokemonAModifier.setName(pokemonBody.getName());
        pokemonAModifier.setLevel(pokemonBody.getLevel());
        pokemonAModifier.setHp(pokemonBody.getHp());
        pokemonRepository.save(pokemonAModifier);
    }

    public void partialUpdate(String id, Pokemon pokemonBody){
        Pokemon pokemonAModifier = findById(id);
        if(pokemonBody.getType() != null){
            pokemonAModifier.setType(pokemonBody.getType());
        }
        if(pokemonBody.getName() != null){
            pokemonAModifier.setName(pokemonBody.getName());
        }
        if(pokemonBody.getLevel() != 0){
            pokemonAModifier.setLevel(pokemonBody.getLevel());
        }
        if(pokemonBody.getHp() != 0){
            pokemonAModifier.setHp(pokemonBody.getHp());
        }
        pokemonRepository.save(pokemonAModifier);
    }
}