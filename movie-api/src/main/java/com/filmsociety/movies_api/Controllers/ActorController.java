package com.filmsociety.movies_api.Controllers;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.filmsociety.movies_api.Models.Actor;
import com.filmsociety.movies_api.Models.Movie;
import com.filmsociety.movies_api.Services.ActorService;

import java.util.Set;

@RestController
@RequestMapping("/api/actors")
@RequiredArgsConstructor
public class ActorController {
 private final ActorService actorService;
    
    @PostMapping
    public ResponseEntity<Actor> createActor(@Valid @RequestBody Actor actor) {
        Actor createdActor = actorService.createActor(actor);
        return new ResponseEntity<>(createdActor, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<Page<Actor>> getAllActors(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Actor> actors;
        
        if (name != null && !name.isEmpty()) {
            actors = actorService.getActorsByName(name, pageable);
        } else {
            actors = actorService.getAllActors(pageable);
        }
        
        return ResponseEntity.ok(actors);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable Long id) {
        Actor actor = actorService.getActorById(id);
        return ResponseEntity.ok(actor);
    }
    
    @GetMapping("/{id}/movies")
    public ResponseEntity<Set<Movie>> getMoviesByActor(@PathVariable Long id) {
        Set<Movie> movies = actorService.getMovieByActor(id);
        return ResponseEntity.ok(movies);
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Actor> updateActor(
            @PathVariable Long id,
            @RequestBody Actor actorDetails) {
        Actor updatedActor = actorService.updateActor(id, actorDetails);
        return ResponseEntity.ok(updatedActor);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(
            @PathVariable Long id,
            @RequestParam(defaultValue = "false") boolean force) {
        actorService.deleteActor(id, force);
        return ResponseEntity.noContent().build();
    }
}
