package br.com.mercadolivre.service.impl;

import br.com.mercadolivre.api.exception.ForbiddenException;
import br.com.mercadolivre.dto.StatsDto;
import br.com.mercadolivre.repository.MutantRepository;
import br.com.mercadolivre.entity.Dna;
import br.com.mercadolivre.service.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tomas Anderson Souza Silva
 * 
 * Serviço de validação de dna mutante.
 * Um dna será mutante se existerem duas sequências de caracteres repetidos,
 * em qualquer sentido dos seguintes: horizontal, vertical ou diagonal.
 */
@Service
public class MutantServiceImpl implements MutantService {

	MutantRepository mutantRepository;

	@Autowired
	public MutantServiceImpl (MutantRepository mutantRepository) {
		this.mutantRepository = mutantRepository;
	}

	@Override
	public boolean isMutant(String[] dna) {
		
		int howManySequences = 0;
		
		//valida se nas sequências horizontais possuem caracteres repetidos 4 vezes seguidas
		if(checkSequenceInString(dna[0].toCharArray()))
			howManySequences++;
		
		if(checkSequenceInString(dna[1].toCharArray()))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}
		
		if(checkSequenceInString(dna[2].toCharArray())) 
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}
		
		if(checkSequenceInString(dna[3].toCharArray())) 
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}
		
		if(checkSequenceInString(dna[4].toCharArray())) 
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}
		
		if(checkSequenceInString(dna[5].toCharArray())) 
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}
		
		//inicia os arrays de caracteres utilizados para armazenar as linhas que precisam ser validadas
		char[] vertical0 = new char[6];
		char[] vertical1 = new char[6];
		char[] vertical2 = new char[6];
		char[] vertical3 = new char[6];
		char[] vertical4 = new char[6];
		char[] vertical5 = new char[6];
		char[] diagonalRight0 = new char[6];
		char[] diagonalRight1 = new char[6];
		char[] diagonalRight2 = new char[6];
		char[] diagonalRight3 = new char[6];
		char[] diagonalRight4 = new char[6];
		char[] diagonalLeft0 = new char[6];
		char[] diagonalLeft1 = new char[6];
		char[] diagonalLeft2 = new char[6];
		char[] diagonalLeft3 = new char[6];
		char[] diagonalLeft4 = new char[6];
		
		//monta as linhas verticais e diagonais para futura validação
		for (int i = 0; i < dna.length; i++) {
			switch (i) {
			case 0:
				for(int j = 0; j < dna[i].length(); j++)  {
					switch (j) {
					case 0:
						vertical0[j] = dna[i].charAt(j);
						diagonalRight2[0] = dna[i].charAt(j);
						break;
					case 1:
						vertical0[j] = dna[i].charAt(j);
						diagonalRight3[0] = dna[i].charAt(j);
						break;
					case 2:
						vertical0[j] = dna[i].charAt(j);
						diagonalRight4[0] = dna[i].charAt(j);
						break;
					case 3:
						vertical0[j] = dna[i].charAt(j);
						diagonalLeft0[0] = dna[i].charAt(j);
						break;
					case 4:
						vertical0[j] = dna[i].charAt(j);
						diagonalLeft1[0] = dna[i].charAt(j);
						break;
					case 5:
						vertical0[j] = dna[i].charAt(j);
						diagonalLeft2[0] = dna[i].charAt(j);
						break;
					default:
						break;
					}
				}
				break;
			case 1:
				for(int j = 0; j < dna[i].length(); j++)  {
					switch (j) {
					case 0:
						vertical1[j] = dna[i].charAt(j);
						diagonalRight1[0] = dna[i].charAt(j);
						break;
					case 1:
						vertical1[j] = dna[i].charAt(j);
						diagonalRight2[1] = dna[i].charAt(j);
						break;
					case 2:
						vertical1[j] = dna[i].charAt(j);
						diagonalRight3[1] = dna[i].charAt(j);
						diagonalLeft0[1] = dna[i].charAt(j);
						break;
					case 3:
						vertical1[j] = dna[i].charAt(j);
						diagonalRight4[1] = dna[i].charAt(j);
						diagonalLeft1[1] = dna[i].charAt(j);
						break;
					case 4:
						vertical1[j] = dna[i].charAt(j);
						diagonalLeft2[1] = dna[i].charAt(j);
						break;
					case 5:
						vertical1[j] = dna[i].charAt(j);
						diagonalLeft3[0] = dna[i].charAt(j);
						break;
					default:
						break;
					}
				}
				break;
			case 2:
				for(int j = 0; j < dna[i].length(); j++)  {
					switch (j) {
					case 0:
						vertical2[j] = dna[i].charAt(j);
						diagonalRight0[0] = dna[i].charAt(j);
						break;
					case 1:
						vertical2[j] = dna[i].charAt(j);
						diagonalRight1[1] = dna[i].charAt(j);
						diagonalLeft0[2] = dna[i].charAt(j);
						break;
					case 2:
						vertical2[j] = dna[i].charAt(j);
						diagonalRight2[2] = dna[i].charAt(j);
						diagonalLeft1[2] = dna[i].charAt(j);
						break;
					case 3:
						vertical2[j] = dna[i].charAt(j);
						diagonalRight3[2] = dna[i].charAt(j);
						diagonalLeft2[2] = dna[i].charAt(j);
						break;
					case 4:
						vertical2[j] = dna[i].charAt(j);
						diagonalRight4[2] = dna[i].charAt(j);
						diagonalLeft3[1] = dna[i].charAt(j);
						break;
					case 5:
						vertical2[j] = dna[i].charAt(j);
						diagonalLeft4[0] = dna[i].charAt(j);
						break;
					default:
						break;
					}
				}
				break;
			case 3:
				for(int j = 0; j < dna[i].length(); j++)  {
					switch (j) {
					case 0:
						vertical3[j] = dna[i].charAt(j);
						diagonalLeft0[3] = dna[i].charAt(j);
						break;
					case 1:
						vertical3[j] = dna[i].charAt(j);
						diagonalRight0[1] = dna[i].charAt(j);
						diagonalLeft1[3] = dna[i].charAt(j);
						break;
					case 2:
						vertical3[j] = dna[i].charAt(j);
						diagonalRight1[2] = dna[i].charAt(j);
						diagonalLeft2[3] = dna[i].charAt(j);
						break;
					case 3:
						vertical3[j] = dna[i].charAt(j);
						diagonalRight2[3] = dna[i].charAt(j);
						diagonalLeft3[2] = dna[i].charAt(j);
						break;
					case 4:
						vertical3[j] = dna[i].charAt(j);
						diagonalRight3[3] = dna[i].charAt(j);
						diagonalLeft4[1] = dna[i].charAt(j);
						break;
					case 5:
						vertical3[j] = dna[i].charAt(j);
						diagonalRight4[3] = dna[i].charAt(j);
						break;
					default:
						break;
					}
				}
				break;
			case 4:
				for(int j = 0; j < dna[i].length(); j++)  {
					switch (j) {
					case 0:
						vertical4[j] = dna[i].charAt(j);
						diagonalLeft1[4] = dna[i].charAt(j);
						break;
					case 1:
						vertical4[j] = dna[i].charAt(j);
						diagonalLeft2[4] = dna[i].charAt(j);
						break;
					case 2:
						vertical4[j] = dna[i].charAt(j);
						diagonalRight0[2] = dna[i].charAt(j);
						diagonalLeft3[3] = dna[i].charAt(j);
						break;
					case 3:
						vertical4[j] = dna[i].charAt(j);
						diagonalRight1[3] = dna[i].charAt(j);
						diagonalLeft4[2] = dna[i].charAt(j);
						break;
					case 4:
						vertical4[j] = dna[i].charAt(j);
						diagonalRight2[4] = dna[i].charAt(j);
						break;
					case 5:
						vertical4[j] = dna[i].charAt(j);
						diagonalRight3[4] = dna[i].charAt(j);
						break;
					default:
						break;
					}
				}
				break;	
			case 5:
				for(int j = 0; j < dna[i].length(); j++)  {
					switch (j) {
					case 0:
						vertical5[j] = dna[i].charAt(j);
						diagonalLeft2[5] = dna[i].charAt(j);
						break;
					case 1:
						vertical5[j] = dna[i].charAt(j);
						diagonalLeft3[4] = dna[i].charAt(j);
						break;
					case 2:
						vertical5[j] = dna[i].charAt(j);
						diagonalLeft4[3] = dna[i].charAt(j);
						break;
					case 3:
						vertical5[j] = dna[i].charAt(j);
						diagonalRight0[3] = dna[i].charAt(j);
						break;
					case 4:
						vertical5[j] = dna[i].charAt(j);
						diagonalRight1[4] = dna[i].charAt(j);
						break;
					case 5:
						vertical5[j] = dna[i].charAt(j);
						diagonalRight2[5] = dna[i].charAt(j);
						break;
					default:
						break;
					}
				}
				break;
			default:
				break;
			}
		
		}
		
		//valida agora as sequências verticais e diagonais, para verifcar as sequências repetidas
		if(checkSequenceInString(vertical0))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		if(checkSequenceInString(vertical1))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		if(checkSequenceInString(vertical2))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		if(checkSequenceInString(vertical3))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		if(checkSequenceInString(vertical4))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		if(checkSequenceInString(vertical5))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		if(checkSequenceInString(diagonalRight0))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		if(checkSequenceInString(diagonalRight1))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		if(checkSequenceInString(diagonalRight2))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		if(checkSequenceInString(diagonalRight3))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		if(checkSequenceInString(diagonalRight4))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		if(checkSequenceInString(diagonalLeft0))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		if(checkSequenceInString(diagonalLeft1))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		if(checkSequenceInString(diagonalLeft2))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		if(checkSequenceInString(diagonalLeft3))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		if(checkSequenceInString(diagonalLeft4))
			howManySequences++;

		if(howManySequences == 2) {
			registerDnaIfUnic(dnaToString(dna), true);
			return true;
		}

		registerDnaIfUnic(dnaToString(dna), false);
		//se não encontrou duas sequências de 4 caracteres repetidos lança uma exceção de não mutante
		//com o http status 403 (FORBIDDEN)
		throw new ForbiddenException("Dna não mutante!!!");
	}

	/**
	 * Função que valida a existência de 4 caracteres repetidos em sequência no array de chars
	 * @param dnaChars
	 * @return boolean -> existe 4 caracteres repetidos no array de chars?
	 */
	private boolean checkSequenceInString(char[] dnaChars) {
		if(dnaChars[0] == dnaChars[3]) {
			if(dnaChars[0] == dnaChars[1] 
					&& dnaChars[1] == dnaChars[2]) return true;
		} else if (dnaChars[1] == dnaChars[4]){
			if(dnaChars[1] == dnaChars[2] 
					&& dnaChars[2] == dnaChars[3]) return true;
		} else if (dnaChars[2] == dnaChars[5]){
			if(dnaChars[2] == dnaChars[3] 
					&& dnaChars[3] == dnaChars[4]) return true;
		}
		return false;
	}

	private void registerDnaIfUnic(String dna, boolean isMutant) {
		try {
			mutantRepository.save(new Dna(dna, isMutant));
		} catch (DataIntegrityViolationException e) {
			//não faz nada, somente impede de gravar um registro duplicado
		}
	}

	private String dnaToString(String[] dna) {
		return new StringBuilder()
				.append(dna[0])
				.append(dna[1])
				.append(dna[2])
				.append(dna[3])
				.append(dna[4])
				.append(dna[5])
				.toString();
	}
	@Override
	public List<Dna> getMutants() {
		return mutantRepository.findAll();
	}

	@Override
	public StatsDto getStats() {
		List<Dna> dnas = mutantRepository.findAll();
		int mutantCount = 0;
		for (Dna dna : dnas) {
			if (dna.isMutant()){
				mutantCount++;
			}
		}
		StatsDto stats = new StatsDto();
		stats.setCountHumanDna(dnas.size());
		stats.setCountMutantDna(mutantCount);
		if(dnas.size() != 0) {
			stats.setRatio((mutantCount * 100) / dnas.size());
		} else {
			stats.setRatio(0);
		}
		return stats;
	}
}
