package com.filmsociety.movies_api.Repositories;
import com.filmsociety.movies_api.Models.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    Page<Movie> findByReleaseYear(Integer releaseYear, Pageable pageable);
    
    @Query("SELECT m FROM Movie m JOIN m.genres g WHERE g.id = :genreId")
    Page<Movie> findByGenreId(@Param("genreId") Long genreId, Pageable pageable);
    
    @Query("SELECT m FROM Movie m JOIN m.actors a WHERE a.id = :actorId")
    Page<Movie> findByActorId(@Param("actorId") Long actorId, Pageable pageable);
    
    Page<Movie> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
