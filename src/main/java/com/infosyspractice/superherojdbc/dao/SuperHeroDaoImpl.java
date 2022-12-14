package com.infosyspractice.superherojdbc.dao;

import com.infosyspractice.superherojdbc.model.SuperHero;
import com.infosyspractice.superherojdbc.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuperHeroDaoImpl implements SuperHeroDao {

    Connection connection;

    public SuperHeroDaoImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public SuperHero save(SuperHero superHero) {
        String sql = "INSERT INTO superhero values (default, ?, ?, ?, ?, ?, ?);";
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

    @Override
    public SuperHero getById(int id) {

        SuperHero s = new SuperHero();

        String sql = "SELECT * FROM superhero WHERE id = ?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs;

            if ((rs = stmt.executeQuery()) != null) {
                rs.next();

                int returnedId = rs.getInt("id");
                String superheroName = rs.getString("superhero_name");
                String superPower = rs.getString("super_power");
                int strength = rs.getInt("strength");
                String weakness = rs.getString("weakness");
                String franchise = rs.getString("franchise");
                String world = rs.getString("world");

                s.setId(returnedId);
                s.setSuperheroName(superheroName);
                s.setSuperPower(superPower);
                s.setStrength(strength);
                s.setWeakness(weakness);
                s.setFranchise(franchise);
                s.setWorld(world);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public List<SuperHero> getAll() {

        List<SuperHero> heroes = new ArrayList<>();

        try {
            String sql = "SELECT * FROM superhero;";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String superheroName = rs.getString("superhero_name");
                String superPower = rs.getString("super_power");
                int strength = rs.getInt("strength");
                String weakness = rs.getString("weakness");
                String franchise = rs.getString("franchise");
                String world = rs.getString("world");

                SuperHero s = new SuperHero();

                s.setId(id);
                s.setSuperheroName(superheroName);
                s.setSuperPower(superPower);
                s.setStrength(strength);
                s.setWeakness(weakness);
                s.setFranchise(franchise);
                s.setWorld(world);

                heroes.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return heroes;
    }

    @Override
    public SuperHero update(SuperHero s) {

        try {
            String sql = "UPDATE superhero " +
                    "SET " +
                    "superhero_name = ?, " +
                    "super_power = ?, " +
                    "strength = ?," +
                    " weakness = ?," +
                    " franchise = ?, " +
                    "world = ? " +
                    "WHERE id = ?;";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, s.getSuperheroName());
            stmt.setString(2, s.getSuperPower());
            stmt.setInt(3, s.getStrength());
            stmt.setString(4, s.getWeakness());
            stmt.setString(5, s.getFranchise());
            stmt.setString(6, s.getWorld());
            stmt.setInt(7, s.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM superhero WHERE id = ?;";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Exercise: Fill out 4 other CRUD methods (GetById, GetAll, Update, Delete)
    // Make some more fun queries like get by power, strength, etc.
    // Alter the save method so that it retrieves the id from the database and store it in the superhero object that you return (Recommend doing online research)
}
