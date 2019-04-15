package br.com.victor.king_donald.repository;

import br.com.victor.king_donald.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
