# Vehicle Catalog Java API
<hr>
<h2>Sumário desta Documentação</h2>
<ul>
  <li><a href="#rodando">Rodando o projeto na sua máquina</a></li>
  <li><a href="#config">Configurões de banco de dados</a></li>
  <li><a href="#pipeline">Pipeline</a></li>
  <li><a href="#docker">Rodando o projeto com Docker</a></li>
  <li><a href="#rodando">Rodando o projeto na sua máquina</a></li>
  <li><a href="#config">Configurões do banco de dados</a></li>
  <li><a href="#rel">Acessando o projeto como administrador</a></li>
  <li><a href="#doc">Documentação da API com Swagger UI</a></li>
  <li><a href="#contr">Como contribuir</a></li>
</ul>
<hr>

<div id="docker"><div>
  
## Rodando o projeto com Docker é a forma que eu recomendo
  
  1. <b>docker pull pedroluiznogueira/vehicle-catalog-api:0.0.2-SNAPSHOT</b>
  2. <b>docker run -p 8080:8080 pedroluiznogueira/vehicle-catalog-api:0.0.2-SNAPSHOT</b>
  4. Abra outro <b>terminal</b>
  3. <b>docker ps</b>, a imagem do projeto estará rodando em um container
  4. Em seu browser acesse <b>http://localhost:8080/swagger-ui.html</b>
  5. Se a interface do Swagger com a documentação da API aparecer, tudo ocorreu bem e o projeto está pronto para uso local
<hr>

<div id="pipeline"><div>
  
## Pipeline

- Caso queira acessar a branch de produção do projeto, acesse a branch <a href="https://github.com/pedroluiznogueira/vehicle-catalog-java/tree/master">master</a>
- Ela está configurada com o pipeline para fazer deploy contínuo
- A branch utilizada em desenvolvimento contínuo é a branch <a href="https://github.com/pedroluiznogueira/vehicle-catalog-java/tree/developer">developer</a> 
<hr>

<div id="rodando"><div>
  
## Como rodar este projeto na sua máquina local

1. git clone https://github.com/pedroluiznogueira/sps-react.git
2. Abra o projeto clonado em sua IDE/Editor de texto de preferência
3. Abra a pasta do projeto no terminal
4. Digite "npm install" e aperte enter
5. git fetch
6. git checkout <b>release/v.1.1</b> (essa é a branch do projeto finalizado configurado para rodar localmente)
7. Rode o projeto
<hr>

<div id="config"><div>
  
##  Configurões de banco de dados 

-> A branch <b>release/v.1.1</b> está configurada para rodar com um banco h2 em memória <br>
-> Quando o projeto é iniciado alguns dados já são persistidos por meio de um script <br>
-> É necessário fazer registro de usuário e login <br>

<div id="rel"><div>
    
## Acessando o projeto como administrador
  
1. Se registre como qualquer <b>email</b> e <b>password</b>, mas no campo <b>name</b> é necessário escrever <b>admin</b><br>
2. Faça login com o <b>email</b> e <b>password</b> que você se registrou
3. Você verá os ícones que dão acesso ao painel de administrador
<hr>

<div id="doc"><div>
  
## Documentação da API podendo ser acessar no Swagger UI

-> Após rodar a aplicação, acesse: <b>http://localhost:8080/swagger-ui.html</b> <br>
<hr>

<div id="contr"><div>
  
## Contribuições

-> Sinta-se livre para abrir contribuir para esse projeto seguindo os seguintes passos:

1. Dê <b>Fork</b> neste projeto
2. Faça suas mudanças e suba-às para o seu repositório forkeado
3. Abra um Pull Request para a branch <b>DEVELOPER</b> deste projeto

<hr>
