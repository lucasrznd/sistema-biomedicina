<p align="center">
  <img width="380" height="216" src="https://github.com/lucasrznd/sistema-biomedicina/blob/main/src/main/resources/META-INF/resources/img/sisges.png">
</p>

<div align="center">

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
</div>

<p align="center">
 <a href="#description">Descrição</a> • 
 <a href="#features">Funcionalidades</a> • 
 <a href="#installation">Instalação</a> •
 <a href="#contribution">Contribuição</a> 
</p>

<h2 id="description">📙 Descrição</h2> Este é um projeto destinado a criar um sistema de gestão de sorologia em parceria com o curso de biomedicina do Centro Universitário das Faculdades Integradas de Ourinhos. O sistema de sorologia é essencial para o armazenamento e controle de soros e amostras de pacientes, e este sistema visa simplificar e automatizar o processo de registro e gerenciamento de pacientes, sua fenotipagem, anticorpos e ampolas associadas.

<h2 id="features">✨ Funcionalidades</h2>

- **Cadastro de Pacientes**: Registra informações detalhadas sobre os pacientes, incluindo dados pessoais, fenotipagem e anticorpos.
- **Cadastro de Ampolas**: Permite o registro de informações específicas sobre as ampolas associadas a cada paciente, como data de coleta, tipo de amostra, condições de armazenamento, entre outros.
- **Listagem de Ampolas e Pacientes**: Fornece uma maneira prática de visualizar e buscar informações sobre ampolas e pacientes registrados.

### Tecnologias Utilizadas

- **Backend**: Desenvolvido em Java com Spring Initializer, Spring Data e Hibernate.
- **Frontend**: Desenvolvido utilizando JSF (JavaServer Faces) e PrimeFaces.

<h2 id="installation">🛠️ Instalação</h2>

1. Clone o repositório para o seu ambiente local:

```
git clone https://github.com/lucasrznd/sistema-biomedicina.git
```

2. Navegue até o diretório do projeto:

```
cd sistema-biomedicina
```

3. Construa a imagem Docker:

```
docker build -t biomed .
```

5. Inicie a aplicação usando Docker Compose:

```
docker-compose up -d
```

<h2 id="contribution">🤝 Contribuição</h2>

Contribuições são bem-vindas! Se você tiver sugestões, melhorias ou encontrar bugs, sinta-se à vontade para abrir uma issue ou enviar um pull request.

<h2 id="authors">👨🏻‍💻 Autores</h2>

<table>
  <tbody>
    <tr>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/lucasrznd"><img src="https://avatars.githubusercontent.com/u/101664450?v=4&v=" width="115px;" alt="Lucas Rezende"/><br /><sub><b>Lucas Rezende</b></sub></a><br/><a title="Code">💻</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/zZ-LeoZin-Zz"><img src="https://avatars.githubusercontent.com/u/88119600?v=4" width="115px;" alt="Leonardo Hermes"/><br /><sub><b>Leonardo Hermes</b></sub></a><br/><a title="Code">💻</a></td>
  </tbody>
</table>
