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
 <a href="#description">Description</a> • 
 <a href="#features">Features</a> • 
 <a href="#installation">Installation</a> •
 <a href="#contribution">Contribution</a> 
</p>

<h2 id="description">📙 Description</h2>
This is an experimental project aimed at creating a serology management system in partnership with the biomedicine course at Centro Universitário das Faculdades Integradas de Ourinhos. The serology system is critical for the storage and control of sera and patient samples, and this system aims to simplify and automate the process of registering and managing patients, their phenotyping, antibodies, and associated vials.

<h2 id="features">✨ Features</h2>

- **Patient Registration**: Register detailed information about patients, including personal data, phenotyping, and antibodies.
- **Vial Registration**: Allows the registration of specific information about the vials associated with each patient, such as collection date, sample type, storage conditions, among others.
- **JSF Screens**: The project includes user interface screens developed in JSF with the PrimeFaces library, making system interaction more user-friendly and efficient.
- **User Authentication**: The login screen allows authenticated users to access the system's functionalities.
- **Vial and Patient Listing**: Provides a convenient way to view and search for information about registered vials and patients.

### Technologies Used

- **Backend**: Developed in Java with Spring Initializer, Spring Data, and Hibernate.
- **Frontend**: Developed within the same project using JSF (JavaServer Faces) and PrimeFaces.

<h2 id="installation">🛠️ Installation</h2>

1. Clone the repository to your local environment:

```
git clone https://github.com/lucasrznd/sistema-biomedicina.git
```

2. Navigate to the project directory:

```
cd sistema-biomedicina
```

3. Build the Docker image:

```
docker build -t biomed .
```

5. Start the application using Docker Compose:

```
docker-compose up -d
```

### Avaible URL's 
| url               |                                         
|----------------------|
| <kbd>localhost:8080/cadastro/fenotipagem.xhtml</kbd>     
| <kbd>localhost:8080/cadastro/anticorpo.xhtml</kbd>     
| <kbd>localhost:8080/cadastro/ampola.xhtml</kbd>
| <kbd>localhost:8080/cadastro/paciente.xhtml</kbd>

<h2 id="contribution">🤝 Contribution</h2>

Contributions are welcome! If you have suggestions, improvements, or find bugs, feel free to open an issue or submit a pull request.

<h2 id="authors">👨🏻‍💻 Authors</h2>

<table>
  <tbody>
    <tr>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/lucasrznd"><img src="https://avatars.githubusercontent.com/u/101664450?v=4&v=" width="115px;" alt="Lucas Rezende"/><br /><sub><b>Lucas Rezende</b></sub></a><br/><a title="Code">💻</a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/zZ-LeoZin-Zz"><img src="https://avatars.githubusercontent.com/u/88119600?v=4" width="115px;" alt="Leonardo Hermes"/><br /><sub><b>Leonardo Hermes</b></sub></a><br/><a title="Code">💻</a></td>
  </tbody>
</table>
