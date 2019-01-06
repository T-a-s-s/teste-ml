package br.com.mercadolivre.repository;


import br.com.mercadolivre.entity.Dna;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MutantRepository extends CrudRepository<Dna, String> {

    List<Dna> findAll();

}
