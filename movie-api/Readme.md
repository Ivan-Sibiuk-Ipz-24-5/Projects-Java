# 🎬 Movies API

REST API для керування фільмами, жанрами та акторами на Spring Boot.

---

## ✨ Можливості

- CRUD для Movies, Genres, Actors  
- Зв’язки Many-to-Many  
- Фільтрація за жанром, роком, актором  
- Пошук за назвою  
- Пагінація  
- Валідація вводу  
- SQLite (створюється автоматично)

---

## 🚀 Запуск

### Вимоги
- Java 17+
- Maven 3.6+
- Git


### Жанри

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/genres` | Get all genres |
| `GET` | `/genres/{id}` | Get genre by ID |
| `POST` | `/genres` | Create new genre |
| `PATCH` | `/genres/{id}` | Update genre |
| `DELETE` | `/genres/{id}` | Delete genre |

### Фільми

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/movies` | Get all movies |
| `GET` | `/movies/{id}` | Get movie by ID |
| `GET` | `/movies?genre={id}` | Filter by genre |
| `GET` | `/movies?year={year}` | Filter by year |
| `GET` | `/movies?actor={id}` | Filter by actor |
| `GET` | `/movies/search?title={title}` | Search by title |
| `POST` | `/movies` | Create new movie |
| `PATCH` | `/movies/{id}` | Update movie |
| `DELETE` | `/movies/{id}` | Delete movie |

### Актори

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/actors` | Get all actors |
| `GET` | `/actors/{id}` | Get actor by ID |
| `GET` | `/actors?name={name}` | Search by name |
| `POST` | `/actors` | Create new actor |
| `PATCH` | `/actors/{id}` | Update actor |
| `DELETE` | `/actors/{id}` | Delete actor |

---


### Створення Фільмів

```bash
curl -X POST http://localhost:8080/api/movies \
  -H "Content-Type: application/json" \
  -d '{
    "title": "The Dark Knight",
    "releaseYear": 2008,
    "duration": 152,
    "genres": [{"id": 1}, {"id": 3}],
    "actors": [{"id": 10}, {"id": 11}]
  }'
```

### Фільми по жанрам

```bash
curl http://localhost:8080/api/movies?genre=1
```

### Пошук фільмів

```bash
curl http://localhost:8080/api/movies/search?title=matrix
```

### Pagination

```bash
curl http://localhost:8080/api/movies?page=0&size=10
```

---

## Прикладові дані

Додаток постачається з попередньо завантаженими тестовими даними та Postman-колекцією (файл: Configuration/PostmanTest.json):

7 жанрів: Бойовик, Драма, Наукова фантастика, Трилер, Комедія, Романтика, Кримінал

15 акторів: Леонардо Ді Капріо, Кіану Рівз, Бред Пітт та інші

20 фільмів: Початок, Матриця, Бійцівський клуб, Темний лицар та інші

Усі дані пов’язані між собою для демонстрації різних сценаріїв роботи.
---


## 📁 Структура проекту

```
movies-api/
├── src/
│   └── main/
│       ├── java/com/filmsociety/movies_api/
│       │   ├── Configuration/
│       │   │   └── DataInitializer.java
|       |   |   └── PostmanTes.json
│       │   ├── Controllers/
│       │   │   ├── ActorController.java
│       │   │   ├── GenreController.java
│       │   │   └── MovieController.java
│       │   │   
│       │   ├── ExceptionsHandlers/
│       │   │   ├── GlobalExceptionHandler.java
│       │   │   ├── ResourceDeletionException.java
│       │   │   └── ResourceNotFoundException.java
|       |   |   └── ErrorResponse.java
│       │   ├── Models/
│       │   │   ├── Actor.java
│       │   │   ├── Genre.java
│       │   │   └── Movie.java
│       │   ├── Repositories/
│       │   │   ├── ActorRepository.java
│       │   │   ├── GenreRepository.java
│       │   │   └── MovieRepository.java
│       │   ├── Services/
│       │   │   ├── ActorService.java
│       │   │   ├── GenreService.java
│       │   │   └── MovieService.java
│       │   └── MoviesApiApplication.java
│       └── resources/
│           └── application.properties
├── pom.xml
└── README.md




