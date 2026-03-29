# Mini-Projet - API Bibliotheque (Spring Boot)

API REST de gestion de bibliotheque (livres, auteurs, categories, emprunts) avec authentification JWT.

## Stack technique

- Java 17
- Spring Boot 4
- Spring Security + JWT
- Spring Data JPA
- Base H2 (en memoire)
- OpenAPI/Swagger
- Docker (deploiement Render)

## Demarrage en local (sans Docker)

### Prerequis

- JDK 17+
- Maven 3.9+ (ou `mvnw`)

### Lancer l'application

`./mvnw spring-boot:run`

`.\mvnw.cmd spring-boot:run`

L'API est disponible sur :

- `http://localhost:8080`
- `https://mini-pojet.onrender.com/`

## Authentification

L'application est en mode JWT stateless.

Routes publiques :

- `POST /api/auth/register`
- `POST /api/auth/login`
- Swagger : `/swagger-ui/index.html`
- OpenAPI : `/v3/api-docs`

Les autres routes necessitent un header :

```http
Authorization: Bearer <token>
```

## Endpoints principaux

### Auth

- `POST /api/auth/register`
- `POST /api/auth/login`

### Books

- `POST /api/books`
- `GET /api/books`
- `GET /api/books/{id}`
- `GET /api/books/top` (agregation metier : nombre d'emprunts par livre)

### Authors

- `POST /api/authors`
- `GET /api/authors`

### Categories

- `POST /api/categories`
- `GET /api/categories`

### Borrows

- `POST /api/borrows`
- `GET /api/borrows`

### Users

- `GET /api/users/{id}/stats` (agregation metier : total des emprunts)

## Exemples d'agregation dans le modele

Relations JPA presentes :

- `Book` -> `Category` (`@ManyToOne`)
- `Book` <-> `Author` (`@ManyToMany`)
- `Category` -> `Book` (`@OneToMany`)
- `Borrow` -> `User` et `Book` (`@ManyToOne`)

## Docker (local)

### Build de l'image

```powershell
docker build -t mini-projet:local .
```

### Execution du conteneur

```powershell
docker run --rm -p 8080:8080 mini-projet:local
```

## Deploiement sur Render

1. Pousser le projet sur GitHub.
2. Sur Render : **New** -> **Web Service**.
3. Connecter le repository.
4. Choisir **Environment: Docker**.
5. Laisser Render utiliser le `Dockerfile` a la racine.
6. Deployer.


## Documentation API

- Swagger UI : `http://localhost:8080/swagger-ui/index.html` / `https://mini-pojet.onrender.com/swagger-ui/index.html`
- OpenAPI JSON : `http://localhost:8080/v3/api-docs` / `https://mini-pojet.onrender.com/v3/api-docs`

## Collection Postman

Le projet contient des collections Postman a la racine :

- `MINI-PROJET-M2_LOCAL.postman_collection.json`
- `MINI-PROJET-M2_DEPLOYE.postman_collection.json`