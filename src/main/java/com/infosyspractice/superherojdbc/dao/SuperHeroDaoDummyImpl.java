package com.infosyspractice.superherojdbc.dao;

import com.infosyspractice.superherojdbc.model.SuperHero;

public class SuperHeroDaoDummyImpl implements SuperHeroDao {
    @Override
    public SuperHero save(SuperHero superHero) {
        superHero.setId(45);
        return superHero;
    }
}
