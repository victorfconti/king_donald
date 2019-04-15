package br.com.victor.king_donald.controller;


import br.com.victor.king_donald.domain.SandwichDomain;
import br.com.victor.king_donald.model.Sandwich;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class SandwichController extends AbstractControllerCrud<Sandwich>{

    public SandwichController(SandwichDomain menuSandwichRepository){
        super(menuSandwichRepository);
    }


}
