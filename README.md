## Tecnologias utilizadas no projeto

- Java JDK 8 - [Java JDK 8](https://www.oracle.com/br/java/technologies/javase/javase8-archive-downloads.html)
- IDE de desenvolvimento (Sugestão) - [JetBrains IntelliJ IDEA Community](https://www.jetbrains.com/pt-br/idea/download/#section=windows)
- Framework de testes automatizados de API - [RestAssured](https://rest-assured.io/)
- Relatório de teste - [Extent Reports](https://www.extentreports.com/)
- Orquestrador de testes - [TestNG](https://testng.org/doc/)
- Biblioteca de geração de dados falsos e randômicos - [Java Faker](https://github.com/DiUS/java-faker)
- Facilitador de criação de objetos Java - [Lombok](https://projectlombok.org/)

## Abrindo o projeto (Baseado no uso do IntelliJ)

1. Baixar o projeto
2. Abrir IntelliJ 
3. Clicar em "File"
4. Clicar em "Open"
5. Selecinar a pasta raiz do projeto
6. Clicar em "OK"
7. O projeto será carregado e as dependências serão baixadas automaticamente. Aguardar até o fim.

## Arquitetura:

A arquitetura padrão composta por:

- `bases`: Pacote que contém as classes pai, que definem comportamentos ou contém implementações que serão extendidas pelas classes filhas. As existentes são:
  - **RequestRestBase:** Deve ser herdada por toda classe "request" que representará uma requisição de uma API REST
  - **TestBase:** Deve ser herdada por toda classe "test".
- `jsonObjects`: Paconte que contém as classes que representam os objetos json que serão utilizados para serializar os contratos (body) das requisições;
- `requests`: Pacote que contém as classes que representam as requisições (endpoints ou serviços) da API que será testada;
- `steps`: Paconte de classes que contém métodos que executam alguma request da API ou e uma API externa para serem utilizados como arranjo do teste;
- `tests`: Pacote de classes que contém os métodos de teste;
- `utils`: Pacote que contém classes com utilitários das teconlogias utilizadas no template, as existentes são:
  - **ExtentReportsUtils:** Contém os métodos que implementam o relatório de testes.
  - **GeneralUtils:** Contém métodos que podem ser utilizados em qualquer ponto do código e não estão ligados à uma tecnologia específica, ex: métodos para formatar json, métodos para manipulação de datas, métodos para gerar cpf etc.
  - **RestAssuredUtils:** Contém os métodos que são o motor de execução das requisições através do RestAssured
- `GlobalParameters.java`: Classe que representa os parâmetros globais do projeto;
- `globalParameters.properties`: Arquivo de configuração dos parâmetros globais do projeto;
- `pom.xml`: Arquivo de configuração do Maven, utilizado para incluir bibliotecas no projeto e definir os procedimentos de build;

## Relatório de testes:
Sempre que um ou mais testes são executados um relatório da execução é gerado na pasta indicada na variável "report.path" do arquivo "globalParameters.properties" (valor defaul é target/reports).
Para abrir o relatório, basta navegar para a pasta que contém o realtório da execução e abrir (através do browser) o arquivo .html com o nome do relatório










