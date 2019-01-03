package br.com.mercadolivre.test.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.mercadolivre.service.MutantService;
import br.com.mercadolivre.service.impl.MutantServiceImpl;

@Configuration
public class ProjetoMutantesTestContext {
	
	@Bean
	public MutantService mutantService() {
		return new MutantServiceImpl();
	}

}
