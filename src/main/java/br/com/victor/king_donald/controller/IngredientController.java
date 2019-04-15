package br.com.victor.king_donald.controller;

import br.com.victor.king_donald.domain.IngredientDomain;
import br.com.victor.king_donald.model.Ingredient;
import org.springframework.web.bind.annotation.RestController;

@RestController("/ingredient")
public class IngredientController extends AbstractControllerCrud<Ingredient> {

    public IngredientController(IngredientDomain ingredientDomain){
        super(ingredientDomain);
    }


}
