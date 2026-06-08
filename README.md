Sistema de Cadastro de Clientes e de Contatos.

### ÍNDICE
- [Sobre o Projeto](#-sobre-o-projeto)
- [Regras de Arquitetura & Restrições](#-regras-de-arquitetura--restrições)
- [Arquitetura de Dados (Modelagem das Matrizes)](#-arquitetura-de-dados-modelagem-das-matrizes)
- [Funcionalidades do Ecossistema](#-funcionalidades-do-ecossistema)
- [Como Executar o Projeto](#-como-executar-o-projeto)

------
### Sobre o Projeto

O sistema consiste em uma aplicação interativa desenvolvida em Java Console, que realiza o gerenciamento de cadastro de clientes e de seus múltiplos meios de contatos. Mapeando assim, o relacionamneto de um para muitos, permitindo que um cliente disponha de diferentes meios de contatos vinculados a ele.  
O grande diferencial do nosso projeto está em sua arquitetura, descantando o uso de bancos de dados ou da API nativa de Collections do Java, como no caso de ArrayList. Em vez disso, toda a persistência e manipulação dos dados foram construídas do zero através de matrizes bidimensionais, utilizando algoritmos puros para realocação dinâmica de memória, busca textual e ordenação manual.

------
### Regras de Arquitetura & Restrições

Para garantir as boas práticas de engenharia de software baseada em escopo isolado, o sistema adota as seguintes diretrizes:

* *Zero Variáveis Globais:* Nenhuma variável de classe (static fields) foi utilizada para armazenamento, as matrizes de dados nascem e residem no método main.
* *Comunicação por Parâmetros:* Os menus e as funções operacionais comunicam-se de forma pura por meio de *passagem de parâmetros* e *retorno de estado* de matrizes.
* *Redimensionamento Dinâmico Manual:* Para simular listas dinâmicas, os métodos aumentarMatriz e aumentoMatriz clonam a matriz antiga em um novo bloco de memória com tamanho variando em N+1 ou N-1 posições a cada inserção ou deleção.
* *Algoritmo Customizado de Ordenação:* A classificação alfabética descarta métodos nativos (como Sort), portanto foi implementado um algoritmo que faz a varredura e comparação caractere por caractere (charAt()) para ordenar os blocos de strings da matriz.

------
### Funcionalidades do Ecossistema

<b>Módulo de Clientes (CRUD & Buscas)</b>
* *Inclusão Dinâmica:* Criação física de novas posições sob demanda.
* *Validação de Entrada:* Filtro em tempo de execução que recusa documentos fora do padrão nacional.
* *Consulta Customizada:* Busca direta por ID e busca parcial por nome (utilizando varredura inteligente com contains e normalização de strings).
* *Remoção com Compactação de Célula:* Exclusão que reconstrói a matriz, ignorando o elemento deletado e limpando referências nulas da memória.
* *Ordenação Alfabética Nativa:* Classificação alfabética de registros de ponta a ponta sem bibliotecas externas.

<b>Módulo de Contatos (Vínculos & Segmentação)</b>
* *Cadastro Assistido:* Lista os clientes existentes para garantir a consistência do vínculo relacional do contato.
* *Menus Inteligentes:* Seleção facilitada do tipo de contato por teclado numérico com tratamento de loops de segurança para dados inválidos.
* *Filtros e Consultas:* Permite listar todos os registros globais ou isolar especificamente os canais associados a um único cliente.
* *Modificação Dinâmica:* Atualização pontual do tipo de contato e do valor da string preservando as amarrações do ID original.


------
### Executar o Projeto

<b>Pré-requisitos</b>
* Possuir o *Java JDK 11* (ou superior) instalado e configurado nas variáveis de ambiente do seu sistema operacional.