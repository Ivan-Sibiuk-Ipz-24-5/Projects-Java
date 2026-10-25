package com.filmsociety.movies_api.Models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;




@Entity
@Table(name = "genres")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Genre name is required")
    @Column(nullable = false,unique = true)
    private String name;

    @ManyToMany(mappedBy = "genres") 
    @JsonIgnore
    @Builder.Default
    private Set<Movie> movies = new HashSet<>();
    public Genre(String name) {
        this.name = name;
        this.movies= new HashSet<>();
    }
}
