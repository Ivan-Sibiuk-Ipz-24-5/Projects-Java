package com.filmsociety.movies_api.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmsociety.movies_api.Models.Genre;
import com.filmsociety.movies_api.Models.Movie;
import com.filmsociety.movies_api.Services.GenreService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.hibernate.query.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @PostMapping
    public ResponseEntity<Genre> createGenre(@Valid @RequestBody Genre entity) {
        Genre createdGenre = genreService.createGenre(entity);
        return new ResponseEntity<>(createdGenre, HttpStatus.CREATED);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id) {
        Genre genre = genreService.getGenreById(id);
        return ResponseEntity.ok(genre);
    }

   @GetMapping
    public ResponseEntity<Page<Genre>> getAllGenres(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Genre> genres = genreService.getAllGenres(pageable);
        return ResponseEntity.ok(genres);
    }
    @GetMapping("/{id}/movies")
    public ResponseEntity<Set<Movie>> getMoviesByGenre(@PathVariable Long id) {
        Set<Movie> movies = genreService.getMovieByGenre(id);
        return ResponseEntity.ok(movies);
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @Valid @RequestBody Genre entity) {
        Genre updatedGenre = genreService.updateGenre(id, entity);
        return ResponseEntity.ok(updatedGenre);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id,@RequestParam(defaultValue = "false") boolean force)  {
        genreService.deleteGenre(id, force);
        return ResponseEntity.noContent().build();
    }
    
}
