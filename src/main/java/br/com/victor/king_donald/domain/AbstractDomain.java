package br.com.victor.king_donald.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Optional;

public abstract class AbstractDomain <T extends Serializable> {

    private JpaRepository<T, Long> repository;

    AbstractDomain(JpaRepository<T, Long> repository){
        this.repository = repository;
    }

    public ResponseEntity<T> finddById(Long id){
        Optional<T> optional = repository.findById(id);
        if(!optional.isPresent())
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    public ResponseEntity<Page<T>> findAll(Pageable pageable){
        Page<T> page = repository.findAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    public ResponseEntity<Null> save(T t){
        repository.save(t);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Null> update(T t){
        repository.save(t);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<T> delete(Long id){
        Optional<T> optional = repository.findById(id);
        if(!optional.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        repository.deleteById(id);
        return new ResponseEntity<>(optional.get(), HttpStatus.OK);
    }

}
