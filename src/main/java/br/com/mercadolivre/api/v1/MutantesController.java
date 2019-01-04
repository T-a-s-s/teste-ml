package br.com.mercadolivre.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.mercadolivre.service.MutantService;

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
	
	@PostMapping("/mutant")
	@ResponseStatus(HttpStatus.OK)
	public void isMutant(@RequestBody String[] dna) {
		mutantService.isMutant(dna);
	} 
}
