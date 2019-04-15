package br.com.victor.king_donald.domain;

import br.com.victor.king_donald.model.*;
import br.com.victor.king_donald.repository.BuyRepository;
import br.com.victor.king_donald.repository.PromotionRepository;
import br.com.victor.king_donald.repository.SandwichRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BuyDomain {
    private JpaRepository<Buy, Long> buyRepository;
    private JpaRepository<Sandwich, Long> sandwichRepository;
    private JpaRepository<Promotion, Long> promotionRepository;
    private Double discount = 0d;

    public BuyDomain(BuyRepository buyRepository, SandwichRepository sandwichRepository,
                     PromotionRepository promotionRepository){
        this.buyRepository = buyRepository;
        this.sandwichRepository = sandwichRepository;
        this.promotionRepository = promotionRepository;
    }

    public ResponseEntity<Buy> buy(Long id){

        Optional<Sandwich> optional = sandwichRepository.findById(id);

        if(!optional.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return buy(optional.get());
    }

    public ResponseEntity<Buy> buy(Sandwich sandwich){

        Buy buy = new Buy();
        buy.setBuyDate(LocalDateTime.now());
        buy.setPrice(calculatePrice(sandwich));

        buyRepository.saveAndFlush(buy);

        return new ResponseEntity<>(buy, HttpStatus.OK);
    }

    private Double calculateDiscount(Sandwich sandwich){
        List<Promotion> promotions = promotionRepository.findAll();

        promotions.forEach(p->{
            if(p.getDontHasIngredient() == null)
                if(!sandwich.getIngredients().contains(p.getDontHasIngredient()))
                    return;

            if(p.getHasIngredient() == null || !sandwich.getIngredients().contains(p.getHasIngredient()) ||
                p.getForEachNumber() > sandwich.getIngredients().stream().filter(r->p.getId().equals(r.getId())).count())
                return;

            if(p.getDiscountType() == DiscountType.PERCENTAGE) {

                Optional<Double> price = sandwich.getIngredients().stream().map(Ingredient::getPrice).reduce((m, n) -> m + n);

                if (!price.isPresent())
                    throw new IllegalArgumentException();

                discount = price.get() * 0.10;
            } else if(p.getDiscountType() == DiscountType.PART){
                int quantity = Long.valueOf(sandwich.getIngredients().stream().filter(r->p.getId().equals(r.getId())).count()).intValue() % p.getForEachNumber();

                discount = quantity * sandwich.getIngredients().stream().filter(r->p.getId().equals(r.getId())).findAny().get().getPrice();
            }
        });

        return discount;
    }

    private Double calculatePrice(Sandwich sandwich){
        Double discount = calculateDiscount( sandwich);
        Optional<Double> price = sandwich.getIngredients().stream().map(Ingredient::getPrice).reduce((p,n)->p+n);

        if(!price.isPresent())
            throw new IllegalArgumentException();

        return price.get() - discount;
    }
}
