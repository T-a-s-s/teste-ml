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
 ```json
 {

"dna": ["CCCCAA", "AGTACA", "ACGCAT", "AACGTG", "GACAGA", "GGACCC"]

}
 ```
 
## Construção da API
Para construir a API você necessita de:
- Git: https://git-scm.com/downloads
- Java SE Development Kit 8: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
- Apache Maven : https://maven.apache.org/download.cgi#

Após realizar o download e instalação das ferramentas acima, você poderá clonar o repositório com o seguinte comando:
```
git clone https://github.com/T-a-s-s/teste-ml.git
```
Navegue para a pasta criada com o comando acima e execute o seguinte comando para construir o projeto:
```
mvn clean install
```
Agora com o projeto construído, navegue para a pasta target, e lá você encontrará o jar do projeto.

## Executar o projeto
Com o jar construído você deverá implantá-lo em um ambiente AWS para executá-lo.

Neste caminho você encontra o nível gratúito AWS onde você poderá implantar o projeto: https://aws.amazon.com/pt/free

Crie um ambiente no Elastic Beanstalk: https://us-west-2.console.aws.amazon.com/elasticbeanstalk
Doc de como realizar esta tarefa: https://docs.aws.amazon.com/pt_br/elasticbeanstalk/latest/dg/using-features.environments.html

Após o ambiente criado, você deverá criar um banco de dados mysql na amazon RDS: https://us-west-2.console.aws.amazon.com/rds
Doc de como realizar esta tarefa: https://docs.aws.amazon.com/pt_br/opsworks/latest/userguide/customizing-rds-connect-create.html

Você deverá conceder acesso ao grupo de segurança que seu banco de dados utiliza para que seu ip consiga conectar neste, verifique o grupo de acesso que seu banco de dados possui em seguida leia este manual de como realizar a tarefa: https://docs.aws.amazon.com/pt_br/AWSEC2/latest/UserGuide/using-network-security.html

Para que a aplicação consiga configurar o ambiente enquanto é executada você deverá dar as devidas permissões de acesso ao role específico que sua aplicação possuirá, o spring boot irá reconhecer este role automaticamente, porém você precisará conceder as devidas permissões de acesso ao role em: https://console.aws.amazon.com/iam/home?region=us-west-2#/roles

Agora basta realizar o deploy do jar criado no passo de construção do projeto.

Siga para o painel do Elastic Beanstalk da instância criada na AWS e aperte o botão *Fazer Upload e Implantar* e aguarde a finalização da implantação.

Pronto sua app se encontra em execução, siga para o caminho: http://<aws-endpoint>/v1/health para validar se app foi implantada com sucesso.
 
 Exemplo: http://mutant-dev.us-west-2.elasticbeanstalk.com/v1/health
 
 Bom proveito.
 
