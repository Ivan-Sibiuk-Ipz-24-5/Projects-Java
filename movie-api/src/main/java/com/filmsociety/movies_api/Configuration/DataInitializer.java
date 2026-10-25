package com.filmsociety.movies_api.Configuration;


import com.filmsociety.movies_api.Models.*;
import com.filmsociety.movies_api.Repositories.*;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final ActorRepository actorRepository;

    @Override
    @Transactional
    public void run(String... args) {
        // Check if data already exists
        if (genreRepository.count() > 0) {
            return;
        }
        
        // Create Genres
        Genre action = genreRepository.save(new Genre("Action"));
        Genre drama = genreRepository.save(new Genre("Drama"));
        Genre sciFi = genreRepository.save(new Genre("Sci-Fi"));
        Genre thriller = genreRepository.save(new Genre("Thriller"));
        Genre comedy = genreRepository.save(new Genre("Comedy"));
        Genre romance = genreRepository.save(new Genre("Romance"));
        Genre crime = genreRepository.save(new Genre("Crime"));
        
        // Create Actors
        Actor leonardoDiCaprio = actorRepository.save(new Actor("Leonardo DiCaprio", LocalDate.of(1974, 11, 11)));
        Actor ellenPage = actorRepository.save(new Actor("Ellen Page", LocalDate.of(1987, 2, 21)));
        Actor tomHardy = actorRepository.save(new Actor("Tom Hardy", LocalDate.of(1977, 9, 15)));
        Actor keanuReeves = actorRepository.save(new Actor("Keanu Reeves", LocalDate.of(1964, 9, 2)));
        Actor carrieAnneMoss = actorRepository.save(new Actor("Carrie-Anne Moss", LocalDate.of(1967, 8, 21)));
        Actor bradPitt = actorRepository.save(new Actor("Brad Pitt", LocalDate.of(1963, 12, 18)));
        Actor edwardNorton = actorRepository.save(new Actor("Edward Norton", LocalDate.of(1969, 8, 18)));
        Actor morganFreeman = actorRepository.save(new Actor("Morgan Freeman", LocalDate.of(1937, 6, 1)));
        Actor timRobbins = actorRepository.save(new Actor("Tim Robbins", LocalDate.of(1958, 10, 16)));
        Actor christianBale = actorRepository.save(new Actor("Christian Bale", LocalDate.of(1974, 1, 30)));
        Actor heathLedger = actorRepository.save(new Actor("Heath Ledger", LocalDate.of(1979, 4, 4)));
        Actor scarlettJohansson = actorRepository.save(new Actor("Scarlett Johansson", LocalDate.of(1984, 11, 22)));
        Actor robertDowneyJr = actorRepository.save(new Actor("Robert Downey Jr.", LocalDate.of(1965, 4, 4)));
        Actor chrisEvans = actorRepository.save(new Actor("Chris Evans", LocalDate.of(1981, 6, 13)));
        Actor samuelLJackson = actorRepository.save(new Actor("Samuel L. Jackson", LocalDate.of(1948, 12, 21)));
        
        // Create Movies 
        Movie inception = Movie.builder()
            .title("Inception")
            .releaseYear(2010)
            .duration(148)
            .build();
        inception.addGenre(action);
        inception.addGenre(sciFi);
        inception.addGenre(thriller);
        inception.addActor(leonardoDiCaprio);
        inception.addActor(ellenPage);
        inception.addActor(tomHardy);
        movieRepository.save(inception);
        
        Movie matrix = Movie.builder()
            .title("The Matrix")
            .releaseYear(1999)
            .duration(136)
            .build();
        matrix.addGenre(action);
        matrix.addGenre(sciFi);
        matrix.addActor(keanuReeves);
        matrix.addActor(carrieAnneMoss);
        movieRepository.save(matrix);
        
        Movie fightClub = Movie.builder()
            .title("Fight Club")
            .releaseYear(1999)
            .duration(139)
            .build();
        fightClub.addGenre(drama);
        fightClub.addActor(bradPitt);
        fightClub.addActor(edwardNorton);
        movieRepository.save(fightClub);
        
        Movie shawshank = Movie.builder()
            .title("The Shawshank Redemption")
            .releaseYear(1994)
            .duration(142)
            .build();
        shawshank.addGenre(drama);
        shawshank.addActor(morganFreeman);
        shawshank.addActor(timRobbins);
        movieRepository.save(shawshank);
        
        Movie darkKnight = Movie.builder()
            .title("The Dark Knight")
            .releaseYear(2008)
            .duration(152)
            .build();
        darkKnight.addGenre(action);
        darkKnight.addGenre(crime);
        darkKnight.addGenre(drama);
        darkKnight.addActor(christianBale);
        darkKnight.addActor(heathLedger);
        movieRepository.save(darkKnight);
        
        Movie avengers = Movie.builder()
            .title("The Avengers")
            .releaseYear(2012)
            .duration(143)
            .build();
        avengers.addGenre(action);
        avengers.addGenre(sciFi);
        avengers.addActor(robertDowneyJr);
        avengers.addActor(chrisEvans);
        avengers.addActor(scarlettJohansson);
        avengers.addActor(samuelLJackson);
        movieRepository.save(avengers);
        
        Movie titanic = Movie.builder()
            .title("Titanic")
            .releaseYear(1997)
            .duration(194)
            .build();
        titanic.addGenre(drama);
        titanic.addGenre(romance);
        titanic.addActor(leonardoDiCaprio);
        movieRepository.save(titanic);
        
        Movie departed = Movie.builder()
            .title("The Departed")
            .releaseYear(2006)
            .duration(151)
            .build();
        departed.addGenre(crime);
        departed.addGenre(drama);
        departed.addGenre(thriller);
        departed.addActor(leonardoDiCaprio);
        movieRepository.save(departed);
        
        Movie matrixReloaded = Movie.builder()
            .title("The Matrix Reloaded")
            .releaseYear(2003)
            .duration(138)
            .build();
        matrixReloaded.addGenre(action);
        matrixReloaded.addGenre(sciFi);
        matrixReloaded.addActor(keanuReeves);
        matrixReloaded.addActor(carrieAnneMoss);
        movieRepository.save(matrixReloaded);
        
        Movie se7en = Movie.builder()
            .title("Se7en")
            .releaseYear(1995)
            .duration(127)
            .build();
        se7en.addGenre(crime);
        se7en.addGenre(drama);
        se7en.addGenre(thriller);
        se7en.addActor(bradPitt);
        se7en.addActor(morganFreeman);
        movieRepository.save(se7en);
        
        Movie interstellar = Movie.builder()
            .title("Interstellar")
            .releaseYear(2014)
            .duration(169)
            .build();
        interstellar.addGenre(sciFi);
        interstellar.addGenre(drama);
        movieRepository.save(interstellar);
        
        Movie johnWick = Movie.builder()
            .title("John Wick")
            .releaseYear(2014)
            .duration(101)
            .build();
        johnWick.addGenre(action);
        johnWick.addGenre(thriller);
        johnWick.addActor(keanuReeves);
        movieRepository.save(johnWick);
        
        Movie lucyMovie = Movie.builder()
            .title("Lucy")
            .releaseYear(2014)
            .duration(89)
            .build();
        lucyMovie.addGenre(action);
        lucyMovie.addGenre(sciFi);
        lucyMovie.addActor(scarlettJohansson);
        movieRepository.save(lucyMovie);
        
        Movie ironMan = Movie.builder()
            .title("Iron Man")
            .releaseYear(2008)
            .duration(126)
            .build();
        ironMan.addGenre(action);
        ironMan.addGenre(sciFi);
        ironMan.addActor(robertDowneyJr);
        movieRepository.save(ironMan);
        
        Movie captainAmerica = Movie.builder()
            .title("Captain America: The First Avenger")
            .releaseYear(2011)
            .duration(124)
            .build();
        captainAmerica.addGenre(action);
        captainAmerica.addGenre(sciFi);
        captainAmerica.addActor(chrisEvans);
        movieRepository.save(captainAmerica);
        
        Movie pulpFiction = Movie.builder()
            .title("Pulp Fiction")
            .releaseYear(1994)
            .duration(154)
            .build();
        pulpFiction.addGenre(crime);
        pulpFiction.addGenre(drama);
        pulpFiction.addActor(samuelLJackson);
        movieRepository.save(pulpFiction);
        
        Movie americanPsycho = Movie.builder()
            .title("American Psycho")
            .releaseYear(2000)
            .duration(102)
            .build();
        americanPsycho.addGenre(crime);
        americanPsycho.addGenre(drama);
        americanPsycho.addGenre(thriller);
        americanPsycho.addActor(christianBale);
        movieRepository.save(americanPsycho);
        
        Movie madMax = Movie.builder()
            .title("Mad Max: Fury Road")
            .releaseYear(2015)
            .duration(120)
            .build();
        madMax.addGenre(action);
        madMax.addGenre(sciFi);
        madMax.addActor(tomHardy);
        movieRepository.save(madMax);
        
        Movie venom = Movie.builder()
            .title("Venom")
            .releaseYear(2018)
            .duration(112)
            .build();
        venom.addGenre(action);
        venom.addGenre(sciFi);
        venom.addActor(tomHardy);
        movieRepository.save(venom);
        
        Movie juno = Movie.builder()
            .title("Juno")
            .releaseYear(2007)
            .duration(96)
            .build();
        juno.addGenre(comedy);
        juno.addGenre(drama);
        juno.addActor(ellenPage);
        movieRepository.save(juno);
        
        System.out.println("Test data initialized successfully)");
    }
}
