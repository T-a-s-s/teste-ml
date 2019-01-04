package br.com.mercadolivre;

import static org.junit.Assert.assertTrue;

import br.com.mercadolivre.repository.MutantRepository;
import br.com.mercadolivre.service.impl.MutantServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.mercadolivre.service.MutantService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjetoMutantesApplicationTests {
	
	public MutantService mutantService;
	@MockBean(name = "mutantRepository")
	public MutantRepository mutantRepository;

	@Before
	public void setUp() throws Exception {
		this.mutantService = new MutantServiceImpl(mutantRepository);
	}
	
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

