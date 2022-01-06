/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.cardealership.dao;

import com.sg.cardealership.dto.Special;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cna
 */
@Repository
public class SpecialDaoImpl implements SpecialDao{
    
    JdbcTemplate jdbc; 
    
    @Autowired
    public SpecialDaoImpl(JdbcTemplate jdbc)
    {
        this.jdbc = jdbc;
    }
    
    public static final class SpecialMapper implements RowMapper<Special> {

        @Override
        public Special mapRow(ResultSet rs, int index) throws SQLException {
            Special sp = new Special();
            sp.setId(rs.getInt("id"));
            sp.setDescription(rs.getString("description"));
            return sp;
        }
    }
    
    @Override
    public List<Special> getAllSpecials() {
        final String SELECT_ALL_SPECIALS = "SELECT * FROM special";
        return jdbc.query(SELECT_ALL_SPECIALS, new SpecialMapper());
    }

    @Override
    public Special getSpecialById(int id) {
        try {
            final String SELECT_SPECIAL_BY_ID = "SELECT * FROM special WHERE id = ?";
            return jdbc.queryForObject(SELECT_SPECIAL_BY_ID, new SpecialMapper(), id);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public Special addSpecialInfo(Special special) {
        final String INSERT_SPECIAL = "INSERT INTO special(description) "
                + "VALUES(?)";
        jdbc.update(INSERT_SPECIAL, 
                special.getDescription());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        special.setId(newId);
        return special;
    }

    @Override
    public void updateSpecial(Special special) {
        final String UPDATE_SPECIAL = "UPDATE special SET description = ? "
                + "WHERE id = ?";
        jdbc.update(UPDATE_SPECIAL,
                special.getDescription(),
                special.getId());
    }

    @Override
    public void deleteSpecialById(int id) {

        final String DELETE_SPECIAL = "DELETE FROM special WHERE id = ?";
        jdbc.update(DELETE_SPECIAL, id);
    }      
}

