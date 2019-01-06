package br.com.mercadolivre.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DNA")
public class Dna {

    public Dna (String dna, boolean mutant) {
        this.dna = dna;
        this.mutant = mutant;
    }

    public Dna () {}

    @Id
    @Column(name="DNA")
    String dna;

    @Column(name="IS_MUTANT")
    @Getter
    boolean mutant;

}
