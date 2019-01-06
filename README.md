# THE MUTANT PROJECT

O projeto mutante é de sigilo absoluto, se você estiver lendo isto, certifique-se de que tem permissão para continuar a leitura.
Algum mutante pode estar vigiando-o enquanto isso.

Escolhi hospedar na AWS para praticar a utilização das ferramentas, obrigado pela oportunidade.

## API
Para validar e verificar o funcionamento da API visite:
http://mutant-dev.us-west-2.elasticbeanstalk.com/swagger-ui.html

Esta API conta com 4 métodos principais:

- Um serviço de health check: http://mutant-dev.us-west-2.elasticbeanstalk.com/v1/health (GET)
- Um serviço de listagem de dnas já validados se mutantes: http://mutant-dev.us-west-2.elasticbeanstalk.com/v1/mutants (GET)
- Um serviço de status de dnas com porcentagem de dnas mutantes: http://mutant-dev.us-west-2.elasticbeanstalk.com/v1/mutants/stats
- Um serviço de validação de dna mutante em: http://mutant-dev.us-west-2.elasticbeanstalk.com/v1/mutants (POST)
 Exemplo de Json para post de reconhecimento de dna:
 ´´´
 {

"dna": ["CCCCAA", "AGTACA", "ACGCAT", "AACGTG", "GACAGA", "GGACCC"]

}
 ´´´
 
## Construção da API
Para construir a API você necessita de:
- Git: https://git-scm.com/downloads
- Java SE Development Kit 8: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
- Apache Maven : https://maven.apache.org/download.cgi#

Após realizar o download e instalação das ferramentas acima, você poderá clonar o repositório com o seguinte comando:
´´´
git clone https://github.com/T-a-s-s/teste-ml.git
´´´
Navegue para a pasta criada com o comando acima e execute o seguinte comando para construir o projeto:
´´´
mvn clean install
´´´
Agora com o projeto construído, navegue para a pasta target, e lá você encontrará o jar do projeto.

## Executar o projeto
Com o jar construído você deve executar o seguinte comando para executá-lo:
´´´
java -jar <nome-do-jar-do-projeto>
´´´
