package fr.efrei.pokemon.repositories;

import fr.efrei.pokemon.models.Bag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagRepository extends JpaRepository<Bag, String> {

}
