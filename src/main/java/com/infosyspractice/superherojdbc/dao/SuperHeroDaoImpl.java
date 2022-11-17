package com.infosyspractice.superherojdbc.dao;

import com.infosyspractice.superherojdbc.model.SuperHero;
import com.infosyspractice.superherojdbc.util.ConnectionFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuperHeroDaoImpl implements SuperHeroDao {

    Connection connection;

    public SuperHeroDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public SuperHero save(SuperHero superHero) {
        String sql = "insert into superhero values (default, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, superHero.getSuperheroName());
            preparedStatement.setString(2, superHero.getSuperPower());
            preparedStatement.setInt(3, superHero.getStrength());
            preparedStatement.setString(4, superHero.getWeakness());
            preparedStatement.setString(5, superHero.getFranchise());
            preparedStatement.setString(6, superHero.getWorld());

            int count = preparedStatement.executeUpdate();

            if (count == 1) {
                return superHero;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Exercise: Fill out 4 other CRUD methods (GetById, GetAll, Update, Delete)
    // Make some more fun queries like get by power, strength, etc.
    // Alter the save method so that it retrieves the id from the database and store it in the superhero object that you return (Recommend doing online research)
}
