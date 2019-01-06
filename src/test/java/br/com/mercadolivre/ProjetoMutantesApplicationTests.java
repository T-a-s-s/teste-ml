package br.com.mercadolivre;

import static org.junit.Assert.assertTrue;

import br.com.mercadolivre.api.exception.ForbiddenException;
import br.com.mercadolivre.dto.StatsDto;
import br.com.mercadolivre.repository.MutantRepository;
import br.com.mercadolivre.service.impl.MutantServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.mercadolivre.service.MutantService;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ProjetoMutantesApplicationTests {

	@Autowired
	private MutantRepository mutantRepository;
	private MutantService mutantService;

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

	@Test(expected = ForbiddenException.class)
	public void isNotMutantTest() {

		String [] dna = {"ATGCAT", "GATCTA", "TAGGAC", "CCAGCA", "CAGGAC", "ACCACC"};
		mutantService.isMutant(dna);

	}

	@Test
	public void ratioTest(){

		String [] dna = {"CTGAGA", "CTGAGC", "TATTGT", "AGAGGG", "CCCCTA", "TCACTG"};
		mutantService.isMutant(dna);
		String [] dna2 = {"CCCCAA", "AGTACA", "ACGCAT", "AACGTG", "GACAGA", "GGACCC"};
		mutantService.isMutant(dna2);
		String [] dna3 = {"ATGACA", "AATCTG", "GACTGA", "ACTGTA", "CATGGA", "AGTAGT"};
		mutantService.isMutant(dna3);
		try {
			String[] dna4 = {"ATGCAT", "GATCTA", "TAGGAC", "CCAGCA", "CAGGAC", "ACCACC"};
			mutantService.isMutant(dna4);
		} catch (Exception e) {
			//segue o processamento com o 403 Forbidden sendo tratado
		}
		StatsDto statsDto = mutantService.getStats();
		System.out.println("stats ratio = " + statsDto.getRatio());
		assertTrue(statsDto.getRatio() == 75.0F);

	}
	

}

