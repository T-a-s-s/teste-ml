package br.com.mercadolivre.repository;


import br.com.mercadolivre.entity.Dna;
import org.springframework.data.repository.CrudRepository;

public interface MutantRepository extends CrudRepository<Dna, String> {

}
