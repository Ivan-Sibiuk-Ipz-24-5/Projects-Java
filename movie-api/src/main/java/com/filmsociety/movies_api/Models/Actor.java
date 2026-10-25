package com.filmsociety.movies_api.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Actor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Actor name is required")
    @Column(nullable = false)
    private String name;
    
    @NotNull(message = "Birth date is required")
    @Column(nullable = false)
    private LocalDate birthDate;
    
    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    @Builder.Default
    private Set<Movie> movies = new HashSet<>();
    
    public Actor(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.movies= new HashSet<>();
    }
}
