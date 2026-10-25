package com.filmsociety.movies_api.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@CrossOrigin
public class testController {
    @GetMapping("/")
    public String getStarting() {
        return "movies-api project started !!!";
    }
    
}
