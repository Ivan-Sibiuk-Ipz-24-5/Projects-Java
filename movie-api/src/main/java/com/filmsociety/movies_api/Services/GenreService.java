package com.filmsociety.movies_api.Services;


import com.filmsociety.movies_api.ExceptionsHandlers.*;
import com.filmsociety.movies_api.Repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.filmsociety.movies_api.Models.Genre;
import com.filmsociety.movies_api.Models.Movie;
import com.filmsociety.movies_api.Repositories.GenreRepository;

import java.util.List;
import java.util.Set;
@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
    @Transactional
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Page<Genre> getAllGenres(Pageable pageable) {
        return genreRepository.findAll(pageable);
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Genre", id));
    }
    @Transactional
    public Genre updateGenre(Long id, Genre updatedGenre) {
        Genre genre = getGenreById(id);
        if (updatedGenre.getName() != null) {
            genre.setName(updatedGenre.getName());
        }

        return genreRepository.save(genre);
    }

    @Transactional
    public void deleteGenre(Long id, boolean force) {
        Genre genre = getGenreById(id);
        Set<Movie> associatedMovies = genre.getMovies();
        if (!force && !associatedMovies.isEmpty()) {
            throw new ResourceDeletionException(
                    String.format("Cannot delete genre '%s' because it has %d associated movies",
                            genre.getName(), associatedMovies.size()));
        }
        if (force) {
            for (Movie movie : associatedMovies) {
                movie.getGenres().remove(genre);
            }
        }
        genreRepository.delete(genre);
    }

    public Set<Movie> getMovieByGenre(Long genreId) {
        Genre genre = getGenreById(genreId);
        return genre.getMovies();
    }
}
