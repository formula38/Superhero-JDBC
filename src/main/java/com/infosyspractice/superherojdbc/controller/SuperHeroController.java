package com.infosyspractice.superherojdbc.controller;

import com.infosyspractice.superherojdbc.service.SuperHeroService;

public class SuperHeroController {
    private SuperHeroService superHeroService;

    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    
}
