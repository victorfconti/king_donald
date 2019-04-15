package br.com.victor.king_donald.domain;

import br.com.victor.king_donald.model.Ingredient;
import br.com.victor.king_donald.repository.IngredientRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredientDomain extends AbstractDomain<Ingredient>{

    public IngredientDomain(IngredientRepository ingredientRepository){
        super(ingredientRepository);
    }
}
