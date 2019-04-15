package br.com.victor.king_donald.controller;

import br.com.victor.king_donald.domain.AbstractDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.io.Serializable;

public abstract class AbstractControllerCrud <T extends Serializable>{

    private AbstractDomain<T> abstractDomain;

    public  AbstractControllerCrud(AbstractDomain<T> abstractDomain){
        this.abstractDomain = abstractDomain;
    }

    @GetMapping(params = "id")
    public ResponseEntity<T> get(@RequestParam("id") Long id){
        return abstractDomain.finddById(id);
    }

    @GetMapping
    public ResponseEntity<Page<T>> get(Pageable pageable){
        return abstractDomain.findAll(pageable);
    }

    @PostMapping
    public ResponseEntity<Null> post(@RequestBody T t){
        return abstractDomain.save(t);
    }

    @PutMapping
    public ResponseEntity<Null> put(@RequestBody T t){
        return abstractDomain.update(t);
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<T> put(@RequestParam Long id){
        return abstractDomain.delete(id);
    }

}
