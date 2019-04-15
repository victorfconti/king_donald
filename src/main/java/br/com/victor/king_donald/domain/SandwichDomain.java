package br.com.victor.king_donald.domain;

import br.com.victor.king_donald.model.Sandwich;
import br.com.victor.king_donald.repository.SandwichRepository;
import org.springframework.stereotype.Service;

@Service
public class SandwichDomain extends AbstractDomain<Sandwich> {

    public SandwichDomain(SandwichRepository sandwichSandwichRepository){
        super(sandwichSandwichRepository);
    }

}
