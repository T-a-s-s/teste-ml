package br.com.mercadolivre.service;

import br.com.mercadolivre.dto.StatsDto;
import br.com.mercadolivre.entity.Dna;

import java.util.List;

public interface MutantService {

	public boolean isMutant(String[] dna);

    public List<Dna> getMutants();

    StatsDto getStats();
}
