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
- Api que cria uma pauta.
- Api que abre uma sessão.
- Api que lista os votos realizados.
- Documentação da api com swagger - link: http://localhost:8080/swagger-ui.html#/




## :gear: Funcionalidades:

- [X] Cadastrar afiliado.
- [X] Listar votos.
- [X] Criar uma pauta.
- [X] Iniciar uma sessão.

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

