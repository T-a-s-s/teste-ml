package br.com.mercadolivre;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mercadolivre.service.MutantService;
import br.com.mercadolivre.test.context.ProjetoMutantesTestContext;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ProjetoMutantesTestContext.class)
@SpringBootTest
public class ProjetoMutantesApplicationTests {
	
	@Autowired
	public MutantService mutantService;
	
	@Test
	public void isMutantTest() {
		
		String [] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
		assertTrue(mutantService.isMutant(dna));
		String [] dna2 = {"CCCCAA", "AGTACA", "ACGCAT", "AACGTG", "GACAGA", "GGACCC"};
		assertTrue(mutantService.isMutant(dna2));
		String [] dna3 = {"ATGACA", "AATCTG", "GACTGA", "ACTGTA", "CATGGA", "AGTAGT"};
		assertTrue(mutantService.isMutant(dna3));
		
	}
	

}

