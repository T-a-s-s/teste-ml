package br.com.mercadolivre.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DNA")
public class Dna {

    public Dna (String dna, boolean isMutant) {
        this.dna = dna;
        this.isMutant = isMutant;
    }

    public Dna () {}

    @Id
    @Column(name="DNA")
    String dna;

    @Column(name="IS_MUTANT")
    boolean isMutant;

}
