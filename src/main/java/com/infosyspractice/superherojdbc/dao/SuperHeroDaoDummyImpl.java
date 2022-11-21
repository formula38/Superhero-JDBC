package com.infosyspractice.superherojdbc.dao;

import com.infosyspractice.superherojdbc.model.SuperHero;

import java.util.List;

public class SuperHeroDaoDummyImpl implements SuperHeroDao {
    @Override
    public SuperHero save(SuperHero superHero) {
        superHero.setId(45);
        return superHero;
    }

    @Override
    public SuperHero getById(int id) {
        return null;
    }

    @Override
    public List<SuperHero> getAll() {
        return null;
    }

    @Override
    public SuperHero update(SuperHero superHero) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
