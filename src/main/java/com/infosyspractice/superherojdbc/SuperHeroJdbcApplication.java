package com.infosyspractice.superherojdbc;

import com.infosyspractice.superherojdbc.dao.SuperHeroDao;
import com.infosyspractice.superherojdbc.dao.SuperHeroDaoImpl;
import com.infosyspractice.superherojdbc.model.SuperHero;
import com.infosyspractice.superherojdbc.service.SuperHeroService;
import com.infosyspractice.superherojdbc.util.DaoFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperHeroJdbcApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SuperHeroJdbcApplication.class, args);

        SuperHero superHero = new SuperHero(
                -1,
                "PostMan",
                "Punctuality",
                12,
                "Loose Dogs",
                "C",
                "Harlem"
        );

        SuperHeroService superHeroService = new SuperHeroService(DaoFactory.getSuperHeroDoaDummy());
        superHeroService.save(superHero);
        System.out.println(superHero.getId());
    }

}
