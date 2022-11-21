package com.infosyspractice.superherojdbc.service;

import com.infosyspractice.superherojdbc.dao.SuperHeroDao;
import com.infosyspractice.superherojdbc.model.SuperHero;

public class SuperHeroService {
    private SuperHeroDao superHeroDao;

    public SuperHeroService(SuperHeroDao superHeroDao) {
        this.superHeroDao = superHeroDao;
    }

    public SuperHero save(SuperHero s) {
        this.superHeroDao.save(s);
        return s;
    }
}
