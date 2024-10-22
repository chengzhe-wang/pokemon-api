package fr.efrei.pokemon.repositories;

import fr.efrei.pokemon.models.Pocket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PocketRepository extends JpaRepository<Pocket, String> {

}
