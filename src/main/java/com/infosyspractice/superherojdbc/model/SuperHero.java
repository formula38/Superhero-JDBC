package com.infosyspractice.superherojdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuperHero {
    private int id;
    private String superheroName;
    private String superPower;
    private int strength;
    private String weakness;
    private String franchise;
    private String world;
}
