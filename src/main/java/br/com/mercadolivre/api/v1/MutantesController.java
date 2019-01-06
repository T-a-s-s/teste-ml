package br.com.mercadolivre.api.v1;

import br.com.mercadolivre.dto.MutantRequest;
import br.com.mercadolivre.dto.StatsDto;
import br.com.mercadolivre.entity.Dna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.mercadolivre.service.MutantService;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class MutantesController {
	
	private MutantService mutantService;

	@Autowired
	MutantesController(MutantService mutantService) {
		this.mutantService = mutantService;
	}

	@GetMapping("/health")
	public String healthCheck() {
		return "Status : UP";
	}
	
	@PostMapping("/mutants")
	@ResponseStatus(HttpStatus.OK)
	public void isMutant(@RequestBody MutantRequest dna) {
		mutantService.isMutant(dna.getDna());
	}

	@GetMapping("/mutants")
	@ResponseStatus(HttpStatus.OK)
	public List<Dna> getMutants() {
		return mutantService.getMutants();
	}

	@GetMapping("/mutants/stats")
	@ResponseStatus(HttpStatus.OK)
	public StatsDto getStats() {
		return mutantService.getStats();
	}
}
