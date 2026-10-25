package com.filmsociety.movies_api.Services;

import com.filmsociety.movies_api.Repositories.ActorRepository;
import com.filmsociety.movies_api.ExceptionsHandlers.*;
import com.filmsociety.movies_api.Repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filmsociety.movies_api.Models.Actor;
import com.filmsociety.movies_api.Models.Genre;
import com.filmsociety.movies_api.Models.Movie;
import com.filmsociety.movies_api.Repositories.GenreRepository;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ActorService {
    private final ActorRepository actorRepository;

    @Transactional
    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Page<Actor> getAllActors(Pageable pageable) {
        return actorRepository.findAll(pageable);
    }

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Actor getActorById(Long id) {
        return actorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Actor", id));
    }

    public Page<Actor> getActorsByName(String name, Pageable pageable) {
        return actorRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    @Transactional
    public Actor updateActor(Long id, Actor updatedActor) {
        Actor actor = getActorById(id);
        if (actor.getName() != null) {
            actor.setName(updatedActor.getName());
        }
        if (actor.getBirthDate() != null) {
            actor.setBirthDate(updatedActor.getBirthDate());
        }
        return actorRepository.save(actor);
    }

    @Transactional
    public void deleteActor(Long id, boolean force) {
        Actor actor = getActorById(id);
        Set<Movie> associatedMovies = actor.getMovies();

        if (!force && !associatedMovies.isEmpty()) {
            throw new ResourceDeletionException(
                    String.format("Cannot delete actor '%s' because it has %d associated movies",
                            actor.getName(), associatedMovies.size()));
        }

        if (force) {
            for (Movie movie : associatedMovies) {
                movie.getActors().remove(actor);
            }
        }
        actorRepository.delete(actor);

    }
    
    public Set<Movie> getMovieByActor(Long actorId) {
        Actor actor = getActorById(actorId);
        return actor.getMovies();
    }
}
