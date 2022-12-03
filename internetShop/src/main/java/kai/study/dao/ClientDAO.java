package kai.study.dao;

import kai.study.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Client> readAll(){
        return jdbcTemplate.query("SELECT * FROM Client", new BeanPropertyRowMapper<>(Client.class));
    }

    public Client read(String password){
        return jdbcTemplate.query("SELECT * FROM Client WHERE password=?", new Object[]{password},
                        new BeanPropertyRowMapper<>(Client.class))
                .stream().findAny().orElse(null);
    }

    public void update(Client updatedClient){
        jdbcTemplate.update("UPDATE Client SET name=?, phone=?, email=?, password=? WHERE client_ID=?",
                updatedClient.getName(), updatedClient.getPhone(), updatedClient.getEmail(),
                updatedClient.getPassword(), updatedClient.getClient_ID());
    }

    public void save(Client client){
        jdbcTemplate.update("INSERT INTO Client VALUES (DEFAULT, ?, ?, ?, ?)", client.getName(),
                client.getPhone(), client.getEmail(), client.getPassword());
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Client WHERE client_ID=?", id);
    }
}

