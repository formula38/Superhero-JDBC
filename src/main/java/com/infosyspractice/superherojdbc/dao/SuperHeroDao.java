package com.infosyspractice.superherojdbc.dao;

import com.infosyspractice.superherojdbc.model.SuperHero;

import java.util.List;

public interface SuperHeroDao {
    SuperHero save(SuperHero superHero);
    SuperHero getById(int id);
    List<SuperHero> getAll();
    SuperHero update(SuperHero superHero);
    void delete(int id);
}
