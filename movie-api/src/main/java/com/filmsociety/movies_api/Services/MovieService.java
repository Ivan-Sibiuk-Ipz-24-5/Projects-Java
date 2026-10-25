package com.filmsociety.movies_api.Services;
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

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final GenreService genreService;
    private final ActorService actorService;

    @Transactional
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Page<Movie> getAllMovies(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie", id));
    }

    public Page<Movie> getMoviesByGenre(Long genreId, Pageable pageable) {
        genreService.getGenreById(genreId);
        return movieRepository.findByGenreId(genreId, pageable);
    }

    public Page<Movie> getMoviesByYear(Integer year, Pageable pageable) {
        return movieRepository.findByReleaseYear(year, pageable);
    }

    public Page<Movie> getMoviesByTitle(String title, Pageable pageable) {
        return movieRepository.findByTitleContainingIgnoreCase(title, pageable);
    }

    public Page<Movie> getMoviesByActor(Long actorId, Pageable pageable) {
        actorService.getActorById(actorId);
        return movieRepository.findByActorId(actorId, pageable);
    }
    
    public Set<Actor> getActorsByMovie(Long movieId) {
        Movie movie = getMovieById(movieId);
        return movie.getActors();
    }
    
    @Transactional
    public Movie updateMovie(Long id, Movie movieDetails) {
        Movie movie = getMovieById(id);
        
        if (movieDetails.getTitle() != null) {
            movie.setTitle(movieDetails.getTitle());
        }
        if (movieDetails.getReleaseYear() != null) {
            movie.setReleaseYear(movieDetails.getReleaseYear());
        }
        if (movieDetails.getDuration() != null) {
            movie.setDuration(movieDetails.getDuration());
        }
    
        if (movieDetails.getGenres() != null && !movieDetails.getGenres().isEmpty()) {
       
            movie.getGenres().clear();
            
      
            for (Genre genre : movieDetails.getGenres()) {
                Genre existingGenre = genreService.getGenreById(genre.getId());
                movie.addGenre(existingGenre);
            }
        }
        
 
        if (movieDetails.getActors() != null && !movieDetails.getActors().isEmpty()) {
        
            movie.getActors().clear();
            
          
            for (Actor actor : movieDetails.getActors()) {
                Actor existingActor = actorService.getActorById(actor.getId());
                movie.addActor(existingActor);
            }
        }
        
        return movieRepository.save(movie);
    }
    
    @Transactional
    public void deleteMovie(Long id) {
        Movie movie = getMovieById(id);
        
     
        for (Genre genre : movie.getGenres()) {
            genre.getMovies().remove(movie);
        }
        for (Actor actor : movie.getActors()) {
            actor.getMovies().remove(movie);
        }
        
        movieRepository.delete(movie);
    }
}
