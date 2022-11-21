package com.infosyspractice.superherojdbc.util;

import com.infosyspractice.superherojdbc.dao.SuperHeroDao;
import com.infosyspractice.superherojdbc.dao.SuperHeroDaoDummyImpl;
import com.infosyspractice.superherojdbc.dao.SuperHeroDaoImpl;

public class DaoFactory {
    private static SuperHeroDao superHeroDao = null;
    private static SuperHeroDao superHeroDaoDummy = null;

    public static SuperHeroDao getSuperHeroDao() {
        if (superHeroDao == null) {
            superHeroDao = new SuperHeroDaoImpl();
        }
        return superHeroDao;
    }

    public static SuperHeroDao getSuperHeroDoaDummy() {
        if (superHeroDaoDummy == null) {
            superHeroDaoDummy = new SuperHeroDaoDummyImpl();
        }
        return superHeroDaoDummy;
    }
}
