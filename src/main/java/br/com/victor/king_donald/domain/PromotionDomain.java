package br.com.victor.king_donald.domain;

import br.com.victor.king_donald.model.Promotion;
import br.com.victor.king_donald.repository.PromotionRepository;
import org.springframework.stereotype.Service;

@Service
public class PromotionDomain extends AbstractDomain<Promotion>{

    public PromotionDomain(PromotionRepository repository){
        super(repository);
    }

}
