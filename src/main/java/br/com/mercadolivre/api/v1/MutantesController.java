package br.com.mercadolivre.api.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolivre.service.MutantService;

@RestController
public class MutantesController {
	
	private MutantService mutantService;
	
	MutantesController(MutantService mutantService) {
		this.mutantService = mutantService;
	}
	
	@PostMapping("/mutant")
	@ResponseStatus(HttpStatus.OK)
	public void isMutant(@RequestBody String[] dna) {
		mutantService.isMutant(dna);
	} 
}
