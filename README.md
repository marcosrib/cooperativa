# Cooperativa

## :page_with_curl: Ídice: 
  - [Descrição do projeto:](#memo-descrição-do-projeto)
  - [Funcionalidades:](#gear-funcionalidades)
  - [Bibliotecas utilizadas:](#file_folder-bibliotecas-utilizadas)
  -  [Banco de dados:](#floppy_disk-banco-de-dados)
  - [Como executar:](#arrow_forward-como-executar)

## :memo: Descrição do projeto:

Projeto desenvolvido para gerenciamento de pautas e votações de uma cooperativa.

Este projeto foi desenvolvido com java e spring boot.


 Propósito de criação:
 
- Api que cadastre um afiliado.
     Antes de criar um afiliado o cpf é validado através de uma api externa. 
- Api lista afiliados
- Api que cria uma pautas
- Api lista pauta.
- Api que abre uma sessão.
- Api que lista os votos realizados.
- Documentação da api com swagger - link: http://localhost:8080/swagger-ui.html#/
- Versionamento da api pela url no modelo path por ser mais simples é melhor entendimento.
- Utilizar o SonarLint para melhoraria do código.




 Escolhas tomadas durante a criação do projeto:
 
- O projeto foi desenvolvido com spring boot por ser um framework simples e prático para criar um projeto.
- O projeto foi desenvolvido com o cadastro de um afiliado com a validação do cpf na criação, onde ao efetuar a votação o cpf já está validado. 
- Foi criado o castro da pauta e start da sessão na mesma tabela, utilizando o campo booleano para verificar se a sessão já havia sido iniciada.
- O afiliado pode votar uma vez por pauta, mas em várias pautas diferentes.
- Foi criado apis para listar os votos, puatas e afiliados.


## :gear: Funcionalidades:

- [X] Cadastrar afiliado.
- [X] Listar votos.
- [X] Criar uma pauta.
- [X] Iniciar uma sessão.
- [X] Listar afiliados.
- [X] Listar Pautas.

## :file_folder: Bibliotecas utilizadas: 
- SpringFox.
- H2DataBase
## :floppy_disk: Banco de dados: 
- H2 Database.
## :arrow_forward: Como executar:
No terminal clone o projeto.
```
git clone https://github.com/marcosrib/gobarber-backend.git
```
Entre na pasta do projeto e instale as dependências executando.
```
yarn ou npm install
```
Para rodar o projeto execute.

```
yarn dev:server
```

