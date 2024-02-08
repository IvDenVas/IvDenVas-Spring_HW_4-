package com.example.Spring_HW4_plus.repository;

import com.example.Spring_HW4_plus.config.ConfigProperties;
import com.example.Spring_HW4_plus.model.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbc;
    private final ConfigProperties configProperties;

    public List<User> findAll() {
//        String sql1 = "SELECT * FROM userTable";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(configProperties.getSqlFindAll(), userRowMapper);
    }

    public User save(User user) {
//        String sql = "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
        jdbc.update(configProperties.getSqlAdd(), user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id) {
//        String sql = "DELETE FROM userTable WHERE id = ?";
        jdbc.update(configProperties.getSqlDelete(), id);
    }

    public User getOne(int id) {
        return findAll().stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public User update(User user) {
//        String sql = "UPDATE userTable SET firstName=?, lastname=? WHERE id=?";
        jdbc.update(configProperties.getSqlUpdate(),user.getFirstName(),user.getLastName(),user.getId());
        return user;
    }
}