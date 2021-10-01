# Takoya Dev' - Car - Back

_-- English bellow --_

Projet de gestion d'entretiens de voitures

## Présentation générale

### Concept

Ce projet a pour ambition de gérer les entretiens d'un park de voitures.

Cette gestion permettra de lister les entretiens, les voitures et les propriétaires,
de les éditer, ainsi que d'en ajouter ou d'en supprimer.

### Auteurs

@chinjto et @ryuji13

### Version en cours de développement

1.0.0

### Versions disponibles

_Aucune pour le moment_

### Technologies

* Application REST Spring Boot _(back)_
* Maven _(gestionnaire de configuration)_
* Spring Boot REST _(framework)_
* SpringFox _(implémentation Swagger)_

## Consignes de lancement

Des process de lancement ont été mis en place pour faciliter la prise en main du projet.

### Lancer le back-end

Pour lancer le back-end, suivez les instructions suivantes :
1. Build le projet, avec `mvn clean install`
2. Lancer l'application Spring `TakoyaCarBack`

### URLs du projet

| Module       | URL                                          |
|--------------|----------------------------------------------|
| API Open API | http://localhost:8081/v3/api-docs            |
| API Swagger  | http://localhost:8081/v2/api-docs            |
| IHM BDD      | http://localhost:8081/h2-console             |
| IHM Swagger  | http://localhost:8081/swagger-ui/index.html  |
| Repo Git     | https://github.com/takoyadev/takoya-car-back |

-----

_-- English translation --_

Car servicing manager

## Global presentation

### Concept

Goal of this project is to make a car servicing manager for park of cars.

Features will be to create, read, update ou delete (CRUD) some data (or all,
if allowed privileges) about servicing, cars or owners.

### Authors

@chinjto and @ryuji13

### Current dev' release

1.0.0

### Releases map

_None, for this moment_

### Technologies

* Maven _(dependencies manager)_
* Spring Boot REST _(framework)_
* SpringFox _(Swagger implementation)_

### Run back-end

To run back-end, follow these instructions :
1. Build project, with `mvn clean install`
2. Run Spring application `TakoyaCarBack`

### Project URLs

| Module      | URL                                          |
|-------------|----------------------------------------------|
| Database UI | http://localhost:8081/h2-console             |
| Git Repo    | https://github.com/takoyadev/takoya-car-back |
| Open API    | http://localhost:8081/v3/api-docs            |
| Swagger API | http://localhost:8081/v2/api-docs            |
| Swagger UI  | http://localhost:8081/swagger-ui/index.html  |
