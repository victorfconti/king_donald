package br.com.victor.king_donald.repository;

import br.com.victor.king_donald.model.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SandwichRepository  extends JpaRepository<Sandwich, Long> {

}
