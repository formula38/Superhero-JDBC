package com.infosyspractice.superherojdbc.service;

import com.infosyspractice.superherojdbc.dao.SuperHeroDao;
import com.infosyspractice.superherojdbc.model.SuperHero;

public class SuperHeroService {
    private SuperHeroDao superHeroDao;

    public SuperHeroService(SuperHeroDao superHeroDao) {
        this.superHeroDao = superHeroDao;
    }

    public SuperHero save(SuperHero s) {
        return this.superHeroDao.save(s);
    }

    public SuperHero getById(int id) {
        return this.superHeroDao.getById(id);
    }

    public SuperHero update(SuperHero s) {
        return this.superHeroDao.update(s);
    }

    public void delete(int id) {
        this.superHeroDao.delete(id);
    }
}
