package br.com.victor.king_donald.controller;

import br.com.victor.king_donald.domain.IngredientDomain;
import br.com.victor.king_donald.model.Ingredient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredient")
public class IngredientController extends AbstractControllerCrud<Ingredient> {

    public IngredientController(IngredientDomain ingredientDomain){
        super(ingredientDomain);
    }


}
