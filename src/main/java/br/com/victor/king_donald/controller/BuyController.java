package br.com.victor.king_donald.controller;

import br.com.victor.king_donald.domain.BuyDomain;
import br.com.victor.king_donald.model.Sandwich;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buy")
public class BuyController {
    private BuyDomain buyDomain;

    public BuyController(BuyDomain buyDomain){
        this.buyDomain = buyDomain;
    }

    @PostMapping
    public ResponseEntity buy(@RequestBody Sandwich sandwich){
        return buyDomain.buy(sandwich);
    }

    @PostMapping(params = "id")
    public ResponseEntity byu(@RequestParam Long id){
        return buyDomain.buy(id);
    }

}
