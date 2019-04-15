package br.com.victor.king_donald.controller;

import br.com.victor.king_donald.domain.PromotionDomain;
import br.com.victor.king_donald.model.Promotion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promotion")
public class PromotionController extends AbstractControllerCrud<Promotion>{

    public PromotionController(PromotionDomain promotion){
        super(promotion);
    }

}
